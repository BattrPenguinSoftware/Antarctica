package Model;

import java.util.ArrayList;
/*
 * import ItemModel 
 */
public class Bidder extends User{
	
	public static ItemModel item;
	
	//create arraylist to hold bidding history
	ArrayList<Bid> bidHistory = new ArrayList<Bid>();
	
	public ItemModel itemsBidOn(ItemModel item) {
		
		return item;
	}
	
	public ItemModel getItem() {
		
		return item;
	}
}
