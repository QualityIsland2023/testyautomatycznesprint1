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

    @FindBy(xpath = "//div[contains(text(), 'Testy')]")
    private WebElement zakladkaTestyMenuBoczne;

    @FindBy(xpath = "//div[contains(text(), 'Certyfikaty')]")
    private WebElement zakladkaCertyfikatyMenuBoczne;

    @FindBy(xpath = "//div[contains(text(), 'Raporty')]")
    private WebElement zakladkaRaportyMenuBoczne;

    @FindBy(xpath = "//div[contains(text(), 'Narzędzia')]")
    private WebElement zakladkaNarzedziaMenuBoczne;

    @FindBy(xpath = "//a[contains(text(), 'Powiadomienia')]")
    private WebElement zakladkaPowiadomieniaMenuBoczne;

    @FindBy(xpath = "//a[contains(text(), 'Logi')]")
    private WebElement zakladkaLogiMenuBoczne;

    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public boolean weryfikacjaCzyMojePubligoButtonIstnieje(){
        boolean status = false;

        if(wait.waitForVisibility(mojePubligoButtonMenuGorne).isDisplayed()){
            status = true;

            System.out.println("Konto zostalo poprawnie zalogowane.");
        }else{
            System.out.println("Nie udalo sie poprawnie zalogowac.");
        }

        return status;
    }

    public void przejdzDoZakladkiTesty(){
        wait.waitForClickability(zakladkaTestyMenuBoczne).click();
    }

    public void przejdzDoZakladkiCertyfikaty(){
        wait.waitForClickability(zakladkaCertyfikatyMenuBoczne).click();
    }

    public void przejdzDoZakladkiRaporty(){
        wait.waitForClickability(zakladkaRaportyMenuBoczne).click();
    }

    public void przejdzDoZakladkiNarzedzia(){
        wait.waitForClickability(zakladkaNarzedziaMenuBoczne).click();
    }

    public void przejdzDoZakladkiPowiadomienia(){
        driver.get("https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=publigo-notifications");
    }

    public void przejdzDoZakladkiLogi(){
        driver.get("https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-logs");
    }

    /**********************************Operacje na webelementach KONIEC ******************************************/

}
