package pages;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WideoPage {

    private WebDriver driver;
    private Waits wait;

    public WideoPage(WebDriver driver) {
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

    private String poprawnyUrlWideo = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-videos";
    private String poprawnyTytulWideo = "Wideo ‹ Platforma kursów online — WordPress";

    @FindBy(linkText = "Dodaj wideo")
    private WebElement dodajWideoButton;

    public void kliknijDodajWideoButton() {
        dodajWideoButton.click();
    }



}
