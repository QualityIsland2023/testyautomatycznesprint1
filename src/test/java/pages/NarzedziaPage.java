package pages;
import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NarzedziaPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public NarzedziaPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************Repozytorium webelementów START **********************************************/

    String poprawnyURLZakladkiNarzedzia = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-tools";
    String poprawnyTytulZakladkiNarzedzia = "Narzędzia ‹ Platforma kursów online — WordPress";

    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public String zwrocAktualnyURLZakladkiNarzedzia(){
        System.out.println("Aktualny adres URL strony to: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyURLZakladkiNarzedzia(){
        System.out.println("Poprawny adres URL strony to: " + poprawnyURLZakladkiNarzedzia);
        return poprawnyURLZakladkiNarzedzia;
    }

    public String zwrocAktualnyTytulZakladkiNarzedzia(){
        System.out.println("Aktualny tytul strony to: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulZakladkiNarzedzia(){
        System.out.println("Poprawny tytul strony to: " + poprawnyTytulZakladkiNarzedzia);
        return poprawnyTytulZakladkiNarzedzia;
    }

    /**********************************Operacje na webelementach KONIEC ******************************************/


}
