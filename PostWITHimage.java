package Impact;

/**
 * Subclass Post with Image: creates methods to post with an Image.
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/10/2019
 * **/
public class PostWITHimage extends Post{
	String postImage, locationOfImage;
	
	/**
	 * default constructor
	 */
	public PostWITHimage() {}
	
	/**
	 * construct a post with an image
	 * @param msg: message
	 * @param img: image
	 * @param lctn: location of image
	 */
	public PostWITHimage(int index, String msg, String img, String lctn) {
		super(index, msg);
		this.postImage = img;
		this.locationOfImage = lctn;
	}
	
	/**
	 * display message
	 * @return message
	 */
	@Override
	public String toString() {
		return " posted image with message : \"" + postMessage +"\"" + "\tPic: " + postImage + "\tPic Location: " + locationOfImage ;
	}
	
	/**
	 * getter
	 * @return post class name
	 */
	public String getPostClass() {
		return "PostWITHimage";
	}
}
