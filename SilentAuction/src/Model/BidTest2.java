package Model;


import javax.swing.ImageIcon;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * A class to perform JUnit tests on Bid.java.
 * 
 * @author reagan
 * @date 6/3/15
 */
public class BidTest2 {
	private Bid bidOne;
	private Bid bidTwo;
	private Bidder alanna;
	private Bidder roger;
	private ItemModel cheetarah;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		alanna = new Bidder("Alanna Trebond", "206-788-8383", "lioness@yahoo.com", 33, "8900");
		roger = new Bidder("Roger Conte", "253-688-5656", "dukesrule@gmail.com", 45, "667");
		cheetarah = new ItemModel("Cheetarah Vinyl Figure", 
				new Donor("Ada Larson", "206-534-6789", "alarson@gmail.com", 24, "1004", 
				new ImageIcon("resources/pop_logo.png").getImage(), "POP Vinyl"),
				200, new ImageIcon("resources/Cheetarah.jpg").getImage(), 12.00, false);
		
		
		bidOne = new Bid(23.56, alanna, cheetarah);
		bidTwo = new Bid(45.00, roger, cheetarah);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		bidOne = null;
		bidTwo = null;
	}

	@Test
	public void testEquality() {
		Assert.assertTrue(!bidOne.equals(null));
	    Assert.assertEquals(bidOne, bidOne);
	    Assert.assertTrue(!bidOne.equals(bidTwo));
	}
	
	@Test
	public void testGetBidders(){
		Assert.assertTrue(bidOne.getBidders().equals(alanna));
		Assert.assertTrue(!bidOne.getBidders().equals(roger));
	}
	
	@Test
	public void testGetAmount(){
		Assert.assertTrue(bidOne.getAmount() == 23.56);
		Assert.assertTrue(bidTwo.getAmount() != 23.56);
		Assert.assertTrue(bidTwo.getAmount() > 39.99);
	}
	
	@Test
	public void testGetItem(){
		Assert.assertTrue(bidOne.getItem().equals(cheetarah));
	
	}

}
