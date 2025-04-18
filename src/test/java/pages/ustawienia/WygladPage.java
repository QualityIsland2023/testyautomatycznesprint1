 package pages.ustawienia_pages;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class WygladPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

    // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

    // Konstruktor klasy WygladPage
    // Inicjalizuje driver oraz obiekt klasy Waits
    // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public WygladPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Oczekiwany (poprawny) adres URL strony "Wygląd"
    private String poprawnyUrlWyglad = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=design";

    // Oczekiwany (poprawny) tytuł strony "Wygląd"
    private String poprawnyTytulWyglad = "Ustawienia ‹ Platforma kursów online — WordPress";

     @FindBy(xpath ="//span[contains(text(),'Ustawienia widoku kursu')]")
     private WebElement sekcjaUstawieniaWidokuKursu;

     @FindBy(xpath ="//span[contains(text(),'Ustawienia katalogu')]")
     private WebElement sekcjaUstawieniaKatalogu;

     @FindBy(xpath ="//span[contains(text(),'Ustawienia widoku oferty')]")
     private WebElement sekcjaUstawieniaWidokuOferty;









    /***************************Repozytorium webelementów KONIEC ******************************************/






    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "Wygląd" i wypisuje go w konsoli
    public String getPoprawnyUrlWyglad() {
        System.out.println("Poprawny url strony wyglad: " + poprawnyUrlWyglad);
        return poprawnyUrlWyglad;
    }

     // Zwraca aktualny URL przeglądanej strony "Wygląd" i wypisuje go w konsoli
    public String getAktualnyUrlWyglad() {
        System.out.println("Aktualny url strony wyglad: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "Wygląd" i wypisuje go w konsoli
     public String getPoprawnyTytulWyglad() {
         System.out.println("Poprawny tytul strony wyglad: " + poprawnyTytulWyglad);
         return poprawnyTytulWyglad;
     }

     // Zwraca aktualny tytuł przeglądanej strony "Wygląd" i wypisuje go w konsoli
     public String getAktualnyTytulWyglad() {
         System.out.println("Aktualny tytul strony wyglad: " + driver.getTitle());
         return driver.getTitle();
     }

     public boolean czyZakladkaWygladPosiadaWlasciweSekcje() {

         return (wait.waitForVisibility(sekcjaUstawieniaWidokuKursu).isDisplayed() &&
                 wait.waitForVisibility(sekcjaUstawieniaKatalogu).isDisplayed() &&
                 wait.waitForVisibility(sekcjaUstawieniaWidokuOferty).isDisplayed());
     }



    /**********************************Operacje na webelementach KONIEC ******************************************/

}
