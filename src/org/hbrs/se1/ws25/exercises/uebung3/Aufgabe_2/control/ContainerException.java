package org.hbrs.se1.ws25.exercises.uebung3.Aufgabe_2.control;

public class ContainerException extends Exception{
    public ContainerException(String id){
        super("Das member mit der ID:  " + id + " Kann nicht gefunden werden.");

    }
}
