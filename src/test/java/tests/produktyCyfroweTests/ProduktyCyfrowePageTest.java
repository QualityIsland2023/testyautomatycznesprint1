package tests.produktyCyfroweTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageNew;
import pages.PanelPage;
import pages.produktyCyfrowe.EdycjaProduktyCyfrowePage;
import pages.produktyCyfrowe.GeneratorLinkowPage;
import pages.produktyCyfrowe.ProduktyCyfrowePage;
import tests.TestBase;




public class ProduktyCyfrowePageTest extends TestBase {

    /****************sekja techniczna START **********************************************/



    private LoginPageNew loginPageNew;
    private PanelPage panelPage;
    private ProduktyCyfrowePage produktCyfrowyPage;
    private EdycjaProduktyCyfrowePage edycjaProduktCyfrowyPage;
    private GeneratorLinkowPage generatorLinkowPage;

    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUpProduktyCyfrowePage(){
        // Metoda uruchamiana przed każdym testem
        // Inicjalizacja obiektów stron potrzebnych do wykonania testów
        loginPageNew = new LoginPageNew(driver);
        panelPage = new PanelPage(driver);
        produktCyfrowyPage = new ProduktyCyfrowePage(driver);
        edycjaProduktCyfrowyPage = new EdycjaProduktyCyfrowePage(driver);
        generatorLinkowPage = new GeneratorLinkowPage(driver);
    }



    // Test sprawdzający cały proces tworzenia produktu cyfrowego – od logowania po finalną weryfikację
    @Test(priority = 110, enabled = true, description = "Weryfikacja poprawnosci procesu tworzenia produktu cyfrowego")
    public void zweryfikujProcesTworzeniaProduktuCyfrowego() {
        loginPageNew.wykonajLogowanie();
        panelPage.przejdzDoZakladkiProduktyCyfrowe();
        produktCyfrowyPage.utworzProduktCyfrowy();
        edycjaProduktCyfrowyPage.edytujProduktCyfrowy();
        generatorLinkowPage.przejdzDoLinkuZakupowego();
        Assert.assertTrue(generatorLinkowPage.czyButtonZamawiamPlaceJestWidoczny(), "Proces tworzenia produktu cyfrowego przebiega nieprawidlowo");
    }









}
