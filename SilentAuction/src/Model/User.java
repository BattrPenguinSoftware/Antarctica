package Model;

public abstract class User {
	String name;
	String phoneNumber;
	String email;
	//QR qrCode;
	String QRCode;
		
	
	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getQRCode() {
		return QRCode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setQRCode(String qRCode) {
		QRCode = qRCode;
	}

	public User(String name, String phoneNumber, String email, String QRCode) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.QRCode = QRCode;
	}
}
