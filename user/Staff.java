package user;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import store.Sahara;

public class Staff implements User {
												// Staff
	@Override	
	public void register(String username) {
		System.out.println("Inside staff::register() method");
		try{
		String usernameFile = "test/usernames.txt";
		FileWriter fw = new FileWriter(usernameFile, true);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(username);
		pw.close();
		fw.close();
		}
		catch(IOException e) {}
	}
	
	@Override
	public void login(String username) {
            try {
                Sahara.letsgo("staff", username);
            } catch (IOException ex) {
                Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
}