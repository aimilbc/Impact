package Impact;

/**
 * Superclass Post: creates methods for child class(PostWITHimage).
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/10/2019
 * **/
public class Post {
	private String postMessage;
	private int index;

	/**
	 * default constructor
	 */
	public Post(){}
	
	/**
	 * construct a post
	 * @param message : message
	 * @param image : image
	 */
	public Post(int index, String message){
		setIndex(index);
		setMessage(message);
	}
	
	/**
	 * set index
	 * @param index number
	 */
	private void setIndex(int ind) {
		this.index = ind;
	}
	
	/**
	 * get index of the account
	 * @return posted account's index number
	 */
	public int getIndex() {
		return this.index;
	}
	
	/**
	 * set message
	 * @param message
	 */
	private void setMessage(String msg) {
		this.postMessage = msg;
	}
	
	/**
	 * get message
	 * @return message
	 */
	public String getMessage() {
		return this.postMessage;
	}
	
	/**
	 * display message
	 * @return message
	 */
	public String toString() {
		return " posted message: \"" + postMessage + "\"";
	}
	
	/**
	 * getter
	 * @return post class name
	 */
	public String getPostClass() {
		return this.getClass().getName();
	}
}
