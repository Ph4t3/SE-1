package org.hbrs.se1.ws25.demo.kapitel6.records;

import org.hbrs.se1.ws25.demo.kapitel6.crud.BuchungDTO;

public class ClientForDTO {
    public static void main(String[] args) {
        PersonDTO personDTO = new PersonDTO("Alda", 2);

        // Methode für name (getName!) wird automatisch erzeugt.
        System.out.println("Name der Person: " + personDTO.name());
        System.out.println(personDTO.toString());
    }
}
