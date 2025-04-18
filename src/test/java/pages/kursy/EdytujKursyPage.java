 package pages.kursy;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class EdytujKursyPage {

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
    public EdytujKursyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }
    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium Webelementów START **********************************************/

    //oczekiwany (poprawny) tytuł strony
    String poprawnyTytulStronyEdytujKursy  ="Edycja kursu ‹ Platforma kursów online — WordPress";

     @FindBy(xpath = "//h1[contains(text(), 'Edycja kursu: ')]")
     private WebElement edycjaKursu;

     @FindBy(xpath = "//span[contains(text(),'#')]")
     private WebElement idAktualnieUtworzonegoKursu;

     @FindBy(xpath = "//div[contains(text(), 'Kursy')]")
     private WebElement zakladkaKursyMenuBoczne;

     /***************************Repozytorium Webelementów KONIEC ******************************************/


    /****************************Operacje na Webelementach START **********************************************/

    //oczekiwanie na pojawienie się okna 'Edycja kursu'
    public void poczekajNaOknoUEdycjaKursu(){
        wait.waitForVisibility(edycjaKursu);
    }
     //zwrócenie aktualnego url strony
     public Boolean zwrocUrlAktualnejStrony(){
         return driver.getCurrentUrl().contains("//mmrmqpr585.publigo.onl/");
     }
     //zwrócenie poprawnego tytułu strony 'Edycja kursu' i wypisanie go w konsoli
    public String zwrocPoprawnyTytulStronyEdytujKursy(){
        System.out.println("Poprawny tytuł strony 'Edycja kursu': " + poprawnyTytulStronyEdytujKursy);
        return poprawnyTytulStronyEdytujKursy;
    }
     //zwrócenie aktualnego tytułu strony i wypisanie go w konsoli
     public String zwroctTytulAktualnejStrony(){
         System.out.println("Aktualny tytuł strony: " + driver.getTitle());
         return driver.getTitle();
     }

    //przejście do zakładki kursy w menu bocznym
     public void przejdzDoZakladkiKursy(){
         wait.waitForClickability(zakladkaKursyMenuBoczne).click();
     }

    /**********************************Operacje na Webelementach KONIEC ******************************************/

}
