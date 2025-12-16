package org.hbrs.se1.ws25.demo.kapitel6.crud;

public class ClientForBuchung {
    public static void main(String[] args) {
        BuchungDTO buchungDTO = new BuchungDTO("Alda", 2);
        System.out.println("Name der Person: " + buchungDTO.name());
        System.out.println(buchungDTO.toString());
    }
}
