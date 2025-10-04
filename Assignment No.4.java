package atm;

import java.util.Scanner;

public class simpleATM {
    private int acc_no;
    private int pin;
    private double balance;
    static int acc_cnt = 0;

    int getAccountNo() {
        return acc_no;
    }

    void checkbalance() {
        System.out.println("Balance is " + balance);
    }

    simpleATM(int pin, double balance) {
        acc_cnt++;
        acc_no = acc_cnt;  // Assign unique account number
        this.pin = pin;
        this.balance = balance;
    }

    void deposite(double ammount) {
        if (ammount < 0) {
            throw new IllegalArgumentException("amount should be positive");
        }
        balance += ammount;
        System.out.println("Amount deposited successfully.");
    }

    void withdraw(int pin, double ammount) {
        if (this.pin == pin) {
            if (ammount < 0) {
                throw new IllegalArgumentException("amount should be positive");
            }
            if (ammount > balance) {
                throw new IllegalArgumentException("Insufficient balance");
            }
            balance -= ammount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Incorrect PIN.");
        }
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        simpleATM account[] = new simpleATM[3];
        int pin;
        double balance;
        int choice;
        boolean exit = false;

        // Create 3 accounts
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter pin code and initial balance for account " + (i + 1) + ":");
            pin = s.nextInt();
            balance = s.nextDouble();
            account[i] = new simpleATM(pin, balance);
            System.out.println("Account created with account number: " + account[i].getAccountNo());
        }

        // Let user choose which account to operate on
        System.out.println("\nEnter account number to access (1-3):");
        int accNo = s.nextInt();
        if (accNo < 1 || accNo > 3) {
            System.out.println("Invalid account number. Exiting.");
            s.close();
            return;
        }

        simpleATM currentAccount = account[accNo - 1];

        while (!exit) {
            System.out.println("\nMenu");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = s.nextDouble();
                    try {
                        currentAccount.deposite(depositAmount);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Enter your PIN:");
                    int enteredPin = s.nextInt();
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = s.nextDouble();
                    try {
                        currentAccount.withdraw(enteredPin, withdrawAmount);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    currentAccount.checkbalance();
                    break;

                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        s.close();
    }
}
