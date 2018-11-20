package user;

public class Login {
	
	public static void main(String[] args){
		
		//System.out.println("login (c./s.)username (for existing users) \n or");
		//System.out.println("register (c./s.)username");
		
		// Scan user file
		boolean found = ScanForExistingUser.scan(args[1]);
		
		// CREATE USER FACTORY
		UserFactory userFact = new UserFactory();

		// Login/Register logic
		if(found == true){
			if(args[1].startsWith("c.")){
				if(args[0].equals("login")){
					User customer1 = userFact.createUser("customer");
					customer1.login(args[1]);
				}
				else if(args[0].equals("register"))
					System.out.println("Username already taken.");
				else
					System.out.println("Unrecognised command");
			}
			else if(args[1].startsWith("s.")){
				if(args[0].equals("login")){
					User staff1 = userFact.createUser("staff");
					staff1.login(args[1]);
				}
				else if(args[0].equals("register"))
					System.out.println("Username already taken.");
				else
					System.out.println("Unrecognised command");
			}
			else
				System.out.println("Username not recognized, username starts with c. or s.");
		}
		else{
			if(args[0].equals("login"))
				System.out.println("Username not found..");
			else if(args[0].equals("register")){
				if(args[1].startsWith("s.")){
					User staff1 = userFact.createUser("staff");
					staff1.register(args[1]);
				}
				else if(args[1].startsWith("c.")){
					User customer1 = userFact.createUser("customer");
					customer1.register(args[1]);
				}
				else
					System.out.println("Invalid user type, try c. or s.");
			}
			else
				System.out.println("Unrecognised command");
		}
	}
}