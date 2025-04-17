package tests;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SprzedazKodyZnizkowePage {

    /************************ Sekcja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //Konstrukotor, który tworzy nową instancję strony logowania
    public SprzedazKodyZnizkowePage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************ Sekcja techniczno konfiguracyjna KONIEC **********************************************/


    /************************Repozytorium webelementów START **********************************************/

    String poprawnyTytulStronyKodyZnizkowe = "Kody zniżkowe ‹ Platforma kursów online — WordPress";
    String poprawnyURLStronyKodyZnizkowe = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-discounts";







    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/


    public String zwrocAktualnyTytulStronyKodyZnizkowe(){
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulStronyKodyZnizkowe(){
        System.out.println("Poprawny tytuł strony KODY ZNIŻKOWE: " + poprawnyTytulStronyKodyZnizkowe);
        return poprawnyTytulStronyKodyZnizkowe;
    }

    public String zwrocAktualnyUrlStronyKodyZnizkowe(){
        System.out.println("Aktualny URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyUrlStronyKodyZnizkowe() {
        System.out.println("Poprawny URL strony KODY ZNIŻKOWE: " + poprawnyURLStronyKodyZnizkowe);
        return poprawnyURLStronyKodyZnizkowe;
    }






    /**********************************Operacje na webelementach KONIEC ******************************************/

}
