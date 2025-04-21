package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.SprzedazUtworzPlatnoscPage;
import pages.SprzedazZamowieniaPage;


public class SprzedazUtworzPlatnoscPageTest extends TestBase {

    //**************** Sekcja techniczna START **********************************************/

    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private SprzedazZamowieniaPage sprzedazZamowieniaPage;
    private SprzedazUtworzPlatnoscPage sprzedazUtworzPlatnoscPage;


    //***************** Sekcja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage(){
        //inicjalizacja strony logowania, linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        sprzedazZamowieniaPage = new SprzedazZamowieniaPage(driver);
        sprzedazUtworzPlatnoscPage = new SprzedazUtworzPlatnoscPage(driver);
    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja tytułu strony UTWÓRZ PŁATNOŚĆ")
    public void weryfikacjaTytuluStronyUtworzPlatnosc(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        sprzedazZamowieniaPage.kliknijDodajZamowienieButton();

        Assert.assertEquals(sprzedazUtworzPlatnoscPage.zwrocAktualnyTytulStronyUtworzPlatnosc(),
                sprzedazUtworzPlatnoscPage.zwrocPoprawnyTytulStronyUtworzPlatnosc(),
                "Tytuł strony UTWÓRZ PŁATNOŚĆ nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego adresu strony UTWÓRZ PŁATNOŚĆ"  )
    public void weryfikacjaPoprawnegoAdresuStronyUtworzPlatnosc(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        sprzedazZamowieniaPage.kliknijDodajZamowienieButton();

        Assert.assertEquals(sprzedazUtworzPlatnoscPage.zwrocAktualnyUrlStronyUtworzPlatnosc(),
                sprzedazUtworzPlatnoscPage.zwrocPoprawnyUrlStronyUtworzPlatnosc(),
                "Adres url strony UTWÓRZ PŁATNOŚĆ nie jest poprawny");
    }

    @Test(priority = 30, enabled = true, description = "Weryfikacja, czy po kliknięciu przycisku DODAJ ZAMÓWIENIE pojawia się ekran UTWÓRZ NOWĄ PŁATNOŚĆ")
    public void weryfikacjaWyswietleniaEkranuUtworzNowaPlatnosc(){
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        sprzedazZamowieniaPage.kliknijDodajZamowienieButton();

        Assert.assertTrue(sprzedazUtworzPlatnoscPage.zwrocSekcjeTytulowaUtworzNowaPlatnosc(),
                "Nie wyświetla się ekran UTWÓRZ NOWĄ PŁATNOŚĆ po kliknięciu przycisku DODAJ ZAMÓWIENIE");
    }

    @Test(priority = 40, enabled = true, description = "Weryfikacja, czy lista WYBIERZ PRODUKTY jest widoczna")
    public void weryfikacjaWidocznosciListyWybierzProdukty() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        sprzedazZamowieniaPage.kliknijDodajZamowienieButton();

        Assert.assertTrue(sprzedazUtworzPlatnoscPage.zweryfikujCzyListaProduktowIstnieje(),
                "Lista WYBIERZ PRODUKTY nie jest widoczna");
    }

    @Test(priority = 50, enabled = true, description = "Weryfikacja, czy przycisk DODAJ KOLEJNY jest widoczny")
    public void weryfikacjaWidocznosciPrzyciskuDodajKolejny() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        sprzedazZamowieniaPage.kliknijDodajZamowienieButton();

        Assert.assertTrue(sprzedazUtworzPlatnoscPage.zweryfikujCzyPrzyciskDodajKolejnyIstnieje(),
                "Przycisk DODAJ KOLEJNY nie jest widoczny");
    }

    @Test(priority = 60, enabled = true, description = "Weryfikacja liczby pozycji w formularzu UTWÓRZ NOWĄ PŁATNOŚĆ")
    public void weryfikacjaLiczbyPozycjiWFormularzuUtworzNowaPlatnosc() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        sprzedazZamowieniaPage.kliknijDodajZamowienieButton();

        Assert.assertEquals(sprzedazUtworzPlatnoscPage.zwrocAktualnaLiczbePozycjiFormularzaUtworzNowaPlatnosc(),
                sprzedazUtworzPlatnoscPage.zwrocPoprawnaLiczbePozycjiFormularzaUtworzNowaPlatnosc(),
                "Niepoprawna liczba pozycji w formularzu UTWÓRZ NOWĄ PŁATNOŚĆ");
    }

    @Test(priority = 70, enabled = true, description = "Weryfikacja nazw pozycji w formularzu UTWÓRZ NOWĄ PŁATNOŚĆ")
    public void weryfikacjaNazwPozycjiWFormularzuUtworzNowaPlatnosc() {
        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazZamowieniaMenu();
        sprzedazZamowieniaPage.kliknijDodajZamowienieButton();

        Assert.assertTrue(sprzedazUtworzPlatnoscPage.zweryfikujNazwyPozycjiFormularzaUtworzNowaPlatnosc(),
                "Pozycje w formularzu UTWÓRZ NOWĄ PŁATNOŚĆ są niewidoczne lub mają nieprawidłowe nazwy");
    }











}
