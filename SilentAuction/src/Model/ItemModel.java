 package Model;

import java.awt.Image;
import java.util.ArrayList;

/**
 * The Class ItemModel, represents an item.
 * 
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

	/** The current bid. */
	private double currentBid;
	
	/** the flag that tells whether the item is alcoholic. */
	private boolean isAlcoholic;

	/**
	 * Constructor for the item.
	 *
	 * @param theName            of the item
	 * @param theDonor            of the item
	 * @param theItemNumber            that uniquely identifies it
	 * @param theImage the image
	 * @param initialPrice the initial price
	 * @param isItADrink the is it a drink
	 */
	public ItemModel(String theName, Donor theDonor, int theItemNumber,
			Image theImage, double initialPrice, boolean isItADrink) {
		name = theName;
		donor = theDonor;
		bidHistory = new ArrayList<Bid>();
		itemNumber = theItemNumber;
		image = theImage;
		currentBid = initialPrice;
		isAlcoholic = isItADrink;

	}
	
	/**
	 * Checks if is alcoholic.
	 *
	 * @return true, if is alcoholic
	 */
	public boolean isAlcoholic(){
		return isAlcoholic;
	}

	/**
	 * Verify new bid and tells whether someone try to place a new bid, verify checks current
	 * bid price and says if its new bid is greater than current price
	 *
	 * @param newBid the new bid
	 * @return true, if successful
	 */
	public boolean verifyNewBid(double newBid) {
		return newBid > currentBid;
	}

	/**
	 * Place new bid.
	 *
	 * @param theNewBid the the new bid
	 */
	public void placeNewBid(Bid theNewBid) {
		// add to end of arryalsit, and update current highest bid
		bidHistory.add(theNewBid);
		currentBid = theNewBid.getAmount();

	}

	/**
	 * Gets the entire bid history. 
	 * 
	 * @return the bid history
	 */
	public ArrayList<Bid> getBidHistory() {
		return bidHistory;
	}

	/**
	 * Gets the latest max bid.
	 * 
	 * @return the max bid
	 */
	public Bid getMaxBid() {
		return bidHistory.get(bidHistory.size() - 1);
	}

	/**
	 * Gets the current bid price.
	 *
	 * @return the current bid price
	 */
	public double getCurrentBidPrice() {
		return currentBid;
	}

	/**
	 * Gets the unique item number.
	 *
	 * @return the item number
	 */
	public int getItemNumber() {
		return itemNumber;
	}

	/**
	 * Gets the image of the item.
	 *
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Gets the name of the item.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the donor of the item.
	 *
	 * @return the donor
	 */
	public Donor getDonor() {
		return donor;
	}

}
