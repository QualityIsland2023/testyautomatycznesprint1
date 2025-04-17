 package pages;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class UstawieniaPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public UstawieniaPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Oczekiwany (poprawny) adres URL strony "Ustawienia"
    private String poprawnyUrlUstawienia = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=general";

     // Oczekiwany (poprawny) tytul strony "Ustawienia"
    private String poprawnyTytulUstawienia = "Ustawienia ‹ Platforma kursów online — WordPress";

     @FindBy(xpath ="//a[contains(text(),'Szablony')]")
     private WebElement linkSzablony;

     @FindBy(xpath ="//a[contains(text(),'Menu')]")
     private WebElement linkMenu;

     @FindBy(id ="accounting")
     private WebElement linkKsiegowe;

     @FindBy(id ="payments")
     private WebElement linkSposobyPlatnosci;

     @FindBy(id ="design")
     private WebElement linkWyglad;

     @FindBy(id ="integrations")
     private WebElement linkIntegracje;

     @FindBy(id ="cart")
     private WebElement linkKoszykZakupowy;

     @FindBy(id ="messages")
     private WebElement linkWiadomosci;

     @FindBy(id ="gift")
     private WebElement linkZakupyNaPrezent;

     @FindBy(id ="certificate")
     private WebElement linkCertyfikaty;

     @FindBy(id ="analytics")
     private WebElement linkAnalitykaSkrypty;

     @FindBy(id ="modules")
     private WebElement linkWlaczModuly;

     @FindBy(id ="advanced")
     private WebElement linkZaawansowane;








    /***************************Repozytorium webelementów KONIEC ******************************************/






    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "Ustawienia" i wypisuje go w konsoli
    public String getPoprawnyUrlUstawienia() {
        System.out.println("Poprawny url strony ustawienia: " + poprawnyUrlUstawienia);
        return poprawnyUrlUstawienia;
    }

     // Zwraca aktualny URL przeglądanej strony "Ustawienia" i wypisuje go w konsoli
    public String getAktualnyUrlUstawienia() {
        System.out.println("Aktualny url strony ustawienia: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytul "Ustawienia" i wypisuje go w konsoli
     public String getPoprawnyTytulUstawienia() {
         System.out.println("Poprawny tytul strony ustawienia: " + poprawnyTytulUstawienia);
         return poprawnyTytulUstawienia;
     }

     // Zwraca aktualny tytul przeglądanej strony "Ustawienia" i wypisuje go w konsoli
     public String getAktualnyTytulUstawienia() {
         System.out.println("Aktualny tytul strony ustawienia: " + driver.getTitle());
         return driver.getTitle();
     }


     public void kliknijLinkSzablony() {
         wait.waitForClickability(linkSzablony).click();
     }

     public void kliknijLinkMenu() {
         wait.waitForClickability(linkMenu).click();
     }

     public void kliknijLinkKsiegowe() {
         wait.waitForClickability(linkKsiegowe).click();
     }

     public void kliknijLinkSposobyPlatnosci() {
         wait.waitForClickability(linkSposobyPlatnosci).click();
     }

     public void kliknijLinkWyglad() {
         wait.waitForClickability(linkWyglad).click();
     }

     public void kliknijLinkIntegracje() {
         wait.waitForClickability(linkIntegracje).click();
     }

     public void kliknijLinkKoszykZakupowy() {
         wait.waitForClickability(linkKoszykZakupowy).click();
     }

     public void kliknijLinkWiadomosci() {
         wait.waitForClickability(linkWiadomosci).click();
     }

     public void kliknijLinkZakupyNaPrezent() {
         wait.waitForClickability(linkZakupyNaPrezent).click();
     }

     public void kliknijLinkCertyfikaty() {
         wait.waitForClickability(linkCertyfikaty).click();
     }

     public void kliknijLinkAnalitykaSkrypty() {
         wait.waitForClickability(linkAnalitykaSkrypty).click();
     }

     public void kliknijLinkWlaczModuly() {
         wait.waitForClickability(linkWlaczModuly).click();
     }

     public void kliknijLinkZaawansowane() {
         wait.waitForClickability(linkZaawansowane).click();
     }











    /**********************************Operacje na webelementach KONIEC ******************************************/

}
