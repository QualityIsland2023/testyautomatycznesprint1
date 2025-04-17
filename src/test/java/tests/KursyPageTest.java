package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.KursyPage;
import pages.LoginPageNew;
import pages.PanelPage;


public class KursyPageTest extends TestBase  {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private KursyPage kursyPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPKursyPage(){
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        kursyPage = new KursyPage(driver);
    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja poprawnego adresu strony 'Kursy'")
    public void weryfikacjaPoprawnegoAdresuStronyKursy(){
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();

        Assert.assertEquals(kursyPage.zwrocUrlAktualnejStrony(), kursyPage.zwrocPoprawnyUrlKursow(), "Adres url nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego tytułu strony 'Kursy'")
    public void weryfikacjaTytuluStronyKursy(){
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiKursy();

        Assert.assertEquals(kursyPage.zwroctTytulAktualnejStrony(), kursyPage.zwrocPoprawnyTytulStronyKursy(), "Nazwy pozycji w menu głównego nie są poprawne" );
    }

}
