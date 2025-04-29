package pages.seleniumShop;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    @FindBy(xpath = "//a[contains(text(),'Moje konto')]")
    private WebElement mojeKontoMenu;

    @FindBy(id = "username")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement hasloInput;

    @FindBy(name = "login")
    private WebElement zalogujSieButton;



    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public void przejscieDoEkranuLogowania(){

        mojeKontoMenu.click();

    }


    public void wpiszLoginDoPolaLogin(){
        System.out.println("Login: " + login);
        loginInput.sendKeys(login);
    }


    public void wpiszHasloDoPolaHaslo(){
        System.out.println("Haslo: " + haslo);
        hasloInput.sendKeys(haslo);
    }


    public void nacisnijPrzyciskZalogujSie() {
        System.out.println("Nacisnięto przycisk Zaloguj się");
        zalogujSieButton.click();
    }

    public boolean sprawdzCzyTekstWZrodleStronyIstnieje(){
        boolean status = false;
        if(wait.waitForTextInPageSource("Witaj")){
            status = true;
        }
        System.out.println("Szukany tekst: " + "Witaj");
        return status;

    }
    /**********************************Operacje na webelementach KONIEC ******************************************/

}
