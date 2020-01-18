package Impact;  // consider deleting implements Post

/**
 * Subclass User: a class for Volunteer user
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/10/2019
 * **/
public class Volunteer extends User{
	String address,phone, time, dayFrom, dayTill;

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
	public Volunteer(String name, String email, String userName, String password, String bio, String from, String to, String time, String address, String phone) {
		super(name, email, userName, password, bio);
		this.dayFrom = from;
		this.dayTill = to;
		this.time = time;
		this.address = address;
		this.phone = phone;
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
		return "Volunteer";
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
	 * getter
	 * @return starting date
	 */
	public String getFrom() {
		return dayFrom;
	}
	
	/**
	 * set/change the time
	 * @param time
	 */
	public void setTime(String time) {
		this.time = time;
	}
	
	/**
	 * set/change a location
	 * @param location
	 */
	public void setLocation(String location) {
		this.address = location;
	}
	
	/**
	 * display event detail
	 * @return event detail
	 */
	public String displayDetail() {
		return "Event name: \t" + username +"\nDate: \t\t" + dayFrom + "-" + dayTill + "\nTime: \t\t" + time + "\nLocation: \t" + address + "\nPhone: \t\t" + phone + "\n";
	}

	
}
