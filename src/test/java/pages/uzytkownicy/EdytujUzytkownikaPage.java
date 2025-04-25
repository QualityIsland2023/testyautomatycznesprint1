 package pages.uzytkownicy;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class EdytujUzytkownikaPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public EdytujUzytkownikaPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/



    @FindBy(xpath ="//button[contains(text(), 'Ustaw nowe hasło')]") private WebElement buttonUtworzNoweHaslo;
    @FindBy(id ="pass-strength-result") private WebElement divSilaHasla;
    @FindBy(id ="submit") private WebElement buttonZaktualizujKontoUzytkownika;
    @FindBy(xpath = "//strong[contains(text(), 'Konto użytkownika zostało zaktualizowane.')]") private WebElement strongKomunikatPotwierdzajacyZmianeHasla;




    /***************************Repozytorium webelementów KONIEC ******************************************/




    /****************************Operacje na webelementach START **********************************************/


    // Metoda klikająca przycisk "Utwórz nowe hasło"
    public void kliknijButtonUtworzNoweHaslo() {
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonUtworzNoweHaslo).click().perform();
    }

     // Metoda sprawdzająca, czy hasło spełnia kryteria silnego hasła
    public boolean czyHasloSilne () {
        wait.waitForVisibility(divSilaHasla);
        return divSilaHasla.getText().equals("Silne");
    }

     // Metoda klikająca przycisk "Zaktualizuj konto użytkownika", jeśli hasło jest silne
    public void kliknijButtonZaktualizujKontoUzytkownika() {
        if(czyHasloSilne()) {
            Actions actions = new Actions(driver);
            actions.moveToElement(buttonZaktualizujKontoUzytkownika).click().perform();
        }
    }

     // Metoda sprawdzająca, czy operacja zmiany hasła zakończyła się powodzeniem
    public boolean czyZmianaHaslaPoprawna() {
        wait.waitForVisibility(strongKomunikatPotwierdzajacyZmianeHasla);
        System.out.println("Komunikat oczekiwany - Konto użytkownika zostało zaktualizowane.");
        System.out.println("komunikat rzeczywisty - " + strongKomunikatPotwierdzajacyZmianeHasla.getText());
        return strongKomunikatPotwierdzajacyZmianeHasla.getText().equals("Konto użytkownika zostało zaktualizowane.");
    }
























     /**********************************Operacje na webelementach KONIEC ******************************************/

}
