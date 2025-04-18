 package pages.ustawienia;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class ZaawansowanePage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy ZaawansowanePage
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public ZaawansowanePage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Oczekiwany (poprawny) adres URL strony "Zaawansowane"
    private String poprawnyUrlZaawansowane = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=advanced";

    // Oczekiwany (poprawny) tytuł strony "Zaawansowane"
    private String poprawnyTytulZaawansowane = "Ustawienia ‹ Platforma kursów online — WordPress";

     @FindBy(xpath ="//span[contains(text(),'Zaawansowane')]")
     private WebElement sekcjaZaawansowane;









    /***************************Repozytorium webelementów KONIEC ******************************************/






    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "Zaawansowane" i wypisuje go w konsoli
    public String getPoprawnyUrlZaawansowane() {
        System.out.println("Poprawny url strony Zaawansowane: " + poprawnyUrlZaawansowane);
        return poprawnyUrlZaawansowane;
    }

     // Zwraca aktualny URL przeglądanej strony "Zaawansowane" i wypisuje go w konsoli
    public String getAktualnyUrlZaawansowane() {
        System.out.println("Aktualny url strony Zaawansowane: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "Zaawansowane" i wypisuje go w konsoli
     public String getPoprawnyTytulZaawansowane() {
         System.out.println("Poprawny tytul strony Zaawansowane: " + poprawnyTytulZaawansowane);
         return poprawnyTytulZaawansowane;
     }

     // Zwraca aktualny tytuł przeglądanej strony "Zaawansowane" i wypisuje go w konsoli
     public String getAktualnyTytulZaawansowane() {
         System.out.println("Aktualny tytul strony Zaawansowane: " + driver.getTitle());
         return driver.getTitle();
     }

     public boolean czyZakladkaZaawansowanePosiadaWlasciweSekcje() {

         return wait.waitForVisibility(sekcjaZaawansowane).isDisplayed();
     }












    /**********************************Operacje na webelementach KONIEC ******************************************/

}
