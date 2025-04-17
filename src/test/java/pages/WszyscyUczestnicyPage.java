 package pages;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

 public class WszyscyUczestnicyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public WszyscyUczestnicyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    String poprawnyURLKursyWszyscyUczestnicy = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-students";
    String poprawnyTytulStronyKursyWszyscyUczestnicy  ="Wszyscy uczestnicy ‹ Platforma kursów online — WordPress";



    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/


     public String zwrocUrlAktualnejStrony(){
        System.out.println("Aktualny URL strony: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyUrlKursyWszyscyUczestnicy(){
        System.out.println("Poprawny URL strony 'Wszyscy uczestnicy' : " + poprawnyURLKursyWszyscyUczestnicy);
        return poprawnyURLKursyWszyscyUczestnicy;
    }

    public String zwroctTytulAktualnejStrony(){
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulStronyKursyWszyscyUczestnicy(){
        System.out.println("Poprawny tytuł strony 'Wszyscy uczestnicy': " + poprawnyTytulStronyKursyWszyscyUczestnicy);
        return poprawnyTytulStronyKursyWszyscyUczestnicy;
    }

    /**********************************Operacje na webelementach KONIEC ******************************************/

}
