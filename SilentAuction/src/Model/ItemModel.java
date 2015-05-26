package Model;

import java.awt.Image;
import java.util.ArrayList;



/**
 * The Class ItemModel, represents an item.
 * @author Audrey Chavarria 5/21/15
 *  
 */
public class ItemModel {
	
	/** The image associated with the item. */
	private Image image;
	
	/** The name of the item. */
	private String name;
	
	/** The donor who donated the item. */
	private Donor donor;
	
	/** The bid history of the item. */
	private ArrayList<Bid> bidHistory;
	
	/** The item number that uniquely identifies it. */
	private int itemNumber;
	
	private double startingPrice;
	
	
	/**
	 *  Constructor for the item.
	 *
	 * @param theName of the item
	 * @param theDonor of the item
	 * @param theItemNumber that uniquely identifies it
	 */
	public ItemModel(String theName, Donor theDonor, int theItemNumber, Image theImage, double thePrice){
		name = theName;
		donor = theDonor;
		bidHistory = new ArrayList<Bid>();
		itemNumber = theItemNumber;	
		image = theImage;
		startingPrice = thePrice;
	}	
	
	public Bid getHighBid() {
		return bidHistory.get(bidHistory.size() - 1);
	}
	
	public Image getImage() {
		return image;
	}
	
	public String getName() {
		return name;
	}
	
	public Donor getDonor() {
		return donor;
	}
	
	public int getNumber() {
		return itemNumber;
	}
	
	public ArrayList<Bid> getBidHistory() {
		return bidHistory;
	}
	
	public void addBid(Bid newBid) {
		bidHistory.add(newBid);
	}
	
	/**
	 * Gets the details.
	 *
	 * @return the details
	 */
	public void getDetails( ) {
	}
	
	/**
	 * Verify new bid.
	 *
	 * @param NewBid the new bid
	 * @return true, if successful
	 */
	//private boolean verifyNewBid(double NewBid ){
	//}
	
	/**
	 * Gets the max bid.
	 *
	 * @return the max bid
	 */
	//public Bid getMaxBid(){		
	//}
	
	/**
	 * Saveinfo.
	 */
	private void saveinfo(){		
	}
	
	/**
	 * Gets the bid history.
	 *
	 * @return the bid history
	 */
	//public void getBidHistory(){		
	//}

}
