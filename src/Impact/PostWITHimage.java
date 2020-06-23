package Impact;

/**
 * Subclass Post with Image: creates methods to post with an Image.
 * @author Aimi Ross
 * @version 1.0.0
 * @since 10/10/2019
 * **/
public class PostWITHimage extends Post{
	private String postImage, locationOfImage;
	
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
		setImage(img);
		setLocationOfImage(lctn);
	}
	
	/**
	 * set image
	 * @param image definition
	 */
	public void setImage(String img) {
		this.postImage = img;
	}
	
	/**
	 * get image
	 * @return image
	 */
	public String getImage() {
		return this.postImage;
	}
	
	/**
	 * set location of image
	 * @param location of image
	 */
	public void setLocationOfImage(String lctn) {
		this.locationOfImage = lctn;
	}
	
	/**
	 * get location of image
	 * @return Location of image
	 */
	public String getLocationOfImage() {
		return this.locationOfImage;
	}
	
	/**
	 * display message
	 * @return message
	 */
	@Override
	public String toString() {
		return " posted image with message : \"" + this.getMessage() +"\"" + "\tPic: " + this.getImage() + "\tPic Location: " + this.getLocationOfImage() ;
	}
	
	/**
	 * getter
	 * @return post class name
	 */
	public String getPostClass() {
		return this.getClass().getName();
	}
}
