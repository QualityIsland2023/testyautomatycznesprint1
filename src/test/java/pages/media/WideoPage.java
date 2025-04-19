package pages.media;

import helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WideoPage {

    private WebDriver driver;
    private Waits wait;

    // Poprawny URL podstrony "Wideo
    private String poprawnyUrlWideo = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-videos";

    // Poprawny tytuł podstrony "Wideo"
    private String poprawnyTytulWideo = "Wideo ‹ Platforma kursów online — WordPress";

    // Lista checkboxów pojawiających się w menu po kliknięciu buttona "Typy danych"
    @FindBy(linkText = "Dodaj wideo")
    private WebElement dodajWideoButton;

    // Button "Typy danych" znajdujący się w prawym-górnym rogu strony "Wideo"
    @FindBy(xpath = "//button[text()='Typy danych']")
    private WebElement typyDanychButton;

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

    public WebElement getDodajWideoButton() {
        return dodajWideoButton;
    }

    public WebElement getTypyDanychButton() {
        return typyDanychButton;
    }

    // Checkboxy pojawiające się dopiero po kliknięciu przycisku "Typy danych" (łącznie 5 elementów)
    public List<WebElement> getCheckboxyKolumnTabeli() {
        return driver.findElements(By.className("checkbox-replacement"));
    }

    public void kliknijDodajWideoButton() {
        dodajWideoButton.click();
    }

    public void kliknijTypyDanychButton() {
        typyDanychButton.click();
    }

}
