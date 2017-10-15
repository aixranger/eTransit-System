package coe528.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * OVERVIEW: This class is the main class and it allows the user to access the
 * operations provided to the user depending on the user's requirements. The
 * operations are different as per the account type (Adult or student). This
 * class is a mutable class.
 */
public class eTransit {

    private static String com1;
    private static int comInt;
    private static AccMembership User;
    protected static ArrayList<AccMembership> ABC = new ArrayList<AccMembership>();

    private static int[] array = new int[5000];

    private static void displayOperation() {
        /**
         * EFFECTS: it will display statements below
         *
         */

        
        
        
        System.out.println(" ");
        System.out.println("You have the following operations: ");
        if (User.accType == 1) {
            System.out.println("*****************************");
            System.out.println("(1) CreateAdultAccount");
            System.out.println("(2) CreateStudentAccount");
            System.out.println("(3) DeleteCustomer");
            System.out.println("Logout");
            System.out.println("*****************************");
        }

        if (User.accType == 2) {
            System.out.println("*****************************");
            System.out.println("(1) DepositToAdultAccount");
            System.out.println("(2) TicketPurchase");
            System.out.println("(3) CheckBalance");
            System.out.println("Logout");
            System.out.println("*****************************");
        }

        if (User.accType == 3) {
            System.out.println("*****************************");
            System.out.println("(1) DepositToStudentAccount");
            System.out.println("(2) DepositToWallet");
            System.out.println("(3) WalletToStudentAccount");
            System.out.println("(4) StudentPayment");
            System.out.println("(5) WalletPayment");
            System.out.println("(6) CheckBalance");
            System.out.println("Logout");

            System.out.println("*****************************");
        }
        System.out.println(" ");
        System.out.print("Enter Command: ");

    }

    private static String userInput() {
        /**
         * EFFECTS: the user will input the text as a String
         */
        Scanner user_input = new Scanner(System.in);
        com1 = user_input.next();
        return com1;
    }

    private static int userInputInt() {
        /**
         * EFFECTS: the user will input the text as an integer
         */
        Scanner user_input = new Scanner(System.in);
        comInt = user_input.nextInt();
        return comInt;
    }

    private static void logout() {
        /**
         * EFFECTS: displays the statement and logout
         */

        System.out.println("Bye " + User.name);
        User = null;
    }

    protected static boolean LoginAuth(String temp1, String temp2) {
        /**
         * MODIFIES: assigns the variable to a value
         */
        int i = searchAccount(temp1);
        if (i != -1) {
            if (temp2.equalsIgnoreCase(ABC.get(i).pass)) {
                return true;
            }
        }
        return false;
    }

    private static int searchAccount(String Name) {
        /**
         * MODIFIES: assigns the variables to a value
         */
        int i = 0;
        String temp;
        for (i = 0; i < (ABC.size()); i++) {
            temp = ABC.get(i).name;
            if (Name.equalsIgnoreCase(temp)) {
                return i;
            }
        }
        System.err.println("Can not find account with name: " + Name);
        return -1;
    }

    public static void main(String[] args) {
        /**
         * EFFECTS: creates a new Transit Officer MODIFIES: assigns the variable
         * to a value
         */


        String temp1, temp2, temp10, temp20;
        int temp3, temp4, temp30, temp40;
        ABC.add(new TransitOfficer("eSystem", "login", 0));

        while (true) {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Transit App Menu:");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Enter Username:");
            temp1 = userInput();
            System.out.println("Enter Password :");
            temp2 = userInput();
            if (LoginAuth(temp1, temp2)) {
                User = ABC.get(searchAccount(temp1));
                if (User.accType == 1) {
                    managerOperation();
                }

                if (User.accType == 2) {
                    AdultOperation();
                }

                if (User.accType == 3) {
                    StudentOperation();
                }
            }
        }
    }

    private static void managerOperation() {
        String temp1, temp2, temp3;
        int temp01, temp02, temp03;

        System.out.println("\nHi! " + User.name);
        while (true) {
            displayOperation();
            com1 = userInput();
            if (com1.equalsIgnoreCase("logout")) {
                break;
            }
            if (com1.equalsIgnoreCase("1")) {
                temp1 = null;
                temp2 = null;
                temp01 = -1;
                System.out.println("Enter New Customer Name: ");
                temp1 = userInput();
                System.out.println("Enter New Password: ");
                temp2 = userInput();
                System.out.println("Enter Amount To Adult Account: ");
                temp01 = userInputInt();
                if ((temp1 != null) && (temp2 != null) && (temp01 > 1)) {
                    ABC.add(new AdultAccount(temp1, temp2, 1, temp01));
                    array[searchAccount(temp1)] = temp01;
                    System.out.println("Adult account created with the name: " + temp1);
                } else {

                    throw new IllegalArgumentException();
                }
            }

            if (com1.equalsIgnoreCase("2")) {
                temp1 = null;
                temp2 = null;
                temp01 = -1;
                System.out.println("Enter New Customer Name: ");
                temp1 = userInput();
                System.out.println("Enter New Password: ");
                temp2 = userInput();
                System.out.println("Enter Amount To Student Account: ");
                temp01 = userInputInt();
                System.out.println("Enter Amount To Wallet: ");
                temp02 = userInputInt();

                if ((temp1 != null) && (temp2 != null) && (temp01 > 1) && (temp02 > 1)) {
                    ABC.add(new StudentAccount(temp1, temp2, 2, temp01, temp02));
                    array[searchAccount(temp1)] = temp01;
                    array[searchAccount(temp1) * 10] = temp02;
                    System.out.println("Student account created with the name: " + temp1);
                } else {
                    throw new IllegalArgumentException();

                }
            }

            if (com1.equalsIgnoreCase("3")) {
                temp1 = null;
                temp01 = -1;
                System.out.println("Enter the username of the person's account: ");
                temp1 = userInput();
                temp01 = searchAccount(temp1);
                if (temp01 != -1) {
                    if (ABC.get(temp01).accType == 2) {
                        array[temp01 * 10] = 0;
                    }
                    ABC.remove(temp01);
                    array[temp01] = 0;
                    System.out.println("Account Removed! ");
                }
            }
        }
    }

    private static void AdultOperation() {
        /**
         * EFFECTS: displays statements MODIFIES: assigns this variable to a
         * value
         */
        String temp1, temp2, temp3;
        int temp01, temp02, temp03;
        System.out.println("Hi\t " + User.name);
        while (true) {
            displayOperation();
            com1 = userInput();
            if (com1.equalsIgnoreCase("logout")) {

                break;
            }
            if (com1.equalsIgnoreCase("1")) {
                temp01 = 0;
                System.out.println("Enter Amount: ");
                temp01 = userInputInt();
                if (temp01 > 0) {

                    array[searchAccount(User.name)] += temp01;
                } else {
                    throw new IllegalArgumentException();

                }
            }

            if (com1.equalsIgnoreCase("2")) {
                temp01 = 0;
                System.out.println("Enter Amount: ");
                System.out.println("Markham to Downtown = $10");
                System.out.println("Mississauga to Downtown = $15");
                System.out.println("Brampton to Downtown = $20");
                temp01 = userInputInt();
                if (temp01 == 10) {
                    array[searchAccount(User.name)] -= temp01;
                    System.out.println("Purchased bus ticket for Markham to Downtown");
                    System.out.println("Bus Deperature Time: 7:00am , 10:00am , 1:00pm , 4:00pm , 7:00pm ");
                    System.out.println("Please arrive to bus stop 5 min prior to departure time, Enjoy your ride!");
                } else if (temp01 == 15) {
                    array[searchAccount(User.name)] -= temp01;
                    System.out.println(" Purchased bus ticket for Mississauga to Downtown");
                    System.out.println("Bus Deperature Time: 6:00am , 90:00am , 12:00pm , 3:00pm , 6:00pm ");
                    System.out.println("Please arrive to bus stop 5 min prior to departure time, Enjoy your ride!");
                } else if (temp01 == 20) {
                    array[searchAccount(User.name)] -= temp01;
                    System.out.println("Purchased bus ticket for Brampton to Downtown");
                    System.out.println("Bus Deperature Time: 8:00am , 11:00am , 2:00pm , 5:00pm , 8:00pm ");
                    System.out.println("Please arrive to bus stop 5 min prior to departure time, Enjoy your ride!");

                } else {
                    throw new IllegalArgumentException();

                }
            }

            if (com1.equalsIgnoreCase("3")) {

                System.out.println(" ");
                System.out.println("Current Adult Account Balance: " + array[searchAccount(User.name)]);   //EFFECTS: displays statement
            }

        }
    }

    private static void StudentOperation() {
        String temp1, temp2, temp3;
        int temp01, temp02, temp03;
        System.out.println("Hey\t" + User.name);
        while (true) {
            displayOperation();
            com1 = userInput();
            if (com1.equalsIgnoreCase("logout")) {

                break;
            }
            if (com1.equalsIgnoreCase("1")) {
                temp01 = 0;
                System.out.println("Enter Amount: ");
                temp01 = userInputInt();
                if (temp01 > 0) {

                    array[searchAccount(User.name)] += temp01;

                } else {
                    throw new IllegalArgumentException();

                }
            }

            if (com1.equalsIgnoreCase("4")) {
                temp01 = 0;
                System.out.println("Enter Amount: ");
                System.out.println("Markham to Downtown = $10");
                System.out.println("Mississauga to Downtown = $15");
                System.out.println("Brampton to Downtown = $20");
                temp01 = userInputInt();
                if (temp01 == 10) {
                    array[searchAccount(User.name)] -= temp01;
                    System.out.println("Purchased bus ticket for Markham to Downtown");
                    System.out.println("Bus Deperature Time: 7:00am , 10:00am , 1:00pm , 4:00pm , 7:00pm ");
                    System.out.println("Please arrive to bus stop 5 mins prior to departure time, Enjoy your ride!");
                } else if (temp01 == 15) {
                    array[searchAccount(User.name)] -= temp01;
                    System.out.println(" Purchased bus ticket for Mississauga to Downtown");
                    System.out.println("Bus Deperature Time: 6:00am , 9:00am , 12:00pm , 3:00pm , 6:00pm ");
                    System.out.println("Please arrive to bus stop 5 mins prior to departure time, Enjoy your ride!");
                } else if (temp01 == 20) {
                    array[searchAccount(User.name)] -= temp01;
                    System.out.println("Purchased bus ticket for Brampton to Downtown");
                    System.out.println("Bus Deperature Time: 8:00am , 11:00am , 2:00pm , 5:00pm , 8:00pm ");
                    System.out.println("Please arrive to bus stop 5 mins prior to departure time, Enjoy your ride!");

                } else {
                    throw new IllegalArgumentException();
                }
            }

            if (com1.equalsIgnoreCase("5")) {
                temp02 = 0;
                System.out.println("Enter Amount: ");
                System.out.println("Meal Package = $20");
                System.out.println("\t(Beverage,Entree,Appetizer)");
                System.out.println("Comfort Package = $70");
                System.out.println("\t(Pillow,Headphones,Wifi) ");
                temp02 = userInputInt();
                if (temp02 == 20) {

                    array[searchAccount(User.name) * 10] -= temp02;
                    System.out.println("(Purchased Meal Package, Enjoy your meal! ");

                } else if (temp02 == 70) {

                    array[searchAccount(User.name) * 10] -= temp02;
                    System.out.println("Purchased Comfort Package, Enjoy your trip! ");

                } else {
                    throw new IllegalArgumentException();
                }

            }

            if (com1.equalsIgnoreCase("6")) {

                System.out.println(" ");
                System.out.println("Current Student Account Balance: " + array[searchAccount(User.name)]);
                System.out.println("Current Wallet Balance: " + array[searchAccount(User.name) * 10]);
            }

            if (com1.equalsIgnoreCase("2")) {
                temp01 = 0;
                System.out.println("Enter Amount: ");
                temp01 = userInputInt();
                if (temp01 > 0) {

                    array[searchAccount(User.name) * 10] += temp01;
                } else {
                    throw new IllegalArgumentException();
                }
            }

            if (com1.equalsIgnoreCase("3")) {
                temp01 = 0;
                System.out.println("Enter Amount: ");
                temp01 = userInputInt();
                if (temp01 > 0) {

                    array[searchAccount(User.name)] += temp01;
                    array[searchAccount(User.name) * 10] -= temp01;
                } else {
                    throw new IllegalArgumentException();
                }
            }

        }
    }

    public static String logout(String logout) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
