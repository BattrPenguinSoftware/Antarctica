package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
	
	private JFrame myFrame;
	
	/**
	 * Constructs an ItemFrame object
	 */
	public WindowFrame() {
		getDimensions();
		setSize(width, height);
		setTitle("Silent Auction");
		
		setJMenuBar(createMenuBar());
	}
	/*
	 * Create JMenu Bar for frame
	 */
	private JMenuBar createMenuBar() {
		final JMenuBar fileMenuBar = new JMenuBar();
		
		//setup file menubar
		final JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		//exit
		final JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				//Exit the Window Frame
				System.exit(0);
			}
			
		});
		
		//donate item
		final JMenuItem donate = new JMenuItem("Donate Item");
		donate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent donateEvent) {
				// add donate event for donor
				
			}
			
		});
		
		fileMenu.add(donate);
		fileMenu.add(exit);
		
		fileMenuBar.add(fileMenu);
		return fileMenuBar;
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
