package Impact;  // consider deleting implements Post

/**
 * Subclass User: a class for Volunteer user
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/10/2019
 * **/
public class Volunteer extends User{
	private String address,phone, time, dayFrom, dayTill;

	/**
	 * a default constructor
	 */
	public Volunteer() {}
	
	/**
	 * a constructor
	 * @param name
	 * @param email
	 * @param userName
	 * @param password
	 * @param bio
	 * @param month
	 * @param date
	 * @param year
	 * @param address
	 * @param phone
	 */
	public Volunteer(String name, String email, String userName, String password, String bio, String from, 
			String to, String time, String address, String phone) {
		super(name, email, userName, password, bio);
		setEventDate(from, to);
		setTime(time);
		setLocation(address);
		setPhone(phone);
	}
	
	/**
	 * set/change an event date
	 * @param from : starting date
	 * @param to : ending date
	 */
	public void setEventDate(String from, String to) {
		this.dayFrom = from;
		this.dayTill = to;
	}
	
	/**
	 * get day till
	 * @return day till
	 */
	private String getTill() {
		return this.dayTill;
	}
	
	/**
	 * getter
	 * @return starting date
	 */
	public String getFrom() {
		return this.dayFrom;
	}
	
	/**
	 * set/change the time
	 * @param time
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
	/**
	 * get time
	 * @return time
	 */
	public String getTime() {
		return this.time;
	}
	
	/**
	 * set/change a location
	 * @param location
	 */
	public void setLocation(String location) {
		this.address = location;
	}
	
	/**
	 * get address
	 * @return address
	 */
	public String getLocation() {
		return this.address;
	}
	
	/**
	 * set phone number
	 * @param phone number
	 */
	private void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * get phone number
	 * @return phone number
	 */
	public String getPhone() {
		return this.phone;
	}
	
	/**
	 * display event detail
	 * @return event detail
	 */
	public String displayDetail() {
		return "Event name: \t" + this.getUserName() +"\nDate: \t\t" + this.getFrom() + "-" + this.getTill() + "\nTime: \t\t" + this.getTime() + "\nLocation: \t" + this.getLocation() + "\nPhone: \t\t" + this.getPhone() + "\n";
	}

	/**
	 * displays menu for volunteer user
	 */
	@Override
	public void displayMenu() {
		System.out.println("P)ost Update");
		System.out.println("M)odify Date/Time/Location");
		System.out.println("E)xit to main");
	}

	/**
	 * getter
	 * @return a class name
	 */
	@Override
	public String getClassName() {
		return this.getClass().getName();
	}
}
