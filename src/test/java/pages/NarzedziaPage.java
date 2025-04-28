package pages;
import config.PropertiesReader;
import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NarzedziaPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/
    //przypisanie loginu i hasła z pliku konfiguracyjnego, teraz korzystamy z danych pliku konfguracyjnego
    private static final String login =  PropertiesReader.read("login");
    private static final String haslo =  PropertiesReader.read("password");

    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public NarzedziaPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/

    /************************Repozytorium webelementów START **********************************************/

    String poprawnyURLZakladkiNarzedzia = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-tools";
    String poprawnyTytulZakladkiNarzedzia = "Narzędzia ‹ Platforma kursów online — WordPress";
    int prawidlowaLiczbaZakladekMenuBoczne = 3;
    int prawidlowaLiczbaCkeckboxowNaStronie = 3;

    @FindBy(xpath = "//ul[contains(@class, 'settings-nav-tab')]/li")
    private List<WebElement> zakladkiMenuBoczne;

    @FindBy(xpath = "//*[contains(@id, 'wp-idea-import_students-tab-link')]")
    private WebElement zakladkaImportKursantow;

    @FindBy(xpath = "//*[contains(@id, 'wp-idea-banned_emails-tab-link')]")
    private WebElement zakladkaZablokowaneAdresyEmail;

    @FindBy(xpath = "//*[contains(@id, 'wp-idea-api-tab-link')]")
    private WebElement zakladkaKluczAPI;

    @FindBy(xpath = "//input[contains(@type, 'checkbox')]")
    private List<WebElement> ckeckboxyNaStronie;

    @FindBy(xpath = "//input[contains(@name, 'access')]")
    private WebElement checkboxWyslijEmailZDanymiDostepowymi;

    @FindBy(xpath = "//input[contains(@name, 'notification')]")
    private WebElement checkboxWyslijPotwierdzenieZamowienia;

    @FindBy(xpath = "//input[contains(@name, 'mailing')]")
    private WebElement checkboxZapiszNaListeMailingowa;

    @FindBy(xpath = "//*[contains(@value, 'Import kursantów')]")
    private WebElement importKursantowButton;

    @FindBy(xpath = "//a[contains(text(), 'Narzędzia')]")
    private WebElement narzedziaMenuBoczne;

    @FindBy(xpath = "//a[contains(text(), 'Powiadomienia')]")
    private WebElement powiadomieniaMenuBoczne;

    @FindBy(xpath = "//a[contains(text(), 'Logi')]")
    private WebElement logiMenuBoczne;

    @FindBy(xpath = "//a[contains(text(), 'Webhooki')]")
    private WebElement webhookiMenuBoczne;

    @FindBy(xpath = "//a[contains(text(), 'Przekierowania')]")
    private WebElement przekierowaniaMenuBoczne;





    /***************************Repozytorium webelementów KONIEC ******************************************/


    /****************************Operacje na webelementach START **********************************************/

    public String zwrocAktualnyURLZakladkiNarzedzia(){
        System.out.println("Aktualny adres URL strony to: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String zwrocPoprawnyURLZakladkiNarzedzia(){
        System.out.println("Poprawny adres URL strony to: " + poprawnyURLZakladkiNarzedzia);
        return poprawnyURLZakladkiNarzedzia;
    }

    public String zwrocAktualnyTytulZakladkiNarzedzia(){
        System.out.println("Aktualny tytul strony to: " + driver.getTitle());
        return driver.getTitle();
    }

    public String zwrocPoprawnyTytulZakladkiNarzedzia(){
        System.out.println("Poprawny tytul strony to: " + poprawnyTytulZakladkiNarzedzia);
        return poprawnyTytulZakladkiNarzedzia;
    }

    // Zwraca aktualną liczbę zakładek w menu bocznym strony "Narzędzia"
    public int zwrocAktualnaLiczbeZakladekMenuBoczneNarzedzia(){
        System.out.println("Altualna liczba zakładek w menu bocznym strony NARZĘDZIA: " + zakladkiMenuBoczne.size());
        return zakladkiMenuBoczne.size();
    }

    // Zwraca oczekiwaną (poprawną) liczbę zakładek w menu bocznym strony "Narzędzia"
    public int zwrocPoprawnaLiczbeZakladekMenuBoczneNarzedzia(){
        System.out.println("Oczekiwana liczba zakładek w menu bocznym strony NARZĘDZIA: " + prawidlowaLiczbaZakladekMenuBoczne);
        return prawidlowaLiczbaZakladekMenuBoczne;
    }

    // Zwraca aktualną liczbę checkboxów na stronie "Narzędzia"
    public int zwrocAktualnaLiczbeCheckboxowNarzedzia(){
        System.out.println("Altualna liczba checkboxów na stronie NARZĘDZIA: " + ckeckboxyNaStronie.size());
        return ckeckboxyNaStronie.size();
    }

    // Zwraca oczekiwaną (poprawną) liczbę checkboxów na stronie "Narzędzia"
    public int zwrocPoprawnaLiczbeCheckboxowNarzedzia(){
        System.out.println("Oczekiwana liczba checkboxów na stronie NARZĘDZIA: " + prawidlowaLiczbaCkeckboxowNaStronie);
        return prawidlowaLiczbaCkeckboxowNaStronie;
    }

    // Sprawdza, czy aktualne nazwy zakładek w menu bocznym strony "Narzędzia" są widoczne i takie same, jak oczekiwane
    public boolean zweryfikujNazwyZakladekMenuBoczneNarzedzia() {
        Map<String, WebElement> nazwyPozycji = new HashMap<>();
        nazwyPozycji.put("Import kursantów", zakladkaImportKursantow);
        nazwyPozycji.put("Zablokowane adresy email", zakladkaZablokowaneAdresyEmail);
        nazwyPozycji.put("Klucz API", zakladkaKluczAPI);


        boolean status = true;

        for (Map.Entry<String, WebElement> entry : nazwyPozycji.entrySet()) {
            String oczekiwanaNazwaPozycji = entry.getKey();
            WebElement aktualnaNazwaPozycji = entry.getValue();

            try {
                WebElement obecnyElement = wait.waitForVisibility(aktualnaNazwaPozycji);

                boolean nazwaWidoczna = obecnyElement.isDisplayed();
                boolean nazwaZgodna = obecnyElement.getText().trim().equals(oczekiwanaNazwaPozycji);

                if (!nazwaWidoczna || !nazwaZgodna) {
                    if (!nazwaWidoczna) {
                        System.out.println("Zakładka w menu bocznym strony NARZĘDZIA nie jest widoczna: " + oczekiwanaNazwaPozycji);
                    }
                    if (!nazwaZgodna) {
                        System.out.println("Nazwa zakładki w menu bocznym strony NARZĘDZIA jest niezgodna. "
                                + "Oczekiwano: '" + oczekiwanaNazwaPozycji + "' "
                                + "Znaleziono: '" + obecnyElement.getText().trim() + "' ");
                    }
                    status = false;
                } else {
                    System.out.println("Zakładki w menu bocznym strony NARZĘDZIA są widoczne i mają zgodne nazwy: " + oczekiwanaNazwaPozycji);
                }

            } catch (Exception e) {
                System.out.println("Na stronie NARZĘDZIA nie ma zakładki: " + oczekiwanaNazwaPozycji);
                e.printStackTrace();
                status = false;
            }
        }

        return status;
    }

    // Sprawdza, czy wszystkie 3 checkboxy są domyślnie niezaznaczone:
    public boolean zweryfikujCzyCheckboxSaNieznaczoneNarzedzia() {
        boolean status = true;

        for(WebElement checkbox : ckeckboxyNaStronie){
            if(checkbox.isSelected()){
                status = false;
                System.out.println("BŁĄD! Checkbox domyślnie zaznaczony: " + checkbox.getAttribute("name"));
            }else{
                System.out.println("Checkbox jest domyślnie niezaznaczony: " + checkbox.getAttribute("name"));
            }
        }

        return status;
    }

    // Sprawdza, czy wszystkie 3 checkboxy są widoczne
    public boolean zweryfikujCzyCheckboxSaWidoczneNarzedzia() {
        boolean status = true;

        for(WebElement checkbox : ckeckboxyNaStronie){
            if(checkbox.isDisplayed()){
                System.out.println("Checkbox widoczny na stronie NARZĘDZIA: " + checkbox.getAttribute("name"));
            }else{
                status = false;
                System.out.println("BŁĄD! Nie widać checkboxa na stronie NARZĘDZIA: " + checkbox.getAttribute("name"));

            }
        }

        return status;
    }

    // Sprawdza, czy przycisk "Import kursantów" istnieje stronie
    public boolean zweryfikujCzyPrzyciskImportKursantowIstnieje(){
        boolean status = false;

        if (importKursantowButton.isDisplayed()) {
            status = true;
            System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ istnieje przycisk: " + importKursantowButton.getAccessibleName());
        } else {
            System.out.println("Na stronie UTWÓRZ PŁATNOŚĆ nie ma przycisku DODAJ KOLEJNY");
        }

        return status;
    }

    // Sprawdza, czy na pasku bocznym menu głównego "Narzędzia" podpozycje są widoczne i mają aktualne nazwy
    public boolean zweryfikujWidocznoscINazwyPodpozycjiMenuGlowneNarzedzia() {
        Map<String, WebElement> nazwyPozycji = new HashMap<>();
        nazwyPozycji.put("Narzędzia", narzedziaMenuBoczne);
        nazwyPozycji.put("Powiadomienia", powiadomieniaMenuBoczne);
        nazwyPozycji.put("Logi", logiMenuBoczne);
        nazwyPozycji.put("Webhooki", webhookiMenuBoczne);
        nazwyPozycji.put("Przekierowania", przekierowaniaMenuBoczne);

        boolean status = true;

        for (Map.Entry<String, WebElement> entry : nazwyPozycji.entrySet()) {
            String oczekiwanaNazwaPozycji = entry.getKey();
            WebElement aktualnaNazwaPozycji = entry.getValue();

            try {
                WebElement obecnyElement = wait.waitForVisibility(aktualnaNazwaPozycji);

                boolean nazwaWidoczna = obecnyElement.isDisplayed();
                boolean nazwaZgodna = obecnyElement.getText().trim().equals(oczekiwanaNazwaPozycji);

                if (!nazwaWidoczna || !nazwaZgodna) {
                    if (!nazwaWidoczna) {
                        System.out.println("Podpozycja w menu głównym NARZĘDZIA nie jest widoczna: " + oczekiwanaNazwaPozycji);
                    }
                    if (!nazwaZgodna) {
                        System.out.println("Nazwa podpozycji w menu głównym NARZĘDZIA jest niezgodna. "
                                + "Oczekiwano: '" + oczekiwanaNazwaPozycji + "' "
                                + "Znaleziono: '" + obecnyElement.getText().trim() + "' ");
                    }
                    status = false;
                } else {
                    System.out.println("Podpozycja w menu głównym NARZĘDZIA jest widoczna i ma zgodną nazwę : " + oczekiwanaNazwaPozycji);
                }

            } catch (Exception e) {
                System.out.println("W menu głównym NARZĘDZIA nie ma podpozycji: " + oczekiwanaNazwaPozycji);
                e.printStackTrace();
                status = false;
            }
        }

        return status;
    }
    // Kliknięcia w podpozycje w bocznym menu głównym NARZĘDZIA
        // Przejście do strony "Powiadomienia"
    public void przejdzDoZakladkiNarzedziaPowiadomieniaMenuBoczne() {
        wait.waitForVisibility(powiadomieniaMenuBoczne).click();
        System.out.println("Kliiknięcie podpozycji 'Powiadomienia' w menu bocznym 'Narzędzia'");
    }
        // Przejście do strony "Logi"
    public void przejdzDoZakladkiNarzedziaLogiMenuBoczne() {
        wait.waitForVisibility(logiMenuBoczne).click();
        System.out.println("Kliiknięcie podpozycji 'Logi' w menu bocznym 'Narzędzia'");
    }
        // Przejście do strony "Webhooki"
    public void przejdzDoZakladkiNarzedziaWebhookiMenuBoczne() {
        wait.waitForVisibility(webhookiMenuBoczne).click();
        System.out.println("Kliiknięcie podpozycji 'Webhooki' w menu bocznym 'Narzędzia'");
    }
        // Przejście do strony "Przekierowania"
    public void przejdzDoZakladkiNarzedziaPrzekierowaniaMenuBoczne() {
        wait.waitForVisibility(przekierowaniaMenuBoczne).click();
        System.out.println("Kliiknięcie podpozycji 'Przekierowania' w menu bocznym 'Narzędzia'");
    }


    /**********************************Operacje na webelementach KONIEC ******************************************/


}
