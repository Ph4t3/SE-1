package org.hbrs.se1.ws25.exercises.uebung1.control;

public class GermanTranslator implements Translator {

	public String date = "Okt/2025"; // Default-Wert

	/**
	 * Methode zur Übersetzung einer Zahl in eine String-Repraesentation
	 */
	 public String translateNumber(int number) {
         String[] words = {"eins","zwei","drei","vier","fuenf","sechs","sieben","acht","neun","zehn"};
         try {
             return words[number-1];
         } catch (ArrayIndexOutOfBoundsException e) {
             return "Uebersetzung der Zahl " + number + " nicht moeglich (Translator Version: " + Translator.version + ")";
         }
	}

	/**
	 * Objektmethode der Klasse GermanTranslator zur Ausgabe einer Info.
	 */
	void printInfo(){
		System.out.println( "GermanTranslator v1.9, erzeugt am " + this.date );
	}

	/**
	 * Setzen des Datums, wann der Uebersetzer erzeugt wurde (Format: Monat/Jahr (Beispiel: "Okt/2024"))
	 * Das Datum sollte system-intern durch eine Factory-Klasse gesetzt werden und nicht von externen View-Klassen
	 */
	public void setDate( String date ) {
		this.date = date;
	}

}
