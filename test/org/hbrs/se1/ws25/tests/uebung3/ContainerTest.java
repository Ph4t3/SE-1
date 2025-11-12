package org.hbrs.se1.ws25.tests.uebung3;

import org.hbrs.se1.ws25.exercises.uebung3.Aufgabe_2.control.ConcreteMember;
import org.hbrs.se1.ws25.exercises.uebung3.Aufgabe_2.control.Container;
import org.hbrs.se1.ws25.exercises.uebung3.Aufgabe_2.control.ContainerException;

public class ContainerTest {

    public static void main(String[] args) {
        ContainerTest test = new ContainerTest();
        test.runTests();
    }

    private Container container = new Container();

    public void runTests() {


        testCase1_addMember1();
        testCase2_addMember2();
        testCase3_addDuplicate();
        testCase4_deleteMember2();
        testCase5_deleteMember1();
        testCase6_addNull();


    }

    void testCase1_addMember1() {
        System.out.println("TC1: add new Member(1)");
        try {
            container.addMember(new ConcreteMember(1, "A"));
            int size = container.size();
            if (size == 1) {
                System.out.println("OK → size == 1");
            } else {
                System.out.println("FAIL → expected size 1 but got " + size);
            }
        } catch (Exception e) {
            System.out.println("FAIL → unexpected exception: " + e.getMessage());
        }
        System.out.println();
    }

    void testCase2_addMember2() {
        System.out.println("TC2: add new Member(2)");
        try {
            container.addMember(new ConcreteMember(2, "B"));
            int size = container.size();
            if (size == 2) {
                System.out.println("OK → size == 2");
            } else {
                System.out.println("FAIL → expected size 2 but got " + size);
            }
        } catch (Exception e) {
            System.out.println("FAIL → unexpected exception: " + e.getMessage());
        }
        System.out.println();
    }

    void testCase3_addDuplicate() {
        System.out.println("TC3: add cloned Member(2)");
        try {
            container.addMember(new ConcreteMember(2, "B-dup"));
            System.out.println("FAIL → duplicate accepted!");
        } catch (ContainerException e) {
            System.out.println("OK → duplicate correctly rejected: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("FAIL → wrong exception: " + e.getMessage());
        }
        System.out.println("size() = " + container.size());
        System.out.println();
    }

    void testCase4_deleteMember2() {
        System.out.println("TC4: delete Member(2)");
        try {
            String msg = container.deleteMember(2);
            System.out.println("deleteMember() → " + msg);
            int size = container.size();
            if (size == 1) {
                System.out.println("OK → size == 1");
            } else {
                System.out.println("FAIL → expected size 1 but got " + size);
            }
        } catch (Exception e) {
            System.out.println("FAIL → unexpected exception: " + e.getMessage());
        }
        System.out.println();
    }

    void testCase5_deleteMember1() {
        System.out.println("TC5: delete Member(1)");
        try {
            String msg = container.deleteMember(1);
            System.out.println("deleteMember() → " + msg);
            int size = container.size();
            if (size == 0) {
                System.out.println("OK → size == 0");
            } else {
                System.out.println("FAIL → expected size 0 but got " + size);
            }
        } catch (Exception e) {
            System.out.println("FAIL → unexpected exception: " + e.getMessage());
        }
        System.out.println();
    }

    void testCase6_addNull() {
        System.out.println("TC6: add null");
        try {
            container.addMember(null);
            System.out.println("FAIL → null was accepted!");
        } catch (IllegalArgumentException e) {
            System.out.println("OK → IllegalArgumentException caught as expected");
        } catch (Exception e) {
            System.out.println("FAIL → wrong exception: " + e.getMessage());
        }
        int size = container.size();
        if (size == 0) {
            System.out.println("OK → size == 0");
        } else {
            System.out.println("FAIL → expected size 0 but got " + size);
        }
        System.out.println();
    }
}
