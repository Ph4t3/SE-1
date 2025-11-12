package org.hbrs.se1.ws25.exercises.uebung4.prototype;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserStoryView {
    public void startAusgabe(List<UserStory> liste, String suchParameter) {
        Collections.sort(liste);
        List<UserStory> rListe = liste.stream().filter(story -> story
                .getProject().equals(suchParameter)).filter(UserStory -> UserStory.getPrio() >= 3).collect(Collectors.toList());
        for (UserStory story : rListe) {
            System.out.println(story.toString());
        }
    }

}
