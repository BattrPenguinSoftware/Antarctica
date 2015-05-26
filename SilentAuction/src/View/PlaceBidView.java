package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controller.ItemController;

public class PlaceBidView extends AbstractView{
	
	private WindowFrame frame;
	private JPanel pane;
	double currentBidAmount;
	ItemController iController;
	
	public PlaceBidView(double currentBidAmount, ItemController iController){
		super();
		this.currentBidAmount = currentBidAmount;
		this.iController = iController;
		frame = super.getFrame();
		pane = initializePane();
		
		frame.add(pane);
		
	}
	
	private JPanel initializePane(){
		
		JPanel result = new JPanel(new GridLayout(7, 1));
		result.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		//Add QR code instructions
		JTextArea instructions = new JTextArea("Hold your barcode over the camera to identify yourself", 3, 22);
		instructions.setFont(instructions.getFont().deriveFont(24.0f));
		result.add(instructions);
		
		//Add current high bid amount
		JLabel highBid = new JLabel("$" + currentBidAmount);
		highBid.setFont(highBid.getFont().deriveFont(22.0f));
		result.add(highBid);
		
		//Let user enter new bid
		//TODO: Recreate with fancy scrolling numbers
		final JTextField newBidAmount = new JTextField("" + (currentBidAmount + 1));
		newBidAmount.setFont(newBidAmount.getFont().deriveFont(26.0f));
		result.add(newBidAmount);
		
		JPanel buttonPanel = new JPanel();
		JButton nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				iController.verifyBid(new Double(newBidAmount.getText()));
				
			}
			
		});
		buttonPanel.add(nextButton, BorderLayout.WEST);
		JButton cancelButton = new JButton("Cancel");
		nextButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				iController.cancelBid();
				
			}
			
		});
		buttonPanel.add(cancelButton, BorderLayout.EAST);
		
		result.add(buttonPanel);
		
		return result;
		
		
	}
	
	public void bidHigher(Double newAmount) {
		JLabel warning = new JLabel("You must bid more than the current high bid.");
		pane.add(warning);
		
	}
	
	

}
