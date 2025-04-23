package tests.uslugiTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.uslugi.UslugiPage;
import tests.TestBase;

public class UslugiPageTest extends TestBase {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private UslugiPage uslugiPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpUslugiPage() {
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        uslugiPage = new UslugiPage(driver);
    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja czy strona Usługi posiada prawidłowy adres URL.")
    public void weryfikacjaAdresuURLZakladkiUslugi() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiUslugi();

        Assert.assertEquals(uslugiPage.zwrocAktualnyURLZakladkiUslugi(), uslugiPage.zwrocPoprawnyURLZakladkiUslugi(), "Adres Url strony Usługi nie jest poprawny.");

    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja czy strona Usługi posiada prawidłowy tytuł.")
    public void weryfikacjaTytuluZakladkiUslugi() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiUslugi();

        Assert.assertEquals(uslugiPage.zwrocAktualnyTytulZakladkiUslugi(), uslugiPage.zwrocPoprawnyTytulZakladkiUslugi(), "Tytul strony Uslugi nie jest poprawny.");
    }

    @Test(priority = 30, enabled = true, description = "Weryfikacja czy na stronie Uslugi istnieje przycisk 'Utworz Nowa Usluge'.")
    public void weryfikacjaCzyIstniejeButtonUtworzNowaUsluge() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiUslugi();

        Assert.assertTrue(uslugiPage.zweryfikujCzyIstniejeUtworzNowaUslugeButton(), "Przycisk 'Utworz Nowa Usluge' nie istnieje.");
    }

    @Test(priority = 40, enabled = true, description = "Weryfikacja czy na stronie Uslugi istnieje przycisk 'Typy danych'.")
    public void weryfikacjaCzyIstniejeButtonTypyDanych() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiUslugi();

        Assert.assertTrue(uslugiPage.zweryfikujCzyIstniejeTypyDanychButton(), "Przycisk 'Typy Danych' nie istnieje.");
    }

    @Test(priority = 50, enabled = true, description = "Weryfikacja czy na stronie Uslugi po kliknieciu w przycisk 'Typy danych' pojawia się sekcja wyboru kolumn")
    public void weryfikacjaCzyPoKliknieciuTypyDanychPojawiaSieSekcjaWyboruKolumn() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiUslugi();
        uslugiPage.kliknijTypyDanychButton();

        Assert.assertTrue(uslugiPage.zweryfikujCzyIstniejeSekcjaWyboruKolumn(), "Sekcja wyboru kolumn nie jest widoczna.");
    }

    @Test(priority = 60, enabled = true, description = "Weryfikacja czy na stronie Uslugi po klikniecu w 'Utwórz nową usługę' pojawia się okno z polami: 'Nazwa uslugi' oraz 'Cena'.")
    public void weryfikacjaCzyPoUtworzeniuNowejUslugiPojawiajaSiePolaNazwaUslugiICena() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiUslugi();
        uslugiPage.poczekajNaTabeleUslug();
        uslugiPage.kliknijPrzyciskUtworzNowaUsluge();
        uslugiPage.poczekajNaOknoUtworzNowaUsluge();

        Assert.assertTrue(uslugiPage.zweryfikujCzyIstniejaPolaNazwaUslugiICena(), "Pola: 'Nazwa uslugi' i 'Cena' nie są widoczne.");
    }

    @Test(priority = 60, enabled = true, description = "Weryfikacja czy po utworzeniu nowej uslugi nastepuje przejscie do strony 'Edycja uslugi'.")
    public void weryfikacjaCzyPoUtworzeniuNowejUslugiNastepujePrzejscieDoEdycjiUslugi() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiUslugi();
        uslugiPage.utworzNowaUsluge();


        Assert.assertTrue(uslugiPage.zweryfikujCzyIstniejaPolaNazwaUslugiICena(), "Nie nastapilo przejscie do strony Edycja uslugi.");
    }



}
