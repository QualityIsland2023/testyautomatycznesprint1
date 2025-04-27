 package pages.uzytkownicy;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static helpers.Utils.generujLiczbeOd1Do100000JakoString;

 public class UzytkownicyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/

    private static final String nowyUzytkownikNazwa = PropertiesReader.read("nowyUzytkownikNazwa");
    private static final String nowyUzytkownikEmail = PropertiesReader.read("nowyUzytkownikEmail");
    private static final String nowyUzytkownikImie = PropertiesReader.read("nowyUzytkownikImie");
    private static final String nowyUzytkownikNazwisko = PropertiesReader.read("nowyUzytkownikNazwisko");

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

     @FindBy(className = "filters-button")
     private WebElement lupaButton;

     @FindBy(xpath = "//input[@placeholder= 'Wpisz by wyszukać'][1]")
     private WebElement wpiaszByWyszukacNazweInput;

     @FindBy(xpath = "//span[contains(text(), '#')]")
     private List<WebElement> idUzytkownikow;

     @FindBy(xpath = "//table[contains(@class, 'dynamic-table loaded')]")
     private WebElement zaladowanieTabeli;

     @FindBy(xpath = "//a[contains(text(), 'Dodaj nowego użytkownika')]")
     private WebElement dodajNowegoUzytkownikaButton;

    @FindBy(xpath = "//td[contains(., 'Menedżer treści Publigo')]")
    private WebElement rolaMenadzerTresciPubligo;

    @FindBy(xpath = "//div[contains(text(), 'Nowe konto użytkownika zostało pomyślnie utworzone')]")
    private WebElement komunikatPomyslneUtworzenieUzytkownika;

     @FindBy (xpath = "//*[contains(@role, 'rowgroup')]/tr[1]")
     private List<WebElement> pierwszyRzadTabeli;

     @FindBy (xpath = "//table[contains(@class, 'dynamic-table loaded')]/tbody/tr")
     private List<WebElement> wszystkieRzedyTabeli;

     /***************************Repozytorium webelementów KONIEC ******************************************/




    /****************************Operacje na webelementach START **********************************************/


    // Klika przycisk edytujacy dane uzytkownika testowego
    public void kliknijLinkTestUser() {
        wait.waitForClickability(linkTestUser).click();
    }

    public void nacisnijPrzyciskLupy(){
        wait.waitForVisibility(lupaButton).click();
    }

    public void wpiszNazweDoPolaWpiszByWyszukacNazwe(){
        wait.waitForVisibility(wpiaszByWyszukacNazweInput).clear();
        wpiaszByWyszukacNazweInput.sendKeys(nowyUzytkownikNazwa);
    }

    public void nacisnijWIdWyswietlonegoUzytkownika(){
        wait.waitForVisibility(zaladowanieTabeli);
        wait.waitForClickability(idUzytkownikow.get(0)).click();
    }

    public void cofnijSieDoStronyUzytkownicy(){
        wait.waitForTextInPageSource("Konto użytkownika zostało zaktualizowane.");
        driver.navigate().back();
        driver.navigate().back();

    }

     public void nacisnijDodajNowegoUzytkownikaButton(){
         wait.waitForVisibility(dodajNowegoUzytkownikaButton).click();
     }

     public boolean sprawdzCzyUzytkownikPosiadaRoleMenadzerTresciPubligo(){
        boolean status = false;

        if(wait.waitForVisibility(rolaMenadzerTresciPubligo).isDisplayed()){
            status = true;
            System.out.println("Zmiana roli przebiegla prawidlowo.");
        }
        return status;
     }

     // Sprawdza, czy pojawił się komunikat o pomyślnym utworzeniu użytkownika
     public boolean sprawdzCzyWidacKomunikatUzytkownikUtworzonyPomyslnie(){
        boolean status = false;

        if(wait.waitForVisibility(komunikatPomyslneUtworzenieUzytkownika).isDisplayed()){
            status = true;
            System.out.println("Użytkownik został utworzony. Komunikat na stronie: " + komunikatPomyslneUtworzenieUzytkownika.getText());
        } else {
            System.out.println("Użytkownik nie został utworzony.");
        }
        return status;
     }

     // Sprawdza, czy użytkownik został poprawnie dodany do tabeli w pierwszym rzędzie wg danych: nazwa, email, imię, nazwisko
     public boolean sprawdzCzyWidacNowegoUtworzonegoUzytkownika(){
             boolean status = false;

                for (WebElement element : pierwszyRzadTabeli) {

                    if (element.getText().contains(nowyUzytkownikNazwa)) {
                        status = true;
                        System.out.println("Nazwa użytkownika widoczna na stronie: " + nowyUzytkownikNazwa);
                    } else {
                        System.out.println("Nie widać nazwy użytkownika: " + element.getText());

                    }

                    if (element.getText().contains(nowyUzytkownikEmail)) {
                        status = true;
                        System.out.println("Email użytkownika widoczny na stronie: " + nowyUzytkownikEmail);
                    } else {
                        System.out.println("Nie widać emaila użytkownika: " + element.getText());

                    }

                    if (element.getText().contains(nowyUzytkownikImie)) {
                        status = true;
                        System.out.println("Imię użytkownika widoczne na stronie: " + nowyUzytkownikImie);
                    } else {
                        System.out.println("Nie widać imienia użytkownika: " + element.getText());

                    }

                    if (element.getText().contains(nowyUzytkownikNazwisko)) {
                        status = true;
                        System.out.println("Nazwisko użytkownika widoczne na stronie: " + nowyUzytkownikNazwisko);
                    } else {
                        System.out.println("Nie widać nazwiska użytkownika: " + element.getText());

                    }
                }

             return status;
         }






     /**********************************Operacje na webelementach KONIEC ******************************************/

}
