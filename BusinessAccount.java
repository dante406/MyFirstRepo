package Solve;

public class BusinessAccount extends BankAccount {
    private  double minimumBalance=5000;
    private  double loanInterestRate;

    public static double newloanbalance= 0.0;

    public void setloanInterestRate(double loanInterestRate){
        this.loanInterestRate = loanInterestRate;
    }
    public double getloanInterestRate(){
        return loanInterestRate;
    }
    public double withdraw(double amount){
        if(super.withdraw(amount)<minimumBalance)
            System.out.println("Warning");
        return super.withdraw(amount);
    }
    public double takeLoan(double amount){
        return super.deposit(amount);
    }
    public void loanInterestRate(double loanInterestRate){
        newloanbalance = getbalance()+getbalance()*loanInterestRate;
        System.out.println("Interest Applied!\nNew Balance: "+ newloanbalance);
    }
}
