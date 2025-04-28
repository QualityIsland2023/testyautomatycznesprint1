package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.SprzedazKodyZnizkoweDodajNowyPage;
import pages.SprzedazKodyZnizkowePage;


public class SprzedazKodyZnizkowePageTest extends TestBase {

    //**************** Sekcja techniczna START **********************************************/
    //instancja strony logowania
    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private SprzedazKodyZnizkowePage sprzedazKodyZnizkowePage;
    private SprzedazKodyZnizkoweDodajNowyPage sprzedazKodyZnizkoweDodajNowyPage;
    //***************** Sekcja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage(){
        //inicjalizacja strony logowania, linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        sprzedazKodyZnizkowePage = new SprzedazKodyZnizkowePage(driver);
        sprzedazKodyZnizkoweDodajNowyPage = new SprzedazKodyZnizkoweDodajNowyPage(driver);
    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja tytułu strony KODY ZNIŻKOWE")
    public void weryfikacjaTytuluStronyKodyZnizkowe(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazKodyZnizkoweMenu();

        Assert.assertEquals(sprzedazKodyZnizkowePage.zwrocAktualnyTytulStronyKodyZnizkowe(),
                sprzedazKodyZnizkowePage.zwrocPoprawnyTytulStronyKodyZnizkowe(),
                "Tytuł strony KODY ZNIŻKOWE nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego adresu strony KODY ZNIŻKOWE"  )
    public void weryfikacjaPoprawnegoAdresuStronyKodyZnizkowe(){

        loginPageNew.wykonajLogowanie();
        panelPage.kliknijSprzedazKodyZnizkoweMenu();

        Assert.assertEquals(sprzedazKodyZnizkowePage.zwrocAktualnyUrlStronyKodyZnizkowe(),
                sprzedazKodyZnizkowePage.zwrocPoprawnyUrlStronyKodyZnizkowe(),
                "Adres url strony KODY ZNIŻKOWE nie jest poprawny");
    }

    //Test weryfikujący, czy po wygenerowaniu kodu zniżkowego z zadanymi parametrami, jest on widoczny na liście kodów zniżkowych.
    @Test(priority = 30, enabled = true, description = "Weryfikacja poprawności generowania kodów zniżkowych")
    public void weryfikacjaPoprawnegoGenerowaniaKodowZnizkowych()  {

        //logowanie
        loginPageNew.wykonajLogowanie();

        //przejscie do modułu 'Sprzedaż' > 'Kody zniżkowe'
        panelPage.kliknijSprzedazKodyZnizkoweMenu();

        //dodanie nowego kodu zniżkowego
        sprzedazKodyZnizkowePage.kliknijWDodajKodZnizkowy();

        //wpisanie nazwy kodu zniżkowego
        sprzedazKodyZnizkoweDodajNowyPage.wpiszNazweKoduZnizkowego();

        //wpisanie kodu zniżkowego zawierającego min 10 znaków w tym min 1 cyfrę
        sprzedazKodyZnizkoweDodajNowyPage.wpiszKodKoduZnizkowego();

        //ustawienie listy 'Typ' na stałą wartość
        sprzedazKodyZnizkoweDodajNowyPage.ustawienieStalejWartosciTypuKoduZnizkowego();

        //ustawienie kwoty zniżki na 15
        sprzedazKodyZnizkoweDodajNowyPage.wpiszKwoteZnizki();

        //ustawienie co najmniej jednego produktu wymaganego
        sprzedazKodyZnizkoweDodajNowyPage.wybierzProduktyWymagane();

        //ustawienie przynajmniej jednego produktu wykluczonego
        sprzedazKodyZnizkoweDodajNowyPage.wybierzProduktWykluczony();

        //ustawienie daty początkowej na ‘04/01/2025’
        sprzedazKodyZnizkoweDodajNowyPage.wpiszDatePoczatkowaZnizki();

        //ustawienie kwoty minimalnej na 100
        sprzedazKodyZnizkoweDodajNowyPage.wpiszKwoteMinimalnaZnizki();

        //ustawienie maksymalnej ilości użyć na 10
        sprzedazKodyZnizkoweDodajNowyPage.wpiszMaksymalnaIloscUzycZnizki();

        //zaznaczenie checkbox na ‘Jednorazowy dla danego klienta’
        sprzedazKodyZnizkoweDodajNowyPage.wybierzJednorazowyDlaDanegoKlienta();

        //kliknęcie przycisku ‘Dodaj kod zniżkowy’
        sprzedazKodyZnizkoweDodajNowyPage.wybierzPrzyciskDodajKodZnizkowy();

        Assert.assertTrue(sprzedazKodyZnizkoweDodajNowyPage.sprawdzKodZnizkowyZostalUtworzony(),"Kod zniżkowy nie został utworzony");

    }








}
