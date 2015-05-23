package model;

public abstract class User {
	String name;
	String phoneNum;
	String email;
	//QR qrCode;
	String QRCode;
	
	public void getContactInfo() {
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.QRCode = QRCode;
	}
}
