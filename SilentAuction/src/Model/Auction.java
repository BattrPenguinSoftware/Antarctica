package Model;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Auction {
	
	ArrayList<ItemModel> items;
	
	/**
	 * Create a new Auction object with an empty list of items
	 */
	public Auction() {
		items = new ArrayList<ItemModel>();
		
		//For testing purposes, populating the auction with
		//an item to start out with
		try{
			
			Image itemImage = new ImageIcon("resources/Cheetarah.jpg").getImage();
			Image logo = new ImageIcon("resources/pop_logo.png").getImage();
			ItemModel defaultItem = new ItemModel("Cheetarah Vinyl Figure", 
					new Donor("Ada Larson", 
					"206-534-6789", "alarson@gmail.com", "1004", logo, "POP Vinyl"),
					200, itemImage, 12.00);
			defaultItem.placeNewBid(new Bid(13.00, 
					new Bidder("Marilyn Oberlander", "206-564-6789", "mO75@gmail.com", "1005"), 
					defaultItem));
			defaultItem.placeNewBid(new Bid(14.00, new Bidder("Violet Montagu", "206-534-6689", "viola@gmail.com", "1006"), 
					defaultItem));
			defaultItem.placeNewBid(new Bid(15.00, new Bidder("Danielle Zubiate", "206-534-6889", "zubiate@gmail.com", "1007"), 
					defaultItem));
			defaultItem.placeNewBid(new Bid(17.00, 
					new Bidder("Kamau Kogo", "206-514-6789", "kogo4lyfe@gmail.com", "1008"), defaultItem));
			defaultItem.placeNewBid(new Bid(18.50, 
					new Bidder("Mieko Maki", "206-434-6789", "maki.mieko@gmail.com", "1009"), defaultItem));
			defaultItem.placeNewBid(new Bid(19.25, 
					new Bidder("Penny Rolle", "206-534-6789", "mO75@gmail.com", "1005"), defaultItem));
			
			
			
			addItem(defaultItem);
			
		} catch ( Exception e ) { 
			System.out.println("There was an error trying to load item or donor images: " + e);
		}
	}
	
	/**
	 * Add an item to the auction
	 * @param newItem the item to add
	 */
	public void addItem(ItemModel newItem){
		items.add(newItem);
	}
	
	/**
	 * Return the list of all items in the auction
	 * @return the list of items
	 */
	public ArrayList<ItemModel> getItems() {
		return items;
	}

}
