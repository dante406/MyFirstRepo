 class Account {
    private int accountNumber;
    private double balance;

    public int getAccountNumber(){
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }
    public void setAccountNumber(int accountNumber){
        this.accountNumber=accountNumber;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }

    public void deposit(double amount){
        double newBalance=amount+balance;
        System.out.println(newBalance);
    }
    public void withdraw(double amount){
        double newBalance=balance-amount;
        System.out.println("After withdrawl :\n"+newBalance);

    }

}
 class SavingsAccount extends Account{
    double interestRate=2.5;

    public double interest(){
        return getBalance()*(interestRate/100);
    }
}
class CurrentAccont extends Account {
    double limit=500;
    

    
}

public class driver{
    public static void main(String[] args) {
        
    }
}


