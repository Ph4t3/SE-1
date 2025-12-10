package org.hbrs.se1.ws25.demo.vererbung.reise;

public class Main {
    public static void main(String[] args) {
        Reise meineReise = new Fernreise();

        // Reise meineReise2 = new Reise();

        // Laden von neuen Reisen mit dem Classloader-Mechanismus
        // (Vorlesung OOKA / Master Informatik)
        // Classloader.load (new URL ( ./Stadtreise.class ) );
        // Reise meineReise2 = new Stadtreise();

    }
}
