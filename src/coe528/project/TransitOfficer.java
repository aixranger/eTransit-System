package coe528.project;

import java.util.Scanner;

/**
 * OVERVIEW: This class represents the Transit Officer who creates and deletes
 * customers' accounts. It can either create a student account or an adult
 * account for the customer. This class is an immutable class.
 * 
 * 
 * Represent Invariant : Null!
 * Abstract Function: Null!
 */


public class TransitOfficer extends AccMembership {


    public TransitOfficer(String Name, String Pass, int AccMembershipType) {
        /**
         * MODIFIES: assigns the object to the value
         */
        super(Name, Pass, AccMembershipType);
        this.name = "eSystem";
        this.pass = "login";
        this.accType = 1;
    }

    public void createCustomer(String Name1, String Password1, int AdultAccBalance1) {
        /**
         * EFFECTS: creates an Adult Account for the customer
         */
        eSystem.add(new AdultAccount(Name1, Password1, 1, AdultAccBalance1));
    }

    public void createCustomer(String Name2, String Password2, int StudentAccountBalance, int Wallet) {
        /**
         * EFFECTS: creates an Student Account for the customer
         */
        eSystem.add(new StudentAccount(Name2, Password2, 2, StudentAccountBalance, Wallet));
    }

    public void deleteCustomer(String Name) {
        /** 
         * EFFECTS: removes the customer
         */
        
        int i = searchAccMembership(Name);
        eSystem.remove(i);
    }

    public void checkCustomer(String Name) {
        int i = searchAccMembership(Name);
        System.out.println(eSystem.get(i));
    }

}
