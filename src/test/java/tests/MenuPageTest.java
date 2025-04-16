package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.MenuPage;
import pages.PanelPage;
import pages.UstawieniaPage;


public class MenuPageTest extends TestBase  {

    /****************sekja techniczna START **********************************************/


    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private UstawieniaPage ustawieniaPage;
    private MenuPage menuPage;
    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpMenuPage(){
        //inicjalizacja strony menu , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        ustawieniaPage = new UstawieniaPage(driver);
        menuPage = new MenuPage(driver);
    }



    @Test(priority = 110, enabled = true, description = "Weryfikacja url strony menu")
    public void zweryfikujPoprawnyUrlUMenu() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkMenu();
        Assert.assertEquals(menuPage.getAktualnyUrlMenu(), menuPage.getPoprawnyUrlMenu(),  "Url strony menu nie jest poprawny");
    }

    @Test(priority = 120, enabled = true, description = "Weryfikacja url strony menu")
    public void zweryfikujPoprawnyTytulUMenu() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkMenu();
        Assert.assertEquals(menuPage.getAktualnyTytulMenu(), menuPage.getPoprawnyTytulMenu(),  "Tytul strony menu nie jest poprawny");
    }







}
