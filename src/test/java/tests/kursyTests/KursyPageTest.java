package tests.kursyTests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.kursy.KursyPage;
import pages.LoginPageNew;
import pages.PanelPage;
import tests.TestBase;


public class KursyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private KursyPage kursyPage;

    /*****************sekja techniczna KONIEC **********************************************/

    // Metoda uruchamiana przed każdym testem
    // Inicjalizacja obiektów stron potrzebnych do wykonania testów
    @BeforeMethod
    public void setUPKursyPage(){
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        kursyPage = new KursyPage(driver);
    }
    // Test weryfikujący, czy adres URL strony 'Kursy' jest poprawny
    @Test(priority = 10, enabled = true, description = "Weryfikacja poprawnego adresu strony 'Kursy'")
    public void weryfikacjaPoprawnegoAdresuStronyKursy(){
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();

        Assert.assertEquals(kursyPage.zwrocUrlAktualnejStrony(), kursyPage.zwrocPoprawnyUrlKursow(), "Adres url nie jest poprawny");
    }
    // Test weryfikujący, czy tytuł strony 'Kursy' jest poprawny
    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego tytułu strony 'Kursy'")
    public void weryfikacjaTytuluStronyKursy(){
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();

        Assert.assertEquals(kursyPage.zwroctTytulAktualnejStrony(), kursyPage.zwrocPoprawnyTytulStronyKursy(), "Tytuł strony nie jest poprawny" );
    }

}
