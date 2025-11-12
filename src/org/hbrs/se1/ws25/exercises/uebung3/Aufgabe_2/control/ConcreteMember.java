package org.hbrs.se1.ws25.exercises.uebung3.Aufgabe_2.control;

public class ConcreteMember implements Member {
    private Integer id;
    private String name;

    public ConcreteMember(Integer id1, String name1) {
        this.id = id1;
        this.name = name1;
    }

    @Override
    public Integer getID() {
        return 0;
    }

    @Override
    public String toString() {
        return "Member (ID =" + id +")";
    }
}