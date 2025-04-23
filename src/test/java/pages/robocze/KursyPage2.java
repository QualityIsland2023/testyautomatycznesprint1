package pages.robocze;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KursyPage2 {

    /************************ Seckja techniczno konfiguracyjna START **********************************************/

    //przypisanie loginu i hasła z pliku konfiguracyjnego
    private static final String login = PropertiesReader.read("login");
    private static final String haslo = PropertiesReader.read("password");

    //konstruktory przyjmujące przeglądarkę i obiekt klasy Waits
    private WebDriver driver;
    private Waits wait;

    //konstrukotor tworzący nową instancję strony
    //inicjalizacja drivera oraz obiektów klasy Waits
    //inicjalizacja wszystkich elementów strony za pomocą PageFactory
    public KursyPage2(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }
    /************************ Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************ Repozytorium Webelementów START *****************************************************/

    //oczekiwany (poprawny) adres URL strony
    String poprawnyURLKursow = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-courses";
    //oczekiwany (poprawny) tytuł strony
    String poprawnyTytulStronyKursy = "Kursy ‹ Platforma kursów online — WordPress";

    String komunikat = "";

    @FindBy(xpath = "//a[contains(text(), 'Wszyscy uczestnicy')]")
    private WebElement zakladkaKursyWszyscyUczestnicyMenuBoczne;

    @FindBy(xpath = "//button[contains(text(), 'Utwórz nowy kurs')]")
    private WebElement utworzNowyKursButton;

    @FindBy(xpath = "//h2[contains(text(), 'Utwórz nowy kurs')]")
    private WebElement utworzNowyKurs;

    @FindBy(xpath = "//input[contains(@name, 'rak')]") //błąd
    private WebElement nazwaKursuInput;

    @FindBy(xpath = "//input[contains(@name, 'price')]")
    private WebElement cenaKursuInput;

    @FindBy(xpath = "//button[contains(@id, 'save-courses_popup_editor')]")
    private WebElement utworzIEdytujButton;

    @FindBy(xpath = "//button[contains(text(), 'Typy danych')]")
    private WebElement typyDanychButton;

    @FindBy(xpath = "//p[contains(text(), 'Wybierz które kolumny mają być widoczne w tabeli')]")
    private WebElement sekcjaWybierzKtoreElementyMajaBycWidoczne;


    /*************************** Repozytorium Webelementów KONIEC ******************************************/


    /**************************** Operacje na Webelementach START **********************************************/

    //zwrócenie poprawnego url strony 'Kursy' i wypisanie go w konsoli
    public String zwrocPoprawnyUrlKursow() {
        System.out.println("Poprawny URL strony kursów: " + poprawnyURLKursow);
        return poprawnyURLKursow;
    }

    //zwrócenie aktualnego url strony i wypisanie go w konsoli
    public String zwrocUrlAktualnejStrony() {
        System.out.println("Aktualny URL strony: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    //zwrócenie poprawnego tytułu strony 'Kursy' i wypisanie go w konsoli
    public String zwrocPoprawnyTytulStronyKursy() {
        System.out.println("Poprawny tytuł strony kursów: " + poprawnyTytulStronyKursy);
        return poprawnyTytulStronyKursy;
    }

    //zwrócenie aktualnego tytułu strony i wypisanie go w konsoli
    public String zwroctTytulAktualnejStrony() {
        System.out.println("Aktualny tytuł strony: " + driver.getTitle());
        return driver.getTitle();
    }

    //przejście do zakładki 'Wszyscy uczestnicy'
    public void przejdzDoZakladkiKursyWszyscyUczestnicy() {
        wait.waitForClickability(zakladkaKursyWszyscyUczestnicyMenuBoczne).click();
    }

    //kliknięcie przycisku 'Utwórz nowy kurs'
    public void przejdzDoTworzeniaNowegoKursu() {
        wait.waitForClickability(utworzNowyKursButton).click();
    }

    //oczekiwanie na pojawienie się okna 'Utwórz nowy kurs'
    public void poczekajNaOknoUtworzNowyKurs() {
        wait.waitForVisibility(utworzNowyKurs);
    }

    //wpisanie nazwy kursu
    public void wpiszNazweKursu() {
        wait.waitForVisibility(nazwaKursuInput).clear();
        wait.waitForVisibility(nazwaKursuInput).sendKeys("Test kurs");
    }

    //wpisanie ceny kursu
    public void wpiszCeneKursu() {
        wait.waitForClickability(cenaKursuInput).clear();
        wait.waitForVisibility(cenaKursuInput).sendKeys("100");
    }

    //kliknięcie przcisku 'Utwórz i edytuj'
    public void nacisnijPrzyciskUtworzIEdytuj() {
        wait.waitForClickability(utworzIEdytujButton).click();

    }

    //oczekiwanie na pojawienie się przycisku 'Utwórz nowy kurs'
    public void oczekiwanieNaButtonUtworzNowyKurs() {
        wait.waitForClickability(utworzNowyKursButton);
    }

    //metoda sprawdzajaca, czy przycisk 'Utwórz nowy kurs' jest wyświetlony i aktywny
    public boolean sprawdzCzyButtonUtworzNowyKursIstnieje() {
        boolean status = false;
        if (utworzNowyKursButton.isDisplayed() && utworzNowyKursButton.isEnabled()) {
            status = true;
            System.out.println("Przycisk 'Utwórz nowy kurs' jest wyświetlony i aktywny.");
        }
        return status;
    }

    //naciśnięcie przycisku 'Typy danych'
    public void nacisnijButtonTypyDanych() {
        wait.waitForClickability(typyDanychButton).click();
    }

    //metoda sprawdzajaca, czy przycisk 'Typy danych' jest wyświetlony i aktywny
    public boolean sprawdzCzyButtonTypyDanychIstnieje() {
        boolean status = false;
        if (typyDanychButton.isDisplayed() && typyDanychButton.isEnabled()) {
            status = true;
            System.out.println("Przycisk 'Typy danych' jest wyświetlony i aktywny.");
        }
        return status;
    }

    //oczekiwanie na pojawienie się przycisku 'Typy Danych'
    public void oczekiwanieNaButtonTypyDanych() {
        wait.waitForClickability(typyDanychButton);
    }

    //oczekiwanie na pojawienie się sekcji 'Wybierz, które kolumny mają być widoczne w tabeli'
    public void oczekiwanieNaSekcjeWybierzKtoreElementyMajaBycWidoczne() {
        wait.waitForClickability(sekcjaWybierzKtoreElementyMajaBycWidoczne);
    }

    //metoda sprawdzajaca, czy sekcja 'Wybierz, które kolumny mają być widoczne w tabeli' jest wyświetlona
    public boolean sprawdzCzySekcjaWybierzKtoreElementyMajaBycWidoczneJestWyswietlona() {
        boolean status = false;
        if (sekcjaWybierzKtoreElementyMajaBycWidoczne.isDisplayed()) {
            status = true;
            System.out.println("Sekcja 'Wybierz, które kolumny mają być widoczne w tabeli' jest wyświetlona.");
        }
        return status;
    }

    public void sprawdzPolaNazwaKursuICena() {
        if (nazwaKursuInput.isDisplayed()) {
            System.out.println("Pole 'Nazwa kursu' jest wyświetlone.");
        } else {
            System.out.println("Pole 'Nazwa kursu' NIE jest wyświetlone.");
        }
        if (!nazwaKursuInput.isEnabled()) {
            System.out.println("Pole 'Nazwa kursu' jest aktywne.");
        } else {
            System.out.println("Pole 'Nazwa kursu' NIE jest aktywne.");
        }
        if (!cenaKursuInput.isDisplayed()) {
            System.out.println("Pole 'Cena' jest wyświetlone.");
        } else {
            System.out.println("Pole 'Cena' NIE jest wyświetlone.");
        }
        if (cenaKursuInput.isEnabled()) {
            System.out.println("Pole 'Cena' jest aktywne.");
        } else {
            System.out.println("Pole 'Cena' NIE jest aktywne.");
        }
    }

    public void sprawdzPolaNazwaKursuICena2() {
        if (nazwaKursuInput.isDisplayed()) {
            komunikat = komunikat + "Pole 'Nazwa kursu' jest wyświetlone.";
        } else {
            komunikat = komunikat + "Pole 'Nazwa kursu' NIE jest wyświetlone.";
        }
        if (!nazwaKursuInput.isEnabled()) {
            komunikat = komunikat + ("Pole 'Nazwa kursu' jest aktywne.");
        } else {
            komunikat = komunikat + ("Pole 'Nazwa kursu' NIE jest aktywne.");
        }
        if (!cenaKursuInput.isDisplayed()) {
            komunikat = komunikat + ("Pole 'Cena' jest wyświetlone.");
        } else {
            komunikat = komunikat + ("Pole 'Cena' NIE jest wyświetlone.");
        }
        if (cenaKursuInput.isEnabled()) {
            komunikat = komunikat + ("Pole 'Cena' jest aktywne.");
        } else {
            komunikat = komunikat + ("Pole 'Cena' NIE jest aktywne.");
        }
    }

    public String pobierzKomunikat(){
        return komunikat;
    }


    //metoda sprawdzajaca, czy pole 'Nazwa kursu' jest wyświetlone i aktywne
    public Boolean sprawdzCzyPoleNazwaKursuIstnieje() {
        boolean status = false;
        if (nazwaKursuInput.isDisplayed() && nazwaKursuInput.isEnabled()) {
            status = true;
            System.out.println("Pole 'Nazwa kursu' jest wyświetlone i aktywne.");
        } else {
            System.out.println("Pole 'Nazwa kursu' NIE jest wyświetlone lub aktywne.");
        }
        return status;
    }

    //metoda sprawdzajaca, czy pole 'Cena' jest wyświetlone i aktywne
    public Boolean sprawdzCzyPoleCenaIstnieje() {
        boolean status = false;

        if (cenaKursuInput.isDisplayed() && cenaKursuInput.isEnabled()) {
            status = true;
            System.out.println("Pole 'Cena' jest wyświetlone i aktywne.");
        } else {
            System.out.println("Pole 'Cena' NIE jest wyświetlone lub aktywne.");
        }
        return status;
    }


    //metoda sprawdzajaca, czy pole 'Nazwa kursu' i 'Cena' są wyświetlone i aktywne
    public Boolean sprawdzCzyPoleNazwaKursuICenaIstnieje() {
        boolean status = false;

        if (nazwaKursuInput.isDisplayed() && !nazwaKursuInput.isEnabled() && cenaKursuInput.isDisplayed() && cenaKursuInput.isEnabled()) {
            status = true;
            System.out.println("Pola 'Nazwa kursu' i 'Cena' są wyświetlone i aktywne.");
        } else {
            System.out.println("Pola 'Nazwa kursu' i 'Cena' nie są wyświetlone i aktywne.");
        }
        return status;
    }

}
/********************************** Operacje na Webelementach KONIEC ******************************************/


