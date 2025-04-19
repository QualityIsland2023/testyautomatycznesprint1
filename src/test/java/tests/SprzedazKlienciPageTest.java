package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.SprzedazKlienciPage;


public class SprzedazKlienciPageTest extends TestBase {

    //**************** Sekcja techniczna START **********************************************/

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private SprzedazKlienciPage sprzedazKlienciPage; //instancja strony logowania

    //***************** Sekcja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage(){
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        sprzedazKlienciPage = new SprzedazKlienciPage(driver);
    }


    @Test(priority = 10, enabled = true, description = "Weryfikacja tytułu strony KLIENCI")
    public void weryfikacjaTytuluStronyKlienci(){

        loginPageNew.wykonajLogowanie();;
        panelPage.kliknijSprzedazKlienciMenu();

        Assert.assertEquals(sprzedazKlienciPage.zwrocAktualnyTytulStronyKlienci(),
                sprzedazKlienciPage.zwrocPoprawnyTytulStronyKlienci(),
                "Tytuł strony KLIENCI nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego adresu strony KLIENCI"  )
    public void weryfikacjaPoprawnegoAdresuStronyKlienci(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazKlienciMenu();

        Assert.assertEquals(sprzedazKlienciPage.zwrocAktualnyUrlStronyKlienci(),
                sprzedazKlienciPage.zwrocPoprawnyUrlStronyKlienci(),
                "Adres url strony KLIENCI nie jest poprawny");
    }






}
