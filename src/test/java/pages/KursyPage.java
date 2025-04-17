 package pages;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class KursyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public KursyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    String poprawnyURLKursow = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-courses";
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


    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/


     public String zwrocUrlAktualnejStrony(){
        System.out.println("Aktualny URL strony: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyUrlKursow(){
        System.out.println("Poprawny URL strony kursów: " + poprawnyURLKursow);
        return poprawnyURLKursow;
    }

    public String zwroctTytulAktualnejStrony(){
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulStronyKursy(){
        System.out.println("Poprawny tytuł strony kursów: " + poprawnyTytulStronyKursy);
        return poprawnyTytulStronyKursy;
    }

     public void przejdzDoZakladkiKursyWszyscyUczestnicy(){
         wait.waitForClickability(zakladkaKursyWszyscyUczestnicyMenuBoczne).click();
     }

     public void przejdzDoTworzeniaNowegoKursu(){
         wait.waitForClickability(utworzNowyKursButton).click();
     }

     public void poczekajNaOknoUtworzNowyKurs(){
         wait.waitForVisibility(utworzNowyKurs);
     }

     public void wpiszNazweKursu(){
         wait.waitForVisibility(nazwaKursuInput).clear();
         wait.waitForVisibility(nazwaKursuInput).sendKeys("Test kurs");
     }

     public void wpiszCeneKursu(){
         wait.waitForClickability(cenaKursuInput).clear();
         wait.waitForVisibility(cenaKursuInput).sendKeys("100");
     }
     public void nacisnijPrzyciskUtworzIEdytuj(){
         wait.waitForClickability(utworzIEdytujButton).click();
     }

    /**********************************Operacje na webelementach KONIEC ******************************************/

}
