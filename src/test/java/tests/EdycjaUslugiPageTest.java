package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EdycjaUslugiPage;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.UslugiPage;

public class EdycjaUslugiPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private UslugiPage uslugiPage;
    private EdycjaUslugiPage edycjaUslugiPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpEdycjaUslugiPage() {
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        uslugiPage = new UslugiPage(driver);
        edycjaUslugiPage = new EdycjaUslugiPage(driver);
    }

    //@Test(priority = 10, enabled = true, description = "Weryfikacja czy strona Edycja usługi posiada prawidłowy adres URL.")
    //public void weryfikacjaAdresuURLStronyEdycjaUslugi() {
    //  loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
    //  loginPageNew.wpiszHasloDoPolaHaslo();
    //  loginPageNew.nacisnijPrzyciskZalogujSie();
    //    panelPage.przejdzDoZakladkiUslugi();
    //    uslugiPage.przejdzDoStronyEdycjaUslugi();

    //   Assert.assertEquals(edycjaUslugiPage.zwrocAktualnyURLStronyEdycjaUslugi(), edycjaUslugiPage.zwrocPoprawnyURLStronyEdycjaUslugi(), "Adres Url strony Edycja usługi nie jest poprawny");
//}

    @Test(priority = 20, enabled = true, description = "Weryfikacja czy strona Edycja usługi posiada prawidłowy tytuł.")
    public void weryfikacjaTytuluStronyEdycjaUslugi() {
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiUslugi();
        uslugiPage.przejdzDoStronyEdycjaUslugi();

        Assert.assertEquals(edycjaUslugiPage.zwrocAktualnyTytulStronyEdycjaUslugi(), edycjaUslugiPage.zwrocPoprawnyTytulStronyEdycjaUslugi());
    }
}
