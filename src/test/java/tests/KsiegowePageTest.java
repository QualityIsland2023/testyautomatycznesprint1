package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.KsiegowePage;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.UstawieniaPage;


public class KsiegowePageTest extends TestBase  {

    /****************sekja techniczna START **********************************************/


    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private UstawieniaPage ustawieniaPage;
    private KsiegowePage ksiegowePage;
    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpKsiegowePage(){
        //inicjalizacja strony ksiegowe , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        ustawieniaPage = new UstawieniaPage(driver);
        ksiegowePage = new KsiegowePage(driver);
    }



    @Test(priority = 110, enabled = true, description = "Weryfikacja url strony ksiegowe")
    public void zweryfikujPoprawnyUrlKsiegowe() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkKsiegowe();
        Assert.assertEquals(ksiegowePage.getAktualnyUrlKsiegowe(), ksiegowePage.getPoprawnyUrlKsiegowe(),  "Url strony ksiegowe nie jest poprawny");
    }

    @Test(priority = 120, enabled = true, description = "Weryfikacja url strony ksiegowe")
    public void zweryfikujPoprawnyTytulKsiegowe() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkKsiegowe();
        Assert.assertEquals(ksiegowePage.getAktualnyTytulKsiegowe(), ksiegowePage.getPoprawnyTytulKsiegowe(),  "Tytul strony ksiegowe nie jest poprawny");
    }







}
