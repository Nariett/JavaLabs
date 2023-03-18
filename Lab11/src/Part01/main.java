package Part01;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("На английском языке");
        printInfo("en", "US");
        System.out.println("На русском языке");
        printInfo("ru", "RU");


    }

    private static void printInfo(String language, String country)
            throws UnsupportedEncodingException {
        Locale current = new Locale(language, country);
        ResourceBundle rb = ResourceBundle.getBundle("text", current);
        for (String key : rb.keySet()) {
            String value = rb.getString(key);
            System.out.println(value);
        }
    }
}
