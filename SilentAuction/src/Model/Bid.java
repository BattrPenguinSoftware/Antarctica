package Model;

public class Bid {
	
	double amount;
	Bidder theBidder;
	ItemModel theItem;
	
	public Bid(double amount, Bidder bidder, ItemModel item){
		this.amount = amount;
		theBidder = bidder;
		theItem = item;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public Bidder getBidder() {
		return theBidder;
	}
	
	public ItemModel getItem() {
		return theItem;
	}

}
