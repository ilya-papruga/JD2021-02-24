package by.it.khrolovich.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Language {
    INSTANCE;

    private final String BASE = "by.it.khrolovich.calc.resources.language";

    ResourceBundle bundle;

    Language() {
        setLocale(Locale.getDefault());
    }

    final void setLocale(Locale locale){
        bundle = ResourceBundle.getBundle(BASE, locale);
    }

    final Locale getLocale( ){
       return bundle.getLocale();
    }

    String get(String key){
        return bundle.getString(key);
    }
}
