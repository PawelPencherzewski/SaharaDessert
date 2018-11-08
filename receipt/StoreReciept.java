package receipt;

public class StoreReciept extends Reciept {

   public StoreReciept(int level){
      this.level = level;
   }

   @Override
   protected void write(String message) {		
      System.out.println("Store Reciept::Reciept: " + message);
   }
}