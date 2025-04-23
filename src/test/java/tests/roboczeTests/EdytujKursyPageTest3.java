package tests.roboczeTests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.kursy.EdytujKursyPage;
import pages.kursy.KursyPage;
import pages.LoginPageNew;
import pages.PanelPage;
import tests.TestBase;


public class EdytujKursyPageTest3 extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private KursyPage kursyPage;
    private EdytujKursyPage edytujKursyPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPKursyEdytujKursyPage(){
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        kursyPage = new KursyPage(driver);
        edytujKursyPage = new EdytujKursyPage(driver);
    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja poprawnego adresu strony 'Edycja kursu'")
    public void weryfikacjaPoprawnegoAdresuStronyEdytujKursy(){
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();
        kursyPage.przejdzDoTworzeniaNowegoKursu();
        kursyPage.poczekajNaOknoUtworzNowyKurs();
        kursyPage.wpiszNazweKursu();
        kursyPage.wpiszCeneKursu();
        kursyPage.nacisnijPrzyciskUtworzIEdytuj();
        edytujKursyPage.poczekajNaOknoEdycjaKursu();
//        edytujKursyPage.zwrocUrlAktualnejStronyEdycji();
//        edytujKursyPage.przechwycUrlStronyEdycjiTworzonegoKursu();
//        edytujKursyPage.ustawPoprawnyPrzechwyconyUrlStronyEdycjiTworzonegoKursu();
//        panelPage.przejdzDoZakladkiKursy();
//        edytujKursyPage.przejdzDoAktualnieUtworzonegoKursu();

//        Assert.assertEquals(edytujKursyPage.zwrocUrlAktualnieUtworzonegoKursu(), edytujKursyPage.pobierzPoprawnyPrzechwyconyUrlStronyEdycjiTworzonegoKursu(), "Adres url nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego tytułu strony 'Edycja kursu'")
    public void weryfikacjaTytuluStronyEdytujKursy(){
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();
        kursyPage.przejdzDoTworzeniaNowegoKursu();
        kursyPage.poczekajNaOknoUtworzNowyKurs();
        kursyPage.wpiszNazweKursu();
        kursyPage.wpiszCeneKursu();
        kursyPage.nacisnijPrzyciskUtworzIEdytuj();
        edytujKursyPage.poczekajNaOknoEdycjaKursu();

        Assert.assertEquals(edytujKursyPage.zwroctTytulAktualnejStrony(), edytujKursyPage.zwrocPoprawnyTytulStronyEdytujKursy(), "Nazwy pozycji w menu głównego nie są poprawne" );
    }

}
