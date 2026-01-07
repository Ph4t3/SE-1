package org.hbrs.se1.ws25.exercises.uebung9.Aufgabe_2.Task_2;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String textDoc2 = "Die Klausur im Fach SE findet bald im März 2026 statt!";
        String textDoc5 = "Software Engineering I ist eine Vorlesung in den Studiengaengen BWI und BCSP!";

        ComplexDocument doc0 = new ComplexDocument();
        doc0.setID(0);


        TextDocument doc2 = new TextDocument(textDoc2, TextDocument.Encoding.UTF16);
        doc2.setID(2);


        ComplexDocument doc3 = new ComplexDocument();
        doc3.setID(3);


        TextDocument doc5 = new TextDocument(textDoc5, TextDocument.Encoding.UTF32);
        doc5.setID(5);


        GraphicDocument doc4 = new GraphicDocument("localhost:8080");
        doc4.setID(4);


        doc3.addDocument(doc5);
        doc3.addDocument(doc4);

        doc0.addDocument(doc2);
        doc0.addDocument(doc3);


        int totalBytes = doc0.size();
        System.out.println("Gesamtgroesse (Bytes) = " + totalBytes);
    }
}


