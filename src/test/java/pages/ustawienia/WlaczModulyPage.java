 package pages.ustawienia;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class WlaczModulyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy WlaczModulyPage
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public WlaczModulyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Oczekiwany (poprawny) adres URL strony "WlaczModuly"
    private String poprawnyUrlWlaczModuly = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=modules";

    // Oczekiwany (poprawny) tytuł strony "WlaczModuly"
    private String poprawnyTytulWlaczModuly = "Ustawienia ‹ Platforma kursów online — WordPress";

     @FindBy(xpath ="//span[contains(text(),'Typy produktów')]")
     private WebElement sekcjaTypyProduktow;

     @FindBy(xpath ="//span[contains(text(),'Marketing i sprzedaż')]")
     private WebElement sekcjaMarketingSprzedaz;

     @FindBy(xpath ="//span[contains(text(),'Komunikacja')]")
     private WebElement sekcjaKomunikacja;

     @FindBy(xpath ="//span[contains(text(),'Pliki')]")
     private WebElement sekcjaPliki;









    /***************************Repozytorium webelementów KONIEC ******************************************/






    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "WlaczModuly" i wypisuje go w konsoli
    public String getPoprawnyUrlWlaczModuly() {
        System.out.println("Poprawny url strony WlaczModuly: " + poprawnyUrlWlaczModuly);
        return poprawnyUrlWlaczModuly;
    }

     // Zwraca aktualny URL przeglądanej strony "WlaczModuly" i wypisuje go w konsoli
    public String getAktualnyUrlWlaczModuly() {
        System.out.println("Aktualny url strony WlaczModuly: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "WlaczModuly" i wypisuje go w konsoli
     public String getPoprawnyTytulWlaczModuly() {
         System.out.println("Poprawny tytul strony WlaczModuly: " + poprawnyTytulWlaczModuly);
         return poprawnyTytulWlaczModuly;
     }

     // Zwraca aktualny tytuł przeglądanej strony "WlaczModuly" i wypisuje go w konsoli
     public String getAktualnyTytulWlaczModuly() {
         System.out.println("Aktualny tytul strony WlaczModuly: " + driver.getTitle());
         return driver.getTitle();
     }

     public boolean czyZakladkaWlaczModulyPosiadaWlasciweSekcje() {

         return (wait.waitForVisibility(sekcjaTypyProduktow).isDisplayed() &&
                 wait.waitForVisibility(sekcjaMarketingSprzedaz).isDisplayed() &&
                 wait.waitForVisibility(sekcjaKomunikacja).isDisplayed() &&
                 wait.waitForVisibility(sekcjaPliki).isDisplayed());
     }












    /**********************************Operacje na webelementach KONIEC ******************************************/

}
