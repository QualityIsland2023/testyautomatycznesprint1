package tests.kursyTests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.kursy.EdytujKursyPage;
import pages.kursy.KursyPage;
import tests.TestBase;


public class EdytujKursyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private KursyPage kursyPage;
    private EdytujKursyPage edytujKursyPage;

    /***************** sekja techniczna KONIEC **********************************************/

    // Metoda uruchamiana przed każdym testem
    // Inicjalizacja obiektów stron potrzebnych do wykonania testów
    @BeforeMethod
    public void setUPEdytujKursyPage(){
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        kursyPage = new KursyPage(driver);
        edytujKursyPage = new EdytujKursyPage(driver);
    }
    // Test weryfikujący, czy adres URL strony 'Edycja kursu' jest poprawny
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
        edytujKursyPage.poczekajNaOknoUEdycjaKursu();

        Assert.assertTrue(edytujKursyPage.zwrocUrlAktualnejStrony(), "Adres url nie jest poprawny");
    }
    // Test weryfikujący, czy tytuł strony 'Edycja kursu' jest poprawny
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
        edytujKursyPage.poczekajNaOknoUEdycjaKursu();

        Assert.assertEquals(edytujKursyPage.zwroctTytulAktualnejStrony(), edytujKursyPage.zwrocPoprawnyTytulStronyEdytujKursy(), "Nazwy pozycji w menu głównego nie są poprawne" );
    }

}
