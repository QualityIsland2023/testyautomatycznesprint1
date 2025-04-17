package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.SprzedazUtworzPlatnoscPage;
import pages.SprzedazZamowieniaPage;


public class SprzedazUtworzPlatnoscPageTest extends TestBase {

    /**************** Sekcja techniczna START **********************************************/

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private SprzedazZamowieniaPage sprzedazZamowieniaPage;
    private SprzedazUtworzPlatnoscPage sprzedazUtworzPlatnoscPage;


    /***************** Sekcja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage(){
        //inicjalizacja strony logowania, linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        sprzedazZamowieniaPage = new SprzedazZamowieniaPage(driver);
        sprzedazUtworzPlatnoscPage = new SprzedazUtworzPlatnoscPage(driver);
    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja tytyłu strony UTWÓRZ PŁATNOŚĆ")
    public void weryfikacjaTytuluStronyUtworzPlatnosc(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        sprzedazZamowieniaPage.przejdzDoStronyUtworzPlatnosc();

        Assert.assertEquals(sprzedazUtworzPlatnoscPage.zwrocAktualnyTytulStronyUtworzPlatnosc(),
                sprzedazUtworzPlatnoscPage.zwrocPoprawnyTytulStronyUtworzPlatnosc(),
                "Tytuł strony UTWÓRZ PŁATNOŚĆ nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego adresu strony UTWÓRZ PŁATNOŚĆ"  )
    public void weryfikacjaPoprawnegoAdresuStronyUtworzPlatnosc(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        sprzedazZamowieniaPage.przejdzDoStronyUtworzPlatnosc();

        Assert.assertEquals(sprzedazUtworzPlatnoscPage.zwrocAktualnyUrlStronyUtworzPlatnosc(),
                sprzedazUtworzPlatnoscPage.zwrocPoprawnyUrlStronyUtworzPlatnosc(),
                "Adres url strony UTWÓRZ PŁATNOŚĆ nie jest poprawny");
    }









}
