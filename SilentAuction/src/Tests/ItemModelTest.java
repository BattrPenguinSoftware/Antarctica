/**
 * 
 */
package Tests;

import static org.junit.Assert.*;

import java.awt.Image;

import org.junit.Test;

import Model.Bid;
import Model.ItemModel;
import Model.Donor;

/**
 * @author tuanhuynh
 *
 */

public class ItemModelTest {
	
	private Donor theDoner;
	
	private Image theImage;
	
	private Bid theNewBid;
	/*
	 * Test for itemModel constructor
	 */
	@Test
	public void testItemModelConstructor() {
		//item 1
		final ItemModel im = new ItemModel("iPad 2 16GB", theDoner, 111, theImage, 125.5, false);
		
		assertEquals("Item name not correctly!", "iPad 2 16GB", im.getName());
		assertEquals("Item Number does not match!!", 111, im.getItemNumber());
		assertEquals("item price does not equal!", 125.5, im.getCurrentBidPrice(), 0.001);
		
		assertFalse("Item is not alcohol!", im.isAlcoholic());
	}
	
	@Test
	public void testNewBid() {
		
		final ItemModel im = new ItemModel("iPad 2 16GB", theDoner, 111, theImage, 125.5, false);
		double newBid = 130.5;
		assertEquals("New Bid not correct!", 130.5, newBid, 0.01);
		assertTrue("New bid has to be greater than current bid!", newBid > im.getCurrentBidPrice());
		
	}
	
	@Test
	public void testPlaceNewBid() {
		
	}
	
}
