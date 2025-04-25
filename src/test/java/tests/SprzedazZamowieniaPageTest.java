package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.SprzedazUtworzPlatnoscPage;
import pages.SprzedazZamowieniaPage;
import pages.produktyCyfrowe.EdytujProduktCyfrowyPage;
import pages.produktyCyfrowe.ProduktyCyfrowePage;

import java.util.Random;


public class SprzedazZamowieniaPageTest extends TestBase {

    //**************** Sekcja techniczna START **********************************************/

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private SprzedazZamowieniaPage sprzedazZamowieniaPage;

    private SprzedazUtworzPlatnoscPage sprzedazUtworzPlatnoscPage;
    private ProduktyCyfrowePage produktyCyfrowePage;
    private EdytujProduktCyfrowyPage edytujProduktCyfrowyPage;


    //***************** Sekcja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage(){
        //inicjalizacja strony logowania, linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        sprzedazZamowieniaPage = new SprzedazZamowieniaPage(driver);
        sprzedazUtworzPlatnoscPage = new SprzedazUtworzPlatnoscPage(driver);
        produktyCyfrowePage = new ProduktyCyfrowePage(driver);
        edytujProduktCyfrowyPage = new EdytujProduktCyfrowyPage(driver);
    }

    // Metoda wewnętrzna - wykonuje wszystkie kroki począwszy od panelu logowania przenosząc nas do strony "Zamówienia"
    private void przejdzDoZakladkiZamowienia() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja tytułu strony ZAMÓWIENIA")
    public void weryfikacjaTytuluStronyZamowienia(){

        przejdzDoZakladkiZamowienia();

        Assert.assertEquals(sprzedazZamowieniaPage.zwrocAktualnyTytulStronyZamowienia(),
                sprzedazZamowieniaPage.zwrocPoprawnyTytulStronyZamowienia(),
                "Tytuł strony ZAMÓWIENIA nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego adresu strony ZAMÓWIENIA"  )
    public void weryfikacjaPoprawnegoAdresuStronyZamowienia(){

        przejdzDoZakladkiZamowienia();

        Assert.assertEquals(sprzedazZamowieniaPage.zwrocAktualnyUrlStronyZamowienia(),
                sprzedazZamowieniaPage.zwrocPoprawnyUrlStronyZamowienia(),
                "Adres url strony ZAMÓWIENIA nie jest poprawny");
    }

    @Test(priority = 30, enabled = true, description = "Weryfikacja widoczności przycisku DODAJ ZAMÓWIENIE")
    public void weryfikacjaWidocznosciPrzyciskuDodajZamowienie(){

        przejdzDoZakladkiZamowienia();

        Assert.assertTrue(sprzedazZamowieniaPage.zweryfikujCzyPrzyciskDodajZamowienieIstnieje(),
                "Przycisk DODAJ ZAMÓWIENIE nie jest widoczny");
    }

    @Test(priority = 40, enabled = true, description = "Weryfikacja widoczności przycisku TYPY DANYCH")
    public void weryfikacjaWidocznosciPrzyciskuTypyDanych(){

        przejdzDoZakladkiZamowienia();

        Assert.assertTrue(sprzedazZamowieniaPage.zweryfikujCzyPrzyciskTypyDanychIstnieje(),
                "Przycisk TYPY DANYCH nie jest widoczny");
    }

    @Test(priority = 50, enabled = true, description = "Weryfikacja poprawnego tekstu informacji w sekcji TYPY DANYCH")
    public void weryfikacjaPoprawnegoTekstuInformacjiWSekcjiTypyDanych(){

        przejdzDoZakladkiZamowienia();
        sprzedazZamowieniaPage.kliknijTypyDanychButton();

        Assert.assertEquals(sprzedazZamowieniaPage.zwrocAktualnyTekstInformacjiWSekcjiTypyDanych(),
                sprzedazZamowieniaPage.zwrocPoprawnyTekstInformacjiWSekcjiTypyDanych(),
                "Informacja w sekcji TYPY DANYCH nie jest poprawna");
    }

    @Test(priority = 60, enabled = true, description = "Weryfikacja widoczności informacji w sekcji TYPY DANYCH")
    public void weryfikacjaWidocznosciInformacjiWSekcjiTypyDanych(){

        przejdzDoZakladkiZamowienia();
        sprzedazZamowieniaPage.kliknijTypyDanychButton();

        Assert.assertTrue(sprzedazZamowieniaPage.zweryfikujCzyInformacjaWSekcjiTypyDanychIstnieje(),
                "Informacja w sekcji TYPY DANYCH nie jest widoczna");
    }

    @Test(priority = 70, enabled = true, description = "Weryfikacja liczby checkboxów w polu TYPY DANYCH")
    public void weryfikacjaLiczbyCheckboxowTypyDanych() {
        przejdzDoZakladkiZamowienia();
        sprzedazZamowieniaPage.kliknijTypyDanychButton();

        Assert.assertEquals(sprzedazZamowieniaPage.zwrocAktualnaLiczbeCheckboxowTypyDanych(),
                sprzedazZamowieniaPage.zwrocPoprawnaLiczbeCheckboxowTypyDanych(),
                "Niepoprawna liczba checkboxów w polu TYPY DANYCH");
    }

    @Test(priority = 80, enabled = true, description = "Weryfikacja nazw checkboxów w polu TYPY DANYCH")
    public void weryfikacjaNazwCheckboxowTypyDanych() {
        przejdzDoZakladkiZamowienia();
        sprzedazZamowieniaPage.kliknijTypyDanychButton();

        Assert.assertTrue(sprzedazZamowieniaPage.zweryfikujNazwyCheckboxowTypyDanych(),
                "Nazwy checkboxów w polu TYPY DANYCH są niewidoczne lub mają nieprawidłowe nazwy");
    }

    // Sprawdza czy na liście zamówień jest widoczne zamówienie ze statusem "Błędne" oraz datą "01.03.2025"
    @Test(priority = 90, enabled = true, description = "Weryfikacja zamówienia 'Błędne' z datą wstecz")
    public void weryfikacja() {
        // Tworzymy random ID do nazwy testu ze względu na problem z sortowaniem po nazwie
        // Błąd na stronie nie wykrywa za drugim razem tej samej nazwy i błędnie nie zwraca oczekiwanego wyniku wyszukiwania
        Random random = new Random();
        int losoweID = random.nextInt(1,10000);
        String nazwaProduktu = Integer.toString(losoweID);
        String email = "zawartkawoj@gmail.com";

        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiProduktyCyfrowe();

        // Tworzy nowy produkt cyfrowy
        produktyCyfrowePage.utworzNowyProduktCyfrowy(nazwaProduktu, 0);

        // Linijka sprawia, że czekamy aż załaduje się strona zanim przejdziemy do URL poniżej
        edytujProduktCyfrowyPage.getEdycjaProduktuCyfrowegoNaglowek();

        // Przechodzi do tworzenia nowej płatności
        driver.get("https://mmrmqpr585.publigo.onl/wp-admin/options.php?page=edd-manual-purchase");

        // Tworzy nową płatność
        sprzedazUtworzPlatnoscPage.stworzNowaPlatnosc(nazwaProduktu, email, "Błędne", "03/01/2025");

        // Przechodzi do zamówień
        driver.get("https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-payment-history");

        // Filtruje wyniki po nazwie produktu
        sprzedazZamowieniaPage.przeflitrujWynikPoNazwieProduktu(nazwaProduktu);

        Assert.assertTrue(sprzedazZamowieniaPage.getPierwszeZamowienieZListy().isDisplayed(),
                "Stworzone zamówienie nie jest widoczne na liście zamówień");
    }

}
