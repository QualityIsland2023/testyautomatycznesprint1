package pages;
import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TestyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public TestyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************Repozytorium webelementów START **********************************************/

    String poprawnyURLZakladkiTesty = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-tests";
    String poprawnyTytulZakladkiTesty = "Zakończone testy ‹ Platforma kursów online — WordPress";

    @FindBy(xpath = "//td[contains(@class, 'type-id')]/a")
    private List<WebElement> pozycjeZakonczonychTestow;

    @FindBy(xpath = "//span[contains(text(), '#')]")
    private WebElement hashtagPrzyIDTestow;

    @FindBy(xpath = "//span[contains(text(), 'Wyników na stronę')]")
    private WebElement liczbaWynikowNaStrone;

    @FindBy(xpath = "//button[contains(text(), 'Typy danych')]")
    private WebElement typyDanychButton;


    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public String zwrocAktualnyURLZakladkiTesty(){
        System.out.println("Aktualny adres URL strony to: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyURLZakladkiTesty(){
        System.out.println("Poprawny adres URL strony to: " + poprawnyURLZakladkiTesty);
        return poprawnyURLZakladkiTesty;
    }

    public String zwrocAktualnyTytulZakladkiTesty(){
        System.out.println("Aktualny tytul strony to: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulZakladkiTesty(){
        System.out.println("Poprawny tytul strony to: " + poprawnyTytulZakladkiTesty);
        return poprawnyTytulZakladkiTesty;
    }

    public void nacisnijPierwszyZakonczonyTestWZakladceTesty(){
        wait.waitForVisibility(hashtagPrzyIDTestow);
        pozycjeZakonczonychTestow.getFirst().click();
    }

    public boolean zweryfikujCzyNapisWynikowNaStroneIstnieje(){
        boolean status = false;

        if(liczbaWynikowNaStrone.isDisplayed()){
            status = true;

            System.out.println("Na stronie testy jest lista 'Wynikow na strone'.");
        }else{
            System.out.println("Lista 'Wynikow na strone' nie  znajduje sie w zakladce testy.");
        }

        return status;

    }

    public boolean zweryfikujCzyButtonTypyDanychIstnieje(){
        boolean status = false;

        if(typyDanychButton.isDisplayed()){
            status = true;

            System.out.println("Na stronie testy jest przycisk 'Typy danych'.");
        }else{
            System.out.println("Przycisk 'Typy danych' nie  znajduje sie w zakladce testy.");
        }

        return status;

    }






    /**********************************Operacje na webelementach KONIEC ******************************************/


}
