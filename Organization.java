package Impact;  // consider deleting implements Post


/**
 * Subclass User: a class for Organization user
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/10/2019
 * **/
public class Organization extends User{
	private String mailAddress, phone, bankInfo, taxExNum;
	
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
		setmailAddress(address);
		setPhone(phone);
		setTax(taxID);
		setBank(bankInfo);
	}
	
	/**
	 * set physical address
	 * @param mail
	 */
	private void setmailAddress(String mail) {
		this.mailAddress = mail;
	}
	
	/**
	 * getter mail address
	 * @return mail address
	 */
	public String getMailAddress() {
		retrun this.mailAddress;
	}
	
	/**
	 * set phone number
	 * @param phoneNum
	 */
	private void setPhone(String phoneNum) {
		this.phone = phoneNum;
	}
	
	/**
	 * getter phone
	 * @return phone number
	 */
	public String getPhone() {
		return this.phone;
	}
	
	/**
	 * set taxID
	 * @param taxID
	 */
	private void setTax(String taxID) {
		this.taxExNum = taxID;
	}
	
	/**
	 * getter tax ID
	 * @return tax ID
	 */
	public String getTaxID() {
		return this.taxExNum;
	}
	
	/**
	 * set bank info
	 * @param bankInfo
	 */
	private void setBank(String bankInfo) {
		this.bankInfo = bankInfo;
	}
	
	/**
	 * get bank info
	 * @return bank info
	 */
	public String getBankInfo() {
		return this.bankInfo;
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
	 * get class name
	 * @return a class name
	 */
	@Override
	public String getClassName() {
		return this.getClass().getName();
	}
	

}
