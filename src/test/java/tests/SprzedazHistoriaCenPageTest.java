package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SprzedazHistoriaCenPageTest extends TestBase {

    /**************** Sekcja techniczna START **********************************************/

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private SprzedazHistoriaCenPage sprzedazHistoriaCenPage; //instancja strony logowania

    /***************** Sekcja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage(){
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        sprzedazHistoriaCenPage = new SprzedazHistoriaCenPage(driver);
    }


    @Test(priority = 10, enabled = true, description = "Weryfikacja tytyłu strony HISTORIA CEN")
    public void weryfikacjaTytuluStronyHistoriaCen(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazHistoriaCenMenu();

        Assert.assertEquals(sprzedazHistoriaCenPage.zwrocAktualnyTytulStronyHistoriaCen(),
                sprzedazHistoriaCenPage.zwrocPoprawnyTytulStronyHistoriaCen(),
                "Tytuł strony HISTORIA CEN nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego adresu strony HISTORIA CEN"  )
    public void weryfikacjaPoprawnegoAdresuStronyHistoriaCen(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazHistoriaCenMenu();

        Assert.assertEquals(sprzedazHistoriaCenPage.zwrocAktualnyUrlStronyHistoriaCen(),
                sprzedazHistoriaCenPage.zwrocPoprawnyUrlStronyHistoriaCen(),
                "Adres url strony HISTORIA CEN nie jest poprawny");
    }









}
