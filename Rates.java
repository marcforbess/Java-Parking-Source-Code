
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
public class Rates {
	
	private JFrame frame;
	private JPanel panel;
	private JPanel parkingRates;
	private JPanel managementRules;
	private JPanel contactNumber;
	private JLabel rateLabel;
	private JLabel contactLabel;
	private JLabel lblParkingRates;
	private JLabel lblNextHoursAfter;
	private JLabel lblNewLabel;
	private JLabel lblRulesAndRegulations;
	private JLabel lblUsersAreAllowed;
	private JLabel lblNewLabel_1;
	private ImageIcon back = new ImageIcon("Images\\backIcon.png");
	private ImageIcon frameLogo = new ImageIcon("Images\\parkingSign.png");
	
	public Rates() {
		setFrame();
		setLabels();
		setButton();
	}
	
	private void setFrame() {
		frame = new JFrame();
		frame.setSize(750, 500);
		frame.setIconImage(frameLogo.getImage());
		frame.setTitle("INQUIRIES");
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPanel();
	}
	
	private void setPanel() {
		panel = new JPanel();
		panel.setBounds(0, 0, 750, 500);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		parkingRates = new JPanel();
		parkingRates.setBounds(10, 10, 342, 327);
		parkingRates.setLayout(null);
		parkingRates.setBorder(BorderFactory.createTitledBorder("Parking Rates"));
		panel.add(parkingRates);
		
		
		managementRules = new JPanel();
		managementRules.setBounds(362, 10, 363, 327);
		managementRules.setLayout(null);
		managementRules.setBorder(BorderFactory.createTitledBorder("Rules and Regulations"));
		panel.add(managementRules);
		
		contactNumber = new JPanel();
		contactNumber.setBackground(Color.LIGHT_GRAY);
		contactNumber.setBounds(10, 347, 715, 102);
		contactNumber.setLayout(null);
		panel.add(contactNumber);
		
	}
	
	private void setLabels() {
		rateLabel = new JLabel("<html> FIRST THREE HOURS:\tRM3\r\n </html>");
		rateLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		rateLabel.setVerticalAlignment(SwingConstants.TOP);
		rateLabel.setBounds(10, 62, 322, 43);
		parkingRates.add(rateLabel);
		
		lblParkingRates = new JLabel("PARKING RATES");
		lblParkingRates.setForeground(UIManager.getColor("Button.shadow"));
		lblParkingRates.setVerticalAlignment(SwingConstants.TOP);
		lblParkingRates.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		lblParkingRates.setBounds(10, 21, 322, 60);
		parkingRates.add(lblParkingRates);
		
		lblNextHoursAfter = new JLabel("<html>NEXT HOURS AFTER: RM1.50/HOUR</html>");
		lblNextHoursAfter.setVerticalAlignment(SwingConstants.TOP);
		lblNextHoursAfter.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNextHoursAfter.setBounds(10, 124, 322, 43);
		parkingRates.add(lblNextHoursAfter);
		
		lblRulesAndRegulations = new JLabel("RULES AND REGULATIONS");
		lblRulesAndRegulations.setVerticalAlignment(SwingConstants.TOP);
		lblRulesAndRegulations.setForeground(SystemColor.controlShadow);
		lblRulesAndRegulations.setFont(new Font("Bauhaus 93", Font.PLAIN, 29));
		lblRulesAndRegulations.setBounds(10, 20, 322, 60);
		managementRules.add(lblRulesAndRegulations);
		
		lblUsersAreAllowed = new JLabel("<html> Users are allowed to park their vehicles only at their booked parking spot. Regular patrols are constantly being held by the security team. Vehicles that are found to be parked at the wrong spot will be clamped and owner will be fined immediately. Vehicles are also not allowed to be parked overnight, a severe penalty will be fined to those who attempt to do so. Our rules and regulations are purely for the benefit of the customers. For more inquiries, feel free to contact the management \r\n </html>");
		lblUsersAreAllowed.setVerticalAlignment(SwingConstants.TOP);
		lblUsersAreAllowed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsersAreAllowed.setBounds(10, 58, 343, 259);
		managementRules.add(lblUsersAreAllowed);
		
		lblNewLabel = new JLabel("CONTACT US AT");
		lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 204, 27);
		contactNumber.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("FAX: 088-123456   HOTLINE: 03-98765432   WEBSITE: www.parkingproject.com");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBounds(10, 43, 695, 49);
		contactNumber.add(lblNewLabel_1);	
		
	}
	
	private void setButton() {
		JButton backButton = new JButton();
		backButton.setIcon(back);
		backButton.addActionListener(new backListener());
		backButton.setBounds(10, 253, 139, 53);
		parkingRates.add(backButton);
	}
	
	private class backListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Menu obj = new Menu();
			
		}
	
	}
}
