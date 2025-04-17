package pages;
import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UslugiPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

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

    /**********************************Operacje na webelementach KONIEC ******************************************/


}
