package Solve;

public class DriverClass {
    public static void main(String[] args) {
       /*BankAccount acc1 = new BankAccount();
        acc1.setAccountHolder("Arefin");
        acc1.setAccountNumber("UTT85269");
        acc1.setbalnce(3000);
        acc1.setinterestRate(0.12);
        acc1.getAccountDetails();
        acc1.applyInterest();
        acc1.getAccountDetails();*/
        SavingAccount savingAccount = new SavingAccount();

        savingAccount.setAccountHolder("Alice");
        savingAccount.setAccountNumber("SA123456");
        savingAccount.setbalnce(1000.00);
        savingAccount.setinterestRate(0.15);

        savingAccount.getAccountDetails();

        savingAccount.deposit(200);
        System.out.println("After deposit:");
        savingAccount.getAccountDetails();

        savingAccount.withdraw(300);
        System.out.println("After withdrawal:");
        savingAccount.getAccountDetails();

       
        savingAccount.withdraw(600);

        savingAccount.applyInterest();
        savingAccount.getAccountDetails();
        BusinessAccount businessAccount = new BusinessAccount();
        businessAccount.withdraw(4000);
        businessAccount.takeLoan(5000);
        businessAccount.loanInterestRate(0.17);

    }


}
    

