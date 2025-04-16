package pages;
import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CertyfikatyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public CertyfikatyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************Repozytorium webelementów START **********************************************/

    String poprawnyURLZakladkiCertyfikaty = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-certificates";
    String poprawnyTytulZakladkiCertyfikaty = "Certyfikaty ‹ Platforma kursów online — WordPress";

    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public String zwrocAktualnyURLZakladkiCertyfikatyt(){
        System.out.println("Aktualny adres URL strony to: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyURLZakladkiCertyfikaty(){
        System.out.println("Poprawny adres URL strony to: " + poprawnyURLZakladkiCertyfikaty);
        return poprawnyURLZakladkiCertyfikaty;
    }

    public String zwrocAktualnyTytulZakladkiCertyfikatyt(){
        System.out.println("Aktualny tytul strony to: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulZakladkiCertyfikaty(){
        System.out.println("Poprawny tytul strony to: " + poprawnyTytulZakladkiCertyfikaty);
        return poprawnyTytulZakladkiCertyfikaty;
    }

    /**********************************Operacje na webelementach KONIEC ******************************************/


}
