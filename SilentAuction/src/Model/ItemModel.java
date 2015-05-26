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

	private double currentBid;

	/**
	 * Constructor for the item.
	 *
	 * @param theName
	 *            of the item
	 * @param theDonor
	 *            of the item
	 * @param theItemNumber
	 *            that uniquely identifies it
	 */
	public ItemModel(String theName, Donor theDonor, int theItemNumber,
			Image theImage, double initialPrice) {
		name = theName;
		donor = theDonor;
		bidHistory = new ArrayList<Bid>();
		itemNumber = theItemNumber;
		image = theImage;
		currentBid = initialPrice;

	}

	/**
	 * Verify new bid. somoneone try to place a new bid, verify checks current
	 * bid price and says if its is new bidd is greater than current price
	 * 
	 * @param NewBid
	 *            the new bid
	 * @return true, if successful
	 */
	private boolean verifyNewBid(double newBid) {
		return newBid > currentBid;
	}

	// add to end of arryalsit, and update current highest bid
	public void placeNewBid(Bid theNewBid) {
		bidHistory.add(theNewBid);
		currentBid = theNewBid.getAmount();

	}

	// ///////////////////////////
	/**
	 * Saveinfo. worry about it later
	 */
	private void saveinfo() {
	}// ////////////////////////////

	/**
	 * Gets the bid history. return whole arraylist
	 * 
	 * @return the bid history
	 */
	public ArrayList<Bid> getBidHistory() {
		return bidHistory;
	}

	/**
	 * Gets the max bid. return latest bid obj from araylist
	 * 
	 * @return the max bid
	 */
	public Bid getMaxBid() {
		return bidHistory.get(bidHistory.size() - 1);
	}

	public void getCurrentBid() {
	}

	public void getItemNumber() {
	}

	public void getImage() {
	}

	public void getName() {
	}

	public void getDonor() {
	}

}
