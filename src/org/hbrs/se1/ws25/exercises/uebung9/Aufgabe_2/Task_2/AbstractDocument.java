package org.hbrs.se1.ws25.exercises.uebung9.Aufgabe_2.Task_2;

public abstract class AbstractDocument implements Document {
    private int id;

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }
}
