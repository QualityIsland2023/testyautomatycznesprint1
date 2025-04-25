 package pages.produktyCyfrowe;

import helpers.Waits;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helpers.Utils.generujLiczbeOd1Do100JakoString;

 public class EdycjaProduktyCyfrowePage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Obiekt WebDriver, służący do sterowania przeglądarką
    private WebDriver driver;

     // Obiekt klasy Waits, służący do obsługi  oczekiwań
    private Waits wait;

     // Konstruktor klasy
     // Inicjalizuje driver oraz obiekt klasy Waits
     // Inicjalizuje wszystkie elementy strony za pomocą PageFactory
    public EdycjaProduktyCyfrowePage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Stałe zawierające poprawne wartości do weryfikacji strony

     private String dataRozpozceciaPromocji = "2025-06-12";
     private String dataZakonczeniaPromocji = "2025-06-24";
     private String losowaLiczbaSztuk = generujLiczbeOd1Do100JakoString();


     // Elementy dostępne na stronie "Edycja Produktu Cyfrowego"
     @FindBy(xpath ="//*[@data-popup-id='special_offer-additional-settings-popup']") private WebElement buttonKonfigurujCenaProduktCyfrowy;
     @FindBy(id ="sale_price") private WebElement inputKonfigurujCenaProduktCyfrowy;
     @FindBy(id ="sale_price_date_from_date") private WebElement inputDataRozpoczeciaPromocji;
     @FindBy(id ="sale_price_date_to_date") private WebElement inputDataZakonczeniaPromocji;
     @FindBy(id ="save-special_offer-additional-settings-popup") private WebElement buttonZapiszCenaPromocyjna;
     @FindBy(id ="hide_from_list") private WebElement checkboxPokazProduktCyfrowyKatalog;
     @FindBy(id ="sales_disabled") private WebElement checkboxWlaczSprzedaz;
     @FindBy(id ="purchase_limit") private WebElement inputLiczbaSztukDoZakupu;
     @FindBy(id ="purchase_limit_items_left") private WebElement inputLiczbaSztukPozostalychDoZakupu;
     @FindBy(xpath ="//*[@data-related-field=\"purchase_limit\"]//button[normalize-space(.)='Zapisz']") private WebElement buttonZapiszLiczbaSztukDoZakupu;
     @FindBy(xpath ="//*[@data-related-field=\"purchase_limit_items_left\"]//button[normalize-space(.)='Zapisz']") private WebElement buttonZapiszLiczbaSztukPozostalychDoZakupu;
     @FindBy(id ="link_generator") private WebElement zakladkaLinkGenerator;







    /***************************Repozytorium webelementów KONIEC ******************************************/




    /****************************Operacje na webelementach START **********************************************/


    // Zaznacza checkbox "Pokaż produkt cyfrowy w katalogu" i wykonuje płynne przewijanie w górę strony
    public void zaznaczCheckboxPokazProduktCyfrowyKatalogScrolling() {
        Actions actions = new Actions(driver);
        actions.moveToElement(checkboxPokazProduktCyfrowyKatalog).click().perform();

        // Scroll w górę strony przy użyciu JavaScript i animacji
        String script = """
        let start = null;
        const duration = 5000;
        const distance = -100;
        const startY = window.scrollY;

        function smoothScrollUp(timestamp) {
            if (!start) start = timestamp;
            const elapsed = timestamp - start;
            const progress = Math.min(elapsed / duration, 1);
            window.scrollTo(0, startY + distance * progress);
            if (progress < 1) {
                requestAnimationFrame(smoothScrollUp);
            } else {
                document.body.setAttribute('data-scroll-ready', 'true');
            }
        }

        requestAnimationFrame(smoothScrollUp);
    """;
        ((JavascriptExecutor) driver).executeScript(script);

        // Oczekiwanie na zakończenie animowanego przewijania
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.attributeToBe(By.tagName("body"), "data-scroll-ready", "true"));
    }

     // Klika przycisk konfiguracji ceny dla produktu cyfrowego
     public void kliknijKonfigurujCenaProduktCyfrowy() {
        wait.waitForClickability(buttonKonfigurujCenaProduktCyfrowy).click();
    }

    // Ustawia promocyjną cenę produktu cyfrowego oraz daty rozpoczęcia i zakończenia promocji
    public void konfigurujCenaPromocyjnaProduktCyfrowy() {
        wait.waitForVisibility(inputKonfigurujCenaProduktCyfrowy).clear();
        wait.waitForVisibility(inputKonfigurujCenaProduktCyfrowy).sendKeys("499");
        wait.waitForVisibility(inputDataRozpoczeciaPromocji);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", inputDataRozpoczeciaPromocji, dataRozpozceciaPromocji);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", inputDataZakonczeniaPromocji, dataZakonczeniaPromocji);
        wait.waitForClickability(buttonZapiszCenaPromocyjna).click();
    }


    // Ustawia liczbę sztuk dostępnych do zakupu produktu
    public void ustawLiczbaSztukDoZakupu() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputLiczbaSztukDoZakupu);
        wait.waitForVisibility(inputLiczbaSztukDoZakupu).clear();
        wait.waitForVisibility(inputLiczbaSztukDoZakupu).sendKeys(losowaLiczbaSztuk);
        wait.waitForClickability(buttonZapiszLiczbaSztukDoZakupu).click();
    }

     // Ustawia liczbę sztuk pozostałych do zakupu produktu
     public void ustawLiczbaSztukPozostalychDoZakupu() {
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputLiczbaSztukPozostalychDoZakupu);
         wait.waitForVisibility(inputLiczbaSztukPozostalychDoZakupu).clear();
         wait.waitForVisibility(inputLiczbaSztukPozostalychDoZakupu).sendKeys(losowaLiczbaSztuk);
         wait.waitForClickability(buttonZapiszLiczbaSztukPozostalychDoZakupu).click();
     }

     // Zaznacza checkbox odpowiedzialny za włączenie sprzedaży produktu
     public void zaznaczcheckboxWlaczSprzedaz() {
         Actions actions = new Actions(driver);
         actions.moveToElement(checkboxWlaczSprzedaz).click().perform();
     }

     // Przewija stronę do zakładki "Link Generator" i klika w nią
    public void przejdzDoZakladkaLinkGenerator() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", zakladkaLinkGenerator);
        wait.waitForClickability(zakladkaLinkGenerator).click();
    }


     // Edytuje produkt cyfrowy wykonując szereg akcji konfiguracyjnych
    public void edytujProduktCyfrowy() {
        kliknijKonfigurujCenaProduktCyfrowy();
        konfigurujCenaPromocyjnaProduktCyfrowy();
        ustawLiczbaSztukDoZakupu();
        ustawLiczbaSztukPozostalychDoZakupu();
        zaznaczcheckboxWlaczSprzedaz();
        zaznaczCheckboxPokazProduktCyfrowyKatalogScrolling();
        przejdzDoZakladkaLinkGenerator();
    }

     /**********************************Operacje na webelementach KONIEC ******************************************/

}
