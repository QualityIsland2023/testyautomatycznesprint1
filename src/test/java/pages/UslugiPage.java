package pages;
import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UslugiPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public UslugiPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************Repozytorium webelementów START **********************************************/

    String poprawnyURLZakladkiUslugi = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=publigo-services";
    String poprawnyTytulZakladkiUslugi = "Usługi ‹ Platforma kursów online — WordPress";

    @FindBy(xpath = "//button[text()='Utwórz nową usługę']")
    WebElement utworzNowaUslugeButton;

    @FindBy(id = "name")
    WebElement nazwaUslugiInput;

    @FindBy(id = "price")
    WebElement cenaInput;

    @FindBy(xpath = "//button[text()='Utwórz i edytuj']")
    WebElement utworzIEdytujButton;

    @FindBy(xpath = "//button[text()='Anuluj']")
    WebElement anulujButton;

    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public String zwrocAktualnyURLZakladkiUslugi() {
        System.out.println("Aktualny adres URL strony to: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyURLZakladkiUslugi() {
        System.out.println("Poprawny adres URL strony to: " + poprawnyURLZakladkiUslugi);
        return poprawnyURLZakladkiUslugi;
    }

    public String zwrocAktualnyTytulZakladkiUslugi() {
        System.out.println("Aktualny tytul strony to: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulZakladkiUslugi() {
        System.out.println("Poprawny tytul strony to: " + poprawnyTytulZakladkiUslugi);
        return poprawnyTytulZakladkiUslugi;
    }

    public void nacisnijPrzyciskUtworzNowaUsluge() {
        wait.waitForClickability(utworzIEdytujButton).click();
    }

    public void wprowadzNazweUslugiDoPolaNazwaUslugi() {
        wait.waitForVisibility(nazwaUslugiInput).sendKeys("testtest");
    }

    public void wprowadzCeneDoPolaCena() {
        wait.waitForVisibility(cenaInput).sendKeys("123");
    }

    public void nacisnijPrzyciskUtworzIEdytuj() {
        wait.waitForClickability(utworzIEdytujButton).click();
    }

    public void przejdzDoStronyEdycjaUslugi() {
        nacisnijPrzyciskUtworzNowaUsluge();
        wprowadzNazweUslugiDoPolaNazwaUslugi();
        wprowadzCeneDoPolaCena();
        nacisnijPrzyciskUtworzIEdytuj();
    }

    /**********************************Operacje na webelementach KONIEC ******************************************/


}
