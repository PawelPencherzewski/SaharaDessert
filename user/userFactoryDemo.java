package user;

public class userFactoryDemo {
	
	public static void main(String[] args){
		// Scan user file for existing usernames.
		boolean found = ScanForExistingUser.scan(args[1]);

		// Login/Register logic
		if(found == true){                                                        // IF USER EXISTS IN DATABASE
			if(args[0].equals("login")){
				if(args[1].startsWith("c.")){                             // CUSTOMER LOGIN
                                        UserFactory factory = new CustomerUserFactory();
					User customer1 = factory.createUser("customer");
					customer1.login(args[1]);
				}
				else if(args[1].startsWith("s.")){                       // STAFF LOGIN
                                        UserFactory factory = new StaffUserFactory();
					User staff1 = factory.createUser("staff");
					staff1.login(args[1]);
                                }
				else
					System.out.println("Unrecognised user type.");
			}
			else if(args[0].equals("register"))
                            System.out.println("Username already taken.");
			else
                            System.out.println("Command not recognized. Try login or register.");
		}
		else{                                                                     // IF USER DOESNT EXIST IN DATABASE
			if(args[0].equals("register")){
				if(args[1].startsWith("c.")){                             // CUSTOMER REGISTER
                                        UserFactory factory = new CustomerUserFactory();
					User customer1 = factory.createUser("customer");
					customer1.register(args[1]);
				}
				else if(args[1].startsWith("s.")){                        // STAFF REGISTER
                                        UserFactory factory = new StaffUserFactory();
					User staff1 = factory.createUser("staff");
					staff1.register(args[1]);
                                }
				else
					System.out.println("Unrecognised user type.");
			}
			else if(args[0].equals("login"))
                            System.out.println("Username doesn't exist.");
			else
                            System.out.println("Command not recognized. Try login or register.");
		}
	}
}