package tests;

import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class CertyfikatyPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private CertyfikatyPage certyfikatyPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage() {
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        certyfikatyPage = new CertyfikatyPage(driver);
    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja czy strona edycji testow zlokalizowana po nacisnieciu w test w zakladce testy, posiada prawidlowy adres URL.")
    public void weryfikacjaAdresuURLStronyEdytujTest() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiCertyfikaty();

        Assert.assertEquals(certyfikatyPage.zwrocAktualnyURLZakladkiCertyfikatyt(), certyfikatyPage.zwrocPoprawnyURLZakladkiCertyfikaty());

    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja trona edycji testow zlokalizowana po nacisnieciu w test w zakladce testy, posiada prawidlowy tytul.")
    public void weryfikacjaTytuluStronyEdytujTest() {
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiCertyfikaty();

        Assert.assertEquals(certyfikatyPage.zwrocAktualnyTytulZakladkiCertyfikatyt(), certyfikatyPage.zwrocPoprawnyTytulZakladkiCertyfikaty());
    }
}
