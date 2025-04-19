package pages.ustawienia;
import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class CertyfikatyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public CertyfikatyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************Repozytorium webelementów START **********************************************/

    // Oczekiwany (poprawny) adres URL strony "Certyfikaty"
    private String poprawnyUrlCertyfikaty = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=certificate";

    // Oczekiwany (poprawny) tytuł strony "Certyfikaty"
    private String poprawnyTytulCertyfikaty = "Ustawienia ‹ Platforma kursów online — WordPress";

    @FindBy(xpath ="//span[contains(text(),'Certyfikaty')]")
    private WebElement sekcjaCertyfikaty;

    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    // Zwraca oczekiwany (poprawny) URL strony "Certyfikaty" i wypisuje go w konsoli
    public String getPoprawnyUrlCertyfikaty() {
        System.out.println("Poprawny url strony Certyfikaty: " + poprawnyUrlCertyfikaty);
        return poprawnyUrlCertyfikaty;
    }

    // Zwraca aktualny URL przeglądanej strony "Certyfikaty" i wypisuje go w konsoli
    public String getAktualnyUrlCertyfikaty() {
        System.out.println("Aktualny url strony Certyfikaty: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    // Zwraca oczekiwany (poprawny) tytuł strony "Certyfikaty" i wypisuje go w konsoli
    public String getPoprawnyTytulCertyfikaty() {
        System.out.println("Poprawny tytul strony Certyfikaty: " + poprawnyTytulCertyfikaty);
        return poprawnyTytulCertyfikaty;
    }

    // Zwraca aktualny tytuł przeglądanej strony "Certyfikaty" i wypisuje go w konsoli
    public String getAktualnyTytulCertyfikaty() {
        System.out.println("Aktualny tytul strony Certyfikaty: " + driver.getTitle());
        return driver.getTitle();
    }

    public boolean czyZakladkaCertyfikatyPosiadaWlasciweSekcje() {
        Map<String, WebElement> sekcje = new LinkedHashMap<>();
        sekcje.put("Certyfikaty", sekcjaCertyfikaty);

        boolean wszystkieWidoczne = true;

        for (Map.Entry<String, WebElement> entry : sekcje.entrySet()) {
            String nazwaSekcji = entry.getKey();
            WebElement elementSekcji = entry.getValue();

            try {
                if (!wait.waitForVisibility(elementSekcji).isDisplayed()) {
                    System.out.println("Sekcja niewidoczna: " + nazwaSekcji);
                    wszystkieWidoczne = false;
                } else {
                    System.out.println("Sekcja widoczna: " + nazwaSekcji);
                }
            } catch (Exception e) {
                System.out.println("Błąd podczas sprawdzania sekcji: " + nazwaSekcji);
                e.printStackTrace();
                wszystkieWidoczne = false;
            }
        }

        return wszystkieWidoczne;
    }


    /**********************************Operacje na webelementach KONIEC ******************************************/


}
