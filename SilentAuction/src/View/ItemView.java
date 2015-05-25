package View;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import Model.User;


public class ItemView {
	
	ItemFrame theFrame;
	
	
	public ItemView() {
		
		
		theFrame = new ItemFrame();
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setVisible(true);
		theFrame.setResizable(false);
		
		
	}
	
	public void greetUser(User theUser){
		
	}
	
	public void startBidView() {
		
	}
	
	public void startConfirmationView() {
		
	}
	
	public void startAdminView() {
		
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