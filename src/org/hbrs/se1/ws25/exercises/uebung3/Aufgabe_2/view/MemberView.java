package org.hbrs.se1.ws25.exercises.uebung3.view;

import org.hbrs.se1.ws25.exercises.uebung3.control.Member;

import java.util.List;

public class MemberView {
    public void dump(List<Member> members){
        System.out.println("Ausgabe der Member Objekte: ");
        for (Member member : members) {
            System.out.println(member.toString());
        }

    }
}
