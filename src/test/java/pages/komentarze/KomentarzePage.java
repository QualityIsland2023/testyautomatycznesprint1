package pages.komentarze;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KomentarzePage {

    private WebDriver driver;
    private Waits wait;

    // Poprawny URL podstrony "Komentarze"
    private String poprawnyUrlPozostaleMedia = "https://mmrmqpr585.publigo.onl/wp-admin/edit-comments.php";

    // Poprawny tytuł podstrony "Komentarze"
    private String poprawnyTytulPozostaleMedia = "Komentarze (1) ‹ Platforma kursów online — WordPress";

    public KomentarzePage(WebDriver driver) {
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
