package org.hbrs.se1.ws25.exercises.uebung4.prototype.commandpattern;

public interface Command {
    public void execute(); // ggf. weitere Paramter
    public void undo();
}
