package pages.uslugi;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UslugiPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public UslugiPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************Repozytorium webelementów START **********************************************/

    String poprawnyURLZakladkiUslugi = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=publigo-services";
    String poprawnyTytulZakladkiUslugi = "Usługi ‹ Platforma kursów online — WordPress";

    @FindBy(xpath = "//button[text()='Utwórz nową usługę']")
    private WebElement utworzNowaUslugeButton;

    @FindBy(xpath = "//button[text()='Typy danych']")
    private WebElement typyDanychButton;

    @FindBy(xpath = "//h2[contains(text(), 'Utwórz nową usługę')]")
    private WebElement utworzNowaUslugeOkno;

    @FindBy(id = "name")
    private WebElement nazwaUslugiInput;

    @FindBy(id = "price")
    private WebElement cenaInput;

    @FindBy(xpath = "//button[text()='Utwórz i edytuj']")
    private WebElement utworzIEdytujButton;

    @FindBy(xpath = "//button[text()='Anuluj']")
    private WebElement anulujButton;

    @FindBy(xpath = "//table[@class='dynamic-table loaded']")
    private WebElement tabelaUslug;

    @FindBy(xpath = "//td[@class='type-id']/a")
    private List<WebElement> listaUslug;



    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public String zwrocAktualnyURLZakladkiUslugi() {
        System.out.println("Aktualny adres URL strony to: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyURLZakladkiUslugi() {
        System.out.println("Poprawny adres URL strony to: " + poprawnyURLZakladkiUslugi);
        return poprawnyURLZakladkiUslugi;
    }

    public String zwrocAktualnyTytulZakladkiUslugi() {
        System.out.println("Aktualny tytul strony to: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulZakladkiUslugi() {
        System.out.println("Poprawny tytul strony to: " + poprawnyTytulZakladkiUslugi);
        return poprawnyTytulZakladkiUslugi;
    }

    public void kliknijPrzyciskUtworzNowaUsluge() {
        wait.waitForClickability(utworzNowaUslugeButton).click();
    }

    public void wprowadzNazweUslugiDoPolaNazwaUslugi() {
        wait.waitForVisibility(nazwaUslugiInput).sendKeys("testtest");
    }

    public void wprowadzCeneDoPolaCena() {
        wait.waitForVisibility(cenaInput).sendKeys("123");
    }

    public void kliknijPrzyciskUtworzIEdytuj() {
        wait.waitForClickability(utworzIEdytujButton).click();
    }

    //    przejscie do strony 'Edycja uslugi' poprzez klikniecie w pierwsza od gory usluge w dynamicznej tabeli
    //    pozwala przejsc do Edycji bez tworzenia nowej uslugi
    public void przejdzDoPierwszejUslugiZListy() {
        wait.waitForClickability(listaUslug.getFirst()).click();
    }

    //oczekiwanie na okno dialogowe po kliknieciu przycisku 'Utwórz nową usługę'
    public void poczekajNaOknoUtworzNowaUsluge() {
        wait.waitForVisibility(utworzNowaUslugeOkno);
    }

    //oczekiwanie zaladowanie sie dynamicznej tabeli uslug
    public void poczekajNaTabeleUslug() {
        wait.waitForVisibility(tabelaUslug);
    }

    //metoda przechodząca przez proces tworzenia nowej uslugi o nazwie 'testtest' i cenie '123'
    //moze byc uzyta by przejsc do strony 'Edycja uslugi'
    public void utworzNowaUsluge() {
        kliknijPrzyciskUtworzNowaUsluge();
        poczekajNaOknoUtworzNowaUsluge();
        wprowadzNazweUslugiDoPolaNazwaUslugi();
        wprowadzCeneDoPolaCena();
        kliknijPrzyciskUtworzIEdytuj();
    }

    public boolean zweryfikujCzyIstniejeUtworzNowaUslugeButton() {
        boolean status = false;

        if (utworzNowaUslugeButton.isDisplayed()) {
            status = true;
        }
        return status;
    }

    public boolean zweryfikujCzyIstniejeTypyDanychButton() {
        boolean status = false;

        if (typyDanychButton.isDisplayed()) {
            status = true;
        }
        return status;

    }

    public void kliknijTypyDanychButton() {
        wait.waitForClickability(typyDanychButton).click();
    }
    //metoda weryfikujaca czy po kliknieciu przycisku 'Typy danych' pojawia się komunikat: "Wybierz które kolumny mają być widoczne w tabeli"
    public boolean zweryfikujCzyIstniejeSekcjaWyboruKolumn() {
        boolean status = false;

        if (driver.getPageSource().contains("Wybierz które kolumny mają być widoczne w tabeli")) {
            status = true;
        }
        return status;
    }
    //metoda weryfikujaca czy po kliknieciu 'Utworz nowa uslugę' w pojawiajacym się oknie dialogowym istnieja pola 'Nazwa uslugi' i 'Cena'
    public boolean zweryfikujCzyIstniejaPolaNazwaUslugiICena() {
        boolean status = false;

        if (nazwaUslugiInput.isDisplayed() && cenaInput.isDisplayed()) {
            status = true;
        }
        return status;
    }


}
