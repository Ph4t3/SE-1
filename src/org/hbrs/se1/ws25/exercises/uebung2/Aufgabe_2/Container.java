package org.hbrs.se1.ws25.exercises.uebung2.Aufgabe_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Container {
    public List<Member> member1 = new ArrayList<>();

public void addMember(Member member) throws ContainerException {
    Objects.requireNonNull(member,"member");
    Integer id = Objects.requireNonNull(member.getID(), "member.getID()");
    for (Member m: member1){
        if(id.equals(m.getID())){
            throw new ContainerException(id);
        }
    }
    member1.add(member);
}
public String deleteMember(Integer id) {
    if (id == null) {
        return "ID darf nicht null sein";
    }
    for (int i=0; i<member1.size(); i++){
        if (id.equals(member1.get(i).getID())){
            member1.remove(i);
            return "Member (ID ="+ id+ ") gelöscht";
        }
    }
    return "kein member mit ID " + id+ "vorhanden!";
}
public void dump(){
    if (member1.isEmpty()){
        System.out.println("Kein Member vorhanden");
        return;
    }
    for (Member m: member1){
        System.out.println("Member(ID"+ m.getID()+")");
    }
}
public int size(){

    return member1.size();
}
}


