 package pages.uzytkownicy;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.Utils.generujLiczbeOd1Do100000JakoString;

 public class UzytkownicyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public UzytkownicyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/



     @FindBy(linkText ="test@test.pld") private WebElement linkTestUser;




    /***************************Repozytorium webelementów KONIEC ******************************************/




    /****************************Operacje na webelementach START **********************************************/


    // Klika przycisk edytujacy dane uzytkownika testowego
    public void kliknijLinkTestUser() {
        wait.waitForClickability(linkTestUser).click();
    }


     /**********************************Operacje na webelementach KONIEC ******************************************/

}
