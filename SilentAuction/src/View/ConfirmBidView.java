package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ItemController;
import Model.Bid;
import Model.User;

/**
 * This view shows the user their current
 * bid and lets them choose to place or 
 * cancel it.
 * 
 * 
 * @author reagan
 * @date 6/2/15
 */
public class ConfirmBidView extends AbstractView{
	
	/** The size of large text. */
	public static final float LARGE_FONT = 36.0f;
	
	/** The size of medium text. */
	public static final float MEDIUM_FONT = 30.0f;
	
	/** The size of buttons' text. */
	public static final float BUTTON_FONT = 26.0f;
			

	/** The panel that holds all the components. */
	JPanel panel;
	
	/** The ItemController that handles changes of state. */
	ItemController iController;
	
	/** The frame that holds the panel that holds the components. */
	JFrame frame;
	
	/** The proposed new bid. */
	Bid proposedBid;
	
	/**
	 * Instantiates a new confirm bid view.
	 *
	 * @param proposedBid the proposed bid
	 * @param iController the item controller
	 */
	public ConfirmBidView(Bid proposedBid, ItemController iController){
		super();
		frame = super.getFrame();
		this.proposedBid = proposedBid;
		this.iController = iController;
		initialize();
	}
	
	/**
	 * Initializes the view.
	 */
	private void initialize(){
		//Create the panel to hold the components
		panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);
		panel.setBorder(new EmptyBorder(new Insets(40, 60, 40, 60)));
		panel.add(Box.createVerticalGlue());
		
		//Display the text
		initializeText();
		
		//and the buttons
		addButtons();
		
		panel.add(Box.createVerticalGlue());
		
		//Then add the panel to the frame so it is visible
		frame.add(panel);
		
	}
	
	/**
	 * Adds the confirm/cancel buttons to the screen.
	 */
	private void addButtons(){
		//Display buttons to accept or cancel the bid
		JButton yesButton = new JButton("Yes, Place This Bid");
		yesButton.setForeground(Color.GREEN);
		yesButton.setFont(yesButton.getFont().deriveFont(BUTTON_FONT));
		
		yesButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//If the user clicks yes, place the bid and go
				//back to the item view
				iController.placeBidAndRefreshView(proposedBid);
				
			}
			
		});
		
		JButton noButton = new JButton("No, Go Back");
		noButton.setForeground(Color.RED);
		noButton.setFont(noButton.getFont().deriveFont(BUTTON_FONT));
		
		noButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//If the user clicks no, go back to the item
				//view
				iController.launchPlaceBidView();
				
			}
			
		});
		
		
		panel.add(yesButton);
		panel.add(Box.createRigidArea(new Dimension(0,10)));
		panel.add(noButton);
	}
	
	/**
	 * Initialize the text, displaying instructions
	 * and the current username and bid amount.
	 */
	private void initializeText(){
		
		//Display user instructions		
		JPanel instrPanel = new JPanel();
		JLabel instructions = new JLabel("<html>Click below to<br>confirm or cancel<br>your bid</html>");
		instructions.setFont(instructions.getFont().deriveFont(LARGE_FONT));
		instructions.setAlignmentX(Component.CENTER_ALIGNMENT);
		instructions.setAlignmentY(Component.CENTER_ALIGNMENT);
		instrPanel.add(instructions);
		panel.add(instrPanel);
		
		//Display current bidder name and bid price
		JPanel detailsPanel = new JPanel();
		BoxLayout dLayout = new BoxLayout(detailsPanel, BoxLayout.Y_AXIS);
		detailsPanel.setLayout(dLayout);
		JLabel nameLabel = new JLabel();
		nameLabel.setText(String.format("<html>YOUR NAME:<br>%s<br><br></html>",
				((User) proposedBid.getBidders()).getName()));
		nameLabel.setFont(nameLabel.getFont().deriveFont(MEDIUM_FONT));
		JLabel bidLabel = new JLabel();
		bidLabel.setText(String.format("<html>YOUR BID:<br> $%.2f<br><br></html>", proposedBid.getAmount()));
		bidLabel.setFont(bidLabel.getFont().deriveFont(MEDIUM_FONT));
		detailsPanel.add(nameLabel);
		detailsPanel.add(bidLabel);
		panel.add(detailsPanel);

		
	}
}
