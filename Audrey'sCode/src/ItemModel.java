
public class ItemModel {
	
	/** The image associated witht the item. */
	private File image;
	
	/** The name of the item. */
	private String name;
	
	/** The donor who donated the item. */
	private DonorModel donor;
	
	/** The bid history of the item. */
	private Bid[] bidHistory;
	
	/** The item number that uniquely identifies it. */
	private int itemNumber;
	
	
	/** Constructor for the item. */
	public ItemModel(String theName, DonorModel theDonor, int theItemNumber){
		name = theName;
		donor = theDonor;
		bidHistory = {null};
		itemNumber = theItemNumber;	
	}	
	
	public void getDetials( ) {
	}
	
	private boolean verifyNewBid(double NewBid ){
	}
	
	public Bid getMaxBid(){		
	}
	
	private void saveinfo(){		
	}
	
	public void getBidHistory(){		
	}

}
