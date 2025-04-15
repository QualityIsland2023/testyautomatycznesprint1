package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AdresyPage;
import pages.LoginPage;
import pages.MainPage;
import pages.ZalogowanyPage;


public class AdresyPageTest extends TestBase  {

    /****************sekja techniczna START **********************************************/

    private AdresyPage adresyPage; //instancja strony logowania
    private MainPage mainPage; //instancja strony logowania
    private LoginPage loginPage;
    private ZalogowanyPage zalogowanyPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage(){
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        adresyPage = new AdresyPage(driver);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        zalogowanyPage = new ZalogowanyPage(driver);
    }


    @Test
    public void weryfikacjaZmianyAdresuDoWysylki(){
        mainPage.przejdzDoEkranuLogowania();
        loginPage.wpiszLoginDoPolaLogin();
        loginPage.wpiszHasloDoPolaHaslo();
        loginPage.nacisnijPrzyciskZalogujSie();
        zalogowanyPage.przejscieDoAdresow();
        adresyPage.otworzEdycjeAdresuWysylki();
        adresyPage.edytujUlicaAdresuWysylki();


       // Assert.assertTrue(adresyPage.sprawdzCzyKomunikatJestWidoczny(), "Nie znaleziono tekstu 'Adres został zmienbiony'");

    }




}
