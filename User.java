package Impact;

/**
 * Child class User: creates methods for grand child classes.
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/10/2019
 * **/
public class User extends Post{
	String name, email, username, password, bio;
	
	/**
	 * default constructor
	 */
	public User(){	}
	
	/**
	 * a constructor
	 * @param name : name
	 * @param email : email
	 * @param username : user name
	 * @param password : password
	 * @param bio : biographical profile
	 */
	public User(String name, String email, String username, String password, String bio) {
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.bio = bio;
	}
	
	/**
	 * get name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * get email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * get a user's name
	 * @return user name
	 */
	public String getUserName() {
		return username;
	}
	
	/**
	 * get a password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * get a biographical profile
	 * @return biographical profile
	 */
	public String getBio() {
		return bio;
	}
	
	/**
	 * displays menu for user
	 */
	public void displayMenu() {
		System.out.println("P)ost Update");
		System.out.println("E)xit to main");
	}
	
	/**
	 * getter
	 * @return a class name
	 */
	public String getClassName() {
		return "User";
	}
}