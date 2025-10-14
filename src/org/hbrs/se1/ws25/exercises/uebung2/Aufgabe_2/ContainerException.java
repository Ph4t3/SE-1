package org.hbrs.se1.ws25.exercises.uebung2.Aufgabe_2;

public class ContainerException extends Exception{
    public ContainerException(Integer id){
        super("Das member mit der ID:  " + id + " Kann nicht gefunden werden.");

    }
}
