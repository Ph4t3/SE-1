package org.hbrs.se1.ws25.exercises.uebung3.Aufgabe_2.control;

import org.hbrs.se1.ws25.exercises.uebung3.Aufgabe_2.persistence.PersistenceException;
import org.hbrs.se1.ws25.exercises.uebung3.Aufgabe_2.persistence.PersistenceStrategy;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private List<Member> liste = new ArrayList<>();
    private static Container cont = null;
    private PersistenceStrategy<Member> strategy;
    public Container() {}

    public static Container getIt(){
        if (cont == null){
            cont = new Container();
        }
        return cont;
    }
    public List<Member> member1 = new ArrayList<>();

public void addMember(Member m) throws ContainerException {
    if (contains(m)) {
        throw new ContainerException(m.getID().toString());
    }
    liste.add(m);
}

private boolean contains(Member member) {
    return liste.stream().anyMatch(m -> member.getID().equals(member.getID()));
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
public List<Member> getCurrentList(){
    return liste;
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

    return cont.size();
}
public void store() throws PersistenceException {
    if (strategy == null) {
        throw new PersistenceException("No persistence strategy set");
    }
   strategy.save(liste);
}
public void load() throws PersistenceException {
    if (strategy == null) {
        throw new PersistenceException("No persistence strategy set");
    }
    liste = strategy.load();
    }
 public void setPersistenceStrategy(PersistenceStrategy<Member> strategy) {
    this.strategy = strategy;
 }
 private Member getMember(Integer id){
    return liste.stream().filter(m->m.getID().equals(id)).findFirst().orElse(null);
 }
}



