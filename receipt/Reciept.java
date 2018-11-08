package receipt;

public abstract class Reciept {
   public static int USER = 1;
   public static int STORE = 2;
   public static int BANK = 3;

   protected int level;

   //next element in chain or responsibility
   protected Reciept rec;

   public void setNextReciept(Reciept rec){
      this.rec = rec;
   }

   public void logReciept(int level, String message){
      if(this.level <= level){
         write(message);
      }
      if(rec !=null){
         rec.logReciept(level, message);
      }
   }

   abstract protected void write(String message);
	
}