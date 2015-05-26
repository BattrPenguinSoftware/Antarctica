package Controller;

import java.util.ArrayList;

import Model.Auction;
import Model.Bid;
import Model.ItemModel;
import View.AbstractView;
import View.ItemView;
import View.PlaceBidView;


/** The controller handles user input events like mouse clicks and keystrokes **/
public class ItemController {
	
	ArrayList<ItemModel> allItems;
	ItemModel currentItem;
	AbstractView currentView;
	
	
	public ItemController(Auction theAuction) {
		allItems = theAuction.getItems();
		
		if (allItems.size() > 0){
			currentItem = allItems.get(0);
		} else {
			throw new IllegalArgumentException("This Auction "
					+ "does not have any items in it");
		}
		
		currentView = new ItemView(this, currentItem);
		
	}
	
	
	public void placeBid() {
		currentView.close();
		currentView = new PlaceBidView(this);
		
		
		
	}
	
	
	
	
}