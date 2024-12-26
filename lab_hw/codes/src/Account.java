import java.util.Calendar;

public class Account {

    private int id;
    private double balance;
    private double annualInterestRate;
    private Calendar dateCreated;
    
    
    //getters
    public int getid(){
        return id;
    }

    public double getbalance(){
        return balance;
    }

    public double getannualInterestRate(){
        return annualInterestRate;
    }

    public Calendar getdateCreated(){
        return dateCreated;
    }

    //setters
    public void setID(int id){
        this.id=id;
    }

    public void setBalnce(double balance){
        this.balance=balance;
    }

    //methods
    public void setannualInterestRate(double annualInterestRate){
        this.annualInterestRate=annualInterestRate;
    }

    public double getMonthlyInterestRate(double annualInterestRate){
        double monthlInterestReate= ((annualInterestRate)/100)/12;
        return monthlInterestReate;
    }

    public double getMonthlyInterestAmount (double balance, double monthlInterestReate){
            return balance*monthlInterestReate;
    }

    public double deposit(double amount){
        return balance+amount;
    }

    public double withdraw(double amount){
        return balance-amount;
    }
}