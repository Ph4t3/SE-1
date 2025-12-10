package org.hbrs.se1.ws25.demo.vererbung.sub;

import org.hbrs.se1.ws25.demo.vererbung.BaseClass;

public class FurtherSubClass extends BaseClass {

    public void aMethod() {
        this.readSomething();
        this.writeSomething(); // is possible, since writeSomething is protected
    }

    @Override
    public void readSomething() { // possible, since readSomething is public
    }

    @Override
    public void writeSomething() { // possible, since writeSomething is protected
    }

    // @Override
    // public void doSomething() {} - not possible, since doSomething is package-private
}
