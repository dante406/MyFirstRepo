import java.util.Scanner;

public class Driver_Account {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account ac1 = new Account();
        System.out.println("Enter the ID to create a new Account: ");
        int id = sc.nextInt();
        ac1.setID(id);
        System.out.println("Enter the inital balance of the account: ");
        double balance = sc.nextDouble();
        ac1.setBalnce(balance);
        System.out.println("Enter the annual interest rate: ");
        double annualInterestRate = sc.nextDouble();
        ac1.setannualInterestRate(annualInterestRate);
        System.out.println("Current Balance: "+ac1.getbalance());
        ac1.setBalnce(ac1.withdraw(2500));
        System.out.println("After withdraw new Balance: "+ ac1.getbalance());
        // System.out.println("After withdraw new Balance: "+ ac1.withdraw(2500));
        System.out.println("Current Balance: "+ac1.getbalance());
        ac1.setBalnce(ac1.deposit(3000));
        System.out.println("After withdraw new Balance: "+ ac1.getbalance());
        //getMonthlyInterestAmount
        double interestAmount = ac1.getMonthlyInterestAmount();
        System.out.println("Monthly Interest Amount: " + interestAmount);
    }
}