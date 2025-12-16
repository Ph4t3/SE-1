package org.hbrs.se1.ws25.exercises.uebung8.Aufgabe_1_b;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LegacyReiseAnbieter legacy = new LegacyReiseAnbieter();
        HotelSuche suche = new HotelsucheAdapter(legacy);

        SuchAuftrag auftrag = new SuchAuftrag();
        SuchErgebnis ergebnis = suche.suche(auftrag);
    }
}