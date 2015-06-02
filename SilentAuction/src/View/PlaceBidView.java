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
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import Controller.ItemController;
import Model.Bidder;

/**
 * The view that allows a user to place
 * a bid.
 *
 * @author reagan
 */
public class PlaceBidView extends AbstractView{
	
	/** The size of the instruction text. */
	public static final float INSTRUCTION_FONT = 30.0f;
	
	/** The size of the price text. */
	public static final float PRICE_FONT = 26.0f;
	
	/** The size of the button text. */
	public static final float BUTTON_FONT = 23.0f;
	
	/** The frame that holds the JPanel and all its components. */
	private WindowFrame frame;
	
	/** The JPanel that holds all the components. */
	private JPanel pane;
	
	/** The current bid amount. */
	double currentBidAmount;
	
	/** A label to let the user know there's a problem. */
	private JLabel errorLabel;
	
	/** The item controller that controls the flow. */
	ItemController iController;
	
	/** The bidder. */
	Bidder theBidder;
	
	/**
	 * Instantiates a new place bid view.
	 *
	 * @param currentBidAmount the current bid amount
	 * @param iController the item controller
	 */
	public PlaceBidView(double currentBidAmount, ItemController iController){
		super();
		this.currentBidAmount = currentBidAmount;
		this.iController = iController;
		frame = super.getFrame();
		pane = initializePane();
		//TODO: correct this so theBidder starts as null and updates at login	
		theBidder = new Bidder("Mary Lou Haggens", "206-673-2343", "mlhay@gmail.com", 23, "4567");
		frame.add(pane);
		
	}
	
	/**
	 * Initializes the pane.
	 *
	 * @return the JPanel
	 */
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
		
		//Add error label as a space holder (for use when bid is too low)
		errorLabel = new JLabel();
		errorLabel.setVisible(false);
		errorLabel.setText(String.format("<html>Your bid is too low.<br>It must be higher than the" 
		+ "<br>current bid amount of $%.2f</html>", currentBidAmount));
		errorLabel.setFont(errorLabel.getFont().deriveFont(PRICE_FONT));
		errorLabel.setForeground(Color.RED);
		result.add(errorLabel);
		
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
	
	/**
	 * Gets the bidder.
	 *
	 * @return the bidder
	 */
	public Bidder getBidder() {
		
		return theBidder;
	}
	
	/**
	 * Displays an error letting the user
	 * know to pick a larger amount.
	 *
	 * @param attemptedAmount the attempted amount
	 */
	//TODO: Make this work
	public void bidHigher(Double attemptedAmount) {
		pane.add(errorLabel);
		errorLabel.setVisible(true);
		
	}
	
	

}
