package org.hbrs.se1.ws25.demo.vererbung;

/**
 * The BaseClass is a simple Java class that defines three methods with different access modifiers.
 * This class serves as a base class that can be extended by other classes, providing a foundation
 * with these three methods that can be overridden or used as-is.
 *
 * The stronger (more restrictive) one is what ultimately limits access. If the class is declared as pakage-private,
 * then even public methods within that class cannot be accessed from outside the package.
 *
 */
public class BaseClass {

    /**
     * The readSomething method is declared as public, meaning it can be accessed from any other class.
     */
    public void readSomething() {}

    /**
     * The writeSomething method is protected, so it can only be accessed within the same package or by subclasses.
     */
    protected void writeSomething() {}

    /**
     * The doSomething method has package-private access (default access modifier), which restricts its visibility
     * to other classes within the same package.
     */
    void doSomething() {}
}
