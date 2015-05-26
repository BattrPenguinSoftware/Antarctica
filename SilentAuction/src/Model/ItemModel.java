package Model;
/**
 * The Class ItemModel, represents an item.
 * @author Audrey Chavarria 5/21/15
 *  
 */
public class ItemModel {
	
	/** The image associated witht the item. */
	private File image;
	
	/** The name of the item. */
	private String name;
	
	/** The donor who donated the item. */
	private Donor donor;
	
	/** The bid history of the item. */
	private Bid[] bidHistory;
	
	/** The item number that uniquely identifies it. */
	private int itemNumber;
	
	
	/**
	 *  Constructor for the item.
	 *
	 * @param theName of the item
	 * @param theDonor of the item
	 * @param theItemNumber that uniquely identifies it
	 */
	public ItemModel(String theName, Donor theDonor, int theItemNumber){
		name = theName;
		donor = theDonor;
		bidHistory = {null};
		itemNumber = theItemNumber;	
	}	
	
	/**
	 * Gets the detials.
	 *
	 * @return the detials
	 */
	public void getDetials( ) {
	}
	
	/**
	 * Verify new bid.
	 *
	 * @param NewBid the new bid
	 * @return true, if successful
	 */
	private boolean verifyNewBid(double NewBid ){
	}
	
	/**
	 * Gets the max bid.
	 *
	 * @return the max bid
	 */
	public Bid getMaxBid(){		
	}
	
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
	public void getBidHistory(){		
	}

}
