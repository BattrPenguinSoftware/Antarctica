package View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;

import Model.ItemModel;
import Model.User;


public class ItemView {
	
	ItemFrame theFrame;
	
	
	public ItemView(ItemModel firstItem) {
		
		createFrame();
		
		
		updateView(firstItem);
		
	}
	
	/**
	 * A helper method to create the JFrame to hold all the ItemView
	 * components.
	 */
	private void createFrame() {
		theFrame = new ItemFrame();
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setResizable(false);
		
		//Add all frame components
		theFrame.add(new ItemDetailsComponent());
		
		
		theFrame.setVisible(true);
	}
	
	/**
	 * Refreshes the view with the most current item details
	 * 
	 * @param theItem the item being displayed
	 */
	public void updateView(ItemModel theItem) {
		
	}
	
	public void greetUser(User theUser){
		
	}
	
	public void startBidView() {
		
	}
	
	public void startConfirmationView() {
		
	}
	
	public void startAdminView() {
		
	}
	
	class ItemDetailsComponent extends JComponent{
		
		public static final int theX = 75;
		public static final int theY = 100;
		public static final int height = 300;
		public static final int width = 200;
		
		public void paintComponent(Graphics g) {
			g.drawString("Item title and other things", theX, theY);
		}
		
		public Dimension getPreferredSize() {
			return new Dimension(width, height);
		}
		
	}
	
	class ItemFrame extends JFrame {
		
		private int width;
		private int height;
		
		public ItemFrame() {
			getDimensions();
			setSize(width, height);
			setTitle("Silent Auction");
		}
		
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
	
}