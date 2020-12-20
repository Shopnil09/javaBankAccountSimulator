package ObjectOrientedProgramming;
import java.util.Iterator;

//IteratorInterface which BankUtility implements to iterate through the list of accounts
public interface IteratorInterface {
   public Iterator createIteratorChecking();
   public Iterator createIteratorSavings();
}
