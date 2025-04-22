package pages;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    int prawidlowaLiczbaChecboxowTypyDanych = 17;

    @FindBy(xpath = "//*[contains(text(),'Dodaj zamówienie')]")
    private WebElement dodajZamowienieButton;

    @FindBy(xpath = "//button[contains(text(),'Typy danych')]")
    private WebElement typyDanychButton;

    @FindBy(className = "dynamic-table__column-visibility-checkboxes__hint")
    private WebElement informacjaWSekcjiTypyDanych;

    @FindBy(xpath = "//*[contains(@class,'checkbox-replacement')]")
    private List<WebElement> wszytkieCheckboxyTypyDanych;

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

    // Sprawdza, czy przycisk "Dodaj zamówienie" jest widoczny i wypisuje go w konsoli
    public boolean zweryfikujCzyPrzyciskDodajZamowienieIstnieje(){
        boolean status = false;

        try {
            boolean przyciskWidoczny = dodajZamowienieButton.isDisplayed();

            if (przyciskWidoczny) {
                status = true;
                System.out.println("Widać przycisk: " + dodajZamowienieButton.getText());
            }

        } catch (Exception e) {
            System.out.println("Nie widać przycisku DODAJ ZAMÓWIENIE");
        }

        return status;
    }

    // Sprawdza, czy przycisk "Typy danych" jest widoczny i wypisuje go w konsoli
    public boolean zweryfikujCzyPrzyciskTypyDanychIstnieje(){
        boolean status = false;

        try {
            boolean przyciskWidoczny = typyDanychButton.isDisplayed();

            if (przyciskWidoczny) {
                status = true;
                System.out.println("Widać przycisk: " + typyDanychButton.getText());
            }

        } catch (Exception e) {
            System.out.println("Nie widać przycisku TYPY DANYCH");
        }

        return status;
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

    // Zwraca informację w sekcji "Typy danych" i wypisuje ją w konsoli.
    // Oczekiwany tekst: "Wybierz, które kolumny mają być widoczne w tabeli:"
    public boolean zweryfikujCzyInformacjaWSekcjiTypyDanychIstnieje(){
        boolean status = false;

        try {
            boolean przyciskWidoczny = informacjaWSekcjiTypyDanych.isDisplayed();

            if (przyciskWidoczny) {
                status = true;
                System.out.println("Widać informację w sekcji TYPY DANYCH: " + informacjaWSekcjiTypyDanych.getText());
            }

        } catch (Exception e) {
            System.out.println("Nie widać informacji w sekcji TYPY DANYCH. " +
                            "Oczekiwany tekst: " + poprawnaInformacjaWSekcjiTypyDanych);
        }

        return status;
    }

    // Zwraca aktualną liczbę checkboxów w polu "Typy danych"
    public int zwrocAktualnaLiczbeCheckboxowTypyDanych(){
        System.out.println("Aktualna liczba checkboxów w polu TYPY DANYCH: " + wszytkieCheckboxyTypyDanych.size());
        return wszytkieCheckboxyTypyDanych.size();
    }

    // Zwraca oczekiwaną (poprawną) liczbę checkboxów w polu "Typy danych"
    public int zwrocPoprawnaLiczbeCheckboxowTypyDanych(){
        System.out.println("Oczekiwana checkboxów w polu TYPY DANYCH: " + prawidlowaLiczbaChecboxowTypyDanych);
        return prawidlowaLiczbaChecboxowTypyDanych;
    }












    //**********************************Operacje na webelementach KONIEC ******************************************/

}
