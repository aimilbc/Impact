package Impact;

/**
 * Subclass Post with Image: creates methods to post donation.
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/10/2019
 * **/
public class Donation extends Post{
	String name, amount;
	
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
		this.name = name;
		this.amount = amount;
	}
	/**
	 * display donation
	 * @return donated organization and amount
	 */
	@Override
	public String toString() {
		return " donated $" + amount + " to " + "\'" + name + "\'";
	}
}
