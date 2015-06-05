package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Model.Bid;
import Model.Bidder;

public class BidderTest {
	
	private ArrayList<Bid> bidHistory = new ArrayList<Bid>();
	@Test
	public void testBidder() {
		Bidder B = new Bidder("Cash Money", null, null, 30, null); 
		assertTrue(B.getName() != null);
		assertTrue(B.getAge() == 30); 
	}

	@Test
	public void testItemsBidOn() {
		assertTrue(bidHistory != null);
	}

}
