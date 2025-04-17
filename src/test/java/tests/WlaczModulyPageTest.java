package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.WlaczModulyPage;
import pages.UstawieniaPage;


public class WlaczModulyPageTest extends TestBase  {

    /****************sekja techniczna START **********************************************/


    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    // Obiekt reprezentujący stronę ustawień
    private UstawieniaPage ustawieniaPage;
    // Obiekt reprezentujący stronę "WlaczModuly"
    private WlaczModulyPage wlaczModuly;
    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpWlaczModulyPage(){
        // Metoda uruchamiana przed każdym testem
        // Inicjalizacja obiektów stron potrzebnych do wykonania testów
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        ustawieniaPage = new UstawieniaPage(driver);
        wlaczModuly = new WlaczModulyPage(driver);
    }



    // Test weryfikujący, czy adres URL strony "WlaczModuly" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja url strony WlaczModuly")
    public void zweryfikujPoprawnyUrlWlaczModuly() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkWlaczModuly();
        Assert.assertEquals(wlaczModuly.getAktualnyUrlWlaczModuly(), wlaczModuly.getPoprawnyUrlWlaczModuly(),  "Url strony WlaczModuly nie jest poprawny");
    }

    // Test weryfikujący, czy tytuł strony "WlaczModuly" jest poprawny
    @Test(priority = 120, enabled = true, description = "Weryfikacja tytulu strony WlaczModuly")
    public void zweryfikujPoprawnyTytulWlaczModuly() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkWlaczModuly();
        Assert.assertEquals(wlaczModuly.getAktualnyTytulWlaczModuly(), wlaczModuly.getPoprawnyTytulWlaczModuly(),  "Tytul strony WlaczModuly nie jest poprawny");
    }







}
