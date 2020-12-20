package ObjectOrientedProgramming;

public class BankAccount {
   private String clientName;
   private String address;
   private long socialSecurity;
   private double balance;

   public BankAccount(String name, String addr, long SSN, double bal) {
      this.clientName = name;
      this.address = addr;
      this.socialSecurity = SSN;
      this.balance = bal;
   }

   public void setName(String name) {
      this.clientName = name;
   }

   public String getName() {
      return this.clientName;
   }

   public void setAddress(String addr) {
      this.address = addr;
   }

   public String getAddress() {
      return this.address;
   }

   public void setSocialSecurity(long SSN) {
      this.socialSecurity = SSN;
   }

   public long returnSocialSecurity() {
      return this.socialSecurity;
   }

   public void setBalance(double amount){
      this.balance =  amount;
   }

   public double getBalance(){
      return this.balance;
   }
}
