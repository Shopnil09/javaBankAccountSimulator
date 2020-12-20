package ObjectOrientedProgramming;

public class CheckingAccount extends BankAccount implements AccountInterface{
   private long checkingAccountNumber;
   private double monthlyCost;

   public CheckingAccount(String name, String addr, long SSN, double bal, long accountNum, double cost){
      super(name, addr, SSN, bal);
      this.checkingAccountNumber = accountNum;
      this.monthlyCost = cost;
   }

   @Override
   public void deposit(double amount) {
      double balance = getBalance();
      balance = balance + amount;
      setBalance(balance);
   }

   @Override
   public void withdraw(double amount) {
      if(amount > getBalance()){
         System.out.println("You have insufficient funds in your checking account! Please deposit sufficient funds to your account, thank you!");
         System.out.println("Your total balance is: $" + getBalance());
      } else {
         double balance = getBalance();
         balance = balance - amount;
         setBalance(balance);
         System.out.println("$" + amount + " has been withdrawn from your checking account successfully!");
      }
   }

   @Override
   public void setAccountNumber(long number) {
      this.checkingAccountNumber = number;
   }

   @Override
   public long getAccountNumber() {
      return this.checkingAccountNumber;
   }

   public void setMonthlyCost(double cost) {
      this.monthlyCost = cost;
   }

   public double getMonthlyCost() {
      return this.monthlyCost;
   }

   public void makeMonthlyPayment() {
      if (monthlyCost == 0.0) {
         System.out.println("Monthly cost is $0.00");
         System.out.println("Please add monthly cost to pay it");
      } else if(monthlyCost > getBalance()){
         System.out.println("Monthly payment was unsuccessful! You have insufficient funds in your checking account. Please deposit funds and make payment again, thank you!");
         System.out.println("Your total balance is: $" + getBalance());
      } else {
         double balance = getBalance();
         balance = balance - monthlyCost;
         setBalance(balance);
      }
   }
}
