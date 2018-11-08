package receipt;

public class UserReciept extends Reciept {

   public UserReciept(int level){
      this.level = level;
   }

   @Override
   protected void write(String message) {		
      System.out.println("User Reciept::Reciept: " + message);
   }
}