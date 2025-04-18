 package pages.ustawienia_pages;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class SposobyPlatnosciPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/



    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
     private Waits wait;

     // Konstruktor klasy sposobyPlatnosciPage
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
     public SposobyPlatnosciPage(WebDriver driver){
         this.driver = driver;
         this.wait = new Waits(driver);
         PageFactory.initElements(driver, this);
     }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Oczekiwany (poprawny) adres URL strony "Sposoby Platnosci"
    private String poprawnyUrlSposobyPlatnosci = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=payments";

     // Oczekiwany (poprawny) tytuł strony "Sposoby Platnosci"
    private String poprawnyTytulSposobyPlatnosci = "Ustawienia ‹ Platforma kursów online — WordPress";

     @FindBy(xpath ="//span[contains(text(),'Konfiguracja i testy')]")
     private WebElement sekcjaKonfiguracjaTesty;

     @FindBy(xpath ="//span[contains(text(),'Płatności elektroniczne bankowe oraz cykliczne')]")
     private WebElement sekcjaPlatnosciBankoweCykliczne;

     @FindBy(xpath ="//span[contains(text(),'Płatności elektroniczne bankowe')]")
     private WebElement sekcjaPlatnosciElektroniczneBankowe;

     @FindBy(xpath ="//span[contains(text(),'Pozostałe typy płatności')]")
     private WebElement sekcjaPozostaleTypyPlatnosci;









    /***************************Repozytorium webelementów KONIEC ******************************************/






    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "Sposoby Platnosci" i wypisuje go w konsoli
    public String getPoprawnyUrlSposobyPlatnosci() {
        System.out.println("Poprawny url strony sposoby platnosci: " + poprawnyUrlSposobyPlatnosci);
        return poprawnyUrlSposobyPlatnosci;
    }

     // Zwraca aktualny URL przeglądanej strony "Sposoby Platnosci" i wypisuje go w konsoli
    public String getAktualnyUrlSposobyPlatnosci() {
        System.out.println("Aktualny url strony sposoby platnosci: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "Sposoby Platnosci" i wypisuje go w konsoli
     public String getPoprawnyTytulSposobyPlatnosci() {
         System.out.println("Poprawny tytul strony sposoby platnosci: " + poprawnyTytulSposobyPlatnosci);
         return poprawnyTytulSposobyPlatnosci;
     }

     // Zwraca aktualny tytuł przeglądanej strony "Sposoby Platnosci" i wypisuje go w konsoli
     public String getAktualnyTytulSposobyPlatnosci() {
         System.out.println("Aktualny tytul strony sposoby platnosci: " + driver.getTitle());
         return driver.getTitle();
     }

     public boolean czyZakladkaSposobyPlatnosciPosiadaWlasciweSekcje() {

         return (wait.waitForVisibility(sekcjaKonfiguracjaTesty).isDisplayed() &&
                 wait.waitForVisibility(sekcjaPlatnosciBankoweCykliczne).isDisplayed() &&
                 wait.waitForVisibility(sekcjaPlatnosciElektroniczneBankowe).isDisplayed() &&
                 wait.waitForVisibility(sekcjaPozostaleTypyPlatnosci).isDisplayed());
     }













     /**********************************Operacje na webelementach KONIEC ******************************************/

}
