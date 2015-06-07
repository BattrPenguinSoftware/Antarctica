package Tests;

import static org.junit.Assert.*;

import java.awt.Image;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Model.ItemModel;
/**
 * tests the donor class
 * @author Todd
 */
public class DonorTest {
	String company;
	Image logo;
	ArrayList<ItemModel> itemList = new ArrayList<>();
	@Test
	public void testDonate() {
		assertTrue(itemList != null); 
	}

	@Test
	public void testDonor() {
		assertTrue(logo == null); 
		assertTrue(company == null); 
	}

	@Test
	public void testSetCompany() {
		assertEquals(this.company, company); 
	}

	@Test
	public void testSetLogo() {
		assertEquals(this.logo, logo);
	}

}
