package receipt;

public class BankReciept extends Reciept {

   public BankReciept(int level){
      this.level = level;
   }

   @Override
   protected void write(String message) {		
      System.out.println("Bank Reciept::Reciept: " + message);
   }
}
