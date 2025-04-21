package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.SprzedazZamowieniaPage;


public class SprzedazZamowieniaPageTest extends TestBase {

    //**************** Sekcja techniczna START **********************************************/

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private SprzedazZamowieniaPage sprzedazZamowieniaPage;


    //***************** Sekcja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage(){
        //inicjalizacja strony logowania, linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        sprzedazZamowieniaPage = new SprzedazZamowieniaPage(driver);
    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja tytułu strony ZAMÓWIENIA")
    public void weryfikacjaTytuluStronyZamowienia(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();

        Assert.assertEquals(sprzedazZamowieniaPage.zwrocAktualnyTytulStronyZamowienia(),
                sprzedazZamowieniaPage.zwrocPoprawnyTytulStronyZamowienia(),
                "Tytuł strony ZAMÓWIENIA nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego adresu strony ZAMÓWIENIA"  )
    public void weryfikacjaPoprawnegoAdresuStronyZamowienia(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();

        Assert.assertEquals(sprzedazZamowieniaPage.zwrocAktualnyUrlStronyZamowienia(),
                sprzedazZamowieniaPage.zwrocPoprawnyUrlStronyZamowienia(),
                "Adres url strony ZAMÓWIENIA nie jest poprawny");
    }

    @Test(priority = 30, enabled = true, description = "Weryfikacja widoczności przycisku DODAJ ZAMÓWIENIE")
    public void weryfikacjaWidocznosciPrzyciskuDodajZamowienie(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();

        Assert.assertTrue(sprzedazZamowieniaPage.zwrocDodajZamowienieButton().isDisplayed(),
                "Przycisk 'Dodaj zamówienie' nie jest widoczny");
    }

    @Test(priority = 40, enabled = true, description = "Weryfikacja widoczności przycisku TYPY DANYCH")
    public void weryfikacjaWidocznosciPrzyciskuTypyDanych(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();

        Assert.assertTrue(sprzedazZamowieniaPage.zwrocTypyDanychButton().isDisplayed(),
                "Przycisk 'Typy danych' nie jest widoczny");
    }

    @Test(priority = 50, enabled = true, description = "Weryfikacja poprawnego tekstu informacji w sekcji TYPY DANYCH")
    public void weryfikacjaPoprawnegoTekstuInformacjiWSekcjiTypyDanych(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        sprzedazZamowieniaPage.kliknijTypyDanychButton();

        Assert.assertEquals(sprzedazZamowieniaPage.zwrocAktualnyTekstInformacjiWSekcjiTypyDanych(),
                sprzedazZamowieniaPage.zwrocPoprawnyTekstInformacjiWSekcjiTypyDanych(),
                "Informacja w sekcji 'Typy danych' nie jest poprawna");
    }

    @Test(priority = 60, enabled = true, description = "Weryfikacja widoczności informacji w sekcji TYPY DANYCH")
    public void weryfikacjaWidocznosciInformacjiWSekcjiTypyDanych(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        sprzedazZamowieniaPage.kliknijTypyDanychButton();

        Assert.assertTrue(sprzedazZamowieniaPage.zwrocInformacjeWSekcjiTypyDanych().isDisplayed(),
                "Informacja w sekcji 'Typy danych' nie jest widoczna");
    }








}
