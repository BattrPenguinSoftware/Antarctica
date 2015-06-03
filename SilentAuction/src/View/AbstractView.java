package View;


import javax.swing.JFrame;

/**
 * An abstract class to create the frame
 * for all of our views.
 * 
 * 
 * @author reagan
 * @date 6/2/15
 */
public abstract class AbstractView {
	
	/** The frame. */
	private WindowFrame frame;
	
	
	/**
	 * Instantiates a new abstract view.
	 */
	public AbstractView(){
		createFrame();
	}
	
	/**
	 * A helper method to create the JFrame to hold all the View
	 * components.
	 */
	private void createFrame() {
		frame = new WindowFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		frame.setVisible(true);
	}
	
	/**
	 * Gets the frame.
	 *
	 * @return the frame
	 */
	public WindowFrame getFrame() {
		return frame;
	}
	
	
	/**
	 * Closes the current view.
	 */
	public void close(){
		frame.dispose();
	}

	
}
