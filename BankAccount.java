    package Solve;

    public class BankAccount {
        private String accountHolder;
        private double balance;
        private String accountNumber;
        private double interestRate;

        public static double newbalance=0.0;

        public void setAccountHolder(String accountHolder) {
            this.accountHolder = accountHolder;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public void setbalnce(double balance){
            this.balance=balance;
        }
        public void setinterestRate (double interestRate){
            this.interestRate=interestRate;
        }
        public String getaccountHolder(){
            return accountHolder;
        }
        public double getbalance(){
            return balance;
        }
        public String getaccoountNumber(){
            return accountNumber;
        }
        public double getinterestRate(){
            return interestRate;
        }
        public double deposit(double amount){
            return balance+=amount;
        }
        public double withdraw(double amount){
            return balance-=amount;
        }
        public void applyInterest(){
            //System.out.println(interestRate);
            newbalance=balance+balance*interestRate;
            System.out.println("Interest Appiled 12% on "+balance+"\nNew Balance: "+newbalance );

        }
        public void getAccountDetails(){
            System.out.println("Account name: "+accountHolder+"\nAccount number: "+accountNumber+"\nBalance: "+balance);
            if(newbalance==0) System.out.println("Current Balance: "+balance);
            else System.out.println("Current Balance: "+newbalance);        
        }

}
