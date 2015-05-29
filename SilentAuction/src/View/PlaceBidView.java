package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import Controller.ItemController;
import Model.Bidder;

/**
 * 
 * 
 * @author reagan
 *
 */
public class PlaceBidView extends AbstractView{
	
	public static final float INSTRUCTION_FONT = 30.0f;
	public static final float PRICE_FONT = 26.0f;
	public static final float BUTTON_FONT = 30.0f;
	
	private WindowFrame frame;
	private JPanel pane;
	double currentBidAmount;
	ItemController iController;
	Bidder theBidder;
	
	public PlaceBidView(double currentBidAmount, ItemController iController){
		super();
		this.currentBidAmount = currentBidAmount;
		this.iController = iController;
		frame = super.getFrame();
		pane = initializePane();
		theBidder = null;
		frame.add(pane);
		
	}
	
	private JPanel initializePane(){
		
		JPanel result = new JPanel(new GridLayout(7, 0));
		result.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		//Add QR code instructions
		JLabel instructions = new JLabel("<html><div style=\"text-align: center;\">Hold your barcode up to<br>the camera to"
				+ "<br>login");
		instructions.setFont(instructions.getFont().deriveFont(INSTRUCTION_FONT));
		//instructions.setAlignmentX(.5f);
		result.add(instructions);
		
		JPanel cameraPanel = new JPanel();
		cameraPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		JLabel cameraText = new JLabel("video from camera feed will go here");
		cameraPanel.add(cameraText);
		result.add(cameraPanel);
		//Add current high bid amount
		JLabel highBid = new JLabel();
		highBid.setText(String.format("Current High Bid: $%.2f", currentBidAmount));
		highBid.setFont(highBid.getFont().deriveFont(PRICE_FONT));
		highBid.setForeground(Color.MAGENTA);
		result.add(highBid);
		
		//Let user enter new bid
		//TODO: Recreate with fancy scrolling numbers
		JLabel placeBidInstructions = new JLabel("Enter your new bid below");
		placeBidInstructions.setFont(highBid.getFont().deriveFont(INSTRUCTION_FONT));
		result.add(placeBidInstructions);
		final JTextField newBidAmount = new JTextField("" + (currentBidAmount + 1));
		newBidAmount.setFont(newBidAmount.getFont().deriveFont(PRICE_FONT));
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
		cancelButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				iController.cancelBid();
				
			}
			
		});
		buttonPanel.add(cancelButton, BorderLayout.EAST);
		
		result.add(buttonPanel);
		
		return result;
		
		
	}
	
	public Bidder getBidder() {
		return theBidder;
	}
	
	public void bidHigher(Double newAmount) {
		JLabel warning = new JLabel("You must bid more than the current high bid.");
		pane.add(warning);
		
	}
	
	

}
