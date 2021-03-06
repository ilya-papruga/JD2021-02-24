package by.it.zmushko.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class ChangeLanguage {

    public Scanner scan = new Scanner(System.in);

    public void changeLang(Language lang) {
        System.out.println(Messages.ASK_CHOOSE_LANG);
        String line = scan.nextLine();
        switch (line) {
            case "BY":
                lang.setLocale(new Locale("be", "BY"));
                break;
            case "RU":
                lang.setLocale(new Locale("ru", "RU"));
                break;
            default:
                lang.setLocale(Locale.getDefault());
                break;
        }
    }
}
