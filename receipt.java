import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class receipt {
	
	private JFrame frame;
	private JPanel panel;
	private JPanel receiptPanel;
	private JButton finishButton;
	private JLabel nameLabel;
	private JLabel uniqueIDLabel;
	private JLabel timeinLabel;
	private JLabel timeoutLabel;
	private JLabel fareLabel;
	private Border lowered = BorderFactory.createLoweredBevelBorder();
	private int uniqueID, inHour, inMinute, outHour, outMinute;
	private double parkingFee;
	private String userName, phoneNum,convUniqueID, timeIn, timeOut, convParkingFee;	
	private JLabel showName;
	private JLabel showUniqueID;
	private JLabel showTimeIn;
	private JLabel showTimeOut;
	private JLabel showFare;
	private ImageIcon home = new ImageIcon("Images\\homeIcon.png");
	private ImageIcon frameLogo = new ImageIcon("Images\\parkingSign.png");

	
	private void run() {
		setFrame_Panel();
		setReceiptPanel();
		convertToStrings();
		setLabels();
		setFinishButton();
		frame.setVisible(true);
	}
	
	public receipt(String userName, String phoneNum, int inHour, int inMin, int outHour, int outMin, double total, int UniqueID) {
		this.userName = userName;
		this.phoneNum = phoneNum;
		this.inHour = inHour;
		this.inMinute = inMin;
		this.outHour = outHour;
		this.outMinute = outMin;
		this.parkingFee = total;
		this.uniqueID = UniqueID;
		run();
	}
	
	private void setFrame_Panel() {
		frame = new JFrame();
		frame.setSize(700, 350);
		frame.setIconImage(frameLogo.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 700, 350);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
			
	}
	
	private void setReceiptPanel() {
		receiptPanel = new JPanel();
		receiptPanel.setBounds(10, 10, 653, 190);
		receiptPanel.setLayout(null);
		receiptPanel.setBorder(BorderFactory.createTitledBorder("e-RECEIPT"));
		panel.add(receiptPanel);
		
		
	}
	
	private void convertToStrings() {
		String convInHour = Integer.toString(inHour);
		String convInMinute = Integer.toString(inMinute);
		String convOutHour = Integer.toString(outHour);
		String convOutMinute = Integer.toString(outMinute);
		convUniqueID = Integer.toString(uniqueID);
		timeIn = String.format("%s : %s", convInHour, convInMinute);
		timeOut = String.format("%s : %s", convOutHour, convOutMinute);
		convParkingFee = Double.toString(parkingFee);
		
	}
	
	private void setLabels() {
		nameLabel = new JLabel("Name");
		nameLabel.setBorder(lowered);
		nameLabel.setBounds(21, 21, 80, 20);
		receiptPanel.add(nameLabel);
		
		uniqueIDLabel = new JLabel("Unique ID");
		uniqueIDLabel.setBorder(lowered);
		uniqueIDLabel.setBounds(21, 51, 80, 20);
		receiptPanel.add(uniqueIDLabel);
		
		timeinLabel = new JLabel("Time in");
		timeinLabel.setBorder(lowered);
		timeinLabel.setBounds(21, 81, 80, 20);
		receiptPanel.add(timeinLabel);
		
		timeoutLabel = new JLabel("Time Out");
		timeoutLabel.setBorder(lowered);
		timeoutLabel.setBounds(21, 111, 80, 20);
		receiptPanel.add(timeoutLabel);
		
		fareLabel = new JLabel("Fare");
		fareLabel.setBorder(lowered);
		fareLabel.setBounds(21, 141, 80, 20);
		receiptPanel.add(fareLabel);
		
		showName = new JLabel(userName);
		showName.setBounds(111, 23, 308, 17);
		receiptPanel.add(showName);
		
		showUniqueID = new JLabel(convUniqueID);
		showUniqueID.setBounds(111, 53, 308, 17);
		receiptPanel.add(showUniqueID);
		
		showTimeIn = new JLabel(timeIn);
		showTimeIn.setBounds(111, 83, 308, 17);
		receiptPanel.add(showTimeIn);
		
		showTimeOut = new JLabel(timeOut);
		showTimeOut.setBounds(111, 113, 308, 17);
		receiptPanel.add(showTimeOut);
		
		showFare = new JLabel("RM"+convParkingFee);
		showFare.setBounds(111, 141, 308, 17);
		receiptPanel.add(showFare);
	}
	
	private void setFinishButton() {
		
		finishButton = new JButton("HOME");
		finishButton.setIcon(home);
		finishButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		finishButton.setBounds(10, 220, 212, 51);
		finishButton.addActionListener(new FinishButtonListener());
		panel.add(finishButton);
	}
	
	private void writeReceipt() {
		try {
		      FileWriter receiptWriter = new FileWriter("texts\\userReceipt.txt", true);
		      receiptWriter.write("NAME: "+userName+"\nUNIQUE ID: "+convUniqueID+"\nTIME IN: "+timeIn+"\nTIME OUT: "+timeOut+"\nFARE: RM"+convParkingFee+"\n\n\n");
		      receiptWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	private class FinishButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "The copy of the receipt has been sent to " + phoneNum);
			writeReceipt();
			frame.setVisible(false);
			Menu obj = new Menu();
			
		}
		
	}
	
	
}
