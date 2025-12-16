package org.hbrs.se1.ws25.demo.kapitel6.chatty;

/**
 * Ist dieses Interface ein gesprächiges Interface (Chatty interface)?
 * Verbesserung?
 */
public interface CustomerController {

    public Customer getCustomer ( int customerID );

    public int[] getAddressIDsOfCustomer( int customerID );

    public Address getSingleAddress(  int addressID );

    public BankDetail[] getBankDetails (  int customerID  );

    public void updateAddress( int customerID, int addressID , int plz, String city, String street );

}
