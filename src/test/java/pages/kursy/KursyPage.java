 package pages.kursy;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class KursyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/

    //przypisanie loginu i hasła z pliku konfiguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    //konstruktory przyjmujące przeglądarkę i obiekt klasy Waits
    private WebDriver driver;
    private Waits wait;

    //konstrukotor tworzący nową instancję strony
    //inicjalizacja drivera oraz obiektów klasy Waits
    //inicjalizacja wszystkich elementów strony za pomocą PageFactory
    public KursyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }
    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************Repozytorium Webelementów START *****************************************************/

    //oczekiwany (poprawny) adres URL strony
    String poprawnyURLKursow = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-courses";
    //oczekiwany (poprawny) tytuł strony
    String poprawnyTytulStronyKursy  ="Kursy ‹ Platforma kursów online — WordPress";

     @FindBy(xpath = "//a[contains(text(), 'Wszyscy uczestnicy')]")
     private WebElement zakladkaKursyWszyscyUczestnicyMenuBoczne;

     @FindBy(xpath = "//button[contains(text(), 'Utwórz nowy kurs')]")
     private WebElement utworzNowyKursButton;

     @FindBy(xpath = "//h2[contains(text(), 'Utwórz nowy kurs')]")
     private WebElement utworzNowyKurs;

     @FindBy(xpath = "//input[contains(@name, 'name')]")
     private WebElement nazwaKursuInput;

     @FindBy(xpath = "//input[contains(@name, 'price')]")
     private WebElement cenaKursuInput;

     @FindBy(xpath = "//button[contains(@id, 'save-courses_popup_editor')]")
     private WebElement utworzIEdytujButton;


    /***************************Repozytorium Webelementów KONIEC ******************************************/


    /****************************Operacje na Webelementach START **********************************************/

    //zwrócenie poprawnego url strony 'Kursy' i wypisanie go w konsoli
    public String zwrocPoprawnyUrlKursow(){
        System.out.println("Poprawny URL strony kursów: " + poprawnyURLKursow);
        return poprawnyURLKursow;
    }
     //zwrócenie aktualnego url strony i wypisanie go w konsoli
     public String zwrocUrlAktualnejStrony(){
         System.out.println("Aktualny URL strony: " + driver.getCurrentUrl());
         return driver.getCurrentUrl();
     }
     //zwrócenie poprawnego tytułu strony 'Kursy' i wypisanie go w konsoli
     public String zwrocPoprawnyTytulStronyKursy(){
         System.out.println("Poprawny tytuł strony kursów: " + poprawnyTytulStronyKursy);
         return poprawnyTytulStronyKursy;
     }
     //zwrócenie aktualnego tytułu strony i wypisanie go w konsoli
    public String zwroctTytulAktualnejStrony(){
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
        return driver.getTitle();
    }
    //przejście do zakładki 'Wszyscy uczestnicy'
     public void przejdzDoZakladkiKursyWszyscyUczestnicy(){
         wait.waitForClickability(zakladkaKursyWszyscyUczestnicyMenuBoczne).click();
     }
    //kliknięcie przycisku 'Utwórz nowy kurs'
     public void przejdzDoTworzeniaNowegoKursu(){
         wait.waitForClickability(utworzNowyKursButton).click();
     }
    //oczekiwanie na pojawienie się okna 'Utwórz nowy kurs'
     public void poczekajNaOknoUtworzNowyKurs(){
         wait.waitForVisibility(utworzNowyKurs);
     }
    //wpisanie nazwy kursu
     public void wpiszNazweKursu(){
         wait.waitForVisibility(nazwaKursuInput).clear();
         wait.waitForVisibility(nazwaKursuInput).sendKeys("Test kurs");
     }
    //wpisanie ceny kursu
     public void wpiszCeneKursu(){
         wait.waitForClickability(cenaKursuInput).clear();
         wait.waitForVisibility(cenaKursuInput).sendKeys("100");
     }
     //kliknięcie przcisku 'Utwórz i edytuj'
     public void nacisnijPrzyciskUtworzIEdytuj(){
         wait.waitForClickability(utworzIEdytujButton).click();
     }

    /**********************************Operacje na Webelementach KONIEC ******************************************/

}
