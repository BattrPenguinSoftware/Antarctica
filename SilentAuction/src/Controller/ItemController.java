package Controller;

import java.util.ArrayList;

import Model.Auction;
import Model.Bid;
import Model.Bidder;
import Model.ItemModel;
import View.AbstractView;
import View.ConfirmBidView;
import View.ItemView;
import View.PlaceBidView;

/**
 * The controller handles user input events like mouse clicks and keystrokes
 * 
 * @author reagan
 */
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
		
		launchItemView();

	}
	
	
	public void placeBid() {
		currentView.close();
		currentView = new PlaceBidView(currentItem.getMaxBid().getAmount(), this);

	}
	
	public void verifyBid(Double newAmount){
		
		if (currentItem.verifyNewBid(newAmount)){
			confirmBid(newAmount);
		} else {	
			((PlaceBidView) currentView).bidHigher(newAmount);
		}
	}
	
	public void confirmBid(Double newAmount) {
		
		Bidder theBidder = ((PlaceBidView) currentView).getBidder();
		currentView.close();
		currentView = new ConfirmBidView(new Bid(newAmount, theBidder, currentItem), this);
	}


	public void cancelBid() {
		currentView.close();
		launchItemView();
		
	}
	
	public void placeBidAndRefreshView(Bid theBid){
		currentItem.placeNewBid(theBid);
		currentView.close();
		launchItemView();
		
	}
	
	private void launchItemView(){
		if (currentView != null){
			currentView.close();
		}
		currentView = new ItemView(this, currentItem);
	}
	
	
	
	
}