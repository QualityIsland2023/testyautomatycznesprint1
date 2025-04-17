package pages;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PozostaleMediaPage {

    private WebDriver driver;
    private Waits wait;

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

    private String poprawnyUrlPozostaleMedia = "https://mmrmqpr585.publigo.onl/wp-admin/upload.php";
    private String poprawnyTytulPozostaleMedia = "Biblioteka mediów ‹ Platforma kursów online — WordPress";


}
