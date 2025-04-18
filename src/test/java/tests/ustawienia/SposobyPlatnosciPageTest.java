package tests.ustawienia_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.ustawienia_pages.SposobyPlatnosciPage;
import pages.ustawienia_pages.UstawieniaPage;
import tests.TestBase;


public class SposobyPlatnosciPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/


    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private UstawieniaPage ustawieniaPage;
    private SposobyPlatnosciPage sposobyPlatnosciPage;
    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpSposobyPlatnosciPage(){
        //inicjalizacja strony sposoby Platnosci , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        ustawieniaPage = new UstawieniaPage(driver);
        sposobyPlatnosciPage = new SposobyPlatnosciPage(driver);
    }



    @Test(priority = 110, enabled = true, description = "Weryfikacja url strony sposoby Platnosci")
    public void zweryfikujPoprawnyUrlSposobyPlatnosci() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkSposobyPlatnosci();
        Assert.assertEquals(sposobyPlatnosciPage.getAktualnyUrlSposobyPlatnosci(), sposobyPlatnosciPage.getPoprawnyUrlSposobyPlatnosci(),  "Url strony sposoby Platnosci nie jest poprawny");
    }

    @Test(priority = 120, enabled = true, description = "Weryfikacja tytulu strony sposoby Platnosci")
    public void zweryfikujPoprawnyTytulSposobyPlatnosci() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkSposobyPlatnosci();
        Assert.assertEquals(sposobyPlatnosciPage.getAktualnyTytulSposobyPlatnosci(), sposobyPlatnosciPage.getPoprawnyTytulSposobyPlatnosci(),  "Tytul strony sposoby Platnosci nie jest poprawny");
    }

    @Test(priority = 120, enabled = true, description = "Weryfikacja poprawnosci sekcji w zakladce sposoby platnosci")
    public void zweryfikujPoprawnoscSekcjiZakladkaSposobyPlatnosci() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkSposobyPlatnosci();
        Assert.assertTrue(sposobyPlatnosciPage.czyZakladkaSposobyPlatnosciPosiadaWlasciweSekcje(),   "Sekcje w zakladce sposoby platnosci nie sa poprawne");
    }







}
