 package pages.ustawienia_pages;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class KoszykZakupowyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy koszykZakupowyPage
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public KoszykZakupowyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Oczekiwany (poprawny) adres URL strony "Koszyk Zakupowy"
    private String poprawnyUrlKoszykZakupowy = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=cart";

    // Oczekiwany (poprawny) tytuł strony "Koszyk Zakupowy"
    private String poprawnyTytulKoszykZakupowy = "Ustawienia ‹ Platforma kursów online — WordPress";

     @FindBy(xpath ="//span[contains(text(),'Widok koszyka')]")
     private WebElement sekcjaWidokKoszyka;

     @FindBy(xpath ="//span[contains(text(),'Dane w formularzu')]")
     private WebElement sekcjaDaneFormularz;

     @FindBy(xpath ="//span[contains(text(),'Dodatkowe checkboxy')]")
     private WebElement sekcjaDodatkoweCheckboxy;

     @FindBy(xpath ="//span[contains(text(),'Regulamin')]")
     private WebElement sekcjaRegulamin;

     @FindBy(xpath ="//span[contains(text(),'Dodatkowe ustawienia')]")
     private WebElement sekcjaDodatkoweUstawienia;

     @FindBy(xpath ="//span[contains(text(),'Sidebar | stopka (koszyk ofertowy)')]")
     private WebElement sekcjaSidebarStopka;










    /***************************Repozytorium webelementów KONIEC ******************************************/






    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "Koszyk Zakupowy" i wypisuje go w konsoli
    public String getPoprawnyUrlKoszykZakupowy() {
        System.out.println("Poprawny url strony koszyk Zakupowy: " + poprawnyUrlKoszykZakupowy);
        return poprawnyUrlKoszykZakupowy;
    }

     // Zwraca aktualny URL przeglądanej strony "Koszyk Zakupowy" i wypisuje go w konsoli
    public String getAktualnyUrlKoszykZakupowy() {
        System.out.println("Aktualny url strony koszyk Zakupowy: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytuł strony "Koszyk Zakupowy" i wypisuje go w konsoli
     public String getPoprawnyTytulKoszykZakupowy() {
         System.out.println("Poprawny tytul strony koszyk Zakupowy: " + poprawnyTytulKoszykZakupowy);
         return poprawnyTytulKoszykZakupowy;
     }

     // Zwraca aktualny tytuł przeglądanej strony "Koszyk Zakupowy" i wypisuje go w konsoli
     public String getAktualnyTytulKoszykZakupowy() {
         System.out.println("Aktualny tytul strony koszyk Zakupowy: " + driver.getTitle());
         return driver.getTitle();
     }

     public boolean czyZakladkaKoszykZakupowyPosiadaWlasciweSekcje() {

         return (wait.waitForVisibility(sekcjaWidokKoszyka).isDisplayed() &&
                 wait.waitForVisibility(sekcjaDaneFormularz).isDisplayed() &&
                 wait.waitForVisibility(sekcjaDodatkoweCheckboxy).isDisplayed() &&
                 wait.waitForVisibility(sekcjaRegulamin).isDisplayed() &&
                 wait.waitForVisibility(sekcjaDodatkoweUstawienia).isDisplayed() &&
                 wait.waitForVisibility(sekcjaSidebarStopka).isDisplayed());
     }













     /**********************************Operacje na webelementach KONIEC ******************************************/

}
