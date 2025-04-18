 package pages.ustawienia_pages;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class IntegracjePage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy integracjePage
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public IntegracjePage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Oczekiwany (poprawny) adres URL strony "Integracje"
    private String poprawnyUrlIntegracje = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=integrations";

    // Oczekiwany (poprawny) tytuł strony "Integracje"
    private String poprawnyTytulIntegracje = "Ustawienia ‹ Platforma kursów online — WordPress";

     @FindBy(xpath ="//span[contains(text(),'Systemy fakturujące')]")
     private WebElement sekcjaSystemyFakturujace;

     @FindBy(xpath ="//span[contains(text(),'Akcje')]")
     private WebElement sekcjaAkcje;

     @FindBy(xpath ="//span[contains(text(),'Polskojęzyczne')]")
     private WebElement sekcjaPolskojezyczne;

     @FindBy(xpath ="//span[contains(text(),'Angielskojęzyczne')]")
     private WebElement sekcjaAngielskojezyczne;

     @FindBy(xpath ="//span[contains(text(),'Społeczności')]")
     private WebElement sekcjaSpolecznosci;









    /***************************Repozytorium webelementów KONIEC ******************************************/






    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "Integracje" i wypisuje go w konsoli
    public String getPoprawnyUrlIntegracje() {
        System.out.println("Poprawny url strony integracje: " + poprawnyUrlIntegracje);
        return poprawnyUrlIntegracje;
    }

     // Zwraca aktualny URL przeglądanej strony "Integracje" i wypisuje go w konsoli
    public String getAktualnyUrlIntegracje() {
        System.out.println("Aktualny url strony integracje: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "Integracje" i wypisuje go w konsoli
     public String getPoprawnyTytulIntegracje() {
         System.out.println("Poprawny tytul strony integracje: " + poprawnyTytulIntegracje);
         return poprawnyTytulIntegracje;
     }

     // Zwraca aktualny tytuł przeglądanej strony "Integracje" i wypisuje go w konsoli
     public String getAktualnyTytulIntegracje() {
         System.out.println("Aktualny tytul strony integracje: " + driver.getTitle());
         return driver.getTitle();
     }

     public boolean czyZakladkaIntegracjePosiadaWlasciweSekcje() {

         return (wait.waitForVisibility(sekcjaSystemyFakturujace).isDisplayed() &&
                 wait.waitForVisibility(sekcjaAkcje).isDisplayed() &&
                 wait.waitForVisibility(sekcjaPolskojezyczne).isDisplayed() &&
                 wait.waitForVisibility(sekcjaAngielskojezyczne).isDisplayed() &&
                 wait.waitForVisibility(sekcjaSpolecznosci).isDisplayed());
     }












    /**********************************Operacje na webelementach KONIEC ******************************************/

}
