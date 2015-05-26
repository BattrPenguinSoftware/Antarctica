package View;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * A custom-sized JFrame object to hold
 * components in the various Silent Auction
 * views.
 * 
 * @author reagan
 *
 */
public class WindowFrame extends JFrame{

	/** the width of the frame **/
	private int width;
	
	/** the height of the frame **/
	private int height;
	
	/**
	 * Constructs an ItemFrame object
	 */
	public WindowFrame() {
		getDimensions();
		setSize(width, height);
		setTitle("Silent Auction");
	}
	
	/**
	 * Get custom dimensions based on the size of the user's screen
	 */
	private void getDimensions(){
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		
		//Set width & height as a proportion of screen width & height
		width = (int) (screenWidth * .5);
		height = (int) (screenHeight * .95);
		
		//Center jFrame on screen
		setLocation((screenWidth / 2) - (width / 2), 0);
		
	}
}
