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
	//AbstractView currentView;
	ItemView iView;
	PlaceBidView pView;
	
	
	public ItemController(Auction theAuction) {
		allItems = theAuction.getItems();
		
		if (allItems.size() > 0){
			currentItem = allItems.get(0);
		} else {
			throw new IllegalArgumentException("This Auction "
					+ "does not have any items in it");
		}
		
		iView = new ItemView(this, currentItem);
		pView = null;
	}
	
	
	public void placeBid() {
		iView.close();
		pView = new PlaceBidView(currentItem.getHighBid().getAmount(), this);
		
		
		
	}
	
	public void verifyBid(Double newAmount){
		Boolean valid = newAmount > currentItem.getHighBid().getAmount();
		
		if (valid){
			confirmBid(newAmount);
		} else {
			
			pView.bidHigher(newAmount);
		}
	}
	
	public void confirmBid(Double newAmount) {
		pView.close();
		//currentView = new ConfirmBidView(newAmount);
	}


	public void cancelBid() {
		pView.close();
		iView = new ItemView(this, currentItem);
		
	}
	
	
	
	
}