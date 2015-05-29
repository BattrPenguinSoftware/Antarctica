import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Dimension;


public class submissionQR extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					submissionQR frame = new submissionQR();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public submissionQR() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDonor = new JButton("Donor");
		btnDonor.setPreferredSize(new Dimension(22, 22));
		btnDonor.setMinimumSize(new Dimension(22, 22));
		btnDonor.setMaximumSize(new Dimension(22, 22));
		btnDonor.setIcon(new ImageIcon(submissionQR.class.getResource("/images/Donor.jpg")));
		btnDonor.setBounds(546, 58, 225, 215);
		contentPane.add(btnDonor);
		
		JButton btnAuctioneer = new JButton("Auctioneer");
		btnAuctioneer.setIcon(new ImageIcon(submissionQR.class.getResource("/images/Auctioneer.jpg")));
		btnAuctioneer.setPreferredSize(new Dimension(22, 22));
		btnAuctioneer.setMinimumSize(new Dimension(22, 22));
		btnAuctioneer.setMaximumSize(new Dimension(22, 22));
		btnAuctioneer.setBounds(275, 58, 225, 215);
		contentPane.add(btnAuctioneer);
		
		JButton btnBidder = new JButton("Bidder");
		btnBidder.setIcon(new ImageIcon(submissionQR.class.getResource("/images/Bidder.jpg")));
		btnBidder.setPreferredSize(new Dimension(22, 22));
		btnBidder.setMinimumSize(new Dimension(22, 22));
		btnBidder.setMaximumSize(new Dimension(22, 22));
		btnBidder.setBounds(10, 58, 225, 215);
		contentPane.add(btnBidder);
	}
}
