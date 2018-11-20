package user;
public abstract class UserFactory {
        String type = "";
        
        public UserFactory(){
            User user = createUser(type);
        }
        
	abstract protected User createUser(String type);
}