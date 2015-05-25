package Controller;

import java.awt.EventQueue;

import View.ItemView;

public class StartGUI {
	
	public static void main (String[] args) {
		
		EventQueue.invokeLater(new Runnable(){
			
			public void run() {
				
				ItemView iView = new ItemView();
				
			}
			
		});
		
	}

}
