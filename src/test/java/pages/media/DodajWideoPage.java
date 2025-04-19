package pages.media;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DodajWideoPage {

    private WebDriver driver;
    private Waits wait;

    // Poprawny URL podstrony "Dodaj wideo"
    private String poprawnyUrlWideo = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=publigo-video-uploader";

    // Poprawny tytuł podstrony "Dodaj wideo"
    private String poprawnyTytulWideo = "‹ Platforma kursów online — WordPress";


    public DodajWideoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPoprawnyUrlStrony() {
        return poprawnyUrlWideo;
    }

    public String getPoprawnyTytulStrony() {
        return poprawnyTytulWideo;
    }


}
