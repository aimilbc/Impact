package Impact;

/**
 * Subclass Post with Image: creates methods to post event.
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/10/2019
 * **/
public class Events extends Post {
	String eventName, eventFrom;
	int amount;
	static int volunteersCount = 0;
	
	/**
	 * a default constructor
	 */
	public Events() {}
	
	/**
	 * a constructor
	 * @param userName
	 * @param eventName
	 */
	public Events(int index, String eventName, String from) {
		super.index = index;
		this.eventName = eventName;
		this.eventFrom = from;
		volunteersCount++;
		amount = volunteersCount;
	}
	
	/**
	 * getter
	 * @return starting date of the event
	 */
	public String getDate() {
		return eventFrom;
	}
	
	/**
	 * display event
	 * @return who joined what event
	 */
	@Override
	public String toString() {
		return " joined \"" + eventName + "\" now has " + amount + " registerd volunteeres. Please join us!!!!" ;
	}
	/**
	 * getter
	 * @return post class name
	 */
	public String getPostClass() {
		return "Evennts";
	}
	
}
