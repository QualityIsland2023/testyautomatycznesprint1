package pages;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SprzedazZamowieniaPage {

    /************************ Sekcja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //Konstrukotor, który tworzy nową instancję strony logowania
    public SprzedazZamowieniaPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************ Sekcja techniczno konfiguracyjna KONIEC **********************************************/


    /************************Repozytorium webelementów START **********************************************/

    String poprawnyTytulStronyZamowienia = "Zamówienia ‹ Platforma kursów online — WordPress";
    String poprawnyURLStronyZamowienia = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-payment-history";

    @FindBy(xpath = "//*[contains(text(),'Dodaj zamówienie')]")
    private WebElement dodajZamowienieButton;





    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public String zwrocAktualnyTytulStronyZamowienia(){
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulStronyZamowienia(){
        System.out.println("Poprawny tytuł strony ZAMÓWIENIA: " + poprawnyTytulStronyZamowienia);
        return poprawnyTytulStronyZamowienia;
    }

    public String zwrocAktualnyUrlStronyZamowienia(){
        System.out.println("Aktualny URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyUrlStronyZamowienia() {
        System.out.println("Poprawny URL strony ZAMÓWIENIA: " + poprawnyURLStronyZamowienia);
        return poprawnyURLStronyZamowienia;
    }

    public void przejdzDoStronyUtworzPlatnosc(){

        wait.waitForVisibility(dodajZamowienieButton).click();
    }







    /**********************************Operacje na webelementach KONIEC ******************************************/

}
