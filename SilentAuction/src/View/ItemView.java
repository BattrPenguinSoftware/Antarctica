package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Model.Bid;
import Model.Donor;
import Model.ItemModel;
import Model.User;


public class ItemView {
	
	private ItemFrame frame;
	private JPanel pane;
	private ItemPictureComponent itemPic;
	private JLabel itemName;
	private JLabel itemNumber;
	private JLabel donorName;
	private LogoPictureComponent donorLogo;
	private JPanel bidHistoryPanel;
	
	
	public ItemView(ItemModel firstItem) {
		
		createFrame();
		createPane();
		frame.add(pane);
		
		setItemDetails(firstItem);
		
		
		
		
		
	}
	
	private void setItemDetails(ItemModel theItem){
		//add item picture to view
		itemPic = new ItemPictureComponent(theItem.getImage());
		GBC picConstraints = new GBC(1, 1, 3, 3);
		//picConstraints.setWeight(0, 0);
		picConstraints.setFill(GridBagConstraints.BOTH);
		pane.add(itemPic, picConstraints);
		
		//add item name
		GBC nameConstraints = new GBC(1, 0, 6, 1);
		nameConstraints.setFill(GridBagConstraints.BOTH);
		nameConstraints.setWeight(0,0);
		//TODO: Adjust so it's based off screen size
		nameConstraints.setInsets(5,150,15,0);
		itemName = new JLabel(theItem.getName());
		itemName.setFont(itemName.getFont().deriveFont(28.0f));
		pane.add(itemName, nameConstraints);
		
		
		GBC itemDetailConstraints = new GBC(4, 1, 2, 3);
		itemDetailConstraints.setFill(GridBagConstraints.VERTICAL);
		itemDetailConstraints.setWeight(00,00);
		itemDetailConstraints.setInsets(30);
		JPanel itemDetails = createItemDetailPanel(theItem);
		pane.add(itemDetails, itemDetailConstraints);
		
		//add bids
		GBC bidConstraints = new GBC(1, 6, 5, 5);
		bidConstraints.setFill(GridBagConstraints.BOTH);
		bidConstraints.setWeight(100,50);
		//TODO: Adjust so it's based off screen size
		bidConstraints.setInsets(5,70,10,70);
		bidHistoryPanel = new BidHistoryComponent(theItem.getBidHistory());
		
		pane.add(bidHistoryPanel, bidConstraints);
	}
	
	private JPanel createItemDetailPanel(ItemModel theItem){
		JPanel deets = new JPanel();
		deets.setLayout(new GridLayout(3,1));
		
		//add item number
		//BC numberConstraints = new GBC(4, 2, 2, 1);
		//numberConstraints.setFill(GridBagConstraints.NONE);
		//numberConstraints.setWeight(0,0);
		String numberString = "Item # " + theItem.getNumber();
		itemNumber = new JLabel(numberString);
		itemNumber.setFont(itemNumber.getFont().deriveFont(20.0f));
		deets.add(itemNumber);
		//pane.add(itemNumber, numberConstraints);
		
		//add donor name
		Donor theDonor = theItem.getDonor();
		
		//GBC donorConstraints = new GBC(4, 3, 2, 1);
		//donorConstraints.setFill(GridBagConstraints.NONE);
		//donorConstraints.setWeight(0,0);
		String donorString = "Donated by " + theDonor.getCompany();
		donorName = new JLabel(donorString);
		donorName.setFont(donorName.getFont().deriveFont(18.0f));
		//pane.add(donorName, donorConstraints);
		deets.add(donorName);
		
		//add donor logo
//				GBC logoConstraints = new GBC(4, 4, 2, 2);
//			logoConstraints.setFill(GridBagConstraints.BOTH);
//		logoConstraints.setWeight(0,0);
		//logoConstraints.setInsets(2);
		donorLogo = new LogoPictureComponent(theDonor.getLogo());
	//	pane.add(donorLogo, logoConstraints);
		deets.add(donorLogo);
		
		return deets;
	}
	
	
	private void createPane() {
		
		GridBagLayout layout = new GridBagLayout();
		
		pane = new JPanel(layout);
		pane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		//Add "Place a bid button" to view
		GBC buttonConstraints = new GBC(0, 13, 6, 1);
		//buttonConstraints.setInsets(1, 0, 0, 0);
		buttonConstraints.setFill(GridBagConstraints.BOTH);
		buttonConstraints.setWeight(100,10);
		//buttonConstraints.setInsets(0,150,0,0);
		JButton bidButton = new JButton("Place a Bid");
		pane.add(bidButton, buttonConstraints);
		
		
		
		
	}
	
	/**
	 * A helper method to create the JFrame to hold all the ItemView
	 * components.
	 */
	private void createFrame() {
		frame = new ItemFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		

		
		frame.setVisible(true);
	}
	
	/**
	 * Refreshes the view with the most current item details
	 * 
	 * @param theItem the item being displayed
	 */
	public void updateView(ItemModel theItem) {
		
		itemPic.setImage(theItem.getImage());
		//redraw components
	}
	
	public void greetUser(User theUser){
		
	}
	
	public void startBidView() {
		
	}
	
	public void startConfirmationView() {
		
	}
	
	public void startAdminView() {
		
	}
	
	@SuppressWarnings("serial")
	class BidHistoryComponent extends JPanel{
		
		ArrayList<Bid> theBids;
		JPanel highBidPanel;
		JLabel winningAmount;
		JLabel winningName;
		JPanel historyPanel;
		
		
		public BidHistoryComponent(ArrayList<Bid> theBids) {
			
			
			this.theBids = theBids;
			
			loadHighBid();
			loadRecentBids();
			
			
		}
		
		public void loadHighBid(){
			highBidPanel = new JPanel();
			
			
			if (theBids.size() > 0){
				Bid highBid = theBids.get(theBids.size() - 1);
				
				String amountString = "$" + highBid.getAmount();
				winningAmount = new JLabel(amountString);
				winningAmount.setFont(winningAmount.getFont().deriveFont(26.0f));
				highBidPanel.add(winningAmount, BorderLayout.WEST);
				
				winningName = new JLabel(highBid.getBidder().getName());
				winningName.setFont(winningAmount.getFont().deriveFont(26.0f));
				highBidPanel.add(winningName, BorderLayout.CENTER);
				
			}
			Border matte = BorderFactory.createEtchedBorder(Color.GREEN, Color.WHITE);
			highBidPanel.setBorder(matte);
			this.add(highBidPanel, BorderLayout.NORTH);
			
		}
		
		public void loadRecentBids(){
			historyPanel = new JPanel();
			historyPanel.setLayout(new BoxLayout(historyPanel, BoxLayout.Y_AXIS));
			Border etched = BorderFactory.createEtchedBorder();
			setBorder(etched);
			
			int i = theBids.size() - 2;
			while(i >= 0 && theBids.size() - 7 < i){
				JPanel currentPanel = new JPanel();
				Bid currentBid = theBids.get(i);
				String amtString = "$" + currentBid.getAmount();
				JLabel amount = new JLabel(amtString);
				amount.setFont(amount.getFont().deriveFont(18.0f));
				currentPanel.add(amount, BorderLayout.WEST);
				JLabel name = new JLabel(currentBid.getBidder().getName());
				name.setFont(name.getFont().deriveFont(18.0f));
				currentPanel.add(name, BorderLayout.CENTER);
				historyPanel.add(currentPanel);
				i--;
				
			}
			historyPanel.setSize(historyPanel.getPreferredSize());
			this.add(historyPanel, BorderLayout.CENTER);
		}
		
		
		
		
		
	}
	
	@SuppressWarnings("serial")
	class ItemPictureComponent extends JComponent{
		//TODO: Adjust these so they're relative to the user's screen
		private int width = 300;
		private int height = 300;
		private Image theImage;
		
		
		public ItemPictureComponent(Image pic){
			theImage = pic;
		}
		
		public void setImage(Image newPic){
			theImage = newPic;
		}
		
		public void paintComponent(Graphics g){
			int imageWidth = theImage.getWidth(this);
			int imageHeight = theImage.getHeight(this);
			
			g.drawImage(theImage, 0, 0, width, height, null);
			
			
		}
		
		public Dimension getPreferredSize() {
			return new Dimension(width, height);
		}
	}
	
	@SuppressWarnings("serial")
	class LogoPictureComponent extends JComponent{
		private int width = 100;;
		private int height = 100;;
		private Image theImage;
		
		
		public LogoPictureComponent(Image pic){
			theImage = pic;
		}
		
		public void setImage(Image newPic){
			theImage = newPic;
		}
		
		public void paintComponent(Graphics g){
			int imageWidth = theImage.getWidth(this);
			int imageHeight = theImage.getHeight(this);
			
			g.drawImage(theImage, 0, 0, 100, 100, null);
			
			
		}
		
		public Dimension getPreferredSize() {
			return new Dimension(width, height);
		}
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