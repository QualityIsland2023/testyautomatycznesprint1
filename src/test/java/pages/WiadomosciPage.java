 package pages;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

 public class WiadomosciPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy WiadomosciPage
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public WiadomosciPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Oczekiwany (poprawny) adres URL strony "Wiadomosci"
    private String poprawnyUrlWiadomosci = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=messages";

    // Oczekiwany (poprawny) tytuł strony "Wiadomosci"
    private String poprawnyTytulWiadomosci = "Ustawienia ‹ Platforma kursów online — WordPress";









    /***************************Repozytorium webelementów KONIEC ******************************************/






    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "Wiadomosci" i wypisuje go w konsoli
    public String getPoprawnyUrlWiadomosci() {
        System.out.println("Poprawny url strony Wiadomosci: " + poprawnyUrlWiadomosci);
        return poprawnyUrlWiadomosci;
    }

     // Zwraca aktualny URL przeglądanej strony "Wiadomosci" i wypisuje go w konsoli
    public String getAktualnyUrlWiadomosci() {
        System.out.println("Aktualny url strony Wiadomosci: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "Wiadomosci" i wypisuje go w konsoli
     public String getPoprawnyTytulWiadomosci() {
         System.out.println("Poprawny tytul strony Wiadomosci: " + poprawnyTytulWiadomosci);
         return poprawnyTytulWiadomosci;
     }

     // Zwraca aktualny tytuł przeglądanej strony "Wiadomosci" i wypisuje go w konsoli
     public String getAktualnyTytulWiadomosci() {
         System.out.println("Aktualny tytul strony Wiadomosci: " + driver.getTitle());
         return driver.getTitle();
     }












    /**********************************Operacje na webelementach KONIEC ******************************************/

}
