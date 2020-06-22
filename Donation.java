package Impact;

/**
 * Subclass Post with Image: creates methods to post donation.
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/10/2019
 * **/
public class Donation extends Post{
	private String name, amount;
	
	/**
	 * default constructor
	 */
	public Donation() {}
	
	/**
	 * a constructor
	 * @param name
	 * @param amount
	 */
	public Donation(int index, String name, String amount) {
		super.index = index;
		setName(name);
		setAmount(amount);
	}
	/**
	 * display donation
	 * @return donated organization and amount
	 */
	@Override
	public String toString() {
		return " donated $" + amount + " to " + "\'" + name + "\'";
	}
	
	/**
	 * set name
	 * @param name
	 */
	private void setName(String name) {
		this.name = name;
	}
	
	/**
	 * getter name
	 */
	public void getName() {
		System.out.println("Name: " + name);
	}
	
	/**
	 * set amount
	 * @param amount
	 */
	private void setAmount(String amount) {
		this.amount = amount;
	}
	
	/**
	 * getter amount
	 */
	public void getAmount() {
		System.out.println("Amount: " + amount);
	}
	
}
