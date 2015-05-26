package View;

import java.awt.event.WindowEvent;

import javax.swing.JFrame;

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
	
	
	/**
	 * Closes the current view
	 */
	public void close(){
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
}
