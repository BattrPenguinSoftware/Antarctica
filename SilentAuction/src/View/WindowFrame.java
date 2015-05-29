package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * A custom-sized JFrame object to hold
 * components in the various Silent Auction
 * views.
 * 
 * @author reagan and tuan
 *
 */
@SuppressWarnings("serial")
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
		
		setJMenuBar(createMenuBar());
	}
	
	/**
	 * Create JMenu Bar for frame
	 * 
	 * @author tuan
	 */
	private JMenuBar createMenuBar() {
		final JMenuBar menuBar = new JMenuBar();
		
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
		//set up history 
		final JMenu historyMenu = new JMenu("History");
		historyMenu.setMnemonic(KeyEvent.VK_H);
		
		final JMenuItem donorHistory = new JMenuItem("Donor History");
		final JMenuItem bidderHistory = new JMenuItem("Bidder History");
		final JMenuItem auctioneerHistory = new JMenuItem("Auctioneer History");
		
		donorHistory.addActionListener(new ActionListener() {
			//showing history of donor actions
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		bidderHistory.addActionListener(new ActionListener() {
			//showing history of bidder
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		auctioneerHistory.addActionListener(new ActionListener() {
			//showing history of auctioneer
			//merge 2 Jpanels of donor and bidder into 1
			@Override
			public void actionPerformed(ActionEvent theEvent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		fileMenu.add(donate);
		fileMenu.add(exit);
		historyMenu.add(donorHistory);
		historyMenu.add(bidderHistory);
		historyMenu.add(auctioneerHistory);
		
		menuBar.add(fileMenu);
		menuBar.add(historyMenu);
		return menuBar;
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
		height = (int) (screenHeight * .93);
		
		//Center jFrame on screen
		setLocation((screenWidth / 2) - (width / 2), 0);
		
	}
}
