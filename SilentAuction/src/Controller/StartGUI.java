package Controller;

import java.awt.EventQueue;

import Model.Auction;
import View.ItemView;

public class StartGUI {
	
	public static void main (String[] args) {
		
		//create Auction with Items and Bidders, etc.
		final Auction theAuction = createAuction();
		
		EventQueue.invokeLater(new Runnable(){
			
			public void run() {
				
				ItemController iControl = new ItemController(theAuction);
				
			}
			
		});
		
	}
	
	private static Auction createAuction() {
		
		Auction result = new Auction();
		
		return result;
	}

}
