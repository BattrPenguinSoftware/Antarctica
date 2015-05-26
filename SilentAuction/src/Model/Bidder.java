package Model;

import java.util.ArrayList;
/*
 * import ItemModel 
 */
public class Bidder extends User{
	
	public static ItemModel item;
	public String name;
	
	//create arraylist to hold bidding history
	ArrayList<Bid> bidHistory = new ArrayList<Bid>();
	
	public Bidder(String name){
		this.name = name;
	}
	
	public ItemModel itemsBidOn(ItemModel item) {
		
		return item;
	}
	
	public ItemModel getItem() {
		
		return item;
	}
	
	public String getName() {
		return name;
	}
	
}
