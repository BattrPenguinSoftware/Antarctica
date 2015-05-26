package Model;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

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
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream input = classLoader.getResourceAsStream("SilentAuction/resources/Cheetarah.jpg");
			Image itemImage = ImageIO.read(input);
			input = classLoader.getResourceAsStream("SilentAuction/resources/pop_logo.jpg");
			Image logo = ImageIO.read(input);
			
			addItem(new ItemModel("Cheetarah Vinyl Figure", new Donor("POP Vinyl", logo), 
				200, itemImage, 15.50));
			
		} catch ( IOException e ) { 
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
