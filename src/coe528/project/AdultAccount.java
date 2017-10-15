package coe528.project;

/**
 * OVERVIEW: This class represents the Adult Account. This class includes,
 * depositing money in the adult account. The adult can also use this class to
 * pay for the transit rides through the method, AdultPayment(). In addition,
 * the adult can also check his/her balance according to the deposits made over
 * a time period. This class is an immutable class.
 * 
 * 
 * AF(c) = {c|c!= AdultAccount if c.AdultAccBalance<100}
 * Represent Invariant: c processes solely based on the AdultAccBalance 
 */
public class AdultAccount extends AccMembership {

    protected int checkBalance;

    public AdultAccount(String Name, String Password, int AccMembershipType, int AdultAccBalance) {
        super(Name, Password, AccMembershipType);
        try {
            if (AdultAccBalance >= 100) {
                this.checkBalance = AdultAccBalance;
                this.accType = 2;
            } else {
                this.checkBalance = 1 / 0;
            }
        } catch (ArithmeticException e) {
            System.err.println("Adult account balance should be greater than $100!");
        }
    }

    public int getAdultAccBalance() {
        /** 
         * EFFECTS: returns the value
         */
     
        return AdultAccount.this.getAdultAccBalance();
    }

    public void AdultDeposit(int Value) {
        System.out.println("Adult account balance is:");
        System.out.println(AdultAccount.this.getAdultAccBalance());
        AdultAccount.this.checkBalance += Value;
        System.out.println("Balance after deposit is:");
        System.out.println(AdultAccount.this.getAdultAccBalance());
    }

    public void AdultPayment(int Value) {
        System.out.println("Adult account balance is:");
        System.out.println(AdultAccount.this.getAdultAccBalance());

        int tmp = AdultAccount.this.checkBalance - Value;
        if (tmp >= 0) {
            AdultAccount.this.checkBalance = tmp;
        } else {
            System.err.println("Not enough credit in Adult Account!");
        }
        System.out.println("Balance after payment is:");
        System.out.println(AdultAccount.this.getAdultAccBalance());
    }

    public static boolean positiveCheck(int money) {
        /**
         * REQUIRED: variable money to be greater then zero
         * EFFECTS: return false if incorrect
         */
        
        if (money > 0) {
            return true;
        }
        return false;
    }

}
