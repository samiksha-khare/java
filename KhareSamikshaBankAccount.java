import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This Java program is to manage the basic bank account functionalities of a customer.
 */
public class KhareSamikshaBankAccount {
    // Private data fields
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private double annualInterestRate;

    // Parameterized constructor to initialize data fields
    KhareSamikshaBankAccount(String accountNumber, String accountHolderName, double balance, double annualInterestRate){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    // Method to deposit amount into the account
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Amount deposited successfully. New Balance: $" + this.balance);
    }

    // Method to withdraw amount from the account
    public void withdraw(double amount) {
        if (amount <= balance) {
            this.balance -= amount;
            System.out.println("Amount withdrawal successfully. Remaining Balance: $" + this.balance);
        }
        else {
            System.out.println("Insufficient funds!");
        }
    }

    // Method to calculate interest based on annual interest rate
    public void calculateInterest(double annualInterestRate) {
        double interest = (this.balance * annualInterestRate) / 100;
        this.balance += interest;
        System.out.println("Interest added. New Balance: $" + this.balance);
    }

    // Method to check the current balance
    public void checkBalance() {
        System.out.println("Current Balance: $" + this.balance);
    }

    // Method to display all details of the account
    public void displayAccountDetails() {
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Holder Name: " + this.accountHolderName);
        System.out.println("Balance: $" + this.balance);
        System.out.println("Annual Interest Rate: " + this.annualInterestRate+"%");

    }

    // main method
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        // Input account number from the user
        System.out.println("Enter account number:");
        String accountNo = scan.nextLine();

        // Input account holder's name from the user
        System.out.println("Enter account holder's name:");
        String accHolderName = scan.nextLine();

        // Input initial balance, handle exceptions
        double initialBalance;
        while (true) {
            try {
                System.out.println("Enter initial balance:");
                initialBalance = scan.nextDouble();

                // Throw exception if initial balance amount is less then zero
                if (initialBalance < 0) {
                    throw new Exception("Please enter valid amount!");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                scan.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scan.nextLine();
            }
        }

        // Input annual interest rate, handle exceptions
        double annualRate;
        while (true) {
            try {
                System.out.println("Enter annual interest rate:");
                annualRate = scan.nextDouble();

                // Throw exception if annual rate is less then zero
                if (annualRate < 0) {
                    throw new Exception("Please enter valid interest rate!");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                scan.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scan.nextLine();
            }
        }

        // Create a bank account object
        KhareSamikshaBankAccount bankAcc = new KhareSamikshaBankAccount(accountNo, accHolderName, initialBalance, annualRate);

        int operation = 0;
        do {
            System.out.println("Choose an operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Calculate Interest");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Exit");

            try {
                operation = scan.nextInt();

                switch (operation) {
                    case 1:
                        System.out.println("Enter deposit amount:");
                        double depositAmt = scan.nextDouble();

                        // Throw exception if deposit amount is less then zero
                        if (depositAmt < 0) {
                            throw new Exception("Please enter valid amount!");
                        }
                        bankAcc.deposit(depositAmt);
                        break;

                    case 2:
                        System.out.println("Enter withdrawal amount:");
                        double withdrawalAmt = scan.nextDouble();

                        // Throw exception if withdrawal amount is less then zero
                        if (withdrawalAmt < 0) {
                            throw new Exception("Please enter valid amount!");
                        }
                        bankAcc.withdraw(withdrawalAmt);
                        break;

                    case 3:
                        bankAcc.calculateInterest(annualRate);
                        break;

                    case 4:
                        bankAcc.checkBalance();
                        break;

                    case 5:
                        bankAcc.displayAccountDetails();
                        break;

                    case 6:
                        System.out.println("Exiting Program.");
                        break;

                    default:
                        System.out.println("Please choose a valid operation!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!");
                scan.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scan.nextLine();
            }

        } while (operation != 6);
        scan.close();
    }
}
