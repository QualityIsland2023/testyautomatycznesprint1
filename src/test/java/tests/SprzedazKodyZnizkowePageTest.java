package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.SprzedazKodyZnizkowePage;


public class SprzedazKodyZnizkowePageTest extends TestBase {

    //**************** Sekcja techniczna START **********************************************/

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private SprzedazKodyZnizkowePage sprzedazKodyZnizkowePage; //instancja strony logowania

    //***************** Sekcja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage(){
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        sprzedazKodyZnizkowePage = new SprzedazKodyZnizkowePage(driver);
    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja tytułu strony KODY ZNIŻKOWE")
    public void weryfikacjaTytuluStronyKodyZnizkowe(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazKodyZnizkoweMenu();

        Assert.assertEquals(sprzedazKodyZnizkowePage.zwrocAktualnyTytulStronyKodyZnizkowe(),
                sprzedazKodyZnizkowePage.zwrocPoprawnyTytulStronyKodyZnizkowe(),
                "Tytuł strony KODY ZNIŻKOWE nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego adresu strony KODY ZNIŻKOWE"  )
    public void weryfikacjaPoprawnegoAdresuStronyKodyZnizkowe(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazKodyZnizkoweMenu();

        Assert.assertEquals(sprzedazKodyZnizkowePage.zwrocAktualnyUrlStronyKodyZnizkowe(),
                sprzedazKodyZnizkowePage.zwrocPoprawnyUrlStronyKodyZnizkowe(),
                "Adres url strony KODY ZNIŻKOWE nie jest poprawny");
    }









}
