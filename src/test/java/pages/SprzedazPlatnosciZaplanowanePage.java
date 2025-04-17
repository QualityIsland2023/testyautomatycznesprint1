package pages;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SprzedazPlatnosciZaplanowanePage {

    /************************ Sekcja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //Konstrukotor, który tworzy nową instancję strony logowania
    public SprzedazPlatnosciZaplanowanePage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************ Sekcja techniczno konfiguracyjna KONIEC **********************************************/


    /************************Repozytorium webelementów START **********************************************/

    String poprawnyTytulStronyPlatnosciZaplanowane = "Płatności zaplanowane ‹ Platforma kursów online — WordPress";
    String poprawnyURLStronyPlatnosciZaplanowane = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=publigo-scheduled-payments";








    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public String zwrocAktualnyTytulStronyPlatnosciZaplanowane(){
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulStronyPlatnosciZaplanowane(){
        System.out.println("Poprawny tytuł strony PŁATNOŚCI ZAPLANOWANE: " + poprawnyTytulStronyPlatnosciZaplanowane);
        return poprawnyTytulStronyPlatnosciZaplanowane;
    }

    public String zwrocAktualnyUrlStronyPlatnosciZaplanowane(){
        System.out.println("Aktualny URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyUrlStronyPlatnosciZaplanowane() {
        System.out.println("Poprawny URL strony PŁATNOŚCI ZAPLANOWANE: " + poprawnyURLStronyPlatnosciZaplanowane);
        return poprawnyURLStronyPlatnosciZaplanowane;
    }







    /**********************************Operacje na webelementach KONIEC ******************************************/

}
