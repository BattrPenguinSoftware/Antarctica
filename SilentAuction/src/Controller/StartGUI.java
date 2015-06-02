//have installed OpenCV 2.4.9 under your C:\, and in runConfigurations under VMArguments put: -Djava.library.path="C:\opencv\build\java\x64" 


package Controller;

import java.awt.EventQueue;

import Model.Auction;

/**
 * 
 * A class to launch the GUI.
 * 
 * @author reagan
 *
 */
public class StartGUI {
	
	/**
	 * The main method which launches the GUI.
	 *
	 * @param args optional command line arguments
	 */
	public static void main (String[] args) {
		
		//create Auction with Items and Bidders, etc.
		final Auction theAuction = createAuction();
		
		EventQueue.invokeLater(new Runnable(){
			
			@SuppressWarnings("unused")
			public void run() {
				
				ItemController iControl = new ItemController(theAuction);
			}	
		});
		
	}
	
	/**
	 * Creates the auction.
	 *
	 * @return the auction
	 */
	private static Auction createAuction() {
		
		Auction result = new Auction();
		
		return result;
	}

}
