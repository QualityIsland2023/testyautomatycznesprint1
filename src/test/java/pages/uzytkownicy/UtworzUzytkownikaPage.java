 package pages.uzytkownicy;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

 public class UtworzUzytkownikaPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/

    private static final String nowyUzytkownikNazwa = PropertiesReader.read("nowyUzytkownikNazwa");
    private static final String nowyUzytkownikEmail = PropertiesReader.read("nowyUzytkownikEmail");


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public UtworzUzytkownikaPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    @FindBy(id = "user_login")
    private WebElement nazwaUzytkowkikaInput;

    @FindBy(id = "email")
    private WebElement emailUzytkowkikaInput;

    @FindBy(id = "createusersub")
    private WebElement utworzUzytkownikaButton;
    /***************************Repozytorium webelementów KONIEC ******************************************/




    /****************************Operacje na webelementach START **********************************************/
    public void wprowadzNazweIEmailUzytkownika(){
        wait.waitForVisibility(nazwaUzytkowkikaInput).clear();
        nazwaUzytkowkikaInput.sendKeys(nowyUzytkownikNazwa);

        emailUzytkowkikaInput.clear();
        emailUzytkowkikaInput.sendKeys(nowyUzytkownikEmail);
    }

    public void nacisnijPrzyciskUtworzUzytkownika(){
        wait.waitForVisibility(utworzUzytkownikaButton).click();
    }


     /**********************************Operacje na webelementach KONIEC ******************************************/

}
