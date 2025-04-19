package pages.media;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PozostaleMediaPage {

    private WebDriver driver;
    private Waits wait;


    // Poprawny URL podstrony "Pozostałe media"
    private String poprawnyUrlPozostaleMedia = "https://mmrmqpr585.publigo.onl/wp-admin/upload.php";

    // Poprawny tytuł podstrony "Pozostałe media"
    private String poprawnyTytulPozostaleMedia = "Biblioteka mediów ‹ Platforma kursów online — WordPress";

    public PozostaleMediaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPoprawnyUrlStrony() {
        return poprawnyUrlPozostaleMedia;
    }

    public String getPoprawnyTytulStrony() {
        return poprawnyTytulPozostaleMedia;
    }

}
