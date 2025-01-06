import java.util.*;

// Part A: Defining the Superclass
class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Calendar dateCreated;

    // No-arg constructor
    public Account() {
        this.id = 0;
        this.balance = 0.0;
        this.annualInterestRate = 0.0;
        this.dateCreated = Calendar.getInstance();
    }

    // Parameterized constructor
    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = Calendar.getInstance();
    }

    // Accessor and mutator methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Calendar getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12 / 100;
    }

    public double getMonthlyInterestAmount() {
        return balance * getMonthlyInterestRate();
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

