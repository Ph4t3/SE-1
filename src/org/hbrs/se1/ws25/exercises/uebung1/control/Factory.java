package org.hbrs.se1.ws25.exercises.uebung1.control;

public class Factory {

    public static Translator createGermanTranslator() {
        GermanTranslator hermann = new GermanTranslator();
        hermann.setDate("Okt/2025");
        return hermann;
    }
}

