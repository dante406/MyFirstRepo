import java.util.Calendar;

class SavingsAccount extends Account {
    private String creditCardNumber;
    private Calendar expiryDate;

    public SavingsAccount(int id, double balance, double annualInterestRate, String creditCardNumber, Calendar expiryDate) {
        super(id, balance, annualInterestRate);
        this.creditCardNumber = creditCardNumber;
        this.expiryDate = expiryDate;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public double getCreditBalance() {
        return 3 * getBalance();
    }
}