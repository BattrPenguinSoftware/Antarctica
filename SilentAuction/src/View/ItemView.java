package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Controller.ItemController;
import Model.Bid;
import Model.Donor;
import Model.ItemModel;
import Model.User;

/**
 * Displays an Item's details and gives
 * the user an option to place a bid.
 * 
 * @author reagan
 *
 */
public class ItemView extends AbstractView{
	
	/** The frame that holds the JPanel that holds all visible components. */
	private WindowFrame frame;
	
	/** The JPanel that sits on the frame. */
	private JPanel pane;
	
	/** The item's picture. */
	private ItemPictureComponent itemPic;
	
	/** The item's name. */
	private JLabel itemName;
	
	/** The item's number. */
	private JLabel itemNumber;
	
	/** The donor's name. */
	private JLabel donorName;
	
	/** The donor's logo. */
	private LogoPictureComponent donorLogo;
	
	/** The bid history panel. */
	private JPanel bidHistoryPanel;
	
	/** The item controller that handles the logic. */
	private ItemController iController;
	
	
	/**
	 *  
	 * Creates an ItemView object and initializes
	 * it to display the given item.
	 *
	 * @param iController the i controller
	 * @param firstItem the item to initially display
	 */
	public ItemView(ItemController iController, ItemModel firstItem) {
		super();
		this.iController = iController;
		frame = super.getFrame();
		createPane();
		frame.add(pane);
		
		initializeView(firstItem);

	}
	

	
	/**
	 * A helper method that loads and displays the item details,
	 * including picture, item name and number,
	 * and bid history.
	 * 
	 * @param theItem the item currently being displayed
	 */
	private void initializeView(ItemModel theItem){
		//add item picture to view
		itemPic = new ItemPictureComponent(theItem.getImage());
		GBC picConstraints = new GBC(1, 1, 3, 3);
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
		
		//add item details (number, donor, donor pic)
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

	/**
	 * Helper method that's in charge of creating the JPanel
	 * for the item# and donor info.
	 *
	 * @param theItem the item whose details are being displayed
	 * @return the JPanel containing this info
	 */
	private JPanel createItemDetailPanel(ItemModel theItem){
		JPanel deets = new JPanel();
		deets.setLayout(new GridLayout(3,1));
		
		//add item number
		String numberString = "Item # " + theItem.getItemNumber();
		itemNumber = new JLabel(numberString);
		itemNumber.setFont(itemNumber.getFont().deriveFont(20.0f));
		deets.add(itemNumber);
		
		//add donor name
		Donor theDonor = theItem.getDonor();
		
		String donorString = "Donated by " + theDonor.getCompany();
		donorName = new JLabel(donorString);
		donorName.setFont(donorName.getFont().deriveFont(18.0f));
		deets.add(donorName);
		
		//add donor logo
		donorLogo = new LogoPictureComponent(theDonor.getLogo());
		deets.add(donorLogo);
		
		return deets;
	}
	
	
	/**
	 * Creates the JPanel that will hold all the components being displayed.
	 */
	private void createPane() {
		
		GridBagLayout layout = new GridBagLayout();
		
		pane = new JPanel(layout);
		pane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		//Add "Place a bid button" to view
		GBC buttonConstraints = new GBC(0, 13, 6, 1);
		buttonConstraints.setFill(GridBagConstraints.BOTH);
		buttonConstraints.setWeight(100,10);
		JButton bidButton = new JButton("Place a Bid");
		bidButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				iController.launchPlaceBidView();
				
			}
			
		});
		pane.add(bidButton, buttonConstraints);
		
	}
	
	
		
	/**
	 * A JPanel to display the item's
	 * bid history, including current
	 * high bidder.
	 *
	 * @author reagan
	 */
	@SuppressWarnings("serial")
	class BidHistoryComponent extends JPanel{
		
		/**  The entire bid history *. */
		ArrayList<Bid> theBids;
		
		/**  a JPanel to hold the highest bid *. */
		JPanel highBidPanel;
		
		/**  a JLabel to hold the highest amount *. */
		JLabel winningAmount;
		
		/**  a JLabel to hold the name of the highest bidder *. */
		JLabel winningName;
		
		/**  a JPanel to display the recent bid history*. */
		JPanel historyPanel;
		
		/**
		 * Creates a BidHistoryComponent object from the given bid history.
		 *
		 * @param theBids the bid history
		 */
		public BidHistoryComponent(ArrayList<Bid> theBids) {
			
			
			this.theBids = theBids;
			
			loadHighBid();
			loadRecentBids();
			
			
		}
		
		/**
		 * Finds and displays the highest bid.
		 */
		public void loadHighBid(){
			highBidPanel = new JPanel();
			
			
			if (theBids.size() > 0){
				Bid highBid = theBids.get(theBids.size() - 1);
				
				//Add highest amount
				winningAmount = new JLabel();
				winningAmount.setText(String.format("$%.2f", highBid.getAmount()));
				winningAmount.setFont(winningAmount.getFont().deriveFont(26.0f));
				highBidPanel.add(winningAmount, BorderLayout.WEST);
				
				//Add name of Bidder with highest amount
				winningName = new JLabel(((User) highBid.getBidders()).getName());
				winningName.setFont(winningAmount.getFont().deriveFont(26.0f));
				highBidPanel.add(winningName, BorderLayout.CENTER);
				
			}
			//Outline highest bid
			Border matte = BorderFactory.createEtchedBorder(Color.GREEN, Color.WHITE);
			highBidPanel.setBorder(matte);
			this.add(highBidPanel, BorderLayout.NORTH);
			
		}
		
		/**
		 * Load and display the other most recent bids.
		 */
		public void loadRecentBids(){
			historyPanel = new JPanel();
			historyPanel.setLayout(new BoxLayout(historyPanel, BoxLayout.Y_AXIS));
			Border etched = BorderFactory.createEtchedBorder();
			setBorder(etched);
			
			int i = theBids.size() - 2;
			while(i >= 0 && theBids.size() - 7 < i){
				JPanel currentPanel = new JPanel();
				Bid currentBid = theBids.get(i);
				//Load bid amount
				JLabel amount = new JLabel();
				amount.setText(String.format("$%.2f", currentBid.getAmount()));
				amount.setFont(amount.getFont().deriveFont(18.0f));
				currentPanel.add(amount, BorderLayout.WEST);
				//Load bidder's name
				JLabel name = new JLabel(((User) currentBid.getBidders()).getName());
				name.setFont(name.getFont().deriveFont(18.0f));
				currentPanel.add(name, BorderLayout.CENTER);
				historyPanel.add(currentPanel);
				i--;
				
			}
			historyPanel.setSize(historyPanel.getPreferredSize());
			this.add(historyPanel, BorderLayout.CENTER);
		}
		
		
		
	}
	
	/**
	 * A JComponent class for storing and painting
	 * the Item's picture. 
	 * 
	 * @author reagan
	 *
	 */
	@SuppressWarnings("serial")
	class ItemPictureComponent extends JComponent{
		//TODO: Adjust these so they're relative to the user's screen
		/**  the width of the picture *. */
		private int width = 300;
		
		/**  the height of the picture *. */
		private int height = 300;
		
		/**  the image itself *. */
		private Image theImage;
		
		
		/**
		 * Creates an ItemPictureComponent from the given image.
		 *
		 * @param pic the image to be displayed
		 */
		public ItemPictureComponent(Image pic){
			theImage = pic;
		}
		
		/**
		 *  
		 * Sets a new image for the item.
		 *
		 * @param newPic the new picture
		 */
		public void setImage(Image newPic){
			theImage = newPic;
		}
		
		/**
		 * Draws the item image.
		 *
		 * @param g the g
		 */
		public void paintComponent(Graphics g){

			
			g.drawImage(theImage, 0, 0, width, height, null);
			
			
		}
		
		/**
		 * Gets the preferred size of the image.
		 *
		 * @return the preferred size
		 */
		public Dimension getPreferredSize() {
			return new Dimension(width, height);
		}
	}
	
	/**
	 * A JComponent class for storing and painting
	 * the Donor's company logo. 
	 * 
	 * 
	 * @author Reagan
	 *
	 */
	@SuppressWarnings("serial")
	class LogoPictureComponent extends JComponent{
		
		/**  the width of the logo *. */
		private int width = 100;
		
		/**  the height of the logo *. */
		private int height = 100;
		
		/**  the image of the logo *. */
		private Image theImage;
		
		
		/**
		 * Creates a logo JComponent from a given image.
		 *
		 * @param pic the logo image
		 */
		public LogoPictureComponent(Image pic){
			theImage = pic;
		}
		
		/**
		 * Sets the logo image.
		 *
		 * @param newPic the new picture
		 */
		public void setImage(Image newPic){
			theImage = newPic;
		}
		
		/**
		 * Draw the logo.
		 *
		 * @param g the g
		 */
		public void paintComponent(Graphics g){
			
			g.drawImage(theImage, 0, 0, width, height, null);
			
			
		}
		
		/**
		 * Gets the preferred size of the logo.
		 *
		 * @return the preferred size
		 */
		public Dimension getPreferredSize() {
			return new Dimension(width, height);
		}
	}
	

}