package Model;

/**
 * Class that extends user and allows for a constructor to be built so that
 * the abstract class can be tested.
 * @author Audrey Chavarria 6/3/15
 *
 */
public class UserConcrete extends User {

	/**
	 * Instantiates a new user concrete.
	 *
	 * @param name the name
	 * @param phoneNumber the phone number
	 * @param email the email
	 * @param age the age
	 * @param QRCode the QR code
	 */
	public UserConcrete(String name, String phoneNumber, String email, int age,
			String QRCode) {
		super(name, phoneNumber, email, age, QRCode);
	}

}
