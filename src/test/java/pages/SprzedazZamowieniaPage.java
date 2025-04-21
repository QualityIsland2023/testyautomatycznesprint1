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
        System.out.println("Aktualny tytuł strony ZAMÓWIENIA: " + driver.getTitle());
        return driver.getTitle();
    }

    // Zwraca oczekiwany (poprawny) tytuł strony "Zamówienia" i wypisuje go w konsoli
    public String zwrocPoprawnyTytulStronyZamowienia(){
        System.out.println("Poprawny tytuł strony ZAMÓWIENIA: " + poprawnyTytulStronyZamowienia);
        return poprawnyTytulStronyZamowienia;
    }

    // Zwraca aktualny adres URL strony "Zamówienia" i wypisuje go w konsoli
    public String zwrocAktualnyUrlStronyZamowienia(){
        System.out.println("Aktualny URL strony ZAMÓWIENIA: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    // Zwraca oczekiwany (poprawny) adres URL strony "Zamówienia" i wypisuje go w konsoli
    public String zwrocPoprawnyUrlStronyZamowienia() {
        System.out.println("Poprawny URL strony ZAMÓWIENIA: " + poprawnyURLStronyZamowienia);
        return poprawnyURLStronyZamowienia;
    }

    // Klika przycisk "Dodaj zamówienie" i wypisuje go w konsoli
    public void kliknijDodajZamowienieButton(){
        System.out.println("Klikam przycisk: " + dodajZamowienieButton.getText());
        wait.waitForVisibility(dodajZamowienieButton).click();
    }

    // Zwraca przycisk "Dodaj zamówienie" i wypisuje go w konsoli
    public WebElement zwrocDodajZamowienieButton(){
        System.out.println("Widać przycisk: " + dodajZamowienieButton.getText());
        return wait.waitForVisibility(dodajZamowienieButton);
    }

    // Zwraca przycisk "Typy danych" i wypisuje go w konsoli
    public WebElement zwrocTypyDanychButton(){
        System.out.println("Widać przycisk: " + typyDanychButton.getText());
        return wait.waitForVisibility(typyDanychButton);
    }

    // Klika przycisk "Typy danych" i wypisuje go w konsoli
    public void kliknijTypyDanychButton(){
        System.out.println("Klikam przycisk: " + typyDanychButton.getText());
        wait.waitForVisibility(typyDanychButton).click();
    }

    // Zwraca aktualny tekst informacji w sekcji "Typy danych" i wypisuje go w konsoli
    public String zwrocAktualnyTekstInformacjiWSekcjiTypyDanych(){
        System.out.println("Aktualna informacja w sekcji 'Typy danych': " + informacjaWSekcjiTypyDanych.getText());
        return informacjaWSekcjiTypyDanych.getText();
    }

    // Zwraca oczekiwany (poprawny) tekst informacji w sekcji "Typy danych" i wypisuje go w konsoli
    public String zwrocPoprawnyTekstInformacjiWSekcjiTypyDanych(){
        System.out.println("Oczekiwana informacja w sekcji 'Typy danych': " + poprawnaInformacjaWSekcjiTypyDanych);
        return poprawnaInformacjaWSekcjiTypyDanych;
    }

    // Zwraca informację w sekcji "Typy danych" i wypisuje ją w konsoli
    public WebElement zwrocInformacjeWSekcjiTypyDanych(){
        System.out.println("Widać informację: " + informacjaWSekcjiTypyDanych.getText());
        return wait.waitForVisibility(informacjaWSekcjiTypyDanych);
    }












    //**********************************Operacje na webelementach KONIEC ******************************************/

}
