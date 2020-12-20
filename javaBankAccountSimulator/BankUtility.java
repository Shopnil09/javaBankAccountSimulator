package ObjectOrientedProgramming;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class BankUtility implements IteratorInterface {
   ArrayList<CheckingAccount> checkingAccountsList = new ArrayList<CheckingAccount>();
   ArrayList<SavingsAccount> savingsAccountList = new ArrayList<SavingsAccount>();

   //Starts the program by providing options for the user to select
   public void startApplication() {
      makeAccounts();
      Scanner keyboard = new Scanner(System.in);
      int option;
      System.out.println("Welcome to the Bank of UAlbany! How can we assist you? ");
      do {
         System.out.println("1. Create a checking account");
         System.out.println("2. Create a savings account");
         System.out.println("3. Check my checking account");
         System.out.println("4. Check my savings account");
         System.out.println("5. Transfer money from savings account to checking account");
         System.out.println("6. Exit");
         System.out.println("Please enter an option from above to continue: ");
         option = keyboard.nextInt();
         switch (option) {
            case 1:
               createCheckingAccount();
               break;
            case 2:
               createSavingsAccount();
               break;
            case 3:
               checkCheckingAccount();
               break;
            case 4:
               checkSavingsAccount();
               break;
            case 5:
               transferMoney();
               break;
            case 6:
               System.out.println("Exiting the program.....");
               break;
            default:
               System.out.println("Invalid Command! Please an option from below, thank you!");
               break;
         }
      } while (option != 6);
   }

   //Hardcoded accounts
   public void makeAccounts() {
      CheckingAccount account1 = new CheckingAccount("Alex Smith", "Staten Island, New York City", 876987327, 4000, 076320123, 0);
      CheckingAccount account2 = new CheckingAccount("Joshua Ryan", "Albany, New York", 546092345, 1200, 034125630, 70);
      CheckingAccount account3 = new CheckingAccount("Jedd Adam", "Bronx, New York City", 234098765, 2500, 120087435, 120);
      CheckingAccount account4 = new CheckingAccount("Inaya Sexton", "Manhattan, New York City", 876234126, 3400, 960204201, 80);
      CheckingAccount account5 = new CheckingAccount("Emily Picardo", "Westchester, New York", 900123760, 3500, 006534226, 40);

      SavingsAccount account6 = new SavingsAccount("Gethlin Gibson", "Brooklyn, New York City", 223778323, 3800, 456783429);
      SavingsAccount account7 = new SavingsAccount("Emily Picardo", "Weschester, New York", 900123760, 11000, 54888231);
      SavingsAccount account8 = new SavingsAccount("Jonas Gonzales", "Bronx, New York City", 435786120, 5200, 658765406);
      SavingsAccount account9 = new SavingsAccount("Alex Smith", "Staten Island, New York Ciy", 876987327, 99900, 408732679);
      SavingsAccount account10 = new SavingsAccount("Joshua Ryan", "Albany, New York", 546092345, 13500, 92378123);

      checkingAccountsList.add(account1);
      checkingAccountsList.add(account2);
      checkingAccountsList.add(account3);
      checkingAccountsList.add(account4);
      checkingAccountsList.add(account5);

      savingsAccountList.add(account6);
      savingsAccountList.add(account7);
      savingsAccountList.add(account8);
      savingsAccountList.add(account9);
      savingsAccountList.add(account10);
   }

   public void createCheckingAccount() {
      String name, currentAddress;
      int socialSecurity, accountNumber;
      double balance, monthlyCost;
      Scanner keyboard = new Scanner(System.in);
      Random randomNumber = new Random();
      System.out.println("---------------------------------------------------------------------------------------------------");
      System.out.println("Please fill out the following information to open an checking account: ");
      System.out.println("Please enter your full name: ");
      System.out.println("Or enter E to exit to the Main Menu");
      name = keyboard.nextLine().trim();
      if(name.equalsIgnoreCase("E") == false){
         System.out.println("Please enter your current address: ");
         currentAddress = keyboard.nextLine();
         System.out.println("Please enter your Social Security Number: ");
         socialSecurity = keyboard.nextInt();
         keyboard.nextLine();
         System.out.println("Please enter the amount you want to deposit to your checking account: ");
         balance = keyboard.nextDouble();
         keyboard.nextLine();
         System.out.println("Please enter your monthly cost; if you do not have a monthly cost, please enter 0");
         monthlyCost = keyboard.nextDouble();
         keyboard.nextLine();
         accountNumber = 100000000 + randomNumber.nextInt(900000000); //providing a random 9 digit number as account number
         CheckingAccount account = new CheckingAccount(name, currentAddress, socialSecurity, balance, accountNumber, monthlyCost);
         checkingAccountsList.add(account);
         System.out.println("Your account is successfully created!");
         System.out.println("Your checking account number is " + accountNumber);
         System.out.println("---------------------------------------------------------------------------------------------------");
      } else {
         System.out.println("Exiting to Main Menu.....");
      }
   }

   public void createSavingsAccount() {
      String name, currentAddress;
      int socialSecurityNum, accountNumber;
      double balance;
      Scanner keyboard = new Scanner(System.in);
      Random randomNumber = new Random();
      System.out.println("Please fill out the following information to open a savings account: ");
      System.out.println("Please enter your full name: ");
      System.out.println("Or enter E to exit to Main Menu");
      name = keyboard.nextLine().trim();
      if(name.equalsIgnoreCase("E") == false){
         System.out.println("Please enter your current address: ");
         currentAddress = keyboard.nextLine();
         System.out.println("Please enter your Social Security Number: ");
         socialSecurityNum = keyboard.nextInt();
         keyboard.nextLine();
         System.out.println("In order to open an account, a deposit of $25 or more should be made. Please enter the amount you want to deposit to your savings account: ");
         balance = keyboard.nextDouble();
         keyboard.nextLine();
         boolean openAccount = false;
         if (balance < 25.0) {
            while (openAccount == false) {
               System.out.println("Amount deposited was less than $25, please deposit an amount of $25 or more to open a savings account");
               balance = keyboard.nextDouble();
               keyboard.nextLine();
               if (balance >= 25.0)
                  openAccount = true;
            }
         }
         accountNumber = 100000000 + randomNumber.nextInt(900000000); //generating a 9 digit number as account number
         SavingsAccount account = new SavingsAccount(name, currentAddress, socialSecurityNum, balance, accountNumber);
         savingsAccountList.add(account);
         System.out.println("Your account is successfully created!");
         System.out.println("Your savings account is " + accountNumber);
         System.out.println("---------------------------------------------------------------------------------------------------");
      } else {
         System.out.println("Exiting to Main Menu.....");
      }
   }

   public void checkCheckingAccount() {
      int flag = 0;
      int option;
      CheckingAccount account = null;
      String findName;
      Scanner keyboard = new Scanner(System.in);
      boolean foundAccount = false;
      System.out.println("If you want to check your checking account, enter your full name: ");
      System.out.println("Or press E to exit to Main Menu");
      findName = keyboard.nextLine().trim();
      Iterator iterator = createIteratorChecking();
      if(findName.equalsIgnoreCase("E") == false){
         while (foundAccount == false) {
            while (iterator.hasNext()) { //iterating through the list to find a match
               CheckingAccount tempAccount = (CheckingAccount) iterator.next();
               if (tempAccount.getName().equalsIgnoreCase(findName) == true) {
                  account = tempAccount;
                  foundAccount = true;
                  break;
               }
            }
            if (foundAccount == true) {
               break;
            }
            else{
               System.out.println("Account was not found in the system! You have entered the name: " + findName);
               System.out.println("If you did not input your name correctly please enter your full name correctly, thank you!");
               System.out.println("If you want to exit to Main Menu, press E");
               String tempOption = keyboard.nextLine().trim();
               if (tempOption.equalsIgnoreCase("E")) {
                  System.out.println("Exiting to Main Menu.....");
                  flag = 1;
                  foundAccount = true;
               } else{
                  findName = tempOption;
                  iterator = createIteratorChecking();
               }
            }
         }
         while (flag != 1) {
            System.out.println("1. Check balance of checking account");
            System.out.println("2. Deposit money into checking account");
            System.out.println("3. Withdraw money from checking account");
            System.out.println("4. Make monthly payment");
            System.out.println("5. Change your monthly cost");
            System.out.println("6. Exit to Main Menu");
            System.out.println("Please choose an option from above: ");
            option = keyboard.nextInt();
            keyboard.nextLine();
            switch (option) {
               case 1:
                  double balance = checkCheckingBalance(account);
                  System.out.println("Total balance in your checking account is: $" + balance);
                  break;
               case 2:
                  System.out.println("Please enter the amount you want to deposit: ");
                  double depositAmount = keyboard.nextDouble();
                  depositMoneyChecking(account, depositAmount);
                  System.out.println("$" + depositAmount + " is deposited into your checking account successfully!");
                  break;
               case 3:
                  System.out.println("Please enter the amount you want to withdraw: ");
                  double withdrawAmount = keyboard.nextDouble();
                  withdrawMoneyChecking(account, withdrawAmount);
                  break;
               case 4:
                  makeMonthlyPayment(account);
                  System.out.println("Monthly payment is successfully made!");
                  break;
               case 5:
                  System.out.println("Please enter your new monthly cost: ");
                  double monthlyAmount = keyboard.nextDouble();
                  changeMonthlyCost(account, monthlyAmount);
                  System.out.println("Monthly cost is set to " + "$" + monthlyAmount);
                  break;
               case 6:
                  System.out.println("Exiting to Main Menu....."); //debug
                  flag = 1;
                  break;
               default:
                  System.out.println("Invalid command! Please choose an option from below, thank you!");
            }
         }
      } else {
         System.out.println("Exiting to Main Menu......");
      }
   }

   public double checkCheckingBalance(CheckingAccount account) {
      return account.getBalance();
   }

   public void depositMoneyChecking(CheckingAccount account, double amount) {
      account.deposit(amount);
   }

   public void withdrawMoneyChecking(CheckingAccount account, double amount) {
      account.withdraw(amount);
   }

   public void makeMonthlyPayment(CheckingAccount account) {
      account.makeMonthlyPayment();
   }

   public void changeMonthlyCost(CheckingAccount account, double cost) {
      account.setMonthlyCost(cost);
   }

   public void checkSavingsAccount() {
      int flag = 0, option;
      SavingsAccount account = null;
      boolean foundAccount = false;
      Scanner keyboard = new Scanner(System.in);
      System.out.println("If you want to check your savings account, please enter your full name: ");
      System.out.println("Or enter E to exit to Main Menu");
      String findName = keyboard.nextLine().trim();
      Iterator iterator = createIteratorSavings();
      if(findName.equalsIgnoreCase("E") == false){
         while (foundAccount == false) {
            while (iterator.hasNext()) {
               SavingsAccount tempAccount = (SavingsAccount) iterator.next();
               if (tempAccount.getName().equalsIgnoreCase(findName) == true) {
                  account = tempAccount;
                  foundAccount = true;
                  break;
               }
            }
            if (foundAccount == true)
               break;
            else{
               System.out.println("Account was not found in the system! You have entered the name: " + findName);
               System.out.println("If you did not input your name correctly please enter your full name correctly, thank you!");
               System.out.println("If you want to exit to Main Menu, press E");
               String tempOption = keyboard.nextLine().trim();
               if (tempOption.equalsIgnoreCase("E")) {
                  System.out.println("Exiting to Main Menu......");
                  flag = 1;
                  foundAccount = true;
               } else{
                  findName = tempOption;
                  iterator = createIteratorSavings();
               }
            }
         }
         while (flag != 1) {
            System.out.println("1. Check balance for savings account");
            System.out.println("2. Deposit money into your savings account");
            System.out.println("3. Withdraw money from your savings account");
            System.out.println("4. Apply monthly interest rate to your balance");
            System.out.println("5. Exit to Main Menu");
            option = keyboard.nextInt();
            keyboard.nextLine();
            switch (option) {
               case 1:
                  double savingsBalance = checkSavingsAccountBalance(account);
                  System.out.println("Total balance in your savings account is : $" + savingsBalance);
                  break;
               case 2:
                  System.out.println("Please enter the amount you want to deposit: ");
                  double depositAmountSavings = keyboard.nextDouble();
                  depositMoneySavings(account, depositAmountSavings);
                  System.out.println("$" + depositAmountSavings + " is deposited into your savings account successfully!");
                  System.out.println("Please check savings account balance to see your new balance");
                  break;
               case 3:
                  System.out.println("The policy of the bank allows one to make 6 withdraws from Savings account ");
                  System.out.println("Please enter the amount you want to withdraw: ");
                  double withdrawAmountSavings = keyboard.nextDouble();
                  withdrawMoneySavings(account, withdrawAmountSavings);
                  break;
               case 4:
                  applyInterestRate(account);
                  System.out.println("Monthly interest rate applied to your balance successfully!");
                  System.out.println("Please check savings account balance to see your new balance");
                  break;
               case 5:
                  System.out.println("Exiting to Main Menu.......");
                  flag = 1;
                  break;
               default:
                  System.out.println("Invalid command! Please choose an option from below, thank you!");
            }
         }
      } else {
         System.out.println("Exiting to Main Menu......");
      }
   }

   public double checkSavingsAccountBalance(SavingsAccount account) {
      double balance = account.getBalance();
      return balance;
   }

   public void depositMoneySavings(SavingsAccount account, double amount) {
      account.deposit(amount);
   }

   public void withdrawMoneySavings(SavingsAccount account, double amount) {
      account.withdraw(amount);
   }

   public void applyInterestRate(SavingsAccount account) {
      account.calcInterestRate();
   }

   public void transferMoney() {
      CheckingAccount checkingAccount = null;
      SavingsAccount savingsAccount = null;
      String findName;
      Iterator iterator = createIteratorChecking();
      Iterator iteratorSavings = createIteratorSavings();
      Scanner keyboard = new Scanner(System.in);
      System.out.println("If you want to transfer money from your savings account to checking account, please enter your full name");
      System.out.println("Or if you want to exit to Main Menu, please press E");
      findName = keyboard.nextLine().trim();
      if(findName.equalsIgnoreCase("E") == false){
         boolean foundChecking = false;
         boolean foundSaving = false;
         while(foundChecking == false){
            while(iterator.hasNext()){
               CheckingAccount cAccount = (CheckingAccount) iterator.next();
               if(cAccount.getName().equalsIgnoreCase(findName)){
                  checkingAccount = cAccount;
                  foundChecking = true;
                  break;
               }
            }
            if(foundChecking == true){
               break;
            }
            System.out.println("Checking account was not found! You have entered the name: " + findName);
            System.out.println("If you do not have a checking account, please create one before transferring money");
            System.out.println("If you did not input your name correctly please enter your full name, thank you!");
            System.out.println("If you want to exit to Main Menu, press E");
            String option = keyboard.nextLine().trim();
            if(option.equalsIgnoreCase("E")){
               System.out.println("Exiting to Main Menu......");
               break;
            } else {
               findName = option;
               iterator = createIteratorChecking();
            }
         }
         if(foundChecking == true){
            while(foundSaving ==  false) {
               while (iteratorSavings.hasNext()) {
                  SavingsAccount sAccount = (SavingsAccount) iteratorSavings.next();
                  if (sAccount.getName().equalsIgnoreCase(findName)) {
                     savingsAccount = sAccount;
                     foundSaving = true;
                     break;
                  }
               }
               if (foundSaving == true)
                  break;
               System.out.println("Savings account was not found! You have entered the name: " + findName);
               System.out.println("If you do not have a savings account, please create one before transferring money");
               System.out.println("If you did not input your name correctly please enter your full name, thank you!");
               System.out.println("If you want to exit to Main Menu, press E");
               String tempOption = keyboard.nextLine().trim();
               if(tempOption.equalsIgnoreCase("E")){
                  System.out.println("Exiting to Main Menu......");
                  break;
               } else {
                  findName = tempOption;
                  iterator = createIteratorSavings();
               }
            }
         }
         if(foundChecking == true && foundSaving == true){ 
            transferMoneyHelper(checkingAccount, savingsAccount);
         }
      } else {
         System.out.println("Exiting to Main Menu.....");
      }
   }

   public void transferMoneyHelper(CheckingAccount checkingAccount, SavingsAccount savingsAccount){
      System.out.println("Checking and Savings account found!");
      System.out.println("Please enter the amount you want to transfer from Savings Account: ");
      Scanner keyboard = new Scanner(System.in);
      double amount = keyboard.nextDouble();
      keyboard.nextLine();
      if(savingsAccount.transferWithdraw(amount) == false){
         System.out.println("You have insufficient funds in your savings account! Please deposit sufficient funds to your account, thank you!");
         System.out.println("Your total balance is: $" + savingsAccount.getBalance());
      } else {
         checkingAccount.deposit(amount);
         System.out.println("$" + amount + " is transferred from savings to checking account successfully!");
      }
   }

   @Override
   public Iterator createIteratorChecking() {
      return checkingAccountsList.iterator();
   }

   @Override
   public Iterator createIteratorSavings() {
      return savingsAccountList.iterator();
   }

}
