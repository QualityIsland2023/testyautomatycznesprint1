package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;


public class RaportyPageTest extends TestBase  {

    /****************sekja techniczna START **********************************************/

    private LoginPageNew loginPageNew; //instancja strony logowania
    private PanelPage panelPage;
    private RaportyPage raportyPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPRaportyPage(){
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        raportyPage = new RaportyPage(driver);

    }

    @Test(priority = 10, enabled = true, description = "Weryfikacja poprawnego adresu strony 'Raporty''")
    public void weryfikacjaPoprawnegoAdresuStronyRaporty(){
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiRaporty();

        Assert.assertEquals(raportyPage.zwrocUrlAktualnejStrony(), raportyPage.zwrocPoprawnyUrlRaportow(), "Adres url nie jest poprawny");
    }

    @Test(priority = 20, enabled = true, description = "Weryfikacja poprawnego tytułu strony 'Raporty''")
    public void weryfikacjaTytuluStronyRaporty(){
        loginPageNew.wpiszHasloDoPolaHaslo();
        loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
        loginPageNew.nacisnijPrzyciskZalogujSie();
        panelPage.przejdzDoZakladkiRaporty();

        Assert.assertEquals(raportyPage.zwroctTytulAktualnejStrony(), raportyPage.zwrocPoprawnyTytulStronyRaporty(), "Nazwy pozycji w menu głównego nie są poprawne" );
    }

}
