package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.SprzedazPlatnosciZaplanowanePage;


public class SprzedazPlatnosciZaplanowanePageTest extends TestBase {

    /**************** Sekcja techniczna START **********************************************/

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private SprzedazPlatnosciZaplanowanePage sprzedazPlatnosciZaplanowanePage; //instancja strony logowania

    /***************** Sekcja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage(){
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        sprzedazPlatnosciZaplanowanePage = new SprzedazPlatnosciZaplanowanePage(driver);
    }


    @Test(priority = 10, enabled = true, description = "Weryfikacja tytyłu strony PŁATNOŚCI ZAPLANOWANE")
    public void weryfikacjaTytuluStronyPlatnosciZaplanowane(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazPlatnosciZaplanowaneMenu();

        Assert.assertEquals(sprzedazPlatnosciZaplanowanePage.zwrocAktualnyTytulStronyPlatnosciZaplanowane(),
                sprzedazPlatnosciZaplanowanePage.zwrocPoprawnyTytulStronyPlatnosciZaplanowane(),
                "Tytuł strony PŁATNOŚCI ZAPLANOWANE nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego adresu strony PŁATNOŚCI ZAPLANOWANE"  )
    public void weryfikacjaPoprawnegoAdresuStronyPlatnosciZaplanowane(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazPlatnosciZaplanowaneMenu();

        Assert.assertEquals(sprzedazPlatnosciZaplanowanePage.zwrocAktualnyUrlStronyPlatnosciZaplanowane(),
                sprzedazPlatnosciZaplanowanePage.zwrocPoprawnyUrlStronyPlatnosciZaplanowane(),
                "Adres url strony PŁATNOŚCI ZAPLANOWANE nie jest poprawny");
    }









}
