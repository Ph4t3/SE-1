package org.hbrs.se1.ws25.exercises.uebung4.Aufgabe_2.control;

import java.io.Serializable;

public class UserStory implements Comparable<UserStory> , Serializable {
        // ToDo: Sind die Attribute der Klasse UserStory vollständig? Wie sieht es mit den
        //  Sichtbarkeiten aus? (F4)

        String titel;
        int id = 0;
        double prio = 0.0;
        String project;
        String title;
        String description;
        int value;
        int effort;
        int risk;
        int strafe;



    public String getProject() {
            return project;
        }

        public void setProject(String project) {
            this.project = project;
        }

    public UserStory(int id, String titel, String desc, String projeckt, int value, int effort, int risk, int strafe) {

            this.id = id;
            this.titel = titel;
            this.prio = prio;
            this.project = projeckt;
            this.title = titel;
            this.description = desc;
            this.value = value;
            this.effort = effort;
            this.risk = risk;
            this.strafe = strafe;

        }

        public UserStory() {
        }

        public double getPrio() {
            return prio;
        }

        public void setPrio(double prio) {
            this.prio = prio;
        }

        public String getTitel() {
            return titel;
        }

        public void setTitel(String titel) {
            this.titel = titel;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAufwand(){
        return effort;
        }
        public void setAufwand(int effort){
        this.effort = effort;
        }
        public int getRisk() {
        return risk;
        }
        public void setRisk(int risk) {
        this.risk = risk;
        }
        public int getStrafe(){
        return strafe;
        }
    public void setStrafe(int strafe){
        this.strafe = strafe;
    }

        //methode zum vergleich zweier stories
    public int compareTo(UserStory us) {
            if (us.getPrio() == this.getPrio()) {
                return 0;
            } if (us.getPrio() > this.getPrio()) {
                return 1;
        }else return -1;
    }
    @Override
    public String toString(){
            return "UserStory{"+
                    "Titel= "+ titel +'\''+
                    ", Aufwand= "+ effort+
                    ", id= "+ id+
                    ", Mebrwert= "+ value+
                    ", Risiko="+ risk+
                    ", Priority= "+ prio+
                    ", Project="+ project+'\''+"}";
    }
    }




