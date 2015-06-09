package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import Controller.ItemController;
import Model.Bidder;

/**
 * The view that allows a user to place
 * a bid.
 *
 * @author Reagan, Ben (one button)
 * @date 6/2/15
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
		
		theBidder = null;
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
		
		//written by Ben
		JPanel cameraPanel = new JPanel();
		cameraPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		JButton nameAgeButton = new JButton("Enter Bidder Information Here");
		nameAgeButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 final WindowFrame frame = new WindowFrame();
				 JPanel thepanel = new JPanel();
				 BoxLayout layout = new BoxLayout(thepanel, BoxLayout.Y_AXIS);
					thepanel.setLayout(layout);
					thepanel.setBorder(new EmptyBorder(new Insets(40, 60, 40, 60)));
					thepanel.add(Box.createVerticalGlue());
				 frame.add(thepanel);
				 frame.setVisible(true);
				 
				 thepanel.setVisible(true);
				 thepanel.setLayout(new BoxLayout(thepanel, BoxLayout.Y_AXIS));
				 
				 JLabel bidderName = new JLabel("Bidder Name:");
				 final JTextArea nameText = new JTextArea();
				 bidderName.setFont(bidderName.getFont().deriveFont(18.0f));
				 
				 nameText.setFont(nameText.getFont().deriveFont(18.0f));
				 nameText.setMaximumSize(new Dimension(Integer.MAX_VALUE, nameText.getPreferredSize().height));
				 JLabel bidderAge = new JLabel("Bidder Age:");
				 bidderAge.setFont(bidderAge.getFont().deriveFont(18.0f));
				 
				 
				 final JSpinner ageSpinner = new JSpinner();
				 ageSpinner.setFont(ageSpinner.getFont().deriveFont(18.0f));
				 ageSpinner.setMaximumSize(new Dimension(Integer.MAX_VALUE, ageSpinner.getPreferredSize().height));
				 
				 thepanel.add(bidderName);
				 thepanel.add(nameText);
				 thepanel.add(bidderAge);
				 thepanel.add(ageSpinner);
				
				 //submit button
				 JButton submit = new JButton("Submit");
				 submit.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent arg0) {
						 //Moved getValue() into the button click so it gets the 
						 //updated value, not the initial zero value --Reagan
						 final Integer age = (Integer) ageSpinner.getValue();
						 theBidder = new Bidder(nameText.getText(), null, null, age, null);
						 frame.dispose();
					 }
				 });
				 thepanel.add(submit);
				 thepanel.add(Box.createVerticalGlue());
			}
		});
		cameraPanel.add(nameAgeButton);
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
		errorLabel.setFont(errorLabel.getFont().deriveFont(PRICE_FONT));
		errorLabel.setForeground(Color.RED);
		result.add(errorLabel);
		
		//Let user enter new bid
		
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
		
				Double newAmount = new Double(newBidAmount.getText());
				
				//Don't allow bidders under 18 to bid $50 or more
				if (theBidder.getAge() < 18 && newAmount >= new Double(50)) {
					errorLabel.setText("<html>Bidders under 18 must<br>bid under $50</html>");
					errorLabel.setVisible(true);
				//Don't allow bidders under 21 to buy alcoholic items	
				} else if (theBidder.getAge() < 21 && iController.isAlcoholic()){
					errorLabel.setText("<html>Bidders under 21 may<br>not bid on alcoholic items</html>");
					errorLabel.setVisible(true);
				} else {
					iController.verifyBid(newAmount);
				}
				
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
	public void bidHigher(Double attemptedAmount) {
		errorLabel.setText(String.format("<html>Your bid is too low.<br>It must be higher than the" 
				+ "<br>current bid amount of $%.2f</html>", currentBidAmount));
		
		errorLabel.setVisible(true);
		
	}
	
	

}
