package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.TestyPage;

public class TestyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private TestyPage testyPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage() {
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        testyPage = new TestyPage(driver);
    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja czy zakladka testy zlokalizowana w menu bocznym posiada prawidlowy adres URL.")
    public void weryfikacjaAdresuURLZakladkiTestyMenuBocznego() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiTesty();

        Assert.assertEquals(testyPage.zwrocPoprawnyURLZakladkiTesty(), testyPage.zwrocAktualnyURLZakladkiTesty());

    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja czy zakladka testy zlokalizowana w menu bocznym posiada prawidlowy tytul.")
    public void weryfikacjaTytuluZakladkiTestyMenuBocznego() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiTesty();

        Assert.assertEquals(testyPage.zwrocPoprawnyTytulZakladkiTesty(), testyPage.zwrocAktualnyTytulZakladkiTesty());
    }

    @Test(priority = 30, enabled = true, description = "Weryfikacja czy lista 'Wynikow na strone' wyswietla sie z zakladce testy znajdujacej sie w menu bocznym.")
    public void weryfikacjaCzyListaWynikowNaStroneJestWZakldaceTesty() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiTesty();

        Assert.assertTrue(testyPage.zweryfikujCzyNapisWynikowNaStroneIstnieje());

    }

    @Test(priority = 40, enabled = true, description = "Weryfikacja czy przycisk 'Typy danych'v wyswietla sie z zakladce testy znajdujacej sie w menu bocznym.")
    public void weryfikacjaCzyWZakladceTestyJestButtonTypyDanych() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiTesty();

        Assert.assertTrue(testyPage.zweryfikujCzyButtonTypyDanychIstnieje());

    }
}
