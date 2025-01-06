// Base class
class Account {
    protected int accountNumber;
    protected double balance;

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance!");
        }
    }

    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber + ", Balance: " + balance);
    }
}

// Derived class: SavingsAccount
class SavingsAccount extends Account {
    private double interestRate; // In percentage

    public SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void calculateInterest() {
        double interest = (balance * interestRate) / 100;
        System.out.println("Interest on balance: " + interest);
    }

    @Override
    public void displayBalance() {
        System.out.println("[Savings Account]");
        super.displayBalance();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Derived class: CurrentAccount
class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(int accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount >= -overdraftLimit)) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Withdrawal exceeds overdraft limit!");
        }
    }

    @Override
    public void displayBalance() {
        System.out.println("[Current Account]");
        super.displayBalance();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

// Main class to test the banking system
public class BankingSystem {
    public static void main(String[] args) {
        // Create accounts
        SavingsAccount savings = new SavingsAccount(101, 5000.0, 3.5); // account number, balance, interest rate
        CurrentAccount current = new CurrentAccount(102, 2000.0, 1000.0); // account number, balance, overdraft limit

        // Display initial balances
        savings.displayBalance();
        current.displayBalance();

        System.out.println("\n-- Transactions on Savings Account --");
        savings.deposit(1000);
        savings.withdraw(2000);
        savings.calculateInterest();
        savings.displayBalance();

        System.out.println("\n-- Transactions on Current Account --");
        current.deposit(500);
        current.withdraw(3000);
        current.withdraw(4000); // Attempt to exceed overdraft
        current.displayBalance();
    }
}

