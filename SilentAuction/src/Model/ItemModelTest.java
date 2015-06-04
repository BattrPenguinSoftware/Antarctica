package Model;

import static org.junit.Assert.*;

import java.awt.Image;
import java.util.ArrayList;

import org.junit.Test;

public class ItemModelTest {
	
	private Bidder bidders;
	
	private static double myNewBid = 130.5;
	
	private Donor theDonor;
	
	private ArrayList<Bid> bidHistory = new ArrayList<Bid>();
	
	@Test
	public void testItemModelConstructor() {
		//add new item
		
		ItemModel im = new ItemModel("iPad 16GB", theDonor, 111, null, 125.5, false);
		
		assertEquals("Name Bot Found!", "iPad 16GB", im.getName());
		assertEquals("Item Number Not Found!", 111, im.getItemNumber());
		assertEquals("Current Bid Not Found!", 125.5, im.getCurrentBidPrice(), 0.01);
		//check item is not alcohol
		assertFalse("Check Alcohol Failed!", im.isAlcoholic());
	}
	
	@Test
	public void testGetDonor() {
		theDonor = new Donor("Reagan", "206-333-1111", "reagan@gmail.com", 26, null, null, null);
		ItemModel im = new ItemModel("iPad 16GB", theDonor, 111, null, 125.5, false);
		assertTrue(theDonor.equals(im.getDonor()));
	}
	
	@Test
	public void testPlaceNewBid() {
		
		double myNewBid = 130.5;
		ItemModel im = new ItemModel("iPad 16GB", theDonor, 111, null, 125.5, false);
		Bid newBid = new Bid(myNewBid, bidders, im);
//		bidHistory.add(newBid);
		im.placeNewBid(newBid);
		//check size of array list = 1 when add 1 item
		assertEquals("Array Size Not Null!", 1,im.getBidHistory().size());
		assertEquals("New Bid Failed!", myNewBid , newBid.getAmount(), 0.01);
		
	}
	@Test
	public void testVerifyNewBid() {
		double theNewBid = 140.5;
		ItemModel im = new ItemModel("iPad 16GB", theDonor, 111, null, 130.5, false);
				
		assertTrue("New Bid Not greater!", im.verifyNewBid(theNewBid));
		theNewBid = 1.0;
		assertFalse("", im.verifyNewBid(theNewBid));
	}
	
	@Test
	public void testGetMaxBid() {
		ItemModel im = new ItemModel("iPad 16GB", theDonor, 111, null, 130.5, false);
		double myMaxBid = 140.5;
		Bid newBid = new Bid(myMaxBid, bidders, im);
		im.placeNewBid(newBid);
		assertEquals(newBid, im.getMaxBid());
	}
}
