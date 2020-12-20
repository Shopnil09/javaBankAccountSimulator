package ObjectOrientedProgramming;

import java.text.DecimalFormat;

public class SavingsAccount extends BankAccount implements AccountInterface {
   private long savingsAccountNumber;
   private double annualInterestRate = 0.003;
   private int withdrawCounter = 0;

   public SavingsAccount(String name, String addr, long SSN, double balance, long accountNum){
      super(name, addr, SSN, balance);
      this.savingsAccountNumber = accountNum;
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
         System.out.println("You have insufficient funds in your savings account! Please deposit sufficient funds to your account, thank you!");
         System.out.println("Your total balance is: $" + getBalance());
      } else {
         if(withdrawCounter <= 6){ //Withdrawals are limited to only 6
            double balance = getBalance();
            balance = balance - amount;
            setBalance(balance);
            withdrawCounter++;
            System.out.println("$" + amount + " has been withdrawn from your savings account successfully!");
         } else {
            System.out.println("You have reached your withdrawal limit for the month please try again later, thank you!");
            withdrawCounter = 0;
         }
      }
   }

   @Override
   public void setAccountNumber(long number) {
      this.savingsAccountNumber = number;
   }

   @Override
   public long getAccountNumber() {
      return this.savingsAccountNumber;
   }

   public void setAnnualInterestRate(double rate){
      this.annualInterestRate = rate;
   }

   public double getAnnualInterestRate(){
      return this.annualInterestRate;
   }

   public void calcInterestRate(){
      double balance = getBalance();
      double monthlyInterestRate = annualInterestRate/12;
      double monthlyInterest = balance * monthlyInterestRate;
      balance = balance + monthlyInterest;
      balance = Math.round(balance * 100.0)/100.0; //rounding balance to two decimal place
      setBalance(balance);
   }

   //Method to help transfer money from savings to checking account
   public boolean transferWithdraw(double amount){
      if(amount > getBalance()){
         return false;
      } else {
         double balance = getBalance();
         balance = balance - amount;
         setBalance(balance);
         return true;
      }
   }
}
