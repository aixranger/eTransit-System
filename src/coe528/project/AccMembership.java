package coe528.project;

import java.util.ArrayList;

/**
 * OVERVIEW: This class could create 3 different kinds of account memberships
 * for the Transit System (eSystem). The accounts that the following class is
 * capable of creating are as follows, Transit Officer(admin), adult membership
 * account and student adult membership. This class is a mutable class.
 * 
 * 
 * Represent Invariant: Null!
 * Abstract Function: Null!
 */

public class AccMembership {

    protected String name;
    protected String pass;
    public AccMembership currAccMembership;
    protected int accType;
    /**
     * MODIFIES: creates a new ArrayList for eSystem
     */ 
    ArrayList<AccMembership> eSystem = new ArrayList<AccMembership>();

    public static final String A1 = "Transit Officer";
    public static final String A2 = "Adult Account";
    public static final String A3 = "Student Account";

   public AccMembership(String Name, String Pass, int AccMembershipType) {
        /**
         * MODIFIES: assigns the object to the value for all the instance variables
         */
        
        this.name = Name;
        this.pass = Pass;
        this.accType = AccMembershipType;
        eSystem.add(this);
    }
    public String getAccMembershipType(String Name) {
       /**
        * MODIFIES: assigns the object to the value (c = searchAccMembership(Name))
        * EFFECTS: returns the type of the account
        */ 
        int c;
        c = searchAccMembership(Name);
        if (c != 748) {
            return TypeAccMembership(eSystem.get(c).accType);
        } else {
            System.out.println("AccMembership Type Error! Please enter a valid name");
            throw new UnsupportedOperationException();
        } 
    }

    public int searchAccMembership(String Name) {
        /**
         * MODIFIES: assigns the object to the value (temp = eSystem.get(x).name)
         */
        int x = 0;
        String temp;
        for (x = 0; x < (eSystem.size()); x++) {
            temp = eSystem.get(x).name;
            if (Name.equalsIgnoreCase(temp)) {
                return x;
            }
        }
        System.out.println("Cannot find the account:" + Name);
        throw new UnsupportedOperationException();
    }

    public String TypeAccMembership(int i) {
        /**
         * EFFECTS: returns the type of the account
         */
        
        if (eSystem.get(i).accType == 1) {
            return A1;
        }
        if (eSystem.get(i).accType == 2) {
            return A2;
        }
        if (eSystem.get(i).accType == 3) {
            return A3;
        }
        throw new UnsupportedOperationException();
    }

    public boolean login(String Name, String Pass) {
        /** 
         * EFFECTS: returns true if login is successful
         * REQUIRED: the password has to be correct
         * MODIFIES: assigns the object to the value (int y = searchAccMembership(Name))
         */

        int y = searchAccMembership(Name);
        String temp = eSystem.get(y).pass;
        if (Pass.equals(temp)) {
            System.out.println("Successfully logged in");
            currAccMembership = eSystem.get(y);
            return true;
        } else {
            System.out.println("Failed to login");
            return false;
        } 
    }

    public void logout() {
        /**
         * MODIFIES: assigns the object to the value (currAccMembership = null)
         */
        currAccMembership = null;
        System.out.append("Successfully logged out ");
        throw new UnsupportedOperationException(); 
    }
}
