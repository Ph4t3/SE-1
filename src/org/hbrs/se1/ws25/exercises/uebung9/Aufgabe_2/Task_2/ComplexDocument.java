package org.hbrs.se1.ws25.exercises.uebung9.Aufgabe_2.Task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ComplexDocument extends AbstractDocument{
    private  List<Document> children = new ArrayList<>();

    public void addDocument(Document d) {
        children.add(Objects.requireNonNull(d));
    }

    public void removeDocument(Document d) {
        children.remove(d);
    }

    @Override
    public int size() {
        int sum = 0;
        for (Document d : children) {
            sum += d.size();
        }
        return sum;
    }
}
