import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;


    public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            System.out.println("Press (1) for creating a Checking Account");
            System.out.println("Press (2) for creating a Savings Account");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter ID, Balance, Annual Interest Rate, and Overdraft Limit:");
                int id = scanner.nextInt();
                double balance = scanner.nextDouble();
                double annualInterestRate = scanner.nextDouble();
                double overdraftLimit = scanner.nextDouble();
                accounts.add(new CheckingAccount(id, balance, annualInterestRate, overdraftLimit));
            } else if (choice == 2) {
                System.out.println("Enter ID, Balance, Annual Interest Rate, Credit Card Number, and Expiry Date (yyyy-MM-dd):");
                int id = scanner.nextInt();
                double balance = scanner.nextDouble();
                double annualInterestRate = scanner.nextDouble();
                String creditCardNumber = scanner.next();
                String dateStr = scanner.next();
                Calendar expiryDate = Calendar.getInstance();
                try {
                    expiryDate.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dateStr));
                } catch (Exception e) {
                    System.out.println("Invalid date format.");
                }
                accounts.add(new SavingsAccount(id, balance, annualInterestRate, creditCardNumber, expiryDate));
            }
        }

        for (Account account : accounts) {
            account.deposit(1000);
            account.withdraw(500);

            if (account instanceof CheckingAccount) {
                CheckingAccount ca = (CheckingAccount) account;
                System.out.println("This is a Checking Account");
                System.out.println("Account ID: " + ca.getId());
                System.out.println("Date Created: " + ca.getDateCreated().getTime());
                System.out.println("Current Balance: " + ca.getBalance());
                System.out.println("Annual Interest Rate: " + ca.getAnnualInterestRate());
                System.out.println("Monthly Interest Amount: " + ca.getMonthlyInterestAmount());
                System.out.println("Overdraft Limit: " + ca.getOverdraftLimit());
            } else if (account instanceof SavingsAccount) {
                SavingsAccount sa = (SavingsAccount) account;
                System.out.println("This is a Savings Account");
                System.out.println("Account ID: " + sa.getId());
                System.out.println("Date Created: " + sa.getDateCreated().getTime());
                System.out.println("Current Balance: " + sa.getBalance());
                System.out.println("Annual Interest Rate: " + sa.getAnnualInterestRate());
                System.out.println("Monthly Interest Amount: " + sa.getMonthlyInterestAmount());
                System.out.println("Credit Card Number: " + sa.getCreditCardNumber());
                System.out.println("Card Expiry Date: " + sa.getExpiryDate().getTime());
                System.out.println("Credit Balance: " + sa.getCreditBalance());
            }
        }

        scanner.close();
    }
}

