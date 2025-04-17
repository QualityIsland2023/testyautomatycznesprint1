package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CertyfikatyPage;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.UslugiPage;

public class UslugiPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private UslugiPage uslugiPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpUslugiPage() {
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        uslugiPage = new UslugiPage(driver);
    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja czy zakładka Usługi, posiada prawidłowy adres URL.")
    public void weryfikacjaAdresuURLZakladkiUslugi() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiUslugi();

        Assert.assertEquals(uslugiPage.zwrocAktualnyURLZakladkiUslugi(), uslugiPage.zwrocPoprawnyURLZakladkiUslugi(), "Adres Url zakładki Usługi nie jest poprawny");

    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja czy zakładka Usługi, posiada prawidłowy tytuł.")
    public void weryfikacjaTytuluZakladkiUslugi() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiUslugi();

        Assert.assertEquals(uslugiPage.zwrocAktualnyTytulZakladkiUslugi(), uslugiPage.zwrocPoprawnyTytulZakladkiUslugi());
    }
}
