package Impact;

/**
 * Superclass Post: creates methods for child class(PostWITHimage).
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/10/2019
 * **/
public class Post {
	String postMessage;
	int index;

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
		this.index = index;
		this.postMessage = message;
	}
	
	/**
	 * get index of the account
	 * @return posted account's index number
	 */
	public int getIndex() {
		return index;
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
		return "Post";
	}
}
