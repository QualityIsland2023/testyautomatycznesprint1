package pages;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SprzedazUtworzPlatnoscPage {

    /************************ Sekcja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //Konstrukotor, który tworzy nową instancję strony logowania
    public SprzedazUtworzPlatnoscPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************ Sekcja techniczno konfiguracyjna KONIEC **********************************************/


    /************************Repozytorium webelementów START **********************************************/

    String poprawnyTytulStronyUtworzPlatnosc = "Utwórz płatność ‹ Platforma kursów online — WordPress";
    String poprawnyURLStronyUtworzPlatnosc = "https://mmrmqpr585.publigo.onl/wp-admin/options.php?page=edd-manual-purchase";







    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public String zwrocAktualnyTytulStronyUtworzPlatnosc(){
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulStronyUtworzPlatnosc(){
        System.out.println("Poprawny tytuł strony UTWÓRZ PŁATNOŚĆ: " + poprawnyTytulStronyUtworzPlatnosc);
        return poprawnyTytulStronyUtworzPlatnosc;
    }

    public String zwrocAktualnyUrlStronyUtworzPlatnosc(){
        System.out.println("Aktualny URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyUrlStronyUtworzPlatnosc() {
        System.out.println("Poprawny URL strony UTWÓRZ PŁATNOŚĆ: " + poprawnyURLStronyUtworzPlatnosc);
        return poprawnyURLStronyUtworzPlatnosc;
    }







    /**********************************Operacje na webelementach KONIEC ******************************************/

}
