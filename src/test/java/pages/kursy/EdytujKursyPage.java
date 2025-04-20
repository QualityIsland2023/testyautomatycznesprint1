 package pages.kursy;

import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

 public class EdytujKursyPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/

    //przypisanie loginu i hasła z pliku konfiguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

     //konstruktory przyjmujące przeglądarkę i obiekt klasy Waits
    private WebDriver driver;
    private Waits wait;

     //konstruktor tworzący nową instancję strony
     //inicjalizacja drivera oraz obiektów klasy Waits
     //inicjalizacja wszystkich elementów strony za pomocą PageFactory
    public EdytujKursyPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }
    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium Webelementów START **********************************************/

    //oczekiwany (poprawny) tytuł strony
    String poprawnyTytulStronyEdytujKursy = "Edycja kursu ‹ Platforma kursów online — WordPress";

    //oczekiwana liczba pozycji menu bocznego okna 'Edycja kursów'
    int poprawnaIloscPozycjiWMenuBoczymOknaEdycjaKursow = 3;

    //oczekiwana liczba sekcji 'Podstawowe'
    int poprawnaIloscSekcjiPodstawowe = 8;

     @FindBy(xpath = "//h1[contains(text(),'Edycja kursu:')]")
     private WebElement edycjaKursu;

     @FindBy(xpath = "//div[contains(text(), 'Kursy')]")
     private WebElement zakladkaKursyMenuBoczne;

     @FindBy(xpath = "//span[contains(@class,'set-ico')]")
     private List<WebElement> menuBoczneEdycjaKursowIlosc;

     @FindBy(xpath = "//ul[contains(@class,'settings-nav-tab')]/li/a")
     private List<WebElement> menuBoczneEdycjaKursow;

     @FindBy(xpath = "//a[contains(@id,'general')]")
     private WebElement zakladkaPodstawoweMenuBoczneEdycjaKursow;

     @FindBy(xpath = "//span[contains(text(),'Nazwa i opis')]")
     private WebElement sekcjaNazwaIOpisZakladkiPodstawowe;

     @FindBy(xpath = "//span[contains(@class,'fields-group__name')]")
     private List<WebElement> sekcjaPodstawoweEdycjaKursowIlosc;

     @FindBy(xpath = "//span[contains(text(),'Sprzedaż')]")
     private WebElement sekcjaSprzedazZakladkiPodstawowe;

     @FindBy(xpath = "//div[@class='settings-content']/div/span")
     private List<WebElement> sekcjaPodstawoweEdycjaKursow;

     /***************************Repozytorium Webelementów KONIEC ******************************************/


    /****************************Operacje na Webelementach START **********************************************/

    //oczekiwanie na pojawienie się okna 'Edycja kursu'
    public void poczekajNaOknoEdycjaKursu(){
        wait.waitForVisibility(edycjaKursu);
    }

     //zwrócenie aktualnego url strony
     public Boolean zwrocUrlAktualnejStrony(){
         System.out.println("Adres strony 'Edycja kursu' jest poprawny, status: " + driver.getCurrentUrl().contains("//mmrmqpr585.publigo.onl/" ));
         return driver.getCurrentUrl().contains("//mmrmqpr585.publigo.onl/");
     }

     //zwrócenie poprawnego tytułu strony 'Edycja kursu' i wypisanie go w konsoli
    public String zwrocPoprawnyTytulStronyEdytujKursy(){
        System.out.println("Poprawny tytuł strony 'Edycja kursu': " + poprawnyTytulStronyEdytujKursy);
        return poprawnyTytulStronyEdytujKursy;
    }

     //zwrócenie aktualnego tytułu strony i wypisanie go w konsoli
     public String zwroctTytulAktualnejStrony(){
         System.out.println("Aktualny tytuł strony: " + driver.getTitle());
         return driver.getTitle();
     }

     //sprawdzenie widoczności sekcji 'Edycja kursu:'
     public Boolean pobranieTekstuOknaEdycjaKursu(){
         boolean status = false;
         if(wait.waitForTextInPageSource("Edycja kursu:")){
             status = true;
             System.out.println("Okno 'Edycja kursu' jest widoczne.");
         }
         return status;
     }

    //zwrócenie aktualnej liczby pozycji menu bocznego okna 'Edycja Kursów'
     public int zworcLiczbePozycjiWMenuBocznymOknaEdycjaKursow(){
         System.out.println("Aktualna liczba pozycji menu bocznego okna 'Edycja kursów': " + menuBoczneEdycjaKursowIlosc.size());
         return menuBoczneEdycjaKursowIlosc.size();
     }

     //zwrócenie poprawnej liczby pozycji menu bocznego okna 'Edycja Kursów'
     public int zwrocPoprawnaLiczbePozycjiWMenuBocznymOknaEdycjaKursow(){
         System.out.println("Poprawna liczba pozycji menu bocznego okna 'Edycja kursów': " + poprawnaIloscPozycjiWMenuBoczymOknaEdycjaKursow);
         return poprawnaIloscPozycjiWMenuBoczymOknaEdycjaKursow;
     }

     //sprawdzenie, czy w oknie Edycja kursu' w menu bocznym są 3 pozycje: 'Podstawowe', 'Struktura', 'Generator linków'.
     public List<String> zwrocNazwyPozycjiMenuBocznymOknaEdycjaKursow(){
         wait.waitForVisibility(menuBoczneEdycjaKursow.get(0));

         List<String> menuNazwa = new ArrayList<>();

         for(WebElement element: menuBoczneEdycjaKursow){
             menuNazwa.add(element.getText().trim());
         }
         System.out.println("Aktualna lista pozycji menu bocznego okna 'Edycja kursów': " + menuNazwa);

         return menuNazwa;
     }

     //zwrócenie oczekiwanych elementów listy menu bocznego okna 'Edycja Kursów'
     public List<String> zwrocPoprawneNazywyPozycjiOknaEdycjaKursow() {
         System.out.println("Poprawna lista pozycji menu bocznego okna 'Edycja kursów': [Podstawowe, Struktura, Generator linków]");
         return List.of("Podstawowe", "Struktura", "Generator linków");
     }

     //oczekiwanie na zakładkę 'Podstawowe'
     public void poczekajNaZakladkePodstawoweWMenuBocznymOknaEdycjaKursow(){
         wait.waitForClickability(zakladkaPodstawoweMenuBoczneEdycjaKursow);
     }

    //kliknięcie w zakładkę 'Podstawowe'
    public void kliknijZakladkePodstawoweWMenuBocznymOknaEdycjaKursow(){
        wait.waitForClickability(zakladkaPodstawoweMenuBoczneEdycjaKursow).click();
    }

     //oczekiwanie na pojawienie się sekcji 'Nazwa i opis' w zakładce 'Podstawowe'
     public void poczekajNaSekcjeNazwaIOpis() {
         wait.waitForVisibility(sekcjaNazwaIOpisZakladkiPodstawowe);
     }

     //oczekiwanie na pojawienie się sekcji 'Sprzedaż' w zakładce 'Podstawowe'
     public void poczekajNaSekcjeSprzedaz() {
         wait.waitForVisibility(sekcjaSprzedazZakladkiPodstawowe);
     }

     //zwrócenie aktualnej liczby sekcji 'Podstawowe' menu bocznego okna 'Edycja Kursów'
     public int zworcLiczbeSekcjiPodstawoweWMenuBocznymOknaEdycjaKursow(){
         System.out.println("Aktualna liczba sekcji 'Podstawowe' menu bocznego okna 'Edycja Kursów': " + sekcjaPodstawoweEdycjaKursowIlosc.size());
         return sekcjaPodstawoweEdycjaKursowIlosc.size();
     }
     //zwrócenie poprawnej liczby sekcji 'Podstawowe' menu bocznego okna 'Edycja Kursów'
     public int zwrocPoprawnaLiczbeSekcjiPodstawoweWMenuBocznymOknaEdycjaKursow(){
         System.out.println("Poprawna liczba sekcji 'Podstawowe' menu bocznego okna 'Edycja Kursów': " + poprawnaIloscSekcjiPodstawowe);
         return poprawnaIloscSekcjiPodstawowe;
     }

     //sprawdzenie, czy w oknie "Edycja kursu' w zakładce 'Podstawowe znajdują się odpowiednie sekcje
     public List<String> zwrocNazwySekcjiZakladkiPodstawoweWMenuBocznymOknaEdycjaKursow(){
         wait.waitForVisibility(sekcjaPodstawoweEdycjaKursow.get(0));

         List<String> menuNazwaSekcji = new ArrayList<>();

         for(WebElement element: sekcjaPodstawoweEdycjaKursow){
             menuNazwaSekcji.add(element.getText().trim());
         }
         System.out.println("Aktualna lista sekcji zakładki 'Podstawowe' menu bocznego okna 'Edycja kursów': " + menuNazwaSekcji);
         return menuNazwaSekcji;
     }

     //zwrócenie oczekiwanych elementów listy sekcji zakładki 'Podstawowe' menu bocznego okna 'Edycja Kursów'
     public List<String> zwrocPoprawneNazywySekcjiZakladkiPodstawoweWMenuBocznymOknaEdycjaKursow() {
         System.out.println("Aktualna lista sekcji zakładki 'Podstawowe' menu bocznego okna 'Edycja kursów': [Nazwa i opis, Umiejscowienie, Warianty, Graficzne, Widok, Certyfikacja, Brak autoryzacji, Sprzedaż]");
         return List.of("Nazwa i opis", "Umiejscowienie", "Warianty", "Graficzne", "Widok", "Certyfikacja", "Brak autoryzacji", "Sprzedaż");
     }


    /**********************************Operacje na Webelementach KONIEC ******************************************/

}
