package helpers;

import java.util.Random;


public class Utils {

    /**
     * Generuje losową liczbę całkowitą z zakresu od 1 do 100 (włącznie)
     * i zwraca ją jako ciąg znaków.
     *
     * @return String reprezentujący liczbę z zakresu 1–100
     */
    public static String generujLiczbeOd1Do100JakoString() {
        Random random = new Random();
        int liczba = random.nextInt(100) + 1;
        return String.valueOf(liczba);
    }

    /**
     * Generuje losową liczbę całkowitą z zakresu od 1 do 100000 (włącznie)
     * i zwraca ją jako ciąg znaków.
     *
     * @return String reprezentujący liczbę z zakresu 1–100000
     */
    public static String generujLiczbeOd1Do100000JakoString() {
        Random random = new Random();
        int liczba = random.nextInt(100000) + 1;
        return String.valueOf(liczba);
    }
}
