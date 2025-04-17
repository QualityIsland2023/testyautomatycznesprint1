package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.MediaPage;
import pages.PanelPage;
import pages.WideoPage;

public class WideoPageTest extends TestBase {

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private MediaPage mediaPage;
    private WideoPage wideoPage;

    @BeforeMethod
    public void setUpWideoPage() {
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        mediaPage = new MediaPage(driver);
        wideoPage = new WideoPage(driver);
    }

    private void przejdzDoZakladkiWideo() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiMedia();
        mediaPage.przejdzDoZakladkiWideo();
    }

    @Test(priority = 100, enabled = true, description = "Weryfikacja adresu URL strony 'Wideo'")
    public void weryfikacjaAdresuUrlZakladkiWideo() {
        przejdzDoZakladkiWideo();
        Assert.assertEquals(driver.getCurrentUrl(), wideoPage.getPoprawnyUrlStrony(), "Adres URL strony jest niepoprawny.");
    }

    @Test(priority = 110, enabled = true, description = "Weryfikacja tytułu strony 'Wideo'")
    public void weryfikacjaTytuluZakladkiWideo() {
        przejdzDoZakladkiWideo();
        Assert.assertEquals(driver.getTitle(), wideoPage.getPoprawnyTytulStrony(), "Tytuł strony jest niepoprawny.");
    }


}
