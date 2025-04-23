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
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiUslugi();
        uslugiPage.przejdzDoPierwszejUslugiZListy();

        Assert.assertEquals(edycjaUslugiPage.zwrocAktualnyTytulStronyEdycjaUslugi(), edycjaUslugiPage.zwrocPoprawnyTytulStronyEdycjaUslugi(), "Tytul strony 'Edycja usługi' nie jest poprawny.");
    }

    @Test(priority = 30, enabled = true, description = "Weryfikacja czy na stronie Edycja usługi istnieja sekcje 'Podstawowe' i 'Generator linkow'.")
    public void weryfikacjaCzyIstniejaPozycjePodstawoweIGeneratorLinkow() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiUslugi();
        uslugiPage.poczekajNaTabeleUslug();
        uslugiPage.przejdzDoPierwszejUslugiZListy();
        edycjaUslugiPage.poczekajNaUstawienia();

        Assert.assertTrue(edycjaUslugiPage.zweryfikujCzyWMenuBocznymIstniejaPodstawoweIGeneratorLinkow(), "Sekcje 'Podstawowe' i/lub 'Generator linkow' nie istnieja.");
    }

    @Test(priority = 40, enabled = true, description = "Weryfikacja czy na stronie Edycja usługi istnieje przycisk 'Zobacz usługę'.")
    public void weryfikacjaCzyIstniejaPrzyciskZobaczUsluge() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiUslugi();
        uslugiPage.poczekajNaTabeleUslug();
        uslugiPage.przejdzDoPierwszejUslugiZListy();

        Assert.assertTrue(edycjaUslugiPage.zweryfikujCzyIstniejeZobaczUslugeButton(), "Przycisk 'Zobacz usługę' nie istnieje.");
    }

    @Test(priority = 50, enabled = true, description = "Weryfikacja czy na stronie Edycja usługi istnieja wszystkie sekcje ustawień.")
    public void wyeryfikacjaCzyIstniejaSekcjeUstawien() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiUslugi();
        uslugiPage.poczekajNaTabeleUslug();
        uslugiPage.przejdzDoPierwszejUslugiZListy();
        edycjaUslugiPage.poczekajNaUstawienia();

        Assert.assertEquals(edycjaUslugiPage.zwrocAktualneSekcje(), edycjaUslugiPage.zwrocPoprawneSekcje(), "Nie wszystkie sekcje ustawien istnieja.");
    }


}
