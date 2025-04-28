package tests.narzedziaTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.PowiadomieniaPage;
import tests.TestBase;

public class PowiadomieniaPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private PowiadomieniaPage powiadomieniaPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage() {
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        powiadomieniaPage = new PowiadomieniaPage(driver);

    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja czy zakladka powiadomienia w menu bocznym, posiada prawidlowy adres URL.")
    public void weryfikacjaAdresuURLZakladkiPowiadomienia() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiPowiadomienia();

        Assert.assertEquals(powiadomieniaPage.zwrocAktualnyURLZakladkiPowiadomienia(), powiadomieniaPage.zwrocPoprawnyURLZakladkiPowiadomienia());

    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja czy zakladka powiadomienia w menu bocznym, posiada prawidlowy tytul.")
    public void weryfikacjaTytuluZakladkiPowiadomienia() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiPowiadomienia();

        Assert.assertEquals(powiadomieniaPage.zwrocAktualnyTytulZakladkiPowiadomienia(), powiadomieniaPage.zwrocPoprawnyTytulZakladkiPowiadomienia());
    }


}
