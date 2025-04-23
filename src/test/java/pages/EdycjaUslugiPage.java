package pages;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EdycjaUslugiPage {


    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public EdycjaUslugiPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    private String poprawnyURLStronyEdycjaUslugi = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=publigo-editor-service&edit_service_id=1205&autofocus=general";
    private String poprawnyTytulStronyEdycjaUslugi = "Edycja usługi ‹ Platforma kursów online — WordPress";
    private List<String> poprawneSekcje = Arrays.asList("Nazwa i opis", "Umiejscowienie", "Cena", "Dostępne ilości", "Graficzne", "Sprzedaż");

    @FindBy(xpath = "//span[@class='fields-group__name']")
    private List<WebElement> aktualneSekcje;

    @FindBy(className = "product-offer-preview-button")
    private WebElement zobaczUslugeButton;

    @FindBy(id = "general")
    private WebElement podstawoweMenuBoczne;

    @FindBy(id = "link_generator")
    private WebElement generatorLinkowMenuBoczne;

    @FindBy(xpath = "//span[@class='fields-group__name']")
    private List<WebElement> listaSekcji;

    @FindBy(xpath = "//div[@class='settings-content']")
    private WebElement ustawienia;

    @FindBy(xpath = "//a[contains(@id,'general')]")
    private WebElement zakladkaPodstawoweMenuBoczneEdycjaKursow;

    //element sekcji ustawień, uzywany do stworzenia waita na okno ustawien
    @FindBy(css = "#wpbody-content > div.wrap.settings-publigo-page > div > div.settings-content > div:nth-child(1) > span")
    private WebElement sekcjaNazwaIOpis;


    public String zwrocAktualnyURLStronyEdycjaUslugi() {
        System.out.println("Aktualny adres URL strony to: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyURLStronyEdycjaUslugi() {
        System.out.println("Poprawny adres URL strony to: " + poprawnyURLStronyEdycjaUslugi);
        return poprawnyURLStronyEdycjaUslugi;
    }

    public String zwrocAktualnyTytulStronyEdycjaUslugi() {
        wait.waitForTextInPageSource("Edycja usługi");
        System.out.println("Aktualny tytul strony to: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulStronyEdycjaUslugi() {
        System.out.println("Poprawny tytul strony to: " + poprawnyTytulStronyEdycjaUslugi);
        return poprawnyTytulStronyEdycjaUslugi;
    }

    //oczekiwanie na zaladowanie sie ustawień
    public void poczekajNaUstawienia() {
        wait.waitForVisibility(sekcjaNazwaIOpis);
    }

    public boolean zweryfikujCzyWMenuBocznymIstniejaPodstawoweIGeneratorLinkow() {
        boolean status = false;
        if (podstawoweMenuBoczne.isDisplayed() && generatorLinkowMenuBoczne.isDisplayed()) {
            status = true;
        }
        return status;
    }

    public boolean zweryfikujCzyIstniejeZobaczUslugeButton() {
        boolean status = false;
        wait.waitForVisibility(zobaczUslugeButton);
        if (zobaczUslugeButton.isDisplayed()) {
            status = true;
        }
        return status;
    }
    //    zwraca liste poprawnych sekcji ustawien
    public List<String> zwrocPoprawneSekcje() {
        return poprawneSekcje;
    }
    //    zwraca aktualne sekcje ustawien, wyciagajac tekst z WebElementow i dodajac je do nowej listy
    public List<String> zwrocAktualneSekcje() {
        List<String> sekcjeArrayList = new ArrayList<String>();
        for (WebElement sekcja : aktualneSekcje) {
            sekcjeArrayList.add(sekcja.getText());
        }
        return sekcjeArrayList;
    }


}
