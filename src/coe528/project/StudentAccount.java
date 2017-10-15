package coe528.project;

/**
 * OVERVIEW: This class represents the Student Account. This class includes,
 * depositing money in the wallet and in the student account. The student can
 * also use this class to pay for the transit rides through the method,
 * StudentPayment(). In addition, the student can also transfer money from the
 * wallet to the student account incase of an emergency. This class is an
 * immutable class.
 * 
 * 
 * AF(c) = {c|c!= StudentAccount if c.StudentAccBalance<50 && c.WalletBalance<100}
 * Represent Invariant: c only performs based on the StudentAccBalance and WalletBalance
 * 
 */
public class StudentAccount extends AccMembership {

    protected int walletBalance;
    protected int checkBalance;

    public StudentAccount(String Name, String Pass, int AccType, int StudentAccBalance, int WalletBalance) {
        /**
         * MODIFIES: assigns the object to the value
         * EFFECTS: returns the statement if the condition fails
        */
        super(Name, Pass, AccType);

        try {
            if (StudentAccBalance >= 50 && WalletBalance >= 100) {
                this.checkBalance = StudentAccBalance;
                this.walletBalance = WalletBalance;
                this.accType = 3;
            } else {
                this.checkBalance = 1 / 0;
            }
        } catch (ArithmeticException e) {
            System.err.println("StudentAccBalance should be more than 50 and WalletBalance should be more than 100");
        }
    }

    public int getWalletBalance() {
        return StudentAccount.this.walletBalance;
    }

    public int getCheckBalance() {
        return StudentAccount.this.checkBalance;
    }

    public void walletDeposit(int Value) {
        /** 
         * EFFECTS: returns the statements
         * MODIFIES: increments the wallet value
        */
        System.out.println("Wallet Balance is:");
        System.out.println(StudentAccount.this.getWalletBalance());
        StudentAccount.this.walletBalance += Value;
        System.out.println("Balance After Deposit is:");
        System.out.println(StudentAccount.this.getWalletBalance());
    }

    public void studentDeposit(int Value) {
        /**
         * EFFECTS: returns the statements
         * MODIFIES: increments the value of the StudentDeposit
        */
        System.out.println("Student Account Balance is:");
        System.out.println(StudentAccount.this.getCheckBalance());
        StudentAccount.this.checkBalance += Value;
        System.out.println("Balance After Deposit is:");
        System.out.println(StudentAccount.this.getCheckBalance());
    }

    public void walletPayment(int Value) {
        System.out.println("Wallet Balance is:");
        System.out.println(StudentAccount.this.getWalletBalance());

        int tmp = StudentAccount.this.walletBalance - Value;
        if (positiveCheck(tmp)) {
            StudentAccount.this.walletBalance = tmp;
        } else {
            System.err.println("Not enough funds in the Wallet!");
        }

        System.out.println("Balance after payment is:");
        System.out.println(StudentAccount.this.getWalletBalance());
    }

    public void studentPayment(int Value) {
        System.out.println("Student Account Balance is:");
        System.out.println(StudentAccount.this.getCheckBalance());

        int tmp = StudentAccount.this.checkBalance - Value;

        if (positiveCheck(tmp)) {
            StudentAccount.this.checkBalance = tmp;
        } else {
            System.err.println("Not enough funds in the Student Account!");
        }

        System.out.println("Balance after payment is:");
        System.out.println(StudentAccount.this.getCheckBalance());
    }

    public void WalletToStudent(int Value) {
        System.out.println("Student Account balance is:");
        System.out.println(StudentAccount.this.getCheckBalance());
        System.out.println("Wallet balance is:");
        System.out.println(StudentAccount.this.getWalletBalance());

        int tmp = StudentAccount.this.checkBalance - Value;
        if (positiveCheck(tmp)) {
            StudentAccount.this.walletBalance = tmp;
            StudentAccount.this.checkBalance += Value;
        } else {
            System.err.println("Not enough funds in the Wallet!");
        }

        System.out.println("Balance after payment from Student Account is:");
        System.out.println(StudentAccount.this.getCheckBalance());
        System.out.println("Balance after paymemt from Wallet is:");
        System.out.println(StudentAccount.this.getWalletBalance());
    }

    public static boolean positiveCheck(int i) {
         /**
         * REQUIRED: variable i to be greater them zero
         * EFFECTS: return true if correct
         * EFFECTS: return false if incorrect
        */
        return i > 0;
    }
}
