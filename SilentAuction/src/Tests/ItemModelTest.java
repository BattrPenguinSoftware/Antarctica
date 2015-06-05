/**
 * 
 */
package Tests;

import static org.junit.Assert.*;

import java.awt.Image;
import java.util.ArrayList;

import org.junit.Test;

import Model.Bid;
import Model.Bidder;
import Model.ItemModel;
import Model.Donor;

/**
 * @author tuanhuynh
 *
 */

public class ItemModelTest {
	
	private Donor theDoner;
	
	private Image theImage;
	
	private ArrayList<Bid> bidHistory;
	
	private ItemModel im;
	
	private Bid myNewBid;
	
	private Bidder theBidder;
	
	private double newBid = 130.5;
	
	private double currentBid = 125.5;
	/*
	 * Test for itemModel constructor
	 */
	
	public void setUp() {
		im = new ItemModel("iPad 2 16GB", theDoner, 111, theImage, currentBid, false);
		myNewBid = new Bid(newBid, theBidder, im);
	}
	
	@Test
	public void testItemModelConstructor() {
		im = new ItemModel("iPad 2 16GB", theDoner, 111, theImage, 125.5, false);
		assertEquals("Item name not correctly!", "iPad 2 16GB", im.getName());
		assertEquals("Item Number does not match!!", 111, im.getItemNumber());
		assertEquals("item price does not equal!", 125.5, im.getCurrentBidPrice(), 0.001);
		assertFalse("Item is not alcohol!", im.isAlcoholic());
	}
	
	@Test
	public void testVerifyNewBid() {
		
		
	}
	
	@Test
	public void testPlaceNewBid() {
		im = new ItemModel("iPad 2 16GB", theDoner, 111, theImage, 125.5, false);
		myNewBid = new Bid(newBid, theBidder, im);
		bidHistory.add(myNewBid);
		currentBid = myNewBid.getAmount();
		assertEquals("bid failed!", newBid > currentBid);
	}
	
	@Test
	public void testGetMaxBid() {
		
	}
}
