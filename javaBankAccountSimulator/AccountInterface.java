package ObjectOrientedProgramming;

//Interface for Checking Account and Savings Account to implement
public interface AccountInterface {
   public void deposit(double amount);
   public void withdraw(double amount);
   public void setAccountNumber(long number);
   public long getAccountNumber();
}
