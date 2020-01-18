package Impact;

/**
 * Subclass User: a class for Individual user
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/10/2019
 * **/
public class Individual extends User{
	int age, month, date, year;
	String bankInfo, dateOfBirth;
	
	/**
	 * a default constructor
	 */
	public Individual() {}
	
	/**
	 * a constructor
	 * @param name : name
	 * @param email : email
	 * @param username : user name
	 * @param password : password
	 * @param bio : biographical profile
	 * @param age : age
	 * @param bankInfo : bank account information
	 */
	public Individual(String name, String email, String userName, String password, String bio, String dob, String bankInfo) {
		super(name, email, userName, password, bio);
		this.dateOfBirth = dob;
		this.bankInfo = bankInfo;
	}
	
/**
 * getter
 * @return date of birth
 */
	public String getDOB() {
		return dateOfBirth;
	}
	
	/**
	 * displays menu for individual user
	 */
	@Override
	public void displayMenu() {
		System.out.println("P)ost Update");
		System.out.println("M)ake a Donation");
		System.out.println("R)egister for Event");
		System.out.println("E)xit to main");
	}
	/**
	 * display inside of each individual
	 */
	public String toString() {
		return "\"" + name +"\"" + "\n\temail: " + email + "\n\tuserName " + username + "\n\tpassword: " + password + "\n\tbio " + bio+ "\n\tage: " + age + "\n\tbank Info " + bankInfo;
	}

	/**
	 * getter
	 * @return a class name
	 */
	@Override
	public String getClassName() {
		return "Individual";
	}



	
	
}
