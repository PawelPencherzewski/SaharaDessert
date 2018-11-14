package user;
import data.Data;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import store.Sahara;

public class Staff implements User {
												// Staff
	@Override	
	public void register(String username) {
		System.out.println("Inside staff::register() method");
                String usernameFile = "test/usernames.txt";
		
                 Data d = new Data();
                d.register(username, usernameFile);
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