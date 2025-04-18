package tests.ustawienia_tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.ustawienia_pages.CertyfikatyPage;
import pages.ustawienia_pages.UstawieniaPage;
import tests.TestBase;

public class CertyfikatyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private UstawieniaPage ustawieniaPage;
    private CertyfikatyPage certyfikatyPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage() {
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        ustawieniaPage = new UstawieniaPage(driver);
        certyfikatyPage = new CertyfikatyPage(driver);
    }

    // Test weryfikujący, czy adres URL strony "Certyfikaty" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja url strony Certyfikaty")
    public void zweryfikujPoprawnyUrlCertyfikaty() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkCertyfikaty();
        Assert.assertEquals(certyfikatyPage.getAktualnyUrlCertyfikaty(), certyfikatyPage.getPoprawnyUrlCertyfikaty(),  "Url strony Certyfikaty nie jest poprawny");
    }

    // Test weryfikujący, czy tytuł strony "Certyfikaty" jest poprawny
    @Test(priority = 120, enabled = true, description = "Weryfikacja tytulu strony Certyfikaty")
    public void zweryfikujPoprawnyTytulCertyfikaty() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkCertyfikaty();
        Assert.assertEquals(certyfikatyPage.getAktualnyTytulCertyfikaty(), certyfikatyPage.getPoprawnyTytulCertyfikaty(),  "Tytul strony Certyfikaty nie jest poprawny");
    }

    @Test(priority = 120, enabled = true, description = "Weryfikacja poprawnosci sekcji w zakladce certyfikaty")
    public void zweryfikujPoprawnoscSekcjiCertyfikaty() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijPrzyciskUstawienia();
        ustawieniaPage.kliknijLinkCertyfikaty();
        Assert.assertTrue(certyfikatyPage.czyZakladkaCertyfikatyPosiadaWlasciweSekcje(),   "Sekcje w zakladce certyfikaty nie sa poprawne");
    }
}
