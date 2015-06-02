//have installed OpenCV 2.4.9 under your C:\, and in runConfigurations under VMArguments put: -Djava.library.path="C:\opencv\build\java\x64" 


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
	
	//TODO: populate auction with items
	private static Auction createAuction() {
		
		Auction result = new Auction();
		
		return result;
	}

}
