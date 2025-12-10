package org.hbrs.se1.ws25.demo.vererbung.reise;

public abstract class Reise {
    public abstract void setzeZiel( String ziel );
    public String getInfo() {
        return new String("A first info");
    }
}
