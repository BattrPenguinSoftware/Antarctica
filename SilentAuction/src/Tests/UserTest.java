
package Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import Model.User;
import Model.UserConcrete;

/**
 * @author Audrey Chavarria, 6/3/2015
 *
 */
public class UserTest {
	

	@Test
	public void testUserConcrete(){
		UserConcrete user1 = new UserConcrete("Will", "2063873090", "will123@gmail.com", 23, "1357968");
		assertEquals("Will",user1.getName());
		assertEquals("2063873090",user1.getPhoneNumber());
		assertEquals("will123@gmail.com",user1.getEmail());
		assertEquals(23,user1.getAge());
		assertEquals("1357968",user1.getQRCode());
		
	}
	
	/**
	 * Test method for {@link Model.User#getAge()}.
	 */
	@Test
	public void testGetAge() {
		UserConcrete user1 = new UserConcrete("Will", "2063873090", "will123@gmail.com", 23, "1357968");
		assertEquals(23,user1.getAge());
		user1.setAge(24);
		assertEquals(24,user1.getAge());
	}

	/**
	 * Test method for {@link Model.User#setAge(int)}.
	 */
	@Test
	public void testSetAge() {
		UserConcrete user1 = new UserConcrete("Will", "2063873090", "will123@gmail.com", 23, "1357968");
		assertEquals(23,user1.getAge());
		user1.setAge(25);
		assertEquals(25,user1.getAge());
		user1.setAge(35);
		user1.setAge(39);
		assertEquals(39,user1.getAge());
	}

	/**
	 * Test method for {@link Model.User#getName()}.
	 */
	@Test
	public void testGetName() {
		UserConcrete user1 = new UserConcrete("Will", "2063873090", "will123@gmail.com", 23, "1357968");
		assertEquals("Will",user1.getName());
		user1.setName("Marta");
		assertEquals("Marta",user1.getName());
		user1.setName("Carlos");
		assertEquals("Carlos",user1.getName());
	}

	/**
	 * Test method for {@link Model.User#getPhoneNumber()}.
	 */
	@Test
	public void testGetPhoneNumber() {
		UserConcrete user1 = new UserConcrete("Will", "2063873090", "will123@gmail.com", 23, "1357968");
		assertEquals("2063873090",user1.getPhoneNumber());
		user1.setPhoneNumber("2063873034");
		assertEquals("2063873034",user1.getPhoneNumber());
		user1.setPhoneNumber("2063563034");
		assertEquals("2063563034",user1.getPhoneNumber());
	}

	/**
	 * Test method for {@link Model.User#getEmail()}.
	 */
	@Test
	public void testGetEmail() {
		UserConcrete user1 = new UserConcrete("Will", "2063873090", "will123@gmail.com", 23, "1357968");
		assertEquals("will123@gmail.com",user1.getEmail());
		user1.setEmail("will@gmail.com");
		assertEquals("will@gmail.com",user1.getEmail());
		user1.setEmail("carlos@gmail.com");
		assertEquals("carlos@gmail.com",user1.getEmail());
	}

	/**
	 * Test method for {@link Model.User#getQRCode()}.
	 */
	@Test
	public void testGetQRCode() {
		UserConcrete user1 = new UserConcrete("Will", "2063873090", "will123@gmail.com", 23, "1357968");
		assertEquals("1357968",user1.getQRCode());
		user1.setQRCode("1357543");
		assertEquals("1357543",user1.getQRCode());
		user1.setQRCode("1357111");
		assertEquals("1357111",user1.getQRCode());
	}

	/**
	 * Test method for {@link Model.User#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		UserConcrete user1 = new UserConcrete("Will", "2063873090", "will123@gmail.com", 23, "1357968");
		assertEquals("Will",user1.getName());
		user1.setName("Karla");
		assertEquals("Karla",user1.getName());
		user1.setName("Kurt");
		user1.setName("Kaur");
		assertEquals("Kaur",user1.getName());
	}

	/**
	 * Test method for {@link Model.User#setPhoneNumber(java.lang.String)}.
	 */
	@Test
	public void testSetPhoneNumber() {
		UserConcrete user1 = new UserConcrete("Will", "2063873090", "will123@gmail.com", 23, "1357968");
		assertEquals("2063873090",user1.getPhoneNumber());
		user1.setPhoneNumber("2063873333");
		assertEquals("2063873333",user1.getPhoneNumber());
		user1.setPhoneNumber("2063873311");
		user1.setPhoneNumber("2063873355");
		assertEquals("2063873355",user1.getPhoneNumber());	
	}

	/**
	 * Test method for {@link Model.User#setEmail(java.lang.String)}.
	 */
	@Test
	public void testSetEmail() {
		UserConcrete user1 = new UserConcrete("Will", "2063873090", "will123@gmail.com", 23, "1357968");
		assertEquals("will123@gmail.com",user1.getEmail());
		user1.setEmail("will144@gmail.com");
		assertEquals("will144@gmail.com",user1.getEmail());
		user1.setEmail("Erick144@gmail.com");
		user1.setEmail("Maxo144@gmail.com");
		assertEquals("Maxo144@gmail.com",user1.getEmail());
	}

	/**
	 * Test method for {@link Model.User#setQRCode(java.lang.String)}.
	 */
	@Test
	public void testSetQRCode() {
		UserConcrete user1 = new UserConcrete("Will", "2063873090", "will123@gmail.com", 23, "1357968");
		assertEquals("1357968",user1.getQRCode());
		user1.setQRCode("1357999");
		assertEquals("1357999",user1.getQRCode());
		user1.setQRCode("1357966");
		user1.setQRCode("1357977");
		assertEquals("1357977",user1.getQRCode());	
	}

	/**
	 * Test method for {@link Model.User#User(java.lang.String, java.lang.String, java.lang.String, int, java.lang.String)}.
	 */
	@Test
	public void testUser() {
		User user1 = new UserConcrete("Will", "2063873090", "will123@gmail.com", 23, "1357968");
		assertEquals("Will",user1.getName());
		assertEquals("2063873090",user1.getPhoneNumber());
		assertEquals("will123@gmail.com",user1.getEmail());
		assertEquals(23,user1.getAge());
		assertEquals("1357968",user1.getQRCode());	
	}

}
