 package pages.ustawienia;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class AnalitykaSkryptyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy AnalitykaSkryptyPage
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public AnalitykaSkryptyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Oczekiwany (poprawny) adres URL strony "AnalitykaSkrypty"
    private String poprawnyUrlAnalitykaSkrypty = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=analytics";

    // Oczekiwany (poprawny) tytuł strony "AnalitykaSkrypty"
    private String poprawnyTytulAnalitykaSkrypty = "Ustawienia ‹ Platforma kursów online — WordPress";

     @FindBy(xpath ="//span[contains(text(),'Google')]")
     private WebElement sekcjaGoogle;

     @FindBy(xpath ="//span[contains(text(),'Facebook')]")
     private WebElement sekcjaFacebook;

     @FindBy(xpath ="//span[contains(text(),'Dodatkowe skrypty')]")
     private WebElement sekcjaDodatkoweSkrypty;









    /***************************Repozytorium webelementów KONIEC ******************************************/






    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "AnalitykaSkrypty" i wypisuje go w konsoli
    public String getPoprawnyUrlAnalitykaSkrypty() {
        System.out.println("Poprawny url strony AnalitykaSkrypty: " + poprawnyUrlAnalitykaSkrypty);
        return poprawnyUrlAnalitykaSkrypty;
    }

     // Zwraca aktualny URL przeglądanej strony "AnalitykaSkrypty" i wypisuje go w konsoli
    public String getAktualnyUrlAnalitykaSkrypty() {
        System.out.println("Aktualny url strony AnalitykaSkrypty: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "AnalitykaSkrypty" i wypisuje go w konsoli
     public String getPoprawnyTytulAnalitykaSkrypty() {
         System.out.println("Poprawny tytul strony AnalitykaSkrypty: " + poprawnyTytulAnalitykaSkrypty);
         return poprawnyTytulAnalitykaSkrypty;
     }

     // Zwraca aktualny tytuł przeglądanej strony "AnalitykaSkrypty" i wypisuje go w konsoli
     public String getAktualnyTytulAnalitykaSkrypty() {
         System.out.println("Aktualny tytul strony AnalitykaSkrypty: " + driver.getTitle());
         return driver.getTitle();
     }

     public boolean czyZakladkaAnalitykaSkryptyPosiadaWlasciweSekcje() {

         return (wait.waitForVisibility(sekcjaGoogle).isDisplayed() &&
                 wait.waitForVisibility(sekcjaFacebook).isDisplayed() &&
                 wait.waitForVisibility(sekcjaDodatkoweSkrypty).isDisplayed());
     }












    /**********************************Operacje na webelementach KONIEC ******************************************/

}
