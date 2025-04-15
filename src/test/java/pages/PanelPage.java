package pages;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PanelPage {
    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego


    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public PanelPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************Repozytorium webelementów START **********************************************/

    @FindBy(xpath = "//span[contains(text(), 'Moje Publigo')]")
    private WebElement mojePubligoButtonMenuGorne;



    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

        public boolean weryfikacjaCzyMojePubligoButtonIstnieje(){
            boolean status = false;

            if(mojePubligoButtonMenuGorne.isDisplayed()){
                status = true;

                System.out.println("Konto zostalo poprawnie zalogowane.");
            }else{
                System.out.println("Nie udalo sie poprawnie zalogowac.");
            }

            return status;
        }




    /**********************************Operacje na webelementach KONIEC ******************************************/

}
