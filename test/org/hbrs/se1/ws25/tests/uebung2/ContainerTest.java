package org.hbrs.se1.ws25.tests.uebung2;

import org.junit.jupiter.api.Test;
import org.hbrs.se1.ws25.exercises.uebung2.Aufgabe_2.Container;
import org.hbrs.se1.ws25.exercises.uebung2.Aufgabe_2.ContainerException;
import org.hbrs.se1.ws25.exercises.uebung2.Aufgabe_2.ConcreteMember;

class ContainerTest {
    private Container container;

    @Test
    void addMember() throws ContainerException {
        container.addMember(new ConcreteMember( 1," phil"));
        container.addMember(new ConcreteMember( 2," leo"));
        container.addMember(new ConcreteMember( 3," david"));
    }
    @Test
    void deleteMember() {
        container.deleteMember(3);
    }

    @Test
    void dump() {
    }

    @Test
    void size() {
    }
}