package org.hbrs.se1.ws25.exercises.uebung3.Aufgabe_2.control;

import org.hbrs.se1.ws25.exercises.uebung3.Aufgabe_2.view.MemberView;

public class Client {
    public static void main(String[] args) {
       Member member1 = new ConcreteMember(1,"loo");
       Member member2 = new ConcreteMember(2,"lee");
       Container container = Container.getIt();

       try{
           container.addMember(member1);
           container.addMember(member2);
       }catch (ContainerException e){
           System.out.println(e.getMessage());
       }
       MemberView memberView = new MemberView();
       memberView.dump(container.getCurrentList());
    }
}
