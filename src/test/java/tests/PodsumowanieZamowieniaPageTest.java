package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CertyfikatyPage;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.PodsumowanieZamowieniaPage;
import pages.kursy.EdytujKursyPage;
import pages.kursy.KursyPage;
import tests.kursyTests.KursyPageTest;

public class PodsumowanieZamowieniaPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private KursyPage kursyPage;
    private EdytujKursyPage edytujKursyPage;
    private PodsumowanieZamowieniaPage podsumowanieZamowieniaPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage() {
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        kursyPage = new KursyPage(driver);
        edytujKursyPage = new EdytujKursyPage(driver);
        podsumowanieZamowieniaPage = new PodsumowanieZamowieniaPage(driver);
    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja, czy po stworzeniu kursu z 4 wariantami, dostepnoscia sztuk wieksza niz 1 ale mniejsza niz 10, z typem dostepu do kursu ustawionym na 'Przez określony czas, od określonej daty', z czasem startu 01.07.2025, 07:00 i czasem dostepu 12 miesiecy link z ekranu 'Generator linkow' dziala poprawnie i wygenerowanmy link prowadzi do strony, na ktorej jest przycisk 'ZAMAWIAM I PLACE'.")
    public void weryfikacjaGeneratoraLinkowKursu(){
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();
        kursyPage.przejdzDoTworzeniaNowegoKursu();
        kursyPage.poczekajNaOknoUtworzNowyKurs();
        kursyPage.wpiszNazweKursu();
        kursyPage.wpiszCeneKursu();
        kursyPage.nacisnijPrzyciskUtworzIEdytuj();
        edytujKursyPage.przewinStroneDoSekcjiSprzedaz();
        edytujKursyPage.wlaczSprzedazWSekcjiSprzedaz();
        edytujKursyPage.przewinStroneDoSekcjiWarianty();
        edytujKursyPage.utworzCzteryWariantyDoTestu();
        edytujKursyPage.przewinStroneDoZakladkiGeneratorLinkow();
        edytujKursyPage.przejdzDoZakladkiGeneratorLinkow();
        edytujKursyPage.pobierzLinkZPolaLinkZakupowy();
        edytujKursyPage.przejdzDoLinkuZPolaLinkZakupowy();

        Assert.assertTrue(podsumowanieZamowieniaPage.weryfikacjaCzyZamawiamIPlaceButtonIstnieje(), "Zamawiam i place button nie istnieje.");
    }
}
