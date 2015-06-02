package Model;

import java.util.ArrayList;
/*
 * import ItemModel 
 */
public class Bidder extends User{
	
	public Bidder(String name, String phoneNumber, String email, int age, String QRCode) {
		super(name, phoneNumber, email, age, QRCode);
	}
	
	
	//create arraylist to hold bidding history
	ArrayList<Bid> bidHistory = new ArrayList<Bid>();
	
	public ArrayList<Bid> itemsBidOn() {
		
		return bidHistory;
	}
}
