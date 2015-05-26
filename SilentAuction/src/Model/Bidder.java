package Model;

import java.util.ArrayList;
/*
 * import ItemModel 
 */
public class Bidder extends User{
	
	public static ItemModel item;
	
	//create arraylist to hold bidding history
	ArrayList<Bid> bidHistory = new ArrayList<Bid>();
	
	public ArrayList<Bid> itemsBidOn() {
		
		return bidHistory;
	}
	
	public ItemModel getItem() {
		
		return item;
	}
}
