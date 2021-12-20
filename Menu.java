import javax.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Menu  {

	private JFrame frame;
	private JLabel TitleLabel;
	private JButton bookParking;
	private JButton RemoveVehicle;
	private JButton ParkingRates;
	private JButton LogOut;
	private ImageIcon frameLogo = new ImageIcon("Images\\parkingSign.png");
	
	
	public Menu() {
		initialize();
		frame.setVisible(true);
	}
	

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(119, 136, 153));
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("FORBES PARKING MENU");
		frame.setIconImage(frameLogo.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		TitleLabel = new JLabel("MALL PARKING MENU");
		TitleLabel.setBackground(new Color(240, 255, 255));
		TitleLabel.setForeground(new Color(240, 255, 255));
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setFont(new Font("Eras Bold ITC", Font.BOLD, 27));
		TitleLabel.setBounds(35, 10, 363, 40);
		frame.getContentPane().add(TitleLabel);
		
		bookParking = new JButton("NEW PARKING");
		bookParking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Book parking menu");
				carParkingSlots obj = new carParkingSlots();
				frame.setVisible(false);
			}
		});
		bookParking.setFont(new Font("Arial Black", Font.BOLD, 9));
		bookParking.setBounds(143, 73, 144, 33);
		frame.getContentPane().add(bookParking);
		
		RemoveVehicle = new JButton("REMOVE VEHICLE");
		RemoveVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Remove Vehicle menu");
				removeVehicle obj = new removeVehicle();
				frame.setVisible(false);
			}
		});
		RemoveVehicle.setFont(new Font("Arial Black", Font.BOLD, 9));
		RemoveVehicle.setBounds(143, 112, 144, 33);
		frame.getContentPane().add(RemoveVehicle);
		
		ParkingRates = new JButton("PARKING RATES");
		ParkingRates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Parking Rates displayed");
				frame.setVisible(false);
				Rates obj = new Rates();
			}
		});
		ParkingRates.setFont(new Font("Arial Black", Font.BOLD, 9));
		ParkingRates.setBounds(143, 151, 144, 33);
		frame.getContentPane().add(ParkingRates);
		
		LogOut = new JButton("LOG OUT");
		LogOut.setFont(new Font("Arial Black", Font.BOLD, 9));
		LogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userLogIn obj = new userLogIn();
				frame.setVisible(false);
			}
			
		});
		LogOut.setBounds(143, 190, 144, 33);
		frame.getContentPane().add(LogOut);
	}
}
