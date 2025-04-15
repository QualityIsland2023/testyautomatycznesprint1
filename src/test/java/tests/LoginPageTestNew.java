package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LoginPageNew;
import pages.PanelPage;

public class LoginPageTestNew extends TestBase {

        /****************sekja techniczna START **********************************************/

        private LoginPageNew loginPageNew; //instancja strony logowania
        private PanelPage panelPage;

        /*****************sekja techniczna KONIEC **********************************************/

        @BeforeMethod
        public void setUPLoginPage(){
            //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
            loginPageNew = new LoginPageNew(driver);
            panelPage = new PanelPage(driver);
        }

        @Test
        public void weryfikacjaLogowaniaDoAplikacji(){
            loginPageNew.wpiszHasloDoPolaHaslo();
            loginPageNew.wpiszLoginDoPolaNazwaUzytkownika();
            loginPageNew.nacisnijPrzyciskZalogujSie();

            Assert.assertTrue(panelPage.weryfikacjaCzyMojePubligoButtonIstnieje());

        }
}
