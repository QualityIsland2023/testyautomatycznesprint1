package pages.pakiety;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EdycjaPakietyPage {

    /************************ Seckja techniczno konfiguracyjna START **********************************************/

    //przypisanie loginu i hasła z pliku konfiguracyjnego
    private static final String login = PropertiesReader.read("login");
    private static final String haslo = PropertiesReader.read("password");

    //konstruktory przyjmujące przeglądarkę i obiekt klasy Waits
    private WebDriver driver;
    private Waits wait;

    //konstruktor tworzący nową instancję strony
    //inicjalizacja drivera oraz obiektów klasy Waits
    //inicjalizacja wszystkich elementów strony za pomocą PageFactory
    public EdycjaPakietyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }
    /************************ Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************ Repozytorium Webelementów START *****************************************************/


    //oczekiwany (poprawny) tytuł strony
    String poprawnyTytulStronyEdycjaPakietu = "Edycja pakietu ‹ Platforma kursów online — WordPress";

    @FindBy(xpath = "//h1[contains(text(),'Edycja pakietu:')]")
    private WebElement oknoEdycjaPakietu;


    /*************************** Repozytorium Webelementów KONIEC ******************************************/


    /**************************** Operacje na Webelementach START **********************************************/

    //zwrócenie aktualnego url strony
    public Boolean zwrocUrlAktualnejStronyEdycjaPakietu(){
        System.out.println("Adres strony 'Edycja pakietu' jest poprawny, status: " + driver.getCurrentUrl().contains("//mmrmqpr585.publigo.onl/" ));
        return driver.getCurrentUrl().contains("//mmrmqpr585.publigo.onl/");
    }

    //zwrócenie poprawnego tytułu strony 'Edycja pakietu' i wypisanie go w konsoli
    public String zwrocPoprawnyTytulStronyEdycjaPakietu() {
        System.out.println("Poprawny tytuł strony 'Edycja pakietu': " + poprawnyTytulStronyEdycjaPakietu);
        return poprawnyTytulStronyEdycjaPakietu;
    }

    //oczekiwanie na okno 'Edycja pakietu'
    public void poczekajNaOknoEdycjaPakietu(){
        wait.waitForVisibility(oknoEdycjaPakietu);
    }

    //zwrócenie aktualnego tytułu strony i wypisanie go w konsoli
    public String zwroctTytulAktualnejStrony() {
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
        return driver.getTitle();
    }


/********************************** Operacje na Webelementach KONIEC ******************************************/

}
