package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AdresyPage;
import pages.LoginPage;
import pages.MainPage;
import pages.ZalogowanyPage;


public class ZalogowanyPageTest extends TestBase  {

    /****************sekja techniczna START **********************************************/

    private ZalogowanyPage zalogowanyPage; //instancja strony logowania


    /*****************sekja techniczna KONIEC **********************************************/

    @BeforeMethod
    public void setUPLoginPage(){
        //inicjalizacja strony logowania , linijka techniczna, konfiguracyjna
        zalogowanyPage = new ZalogowanyPage(driver);

    }






}
