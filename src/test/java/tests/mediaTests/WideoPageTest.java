package tests.mediaTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.MediaPage;
import pages.PanelPage;
import pages.media.WideoPage;
import tests.TestBase;

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
    // Metoda wewnętrzna - wykonuje wszystkie kroki począwszy od panelu logowania przenosząc nas do strony "Wideo"
    private void przejdzDoZakladkiWideo() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiMedia();
        mediaPage.przejdzDoZakladkiWideo();
    }

    // Sprawdza czy adres URL strony "Wideo" jest poprawny
    @Test(priority = 100, enabled = true, description = "Weryfikacja adresu URL strony 'Wideo'")
    public void weryfikacjaAdresuUrlZakladkiWideo() {
        przejdzDoZakladkiWideo();
        Assert.assertEquals(driver.getCurrentUrl(), wideoPage.getPoprawnyUrlStrony(), "Adres URL strony jest niepoprawny.");
    }

    // Sprawdza czy tytuł strony "Wideo" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja tytułu strony 'Wideo'")
    public void weryfikacjaTytuluZakladkiWideo() {
        przejdzDoZakladkiWideo();
        Assert.assertEquals(driver.getTitle(), wideoPage.getPoprawnyTytulStrony(), "Tytuł strony jest niepoprawny.");
    }


}
