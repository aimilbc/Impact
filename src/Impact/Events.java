package Impact;

/**
 * Subclass Post with Image: creates methods to post event.
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/10/2019
 * **/
public class Events extends Post {
	private String eventName, eventFrom;
	private int amount;
	private static int volunteersCount = 0;
	
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
		super(index, "");
		setEventName(eventName);
		setFrom(from);
		volunteersCount++;
		amount = volunteersCount;
	}
	
	/**
	 * setting event Name
	 * @param event name
	 */
	public void setEventName(String event) {
		this.eventName = event;
	}
	
	/**
	 * getter event name
	 * @return event name
	 */
	public String getEventName() {
		return this.eventName;
	}
	
	/**
	 * setting set event from date
	 * @param from
	 */
	public void setFrom(String from) {
		this.eventFrom = from;
	}
	
	/**
	 * getter date of the event
	 * @return starting date of the event
	 */
	public String getDate() {
		return this.eventFrom;
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
	 * getter for class name
	 * @return post class name
	 */
	public String getPostClass() {
		return this.getClass().getName();
	}
	
}
