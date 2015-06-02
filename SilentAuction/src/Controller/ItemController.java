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
 * The controller handles user input events like mouse clicks and keystrokes.
 *
 * @author reagan
 */
public class ItemController {
	
	/** A list of all items in the auction. */
	ArrayList<ItemModel> allItems;
	
	/** The current item. */
	ItemModel currentItem;
	
	/** The current view. */
	AbstractView currentView;
	
	/**
	 * Instantiates a new item controller.
	 *
	 * @param theAuction the auction
	 */
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
	
	
	/**
	 * Starts the view that allows a user to place a bid.
	 */
	public void launchPlaceBidView() {
		currentView.close();
		currentView = new PlaceBidView(currentItem.getMaxBid().getAmount(), this);

	}
	
	/**
	 * Verifies whether a new bid amount is valid (greater than
	 * the previous high bid amount).
	 *
	 * @param newAmount the new amount
	 */
	public void verifyBid(Double newAmount){
		
		if (currentItem.verifyNewBid(newAmount)){
			launchConfirmBidView(newAmount);
		} else {	
			((PlaceBidView) currentView).bidHigher(newAmount);
		}
	}
	
	public boolean isAlcoholic(){
		return currentItem.isAlcoholic();
	}
	
	/**
	 * Launches the view that lets a user confirm their bid or cancel it.
	 *
	 * @param newAmount the new amount
	 */
	public void launchConfirmBidView(Double newAmount) {
		
		Bidder theBidder = ((PlaceBidView) currentView).getBidder();
		currentView.close();
		currentView = new ConfirmBidView(new Bid(newAmount, theBidder, currentItem), this);
	}


	/**
	 * Returns the user to the main
	 * ItemView.
	 */
	public void cancelBid() {
		currentView.close();
		launchItemView();
		
	}
	
	/**
	 * Place the bid and return to the main
	 * ItemView, showing the new high bid.
	 *
	 * @param theBid the bid being placed
	 */
	public void placeBidAndRefreshView(Bid theBid){
		currentItem.placeNewBid(theBid);
		currentView.close();
		launchItemView();
		
	}
	
	/**
	 * Launch the basic item view.
	 */
	private void launchItemView(){
		if (currentView != null){
			currentView.close();
		}
		currentView = new ItemView(this, currentItem);
	}
	
	
	
	
}