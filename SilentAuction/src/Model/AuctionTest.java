package Model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AuctionTest {
	
	Auction test;
	
	ItemModel testItem;
	
	Donor testDoner;

	@Before
	public void setUp() throws Exception {
		test = new Auction();
		testItem = new ItemModel("testItem", testDoner, 0, null, 20.0, false);
		test.addItem(testItem);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAuction() {
		assertTrue(test != null);
	}

	@Test
	public void testGetItems() {
		assertTrue(!test.getItems().isEmpty());
		assertEquals(testItem.getName(), test.getItems().get(1).getName());
	}

}
