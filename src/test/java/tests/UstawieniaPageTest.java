package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.UstawieniaPage;


public class UstawieniaPageTest extends TestBase  {

    /****************sekja techniczna START **********************************************/


    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private UstawieniaPage ustawieniaPage;
    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpUstawieniaPage(){
        //inicjalizacja strony ustawienia , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        ustawieniaPage = new UstawieniaPage(driver);
    }



    @Test(priority = 110, enabled = true, description = "Weryfikacja url strony ustawienia")
    public void zweryfikujPoprawnyUrlUstawienia() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        Assert.assertEquals(ustawieniaPage.getAktualnyUrlUstawienia(), ustawieniaPage.getPoprawnyUrlUstawienia(),  "Url strony ustawienia nie jest poprawny");
    }

    @Test(priority = 120, enabled = true, description = "Weryfikacja tytulu strony ustawienia")
    public void zweryfikujPoprawnyTytulUstawienia() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        Assert.assertEquals(ustawieniaPage.getAktualnyTytulUstawienia(), ustawieniaPage.getPoprawnyTytulUstawienia(),  "Tytul strony ustawienia nie jest poprawny");
    }







}
