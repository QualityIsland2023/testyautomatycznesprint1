package pages;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SprzedazZamowieniaPage {

    //************************ Sekcja techniczno konfiguracyjna START **********************************************/
    // Przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    // Konstrukotor, który tworzy nową instancję strony logowania
    public SprzedazZamowieniaPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    //************************ Sekcja techniczno konfiguracyjna KONIEC **********************************************/


    //************************Repozytorium webelementów START **********************************************/

    // Oczekiwany (poprawny) tytuł strony "Zamówienia"
    String poprawnyTytulStronyZamowienia = "Zamówienia ‹ Platforma kursów online — WordPress";

    // Oczekiwany (poprawny) adres URL strony "Zamówienia"
    String poprawnyURLStronyZamowienia = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-payment-history";

    // Oczekiwana (poprawna) informacja w sekcji po kliknięciu przycisku "Typy danych"
    String poprawnaInformacjaWSekcjiTypyDanych = "Wybierz, które kolumny mają być widoczne w tabeli:";

    @FindBy(xpath = "//*[contains(text(),'Dodaj zamówienie')]")
    private WebElement dodajZamowienieButton;

    @FindBy(xpath = "//button[contains(text(),'Typy danych')]")
    private WebElement typyDanychButton;

    @FindBy(className = "dynamic-table__column-visibility-checkboxes__hint")
    private WebElement informacjaWSekcjiTypyDanych;

//    Xpath zamienny/alternatywny po poprawie błędu interpunkcyjnego w tekście informacji w sekcji "Typy danych"
//    @FindBy(xpath = "//*[contains(text(),'Wybierz, które kolumny mają być widoczne w tabeli')]")
//    private WebElement informacjaWSekcjiTypyDanych;









    //***************************Repozytorium webelementów KONIEC ******************************************/


    //****************************Operacje na webelementach START **********************************************/

    // Zwraca aktualny tytuł strony "Zamówienia" i wypisuje go w konsoli
    public String zwrocAktualnyTytulStronyZamowienia(){
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
        return driver.getTitle();
    }

    // Zwraca oczekiwany (poprawny) tytuł strony "Zamówienia" i wypisuje go w konsoli
    public String zwrocPoprawnyTytulStronyZamowienia(){
        System.out.println("Poprawny tytuł strony ZAMÓWIENIA: " + poprawnyTytulStronyZamowienia);
        return poprawnyTytulStronyZamowienia;
    }

    // Zwraca aktualny adres URL strony "Zamówienia" i wypisuje go w konsoli
    public String zwrocAktualnyUrlStronyZamowienia(){
        System.out.println("Aktualny URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    // Zwraca oczekiwany (poprawny) adres URL strony "Zamówienia" i wypisuje go w konsoli
    public String zwrocPoprawnyUrlStronyZamowienia() {
        System.out.println("Poprawny URL strony ZAMÓWIENIA: " + poprawnyURLStronyZamowienia);
        return poprawnyURLStronyZamowienia;
    }

    // Przechodzi do strony "Utwórz Płatność" poprzez kliknięcie przycisku "Dodaj zamówienie"
    public void przejdzDoStronyUtworzPlatnosc(){

        wait.waitForVisibility(dodajZamowienieButton).click();
    }

    // Zwraca przycisk "Dodaj zamówienie"
    public WebElement zwrocDodajZamowienieButton(){
        return dodajZamowienieButton;
    }

    // Zwraca przycisk "Typy danych"
    public WebElement zwrocTypyDanychButton(){
        return typyDanychButton;
    }

    // Kliknięcie przycisku "Typy danych"
    public void kliknijTypyDanychButton(){
        wait.waitForVisibility(typyDanychButton).click();
    }

    // Zwraca aktualny tekst informacji w sekcji "Typy danych"
    public String zwrocAktualnaInformacjeWSekcjiTypyDanych(){
        System.out.println("Aktualna informacja w sekcji 'Typy danych': " + informacjaWSekcjiTypyDanych.getText());
        return informacjaWSekcjiTypyDanych.getText();
    }

    // Zwraca oczekiwany (poprawny) tekst informacji w sekcji "Typy danych"
    public String zwrocPoprawnaInformacjeWSekcjiTypyDanych(){
        System.out.println("Oczekiwana informacja w sekcji 'Typy danych': " + poprawnaInformacjaWSekcjiTypyDanych);
        return poprawnaInformacjaWSekcjiTypyDanych;
    }

    // Zwraca informację w sekcji "Typy danych"
    public WebElement zwrocInformacjeWSekcjiTypyDanych(){
        return informacjaWSekcjiTypyDanych;
    }












    //**********************************Operacje na webelementach KONIEC ******************************************/

}
