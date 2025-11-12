package org.hbrs.se1.ws25.exercises.uebung4.Aufgabe_2.control;


import org.hbrs.se1.ws25.exercises.uebung4.Aufgabe_2.view.UserStoryView;

import java.util.Scanner;

public class InputDialog {
    private Container container = Container.getInstance();

    public InputDialog(){}
     public void startEingabe() throws ContainerException, Exception{
        String strInput = null;
        Scanner scanner = new Scanner(System.in);
         System.out.println("UserStory-Tool");
         System.out.println(">");
         while(true){
             strInput = scanner.nextLine();
             String[] strings = strInput.split(" ");
             if (strings[0].equals("help")){
                 System.out.println("Folgende Befehle, die zur Verfuegung stehen: help, dump, enter, store, exit");
             }
             String suchParameter= null;
             if (strings[0].equals("dump")){
                 try {
                     suchParameter = strings[1];
                 }catch (ArrayIndexOutOfBoundsException e){}
                 UserStoryView view = new UserStoryView();
                 view.startAusgabe(this.container.getCurrentList(), suchParameter);
             }
             if (strings[0].equals("enter")){
                 System.out.println("Korrekte Daten eingeben, zur Erstellung einer UserStory");
                 System.out.println("Reihenfolge: Titel, Aufwand, id, Mehrwert, Risiko, Prioritaet, Project");
                 UserStory us;

                 String titel = scanner.nextLine();
                 int aufwand = scanner.nextInt();
                 int id = scanner.nextInt();
                 int mehrwert = scanner.nextInt();
                 String description = scanner.nextLine();
                 int risiko = scanner.nextInt();
                 double prioritaet= scanner.nextDouble();
                 String project= scanner.nextLine();
                 int strafe = scanner.nextInt();

                 us = new UserStory(id,titel,description,project,mehrwert,risiko,aufwand,strafe);
                 us.setTitel(titel);
                 us.setAufwand(aufwand);
                 us.setId(id);
                 us.setRisk(risiko);
                 us.setProject(project);
                 us.setStrafe(strafe);
                 this.container.addUserStory(us);
             }
             if (strings[0].equals("store")){
                 this.container.store();
             }
             if (strings[0].equals("load")){
                 this.container.load();
             }
             if (strings[0].equals("exit")){
                 break;
             }
         }scanner.close();
     }
}
