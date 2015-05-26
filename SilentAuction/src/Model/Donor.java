package Model;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

public class Donor extends User {
	
	private static ItemModel item;

	String company;
	Image logo;
	ArrayList<ItemModel> itemList = new ArrayList<>();
	
	public void donate(ItemModel item) {
		itemList.add(item);	

	}
	
	public Donor(String name, String phoneNumber, String email, String QRCode, 
			Image logo, String company) {
		super(name, phoneNumber, email, QRCode);
		setLogo(logo);
		setCompany(company);
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Image getLogo() {
		return logo;
	}

	public void setLogo(Image logo) {
		this.logo = logo;
	}
}
