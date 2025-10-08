package org.hbrs.se1.ws25.tests.uebung1;

import org.hbrs.se1.ws25.exercises.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws25.exercises.uebung1.control.Translator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GermanTranslatorTest {
    private Translator translator;

    @BeforeEach
    void setUp() {
        this.translator = new GermanTranslator();
    }

    @Test
    @DisplayName("Test1: Gueltige Zahl aus der Mitte des Bereichs (5)")
    void testTranslationForValidNumber() {
        String result = translator.translateNumber(5);
        assertEquals("fuenf", result);
    }

    @Test
    @DisplayName("Test2 & Test3: Grenzwerte des gueltigen Bereichs (1 und 10)")
    void testTranslationForBoundaryValuesValid() {
        assertEquals("eins", translator.translateNumber(1));
        assertEquals("zehn", translator.translateNumber(10));
    }

    @Test
    @DisplayName("Test4: Untere Grenze des ungueltigen Bereichs (0)")
    void testTranslationForInvalidNumberTooSmall() {
        String expected = "Uebersetzung der Zahl 0 nicht moeglich (Translator Version: 1.0)";
        String actual = translator.translateNumber(0);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test5: Obere Grenze des ungueltigen Bereichs (11)")
    void testTranslationForInvalidNumberTooLarge() {
        String expected = "Uebersetzung der Zahl 11 nicht moeglich (Translator Version: 1.0)";
        String actual = translator.translateNumber(11);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test6: Repraesentative ungueltigen negative Zahl (-5)")
    void testTranslationForRepresentativeNegativeNumber() {
        String expected = "Uebersetzung der Zahl -5 nicht moeglich (Translator Version: 1.0)";
        String actual = translator.translateNumber(-5);
        assertEquals(expected, actual);
    }
}