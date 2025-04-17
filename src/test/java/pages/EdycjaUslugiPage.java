package pages;
import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EdycjaUslugiPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public EdycjaUslugiPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************Repozytorium webelementów START **********************************************/



    String poprawnyURLStronyEdycjaUslugi = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=publigo-editor-service&edit_service_id=1205&autofocus=general";
    String poprawnyTytulStronyEdycjaUslugi = "Edycja usługi ‹ Platforma kursów online — WordPress";


    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public String zwrocAktualnyURLStronyEdycjaUslugi() {
        System.out.println("Aktualny adres URL strony to: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyURLStronyEdycjaUslugi() {
        System.out.println("Poprawny adres URL strony to: " + poprawnyURLStronyEdycjaUslugi);
        return poprawnyURLStronyEdycjaUslugi;
    }

    public String zwrocAktualnyTytulStronyEdycjaUslugi() {
        wait.waitForTextInPageSource("Edycja usługi");
        System.out.println("Aktualny tytul strony to: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulStronyEdycjaUslugi() {
        System.out.println("Poprawny tytul strony to: " + poprawnyTytulStronyEdycjaUslugi);
        return poprawnyTytulStronyEdycjaUslugi;
    }

    /**********************************Operacje na webelementach KONIEC ******************************************/


}
