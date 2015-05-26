package Model;
/**
 * bid objects created after each bidder places a bid 
 * @author Todd Robbins
 */
@SuppressWarnings("hiding")
public class Bid<ItemModel, Bidder> {
	private double amount  = 0; 
	private Bidder bidders; 
	private ItemModel item; 
	/**
	 * 
	 */
	public Bid(double amount, Bidder bidders, ItemModel item) {
		this.amount = amount;
		this.item = item;
		this.bidders = bidders; 
		}
	/** 
	 * @return bid placed
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * gets the item to be bid on 
	 * @return object being bid on 
	 */
	public ItemModel getItem() {
		return item;
	}
	/**
	 * gets the bidder
	 * @return
	 */
	public Bidder getBidders() {
		return bidders;
	}
}