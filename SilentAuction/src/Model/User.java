package Model;

public abstract class User {
	String name;
	String phoneNumber;
	String email;
	int age;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
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
	
	public User(String name, String phoneNumber, String email, int age, String QRCode) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.age = age;
		this.QRCode = QRCode;
	}
}
