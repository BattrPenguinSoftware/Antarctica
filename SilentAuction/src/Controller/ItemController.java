package Controller;

import java.util.ArrayList;

import Model.Auction;
import Model.Bid;
import Model.ItemModel;
import View.ItemView;


/** The controller handles user input events like mouse clicks and keystrokes **/
public class ItemController {
	
	ArrayList<ItemModel> allItems;
	ItemModel currentItem;
	
	
	public ItemController(Auction theAuction) {
		allItems = theAuction.getItems();
		
		if (allItems.size() > 0){
			currentItem = allItems.get(0);
		} else {
			throw new IllegalArgumentException("This Auction "
					+ "does not have any items in it");
		}
		
		ItemView iView = new ItemView(currentItem);
		
	}
	
	
	//public Bid placeBid() {
		
	//}
	
	
	
	
}