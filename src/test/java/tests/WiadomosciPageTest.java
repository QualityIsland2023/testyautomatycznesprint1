package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.WiadomosciPage;
import pages.UstawieniaPage;


public class WiadomosciPageTest extends TestBase  {

    /****************sekja techniczna START **********************************************/


    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    // Obiekt reprezentujący stronę ustawień
    private UstawieniaPage ustawieniaPage;
    // Obiekt reprezentujący stronę "Wiadomosci"
    private WiadomosciPage WiadomosciPage;
    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpWiadomosciPage(){
        // Metoda uruchamiana przed każdym testem
        // Inicjalizacja obiektów stron potrzebnych do wykonania testów
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        ustawieniaPage = new UstawieniaPage(driver);
        WiadomosciPage = new WiadomosciPage(driver);
    }



    // Test weryfikujący, czy adres URL strony "Wiadomosci" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja url strony Wiadomosci")
    public void zweryfikujPoprawnyUrlWiadomosci() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkWiadomosci();
        Assert.assertEquals(WiadomosciPage.getAktualnyUrlWiadomosci(), WiadomosciPage.getPoprawnyUrlWiadomosci(),  "Url strony Wiadomosci nie jest poprawny");
    }

    // Test weryfikujący, czy tytuł strony "Wiadomosci" jest poprawny
    @Test(priority = 120, enabled = true, description = "Weryfikacja tytulu strony Wiadomosci")
    public void zweryfikujPoprawnyTytulWiadomosci() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkWiadomosci();
        Assert.assertEquals(WiadomosciPage.getAktualnyTytulWiadomosci(), WiadomosciPage.getPoprawnyTytulWiadomosci(),  "Tytul strony Wiadomosci nie jest poprawny");
    }







}
