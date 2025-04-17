package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class DodajWideoPageTest extends TestBase {

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private MediaPage mediaPage;
    private WideoPage wideoPage;
    private DodajWideoPage dodajWideoPage;

    @BeforeMethod
    public void setUpWideoPage() {
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        mediaPage = new MediaPage(driver);
        wideoPage = new WideoPage(driver);
        dodajWideoPage = new DodajWideoPage(driver);
    }

    private void przejdzDoStronyDodajWideo() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiMedia();
        mediaPage.przejdzDoZakladkiWideo();
        wideoPage.kliknijDodajWideoButton();
    }

    @Test(priority = 100, enabled = true, description = "Weryfikacja adresu URL strony 'Dodaj wideo'")
    public void weryfikacjaAdresuUrlStronyDodajWideo() {
        przejdzDoStronyDodajWideo();
        Assert.assertEquals(driver.getCurrentUrl(), dodajWideoPage.getPoprawnyUrlStrony(), "Adres URL strony jest niepoprawny.");
    }

    @Test(priority = 110, enabled = true, description = "Weryfikacja tytułu strony 'Dodaj wideo'")
    public void weryfikacjaTytuluStronyDodajWideo() {
        przejdzDoStronyDodajWideo();
        Assert.assertEquals(driver.getTitle(), dodajWideoPage.getPoprawnyTytulStrony(), "Tytuł strony jest niepoprawny.");
    }

}
