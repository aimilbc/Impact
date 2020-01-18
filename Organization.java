package Impact;  // consider deleting implements Post


/**
 * Subclass User: a class for Organization user
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/10/2019
 * **/
public class Organization extends User{
	String mailAddress, phone, bankInfo, taxExNum;
	
	/**
	 * a default constructor
	 */
	public Organization() {}
	
	/**
	 * a constructor
	 * @param name
	 * @param email
	 * @param userName
	 * @param password
	 * @param bio
	 * @param address
	 * @param phone
	 * @param taxID
	 * @param bankInfo
	 */
	public 	Organization(String name, String email, String userName, String password, String bio, String address, String phone, String taxID, String bankInfo) {
		super(name, email, userName, password, bio);
		this.mailAddress = address;
		this.phone = phone;
		this.taxExNum = taxID;
		this.bankInfo = bankInfo;
	}

	/**
	 * displays menu for organization user
	 */
	@Override
	public void displayMenu() {
		System.out.println("P)ost Update");
		System.out.println("E)xit to main");
	}

	/**
	 * getter
	 * @return a class name
	 */
	@Override
	public String getClassName() {
		return "Organization";
	}
	

}
