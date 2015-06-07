package Model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Class to test auction class.
 * @author Ben
 *
 */
public class AuctionTest {
	
	/**
	 * Test auction object
	 */
	Auction test;
	
	/**
	 * Item added to auction
	 */
	ItemModel testItem;
	
	/**
	 * Donor added to test item.
	 */
	Donor testDoner;

	/**
	 * Set up method
	 * @throws Exception
	 */
	public void setUp() throws Exception {
		test = new Auction();
		testItem = new ItemModel("testItem", testDoner, 0, null, 20.0, false);
		test.addItem(testItem);
	}

	/**
	 * Tear down method.
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
	}

	/**
	 * Tests that auction is created
	 */
	public void testAuction() {
		assertTrue(test != null);
	}

	/**
	 * Gets the items and confirms place and name
	 */
	public void testGetItems() {
		assertTrue(!test.getItems().isEmpty());
		assertEquals(testItem.getName(), test.getItems().get(1).getName());
	}

}
