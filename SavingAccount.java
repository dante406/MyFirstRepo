package Solve;

public class SavingAccount extends BankAccount {
    private double withdrawalLimit = 500.0;

    public void setWithdrawalLimit(double withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    
    public double withdraw(double amount) {
        if (amount > getbalance()) {
            System.out.println("Insufficient funds.");
            return getbalance();
        } 
        else if (amount > withdrawalLimit) {
            System.out.println("Withdrawal exceeds the limit of $" + withdrawalLimit);
            return getbalance();
        } 
        else {
            return super.withdraw(amount);
        }
    }

    
    public void applyInterest() {
        double interestRate = getinterestRate();
        double balance = getbalance();
        newbalance = balance + balance * interestRate;
        System.out.println("Interest applied at rate of " + (interestRate * 100) + "% on " + balance);
        System.out.println("Interset : " + (newbalance-balance));
    }

}
