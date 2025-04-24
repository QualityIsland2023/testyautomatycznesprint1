package pages.pakiety;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PakietyPage {

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
    public PakietyPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }
    /************************ Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************ Repozytorium Webelementów START *****************************************************/

    //oczekiwany (poprawny) adres URL strony
    String poprawnyURLStronyPakiety = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=publigo-packages";
    //oczekiwany (poprawny) tytuł strony
    String poprawnyTytulStronyPakiety = "Pakiety ‹ Platforma kursów online — WordPress";


    /*************************** Repozytorium Webelementów KONIEC ******************************************/


    /**************************** Operacje na Webelementach START **********************************************/

    //zwrócenie poprawnego url strony 'Pakiety' i wypisanie go w konsoli
    public String zwrocPoprawnyUrlPakiety() {
        System.out.println("Poprawny URL strony pakietów: " + poprawnyURLStronyPakiety);
        return poprawnyURLStronyPakiety;
    }

    //zwrócenie aktualnego url strony i wypisanie go w konsoli
    public String zwrocUrlAktualnejStrony() {
        System.out.println("Aktualny URL strony: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    //zwrócenie poprawnego tytułu strony 'Pakiety' i wypisanie go w konsoli
    public String zwrocPoprawnyTytulStronyPakiety() {
        System.out.println("Poprawny tytuł strony pakietów: " + poprawnyTytulStronyPakiety);
        return poprawnyTytulStronyPakiety;
    }

    //zwrócenie aktualnego tytułu strony i wypisanie go w konsoli
    public String zwroctTytulAktualnejStrony() {
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
        return driver.getTitle();
    }


/********************************** Operacje na Webelementach KONIEC ******************************************/

}
