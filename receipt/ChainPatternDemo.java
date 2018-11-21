package receipt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ChainPatternDemo {
	
   private static Reciept getReciept(){

      Reciept bankReciept = new BankReciept(Reciept.BANK);
      Reciept storeReciept = new StoreReciept(Reciept.STORE);
      Reciept userReciept = new UserReciept(Reciept.USER);

      bankReciept.setNextReciept(userReciept);

      return bankReciept;	
   }

   public static void printReceipt(String usernamename, double totalPrice, String cartList, double disc) {
      Reciept rec = getReciept();
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate localDate = LocalDate.now();
	System.out.println(dtf.format(localDate));

      rec.logReciept(Reciept.USER, 
         "\n Username: " + usernamename + "\n Order #: 1042 \n Product : " + cartList + "\n Total: $" + (totalPrice - disc) + "\n Discount: $" + disc + "\nTransaction Date: " + dtf.format(localDate) + "\n");

      rec.logReciept(Reciept.STORE, 
         "\n Username: " + usernamename + "\n Order #: 1042 \n Product : " + cartList + "\n Total: $" + (totalPrice - disc) + "\n  Discount: $" + disc + "\nTransaction Date: " + dtf.format(localDate) + "\n");

      rec.logReciept(Reciept.BANK, 
		 "\n Order #: 1042 \n Total: $" + totalPrice + "\n Transaction Date: " + dtf.format(localDate) + "\n");
   }
   
   public static void printReceipt(String usernamename, double totalPrice, String boughtType) {
      Reciept rec = getReciept();
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate localDate = LocalDate.now();
	System.out.println(dtf.format(localDate));

      rec.logReciept(Reciept.USER, 
         "\n Username: " + usernamename + "\n Order #: 1042 \n Product : " + boughtType + "\n Total: $" + totalPrice + "\nTransaction Date: " + dtf.format(localDate) + "\n");

      rec.logReciept(Reciept.STORE, 
         "\n Username: " + usernamename + "\n Order #: 1042 \n Product : " + boughtType + "\n Total: $" + totalPrice + "\nTransaction Date: " + dtf.format(localDate) + "\n");

      rec.logReciept(Reciept.BANK, 
		 "\n Order #: 1042 \n Total: $" + totalPrice + "\n Transaction Date: " + dtf.format(localDate) + "\n");
   }
}