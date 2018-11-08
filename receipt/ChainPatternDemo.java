package receipt;

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

      rec.logReciept(Reciept.USER, 
         "\n Username: " + usernamename + "\n Order #: 1042 \n Product : " + cartList + "\n Total: $" + totalPrice + "\n Discount: $" + disc + "\nTransaction Date:01/11/2018\n");

      rec.logReciept(Reciept.STORE, 
         "\n Username: " + usernamename + "\n Order #: 1042 \n Product : " + cartList + "\n Total: $" + totalPrice + "\n  Discount: $" + disc + "\nTransaction Date:01/11/2018\n");

      rec.logReciept(Reciept.BANK, 
		 "\n Order #: 1042 \n Total: $" + totalPrice + "\n Transaction Date:01/11/2018\n");
   }
}