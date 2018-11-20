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
                String usernameFile = "test/usernames.txt";
                Data d = new Data();
                d.register(username, usernameFile);
	}
	
	@Override
	public void login(String username) {
            try {
                int userlevel = ScanForExistingUser.returnType(username);
                Sahara.letsgo("staff", username, userlevel);
            } catch (IOException ex) {
                Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
}