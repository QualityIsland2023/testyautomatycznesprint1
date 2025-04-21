package pages;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SprzedazUtworzPlatnoscPage {

    //************************ Sekcja techniczno konfiguracyjna START **********************************************/
    // Przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    // Konstrukotor, który tworzy nową instancję strony logowania
    public SprzedazUtworzPlatnoscPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    //************************ Sekcja techniczno konfiguracyjna KONIEC **********************************************/


    //************************Repozytorium webelementów START **********************************************/

    // Oczekiwany (poprawny) tytuł strony "Utwórz płatność"
    String poprawnyTytulStronyUtworzPlatnosc = "Utwórz płatność ‹ Platforma kursów online — WordPress";

    // Oczekiwany (poprawny) adres URL strony "Utwórz płatność"
    String poprawnyURLStronyUtworzPlatnosc = "https://mmrmqpr585.publigo.onl/wp-admin/options.php?page=edd-manual-purchase";

    @FindBy(xpath = "//*[contains(text(),'Utwórz nową płatność')]")
    private WebElement sekcjaTytulowaUtworzNowaPlatnosc;

    @FindBy(xpath = "//*[contains(text(),'Wybierz Produkty')]")
    private WebElement listaWybierzProdukty;





    //***************************Repozytorium webelementów KONIEC ******************************************/


    //****************************Operacje na webelementach START **********************************************/

    // Zwraca aktualny tytuł strony "Utwórz płatność" i wypisuje go w konsoli
    public String zwrocAktualnyTytulStronyUtworzPlatnosc(){
        System.out.println("Aktualny tytuł strony UTWÓRZ PŁATNOŚĆ: " + driver.getTitle());
        return driver.getTitle();
    }

    // Zwraca oczekiwany (poprawny) tytuł strony "Utwórz płatność" i wypisuje go w konsoli
    public String zwrocPoprawnyTytulStronyUtworzPlatnosc(){
        System.out.println("Poprawny tytuł strony UTWÓRZ PŁATNOŚĆ: " + poprawnyTytulStronyUtworzPlatnosc);
        return poprawnyTytulStronyUtworzPlatnosc;
    }

    // Zwraca aktualny adres URL strony "Utwórz płatność" i wypisuje go w konsoli
    public String zwrocAktualnyUrlStronyUtworzPlatnosc(){
        System.out.println("Aktualny URL strony UTWÓRZ PŁATNOŚĆ: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    // Zwraca oczekiwany (poprawny) adres URL strony "Utwórz płatność" i wypisuje go w konsoli
    public String zwrocPoprawnyUrlStronyUtworzPlatnosc() {
        System.out.println("Poprawny URL strony UTWÓRZ PŁATNOŚĆ: " + poprawnyURLStronyUtworzPlatnosc);
        return poprawnyURLStronyUtworzPlatnosc;
    }

    // Sprawdza, czy sekcja tytułowa "Utwórz nową płatność" jest widoczna
    public boolean zwrocSekcjeTytulowaUtworzNowaPlatnosc(){
        boolean status = false;
        if(sekcjaTytulowaUtworzNowaPlatnosc.isDisplayed()){
            status = true;
            System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ istnieje sekcja tytułowa UTWÓRZ NOWĄ PŁATNOŚĆ");
        }else {
            System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ nie ma sekcji tytułowej UTWÓRZ NOWĄ PŁATNOŚĆ");
        }
        return status;
    }

    // Sprawdza, czy lista "Wybierz produkty" jest widoczna
    public boolean zweryfikujCzyListaProduktowIstnieje(){
        boolean status = false;

        if(listaWybierzProdukty.isDisplayed()){
            status = true;
            System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ istnieje lista WYBIERZ PRODUKTY");
        }else{
            System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ nie ma listy WYBIERZ PRODUKTY");
        }

        return status;

    }

    // Sprawdza, czy lista "Wybierz produkty" jest klikalna
    public boolean zweryfikujCzyListaProduktowJestKlikalna(){
        wait.waitForClickability(listaWybierzProdukty).click();

        boolean status = false;
        if(listaWybierzProdukty.isEnabled()){
            status = true;
            System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ lista WYBIERZ PRODUKTY jest klikalna");
        }else {
            System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ lista WYBIERZ PRODUKTY nie jest klikalna");
        }

        return status;

    }











    //**********************************Operacje na webelementach KONIEC ******************************************/

}
