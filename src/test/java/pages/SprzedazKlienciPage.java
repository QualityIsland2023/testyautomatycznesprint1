package pages;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SprzedazKlienciPage {

    /************************ Sekcja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //Konstrukotor, który tworzy nową instancję strony logowania
    public SprzedazKlienciPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************ Sekcja techniczno konfiguracyjna KONIEC **********************************************/


    /************************Repozytorium webelementów START **********************************************/

    String poprawnyTytulStronyKlienci = "Klienci ‹ Platforma kursów online — WordPress";
    String poprawnyURLStronyKlienci = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-customers";







    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public String zwrocAktualnyTytulStronyKlienci(){
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulStronyKlienci(){
        System.out.println("Poprawny tytuł strony KLIENCI: " + poprawnyTytulStronyKlienci);
        return poprawnyTytulStronyKlienci;
    }

    public String zwrocAktualnyUrlStronyKlienci(){
        System.out.println("Aktualny URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyUrlStronyKlienci() {
        System.out.println("Poprawny URL strony KLIENCI: " + poprawnyURLStronyKlienci);
        return poprawnyURLStronyKlienci;
    }







    /**********************************Operacje na webelementach KONIEC ******************************************/

}
