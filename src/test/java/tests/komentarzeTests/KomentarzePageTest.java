package tests.komentarzeTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.komentarze.KomentarzePage;
import tests.TestBase;

public class KomentarzePageTest extends TestBase {

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private KomentarzePage komentarzePage;

    @BeforeMethod
    public void setUpKomentarzePage() {
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        komentarzePage = new KomentarzePage(driver);
    }

    // Metoda wewnętrzna - wykonuje wszystkie kroki począwszy od panelu logowania przenosząc nas do zakładki "Komentarze"
    private void przejdzDoZakladkiKomentarze() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiKomentarze();
    }

    // Sprawdza czy adres URL strony "Komentarze" jest poprawny
    @Test(priority = 100, enabled = true, description = "Weryfikacja adresu URL strony 'Komentarze'")
    public void weryfikacjaAdresuUrlZakladkiKomentarze() {
        przejdzDoZakladkiKomentarze();
        Assert.assertEquals(driver.getCurrentUrl(), komentarzePage.getPoprawnyUrlStrony(), "Adres URL strony jest niepoprawny.");
    }

    // Sprawdza czy tytuł strony "Komentarze" jest poprawny
    @Test(priority = 110, enabled = true, description = "Weryfikacja tytułu strony 'Komentarze'")
    public void weryfikacjaTytuluStronyKomentarze() {
        przejdzDoZakladkiKomentarze();
        Assert.assertEquals(driver.getTitle(), komentarzePage.getPoprawnyTytulStrony(), "Tytuł strony jest niepoprawny.");
    }

}
