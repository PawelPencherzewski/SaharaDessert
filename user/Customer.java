package user;

import data.Data;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import store.Sahara;

public class Customer implements User {
												// Customer 
	@Override
	public void register(String username) {
                String usernameFile = "test/usernames.txt";
                Data d = new Data();
                d.register(username, usernameFile);
	}
	
	@Override
	public void login(String username) {
            try {
                int userlevel = ScanForExistingUser.returnType(username);
                Sahara.letsgo("customer", username, userlevel);
            } catch (IOException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
}