package View;


import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class AbstractView {
	
	private WindowFrame frame;
	
	
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
	
	public WindowFrame getFrame() {
		return frame;
	}
	
	
	/**
	 * Closes the current view
	 */
	public void close(){
		frame.dispose();
	}

	
}
