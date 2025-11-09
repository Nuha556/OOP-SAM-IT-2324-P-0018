
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount not valid! Please enter a value greater than zero.");
        } else {
            balance += amount;
            System.out.println("Rs. " + amount + " has been successfully deposited to your account.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid entry! Please enter a positive amount.");
        } else if (amount > balance) {
            System.out.println("Sorry, not enough funds! Your available balance is Rs. " + balance);
        } else {
            balance -= amount;
            System.out.println("You have withdrawn Rs. " + amount + " successfully.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void showAccountInfo() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Available Balance: Rs. " + balance);
    }
}

public class BankAss {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your account number: ");
        String accNo = input.nextLine();

        BankAccount account = new BankAccount(accNo);

        int choice;
        do {
            System.out.println("\n==== Welcome to Smart Bank ====");
            System.out.println("1. Deposit Funds");
            System.out.println("2. Withdraw Funds");
            System.out.println("3. View Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: Rs. ");
                    double depositAmount = input.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter the amount to withdraw: Rs. ");
                    double withdrawAmount = input.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.println("Your balance is currently: Rs. " + account.getBalance());
                    break;

                case 4:
                    account.showAccountInfo();
                    break;

                case 5:
                    System.out.println("We appreciate your banking with us. Have a great day!");
                    break;

                default:
                    System.out.println("Option not recognized! Please choose again.");
            }
        } while (choice != 5);

        input.close();
    }
}

