import java.awt.Color;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class payment {
	private JFrame frame;
	private JPanel panel, durationPanel, cardPanel;
	private String[] hours = new String[12];
	private String[] minutes = new String[60];
	private String[] months = new String[12];
	private String[] years = new String[30];
	private JComboBox inHour, inMinutes, outHour, outMinutes;
	private JLabel labelInHour, labelInMinutes, labelOutHour, labelOutMinutes;
	private Border lineBorder = BorderFactory.createLineBorder(Color.black);
	private Border loweredBorder = BorderFactory.createLoweredBevelBorder();
	private JButton confirmDuration, confirmBooking;
	private JLabel fareLabel, nameLabel, cardnoLabel, expiryLabel, cvvLabel;
	private JTextField nameField, cardNoField;
	private JPasswordField cvv;
	private JComboBox monthComboBox, yearComboBox;
	private double total, selectedInHour=10, selectedInMinutes=0, selectedOutHour=11, selectedOutMinutes=0;
	private JPasswordField cvvField;
	private Font sitka = new Font("Sitka Text", Font.BOLD, 15);
	private JLabel phoneNoLabel;
	private JTextField phoneNoField;
	private String userName, phoneNum;
	private int uniqueID;
	private ImageIcon confirm = new ImageIcon("Images\\confirmIcon.png");
	private ImageIcon frameLogo = new ImageIcon("Images\\parkingSign.png");
	
	public payment(int UniqueID) {
		setFrame();
		setTimeLabels();
		initializeTime();
		initializeMonthandYears();
		setTimeComboBox();
		setButtons();
		setDetailsLabels();
		setDetailsTextField();
		setCardComboBox();
		this.uniqueID = UniqueID;
		frame.setVisible(true);
	}
	
	public payment(String random) {
		System.out.println(random + " called by receipt class");
	}
	
	
	private void setFrame() {
		frame = new JFrame();
		frame.setSize(900, 550);
		frame.setIconImage(frameLogo.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		durationPanel = new JPanel();
		durationPanel.setLocation(0, 0);
		durationPanel.setSize(450, 495);
		durationPanel.setLayout(null);
		durationPanel.setBorder(BorderFactory.createTitledBorder("Parking Duration"));
		panel.add(durationPanel);
		
		cardPanel = new JPanel();
		cardPanel.setBounds(460, 0, 450, 495);
		cardPanel.setLayout(null);
		cardPanel.setBorder(BorderFactory.createTitledBorder("Vehicle Details"));
		panel.add(cardPanel);
		
		
	}
	
	private void initializeTime() {
		int hourscounter = 10;
		for(int i=0; i<12; i++) {
			hours[i] = Integer.toString(hourscounter);
			hourscounter++;
		}
		
		for(int i=0; i<60; i++) {
			minutes[i] = Integer.toString(i);
		}
	}
	
	private void initializeMonthandYears() {
		int yearcounter = 2021;
		for(int i=0; i<12; i++) {
			months[i] = Integer.toString(i+1);
		}
		
		for(int i=0; i<30; i++) {
			years[i] = Integer.toString(yearcounter);
			yearcounter++;
		}
	}
	
	private void setTimeLabels() {
		labelInHour = new JLabel("Start Hour");
		labelInHour.setHorizontalAlignment(SwingConstants.CENTER);
		labelInHour.setBounds(10, 34, 80, 30);
		labelInHour.setBorder(loweredBorder);
		durationPanel.add(labelInHour);
		
		labelInMinutes = new JLabel("Start Minute");
		labelInMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		labelInMinutes.setBorder(loweredBorder);
		labelInMinutes.setBounds(217, 34, 80, 30);
		durationPanel.add(labelInMinutes);
		
		labelOutHour = new JLabel("End Hour");
		labelOutHour.setHorizontalAlignment(SwingConstants.CENTER);
		labelOutHour.setBorder(loweredBorder);
		labelOutHour.setBounds(10, 162, 80, 30);
		durationPanel.add(labelOutHour);
		
		labelOutMinutes = new JLabel("End Minute");
		labelOutMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		labelOutMinutes.setBorder(loweredBorder);
		labelOutMinutes.setBounds(217, 162, 80, 30);
		durationPanel.add(labelOutMinutes);
		
		fareLabel = new JLabel();
		fareLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		fareLabel.setBounds(10, 355, 219, 57);
		durationPanel.add(fareLabel);
		fareLabel.setVisible(false);
		
	}
	
	private void setDetailsLabels() {
		nameLabel = new JLabel("CARDHOLDER NAME");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 8));
		nameLabel.setBounds(29, 54, 122, 32);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBorder(lineBorder);
		cardPanel.add(nameLabel);
		
		cardnoLabel = new JLabel("CARD NUMBER");
		cardnoLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		cardnoLabel.setBorder(lineBorder);
		cardnoLabel.setBounds(29, 107, 122, 32);
		cardnoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardPanel.add(cardnoLabel);
		
		expiryLabel = new JLabel("EXPIRY DATE (M/Y)");
		expiryLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		expiryLabel.setBorder(lineBorder);
		expiryLabel.setBounds(29, 163, 122, 32);
		expiryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardPanel.add(expiryLabel);
		
		cvvLabel = new JLabel("CVV");
		cvvLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		cvvLabel.setBorder(lineBorder);
		cvvLabel.setBounds(29, 220, 122, 32);
		cvvLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cardPanel.add(cvvLabel);
		
		phoneNoLabel = new JLabel("PHONE NUMBER");
		phoneNoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		phoneNoLabel.setFont(new Font("Tahoma", Font.BOLD, 8));
		phoneNoLabel.setBorder(lineBorder);
		phoneNoLabel.setBounds(29, 262, 122, 32);
		cardPanel.add(phoneNoLabel);
		
	
	}
	
	private void setDetailsTextField() {
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		nameField.setBounds(161, 55, 245, 32);
		cardPanel.add(nameField);
		nameField.setColumns(10);
		
		
		cardNoField = new JTextField();
		cardNoField.setFont(new Font("Tahoma", Font.BOLD, 10));
		cardNoField.setColumns(10);
		nameField.setFont(sitka);
		cardNoField.setBounds(161, 108, 245, 32);
		cardPanel.add(cardNoField);
		
		
		cvvField = new JPasswordField();
		cvvField.setBounds(161, 224, 94, 26);
		cardPanel.add(cvvField);
		
		phoneNoField = new JTextField();
		phoneNoField.setFont(new Font("Tahoma", Font.BOLD, 10));
		phoneNoField.setColumns(10);
		phoneNoField.setBounds(161, 260, 245, 32);
		cardPanel.add(phoneNoField);
		
	}
	
	private void setCardComboBox() {
		monthComboBox = new JComboBox(months);
		monthComboBox.setBounds(161, 166, 94, 27);
		cardPanel.add(monthComboBox);
		
		yearComboBox = new JComboBox(years);
		yearComboBox.setBounds(312, 166, 94, 27);
		cardPanel.add(yearComboBox);

	}
	
	private void setTimeComboBox() {
		
		inHour = new JComboBox(hours);
		inHour.setBounds(10, 70, 160, 20);
		inHour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox inH = (JComboBox)e.getSource();
				Object selected = inH.getSelectedItem();
				selectedInHour = Double.parseDouble((String) selected);			
			}
			
		});
		durationPanel.add(inHour);
		
		inMinutes = new JComboBox(minutes);
		inMinutes.setBounds(217, 70, 160, 20);
		inMinutes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox inM = (JComboBox)e.getSource();
				Object selected = inM.getSelectedItem();
				selectedInMinutes = Double.parseDouble((String) selected);			
			}
			
		});
		durationPanel.add(inMinutes);
		
		outHour = new JComboBox(hours);
		outHour.setBounds(10, 200, 160, 20);
		outHour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox outH = (JComboBox)e.getSource();
				Object selected = outH.getSelectedItem();
				selectedOutHour = Double.parseDouble((String) selected);			
			}
			
		});
		durationPanel.add(outHour);
		
		outMinutes = new JComboBox(minutes);
		outMinutes.setBounds(217, 200, 160, 20);
		outMinutes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox outM = (JComboBox)e.getSource();
				Object selected = outM.getSelectedItem();
				selectedOutMinutes = Double.parseDouble((String) selected);			
			}
			
		});
		durationPanel.add(outMinutes);
		
	}
	
	private void setButtons() {
		confirmDuration = new JButton("CONFIRM DURATION");
		confirmDuration.setIcon(confirm);
		confirmDuration.setFont(new Font("Tahoma", Font.BOLD, 15));
		confirmDuration.setBounds(10, 289, 219, 42);
		confirmDuration.addActionListener(new ConfirmDurationListener());
		durationPanel.add(confirmDuration);
		
		confirmBooking = new JButton("CONFIRM BOOKING");
		confirmBooking.setIcon(confirm);
		confirmBooking.addActionListener(new ConfirmBookingListener());
		confirmBooking.setFont(new Font("Tahoma", Font.BOLD, 12));
		confirmBooking.setBounds(29, 308, 176, 40);
		cardPanel.add(confirmBooking);
		
	}
	
	private class ConfirmDurationListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(selectedInHour>selectedOutHour) {
				JOptionPane.showMessageDialog(null, "INVALID TIME, PLEASE RE-ENTER","ERROR", JOptionPane.ERROR_MESSAGE);
			}else if((selectedInHour==selectedOutHour) && (selectedInMinutes<selectedOutMinutes)){
				JOptionPane.showMessageDialog(null, "INVALID TIME, PLEASE RE-ENTER","ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				fees obj = new fees();
				obj.calculateFees(selectedInHour, selectedInMinutes, selectedOutHour, selectedOutMinutes);
				total = obj.getFees();
				String converted_total = Double.toString(total);
				fareLabel.setText("FARE: RM"+converted_total);
				fareLabel.setVisible(true);
				confirmDuration.setEnabled(false);
			}
			
		}
		
	}
	
	private class ConfirmBookingListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		
			userName = nameField.getText();
			phoneNum = phoneNoField.getText();
			String card = cardNoField.getText();
			if(userName.length()==0 || phoneNum.length()==0 || card.length()==0) {
				JOptionPane.showMessageDialog(null, "PLEASE FILL UP ALL FIELDS", "ERROR", JOptionPane.ERROR_MESSAGE);
			}else if(phoneNum.length()<10) {
				JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID PHONE NUMBER", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {

				CreditCardValidation cardObject = new CreditCardValidation();
				cardObject.validate(card);
				if(cardObject.validate(card)==false) {
					JOptionPane.showMessageDialog(null, "ERROR, INVALID CARD, PLEASE RE-ENTER", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else if(cardObject.validate(card)==true) {
					System.out.println("BOOKING CONFIRMED");
					confirmBooking.setEnabled(false);
					frame.setVisible(false);
					receipt obj = new receipt(userName, phoneNum, (int)selectedInHour, (int)selectedInMinutes, (int)selectedOutHour, (int)selectedInMinutes, total, uniqueID);
				}
		}
			
		}
		
	}
	
}
