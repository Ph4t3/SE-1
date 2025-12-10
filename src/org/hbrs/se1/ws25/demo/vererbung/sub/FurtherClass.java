package org.hbrs.se1.ws25.demo.vererbung.sub;
import org.hbrs.se1.ws25.demo.vererbung.ExtendedClass;

public class FurtherClass {

    public void aMethod() {
        ExtendedClass extendedClass = new ExtendedClass();
        extendedClass.readSomething();
        extendedClass.singlemethod();
        // extendedClass.writeSomething(); -- not possible since protected
        // extendedClass.doSomething(); -- not possible since package-private
    }

    public static void main(String[] args) {

    }
}
