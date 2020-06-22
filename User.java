package Impact;

/**
 * Child class User: creates methods for grand child classes.
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/10/2019
 * **/
public class User extends Post{
	private String name, email, username, password, bio;
	
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
		setName(name);
		setEmail(email);
		setUserName(useraname);
		setPassword(password);
		setBio(bio);
	}
	
	/**
	 * set name
	 * @param name
	 */
	private void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get name
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * set email
	 * @param email
	 */
	private void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * get email
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * set user name
	 * @param user name
	 */
	private void setUserName(String un) {
		this.username = un;
	}
	
	/**
	 * get a user's name
	 * @return user name
	 */
	public String getUserName() {
		return this.username;
	}
	
	/**
	 * set password
	 * @param password
	 */
	private void setPassword(String pw) {
		this.password = pw;
	}
	
	/**
	 * get a password
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * set bio
	 * @param bio
	 */
	private void setBio(String bio) {
		this.bio = bio;
	}
	
	/**
	 * get a biographical profile
	 * @return biographical profile
	 */
	public String getBio() {
		return this.bio;
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
		return this.getClass().getName();
	}
}