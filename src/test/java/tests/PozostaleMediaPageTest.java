package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class PozostaleMediaPageTest extends TestBase {

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private MediaPage mediaPage;
    private PozostaleMediaPage pozostaleMediaPage;

    @BeforeMethod
    public void setUpPozostaleMediaPage() {
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        mediaPage = new MediaPage(driver);
        pozostaleMediaPage = new PozostaleMediaPage(driver);
    }


    private void przejdzDoZakladkiPozostaleMedia() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiMedia();
        mediaPage.przejdzDoZakladkiPozostaleMedia();
    }

    @Test(priority = 100, enabled = true, description = "Weryfikacja adresu URL strony 'Pozostałe media'")
    public void weryfikacjaAdresuUrlZakladkiWideo() {
        przejdzDoZakladkiPozostaleMedia();
        Assert.assertEquals(driver.getCurrentUrl(), pozostaleMediaPage.getPoprawnyUrlStrony(), "Adres URL strony jest niepoprawny.");
    }

    @Test(priority = 110, enabled = true, description = "Weryfikacja tytułu strony 'Pozostałe media'")
    public void weryfikacjaTytuluZakladkiWideo() {
        przejdzDoZakladkiPozostaleMedia();
        Assert.assertEquals(driver.getTitle(), pozostaleMediaPage.getPoprawnyTytulStrony(), "Tytuł strony jest niepoprawny.");
    }

}
