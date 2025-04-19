 package pages.ustawienia;

import helpers.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

 public class UstawieniaPage {

    /************************Seckja techniczno konfiguracyjna START **********************************************/


    // Konstruktor, który przyjmuje przeglądarkę, linia techniczna / konfiguracyjna
    private WebDriver driver;
    private Waits wait;

    //konstrukotor, który tworzy nową instancję strony logowania
    public UstawieniaPage(WebDriver driver){
        this.driver = driver;
        this.wait = new Waits(driver);
        PageFactory.initElements(driver, this);
    }

    /************************Seckja techniczno konfiguracyjna KONIEC**********************************************/


    /************************Repozytorium webelementów START **********************************************/

    // Oczekiwany (poprawny) adres URL strony "Ustawienia"
    private String poprawnyUrlUstawienia = "https://mmrmqpr585.publigo.onl/wp-admin/admin.php?page=wp-idea-settings&autofocus=general";

     // Oczekiwany (poprawny) tytul strony "Ustawienia"
    private String poprawnyTytulUstawienia = "Ustawienia ‹ Platforma kursów online — WordPress";

    private Integer poprawnaIloscPozycjiMenuBoczne = 12;

     @FindBy(xpath ="//a[contains(text(),'Główne')]")
     private WebElement linkGlowne;

     @FindBy(xpath ="//a[contains(text(),'Szablony')]")
     private WebElement linkSzablony;

     @FindBy(xpath ="//a[contains(text(),'Menu')]")
     private WebElement linkMenu;

     @FindBy(xpath ="//a[contains(text(),'Wygląd')]")
     private WebElement linkUstawieniaWyglad;

     @FindBy(id ="general")
     private WebElement linkPodstawowe;

     @FindBy(id ="accounting")
     private WebElement linkKsiegowe;

     @FindBy(id ="payments")
     private WebElement linkSposobyPlatnosci;

     @FindBy(id ="design")
     private WebElement linkWyglad;

     @FindBy(id ="integrations")
     private WebElement linkIntegracje;

     @FindBy(id ="cart")
     private WebElement linkKoszykZakupowy;

     @FindBy(id ="messages")
     private WebElement linkWiadomosci;

     @FindBy(id ="gift")
     private WebElement linkZakupyNaPrezent;

     @FindBy(id ="certificate")
     private WebElement linkCertyfikaty;

     @FindBy(id ="analytics")
     private WebElement linkAnalitykaSkrypty;

     @FindBy(id ="modules")
     private WebElement linkWlaczModuly;

     @FindBy(id ="advanced")
     private WebElement linkZaawansowane;

     @FindBy(className = "set-ico")
     private List<WebElement> pozycjeMenuBoczne;

     @FindBy(xpath ="//span[contains(text(),'Serwis')]")
     private WebElement sekcjaSerwis;

     @FindBy(xpath ="//span[contains(text(),'Branding')]")
     private WebElement sekcjaBranding;

     @FindBy(xpath ="//span[contains(text(),'Strony funkcjonalne')]")
     private WebElement sekcjaStronyFunkcjonalne;

     @FindBy(xpath ="//span[contains(text(),'Zarządzanie komentarzami')]")
     private WebElement sekcjaZarzadzanieKomentarzami;

     @FindBy(xpath ="//span[contains(text(),'Administracyjne')]")
     private WebElement sekcjaAdministracyjne;

     @FindBy(xpath ="//span[contains(text(),'Stopka')]")
     private WebElement sekcjaStopka;

     @FindBy(xpath ="//span[contains(text(),'RODO')]")
     private WebElement sekcjaRODO;

     @FindBy(xpath ="//span[contains(text(),'Sprzedaż')]")
     private WebElement sekcjaSprzedaz;








    /***************************Repozytorium webelementów KONIEC ******************************************/






    /****************************Operacje na webelementach START **********************************************/


    // Zwraca oczekiwany (poprawny) URL strony "Ustawienia" i wypisuje go w konsoli
    public String getPoprawnyUrlUstawienia() {
        System.out.println("Poprawny url strony ustawienia: " + poprawnyUrlUstawienia);
        return poprawnyUrlUstawienia;
    }

     // Zwraca aktualny URL przeglądanej strony "Ustawienia" i wypisuje go w konsoli
    public String getAktualnyUrlUstawienia() {
        System.out.println("Aktualny url strony ustawienia: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

     // Zwraca oczekiwany (poprawny) tytul "Ustawienia" i wypisuje go w konsoli
     public String getPoprawnyTytulUstawienia() {
         System.out.println("Poprawny tytul strony ustawienia: " + poprawnyTytulUstawienia);
         return poprawnyTytulUstawienia;
     }

     // Zwraca aktualny tytul przeglądanej strony "Ustawienia" i wypisuje go w konsoli
     public String getAktualnyTytulUstawienia() {
         System.out.println("Aktualny tytul strony ustawienia: " + driver.getTitle());
         return driver.getTitle();
     }

     public Integer aktualnaLiczbaPozycjiMenuBoczne() {
        System.out.println("Aktualna ilosc pozycji menu boczne: " + pozycjeMenuBoczne.size());
        return pozycjeMenuBoczne.size();
     }

     public Integer zwrocPoprawnaIloscPozycjiMenuBoczne() {
        System.out.println("Pooprawna ilosc pozycji menu boczne: " + poprawnaIloscPozycjiMenuBoczne);
        return poprawnaIloscPozycjiMenuBoczne;
     }

     public boolean czyPozycjeMenuBoczneUstawieniaSaPoprawne() {

         return (linkPodstawowe.getText().equals("Podstawowe") &&
                 linkKsiegowe.getText().equals("Księgowe") &&
                 linkSposobyPlatnosci.getText().equals("Sposoby płatności") &&
                 linkWyglad.getText().equals("Wygląd") &&
                 linkIntegracje.getText().equals("Integracje") &&
                 linkKoszykZakupowy.getText().equals("Koszyk zakupowy") &&
                 linkWiadomosci.getText().equals("Wiadomości") &&
                 linkZakupyNaPrezent.getText().equals("Zakupy na prezent") &&
                 linkCertyfikaty.getText().equals("Certyfikaty") &&
                 linkAnalitykaSkrypty.getText().equals("Analityka i skrypty") &&
                 linkWlaczModuly.getText().equals("Włącz moduły") &&
                 linkZaawansowane.getText().equals("Zaawansowane"));
     }


     public boolean czyMenuGlowneUstawieniaZawieraWlasciwePozycje() {
         Map<String, WebElement> pozycje = new LinkedHashMap<>();
         pozycje.put("Główne", linkGlowne);
         pozycje.put("Szablony", linkSzablony);
         pozycje.put("Menu", linkMenu);
         pozycje.put("Wygląd", linkUstawieniaWyglad);

         boolean wszystkieWidoczne = true;

         for (Map.Entry<String, WebElement> entry : pozycje.entrySet()) {
             String nazwaPozycji = entry.getKey();
             WebElement elementPozycji = entry.getValue();

             try {
                 if (!wait.waitForVisibility(elementPozycji).isDisplayed()) {
                     System.out.println("Pozycja niewidoczna: " + nazwaPozycji);
                     wszystkieWidoczne = false;
                 } else {
                     System.out.println("Pozycja widoczna: " + nazwaPozycji);
                 }
             } catch (Exception e) {
                 System.out.println("Błąd podczas sprawdzania pozycji: " + nazwaPozycji);
                 e.printStackTrace();
                 wszystkieWidoczne = false;
             }
         }

         return wszystkieWidoczne;
     }




     public boolean czyZakladkaPodstawowePosiadaWlasciweSekcje() {
         Map<String, WebElement> sekcje = new LinkedHashMap<>();
         sekcje.put("Serwis", sekcjaSerwis);
         sekcje.put("Branding", sekcjaBranding);
         sekcje.put("Strony funkcjonalne", sekcjaStronyFunkcjonalne);
         sekcje.put("Zarządzanie komentarzami", sekcjaZarzadzanieKomentarzami);
         sekcje.put("Administracyjne", sekcjaAdministracyjne);
         sekcje.put("Stopka", sekcjaStopka);
         sekcje.put("RODO", sekcjaRODO);
         sekcje.put("Sprzedaż", sekcjaSprzedaz);

         boolean wszystkieWidoczne = true;

         for (Map.Entry<String, WebElement> entry : sekcje.entrySet()) {
             String nazwaSekcji = entry.getKey();
             WebElement elementSekcji = entry.getValue();

             try {
                 if (!wait.waitForVisibility(elementSekcji).isDisplayed()) {
                     System.out.println("Sekcja niewidoczna: " + nazwaSekcji);
                     wszystkieWidoczne = false;
                 }

                 else {
                     System.out.println("Sekcja widoczna: " + nazwaSekcji);
                 }
             } catch (Exception e) {
                 System.out.println("Błąd podczas sprawdzania sekcji: " + nazwaSekcji);
                 e.printStackTrace();
                 wszystkieWidoczne = false;
             }
         }

         return wszystkieWidoczne;
     }




     public void kliknijLinkSzablony() {
         wait.waitForClickability(linkSzablony).click();
     }

     public void kliknijLinkMenu() {
         wait.waitForClickability(linkMenu).click();
     }

     public void kliknijLinkKsiegowe() {
         wait.waitForClickability(linkKsiegowe).click();
     }

     public void kliknijLinkSposobyPlatnosci() {
         wait.waitForClickability(linkSposobyPlatnosci).click();
     }

     public void kliknijLinkWyglad() {
         wait.waitForClickability(linkWyglad).click();
     }

     public void kliknijLinkIntegracje() {
         wait.waitForClickability(linkIntegracje).click();
     }

     public void kliknijLinkKoszykZakupowy() {
         wait.waitForClickability(linkKoszykZakupowy).click();
     }

     public void kliknijLinkWiadomosci() {
         wait.waitForClickability(linkWiadomosci).click();
     }

     public void kliknijLinkZakupyNaPrezent() {
         wait.waitForClickability(linkZakupyNaPrezent).click();
     }

     public void kliknijLinkCertyfikaty() {
         wait.waitForClickability(linkCertyfikaty).click();
     }

     public void kliknijLinkAnalitykaSkrypty() {
         wait.waitForClickability(linkAnalitykaSkrypty).click();
     }

     public void kliknijLinkWlaczModuly() {
         wait.waitForClickability(linkWlaczModuly).click();
     }

     public void kliknijLinkZaawansowane() {
         wait.waitForClickability(linkZaawansowane).click();
     }











    /**********************************Operacje na webelementach KONIEC ******************************************/

}
