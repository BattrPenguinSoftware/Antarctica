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
			ItemModel defaultItem = new ItemModel("Cheetarah Vinyl Figure", new Donor("POP Vinyl", logo), 
					200, itemImage, 12.00);
			defaultItem.addBid(new Bid(13.00, new Bidder("Marilyn Oberlander"), defaultItem));
			defaultItem.addBid(new Bid(14.00, new Bidder("Violet Montagu"), defaultItem));
			defaultItem.addBid(new Bid(15.00, new Bidder("Danielle Zubiate"), defaultItem));
			defaultItem.addBid(new Bid(17.00, new Bidder("Kamau Kogo"), defaultItem));
			defaultItem.addBid(new Bid(18.50, new Bidder("Mieko Maki"), defaultItem));
			defaultItem.addBid(new Bid(19.25, new Bidder("Penny Rolle"), defaultItem));
			
			
			
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
