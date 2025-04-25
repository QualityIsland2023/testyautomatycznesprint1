package tests.uslugiTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.uslugi.UslugiPage;
import tests.TestBase;

public class UslugiPageTest extends TestBase {

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private UslugiPage uslugiPage;


    @BeforeMethod
    public void setUpUslugiPage() {
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        uslugiPage = new UslugiPage(driver);
    }

    //sprawdza czy pobrany adres URL odpowiada wzorowemu adresowi url
    @Test(priority = 10, enabled = true, description = "Weryfikacja czy strona 'Usługi' posiada prawidłowy adres URL.")
    public void weryfikacjaAdresuURLStronyUslugi() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiUslugi();

        Assert.assertEquals(uslugiPage.zwrocAktualnyURLStronyUslugi(),
                uslugiPage.zwrocPoprawnyURLStronyUslugi(), "Adres Url strony 'Usługi' nie jest poprawny.");
    }

    //sprawdza czy pobrany tytul strony odpowiada wzorowemu adresowi strony
    @Test(priority = 20, enabled = true, description = "Weryfikacja czy strona 'Usługi' posiada prawidłowy tytuł.")
    public void weryfikacjaTytuluStronyUslugi() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiUslugi();

        Assert.assertEquals(uslugiPage.zwrocAktualnyTytulStronyUslugi(),
                uslugiPage.zwrocPoprawnyTytulStronyUslugi(), "Tytul strony 'Uslugi' nie jest poprawny.");
    }

    //sprawdza czy na stronie widoczny jest button 'Utworz nowa usluge'
    @Test(priority = 30, enabled = true, description = "Weryfikacja czy na stronie Uslugi istnieje przycisk 'Utworz Nowa Usluge'.")
    public void weryfikacjaCzyIstniejeUtworzNowaUslugeButton() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiUslugi();

        Assert.assertTrue(uslugiPage.zweryfikujCzyIstniejeUtworzNowaUslugeButton(), "Przycisk 'Utworz Nowa Usluge' nie istnieje.");
    }

    @Test(priority = 40, enabled = true, description = "Weryfikacja czy na stronie Uslugi istnieje przycisk 'Typy danych'.")
    public void weryfikacjaCzyIstniejeTypyDanychButton() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiUslugi();

        Assert.assertTrue(uslugiPage.zweryfikujCzyIstniejeTypyDanychButton(), "Przycisk 'Typy Danych' nie istnieje.");
    }

    @Test(priority = 50, enabled = true,
            description = "Weryfikacja czy na stronie Uslugi po kliknieciu w przycisk 'Typy danych' pojawia się sekcja wyboru kolumn")
    public void weryfikacjaCzyPoKliknieciuTypyDanychPojawiaSieSekcjaWyboruKolumn() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiUslugi();
        uslugiPage.kliknijTypyDanychButton();

        Assert.assertTrue(uslugiPage.zweryfikujCzyIstniejeSekcjaWyboruKolumn(), "Sekcja wyboru kolumn nie jest widoczna.");
    }

    @Test(priority = 60, enabled = true,
            description = "Weryfikacja czy na stronie Uslugi po klikniecu w 'Utwórz nową usługę' pojawia się okno z polami: 'Nazwa uslugi' oraz 'Cena'.")
    public void weryfikacjaCzyPoUtworzeniuNowejUslugiPojawiajaSiePolaNazwaUslugiICena() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiUslugi();
        uslugiPage.poczekajNaTabeleUslug();
        uslugiPage.kliknijUtworzNowaUslugeButton();
        uslugiPage.poczekajNaUtworzNowaUslugeOkno();

        Assert.assertTrue(uslugiPage.zweryfikujCzyIstniejaPolaNazwaUslugiICena(), "Pola: 'Nazwa uslugi' i 'Cena' nie są widoczne.");
    }





}
