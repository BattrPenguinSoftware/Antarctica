package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ItemController;
import Model.Bid;
import Model.Bidder;
import Model.User;

public class ConfirmBidView extends AbstractView{
	
	public static final float LARGE_FONT = 36.0f;
	public static final float MEDIUM_FONT = 30.0f;
	public static final float BUTTON_FONT = 26.0f;
			

	JPanel panel;
	ItemController iController;
	JFrame frame;
	Bid proposedBid;
	
	public ConfirmBidView(Bid proposedBid, ItemController iController){
		super();
		frame = super.getFrame();
		this.proposedBid = proposedBid;
		this.iController = iController;
		initialize();
	}
	
	private void initialize(){
		panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);
		panel.setBorder(new EmptyBorder(new Insets(40, 60, 40, 60)));
		panel.add(Box.createVerticalGlue());
		initializeText();
		addButtons();
		panel.add(Box.createVerticalGlue());
		frame.add(panel);
		
	}
	
	private void addButtons(){
		//Display buttons to accept or cancel the bid
		JButton yesButton = new JButton("Yes, Place This Bid");
		yesButton.setForeground(Color.GREEN);
		yesButton.setFont(yesButton.getFont().deriveFont(BUTTON_FONT));
		
		yesButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				iController.placeBidAndRefreshView(proposedBid);
				
			}
			
		});
		
		JButton noButton = new JButton("No, Cancel This Bid");
		noButton.setForeground(Color.RED);
		noButton.setFont(noButton.getFont().deriveFont(BUTTON_FONT));
		
		noButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				iController.cancelBid();
				
			}
			
		});
		
		
		panel.add(yesButton);
		panel.add(Box.createRigidArea(new Dimension(0,10)));
		panel.add(noButton);
	}
	
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
