import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Font;
public class carParkingSlots extends parkingStatus{
	private JFrame frame;
	private JPanel panel;
	private JPanel parkingpanel;
	private JPanel detailspanel;
	private JButton confirmButton, nextButton, backButton;
	private ButtonGroup btnGrp;
	private Border lineBorder = BorderFactory.createLineBorder(Color.black);
	private Font tahoma = new Font("Tahoma", Font.BOLD, 15);
	private JCheckBox selected;
	private JCheckBox r0c0, r0c1, r0c2, r0c3, r1c0,r1c1,r1c2,r1c3,r2c0,r2c1,r2c2,r2c3,r3c0,r3c1,r3c2,r3c3,r4c0,r4c1,r4c2,r4c3,r5c0,r5c1,r5c2,r5c3,r6c0,r6c1,r6c2,r6c3;
	private JLabel labelModel, labelBrand, labelColor, labelPlat;
	private JTextField vehicleModel, vehicleBrand, vehicleColor, vehiclePlat;
	private String model, brand, color, plat;
	private int uniqueID;
	private ImageIcon back = new ImageIcon("Images\\backIcon.png");
	private ImageIcon next = new ImageIcon("Images\\nextIcon.png");
	private ImageIcon confirm = new ImageIcon("Images\\confirmIcon.png");
	private ImageIcon frameLogo = new ImageIcon("Images\\parkingSign.png");
	
	public carParkingSlots() {
		setFrame_Panel();
		setCheckBox();
		setLabels();
		setTextFields();
		setButtons();
		frame.setVisible(true);
	}
	
	
	private void setFrame_Panel() {
		frame = new JFrame();
		frame.setSize(900, 550);
		frame.setIconImage(frameLogo.getImage());
		frame.setTitle("PARKING SLOT & VEHICLE DETAILS");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		parkingpanel = new JPanel();
		parkingpanel.setLocation(0, 0);
		parkingpanel.setSize(450, 495);
		parkingpanel.setLayout(null);
		parkingpanel.setBorder(BorderFactory.createTitledBorder("Parking Spaces"));
		panel.add(parkingpanel);
		
		detailspanel = new JPanel();
		detailspanel.setBounds(460, 0, 450, 495);
		detailspanel.setLayout(null);
		detailspanel.setBorder(BorderFactory.createTitledBorder("Vehicle Details"));
		panel.add(detailspanel);
		
	}
	
	private void setLabels() {
		labelModel = new JLabel("Brand");
		labelModel.setFont(tahoma);
		labelModel.setBounds(10, 30, 100, 25);
		labelModel.setBorder(lineBorder);
		detailspanel.add(labelModel);
		
		labelBrand = new JLabel("Model");
		labelBrand.setFont(tahoma);
		labelBrand.setBounds(10,90, 100, 25);
		labelBrand.setBorder(lineBorder);
		detailspanel.add(labelBrand);
		
		labelColor = new JLabel("Color");
		labelColor.setFont(tahoma);
		labelColor.setBounds(10, 150, 100, 25);
		labelColor.setBorder(lineBorder);
		detailspanel.add(labelColor);
		
		labelPlat = new JLabel("Plat No");
		labelPlat.setFont(tahoma);
		labelPlat.setBounds(10, 210, 100, 25);
		labelPlat.setBorder(lineBorder);
		detailspanel.add(labelPlat);
		
		
	}
	
	private void setTextFields() {
		vehicleBrand = new JTextField();
		vehicleBrand.setBounds(120, 30, 250, 25);
		vehicleBrand.setFont(tahoma);
		detailspanel.add(vehicleBrand);
		vehicleBrand.setEnabled(false);
		
		vehicleModel = new JTextField();
		vehicleModel.setBounds(120, 90, 250, 25);
		vehicleModel.setFont(tahoma);
		detailspanel.add(vehicleModel);
		vehicleModel.setEnabled(false);
		
		vehicleColor = new JTextField();
		vehicleColor.setBounds(120, 150, 250, 25);
		vehicleColor.setFont(tahoma);
		detailspanel.add(vehicleColor);
		vehicleColor.setEnabled(false);
		
		vehiclePlat = new JTextField();
		vehiclePlat.setBounds(120, 210, 250, 25);
		vehiclePlat.setFont(tahoma);
		detailspanel.add(vehiclePlat);
		vehiclePlat.setEnabled(false);
		
	
	}
	
	private void setCheckBox() {
		btnGrp = new ButtonGroup();
		initializeParking();
		
		r0c0 = new JCheckBox("00");
		r0c0.setBounds(10,23,100, 23);
		r0c0.setBorder(lineBorder);
		r0c0.addItemListener(new BoxListener());
		//r0c0.setBackground(Color.green);
		checkParking(r0c0);
		btnGrp.add(r0c0);
		parkingpanel.add(r0c0);
		
		r0c1 = new JCheckBox("01");
		r0c1.setBounds(120,23,100, 23);
		r0c1.setBorder(lineBorder);
		r0c1.addItemListener(new BoxListener());
		//r0c1.setBackground(Color.green);
		checkParking(r0c1);
		btnGrp.add(r0c1);
		parkingpanel.add(r0c1);
		
		r0c2 = new JCheckBox("02");
		r0c2.setBounds(230,23,100, 23);
		r0c2.setBorder(lineBorder);
		r0c2.addItemListener(new BoxListener());
		//r0c2.setBackground(Color.green);
		checkParking(r0c2);
		btnGrp.add(r0c2);
		parkingpanel.add(r0c2);
		
		r0c3 = new JCheckBox("03");
		r0c3.setBounds(340,23,100, 23);
		r0c3.setBorder(lineBorder);
		r0c3.addItemListener(new BoxListener());
		//r0c3.setBackground(Color.green);
		checkParking(r0c3);
		btnGrp.add(r0c3);
		parkingpanel.add(r0c3);
		
		r1c0 = new JCheckBox("10");
		r1c0.setBounds(10,67,100, 23);
		r1c0.setBorder(lineBorder);
		r1c0.addItemListener(new BoxListener());
		//r1c0.setBackground(Color.green);
		checkParking(r1c0);
		btnGrp.add(r1c0);
		parkingpanel.add(r1c0);
		
		r1c1 = new JCheckBox("11");
		r1c1.setBounds(120,67,100, 23);
		r1c1.setBorder(lineBorder);
		r1c1.addItemListener(new BoxListener());
		//r1c1.setBackground(Color.green);
		checkParking(r1c1);
		btnGrp.add(r1c1);
		parkingpanel.add(r1c1);
		
		r1c2= new JCheckBox("12");
		r1c2.setBounds(230,67,100, 23);
		r1c2.setBorder(lineBorder);
		r1c2.addItemListener(new BoxListener());
		//r1c2.setBackground(Color.green);
		checkParking(r1c2);
		btnGrp.add(r1c2);
		parkingpanel.add(r1c2);
		
		r1c3 = new JCheckBox("13");
		btnGrp.add(r1c3);
		r1c3.setBorder(lineBorder);
		r1c3.addItemListener(new BoxListener());
		//r1c3.setBackground(Color.GREEN);
		checkParking(r1c3);
		r1c3.setBounds(340, 68, 100, 23);
		parkingpanel.add(r1c3);
		
		r2c0 = new JCheckBox("20");
		btnGrp.add(r2c0);
		r2c0.setBorder(lineBorder);
		r2c0.addItemListener(new BoxListener());
		//r2c0.setBackground(Color.GREEN);
		checkParking(r2c0);
		r2c0.setBounds(10, 109, 100, 23);
		parkingpanel.add(r2c0);
		
		r2c1 = new JCheckBox("21");
		btnGrp.add(r2c1);
		r2c1.setBorder(lineBorder);
		r2c1.addItemListener(new BoxListener());
		//r2c1.setBackground(Color.GREEN);
		checkParking(r2c1);
		r2c1.setBounds(120, 110, 100, 23);
		parkingpanel.add(r2c1);
		
		r2c2 = new JCheckBox("22");
		btnGrp.add(r2c2);
		r2c2.setBorder(lineBorder);
		r2c2.addItemListener(new BoxListener());
		//r2c2.setBackground(Color.GREEN);
		checkParking(r2c2);
		r2c2.setBounds(230, 110, 100, 23);
		parkingpanel.add(r2c2);
		
		r2c3 = new JCheckBox("23");
		btnGrp.add(r2c3);
		r2c3.setBorder(lineBorder);
		r2c3.addItemListener(new BoxListener());
		//r2c3.setBackground(Color.GREEN);
		checkParking(r2c3);
		r2c3.setBounds(340, 111, 100, 23);
		parkingpanel.add(r2c3);
		
		r3c0 = new JCheckBox("30");
		btnGrp.add(r3c0);
		r3c0.setBorder(lineBorder);
		r3c0.addItemListener(new BoxListener());
		//r3c0.setBackground(Color.GREEN);
		checkParking(r3c0);
		r3c0.setBounds(10, 158, 100, 23);
		parkingpanel.add(r3c0);
		
		r3c1 = new JCheckBox("31");
		btnGrp.add(r3c1);
		r3c1.setBorder(lineBorder);
		r3c1.addItemListener(new BoxListener());
		//r3c1.setBackground(Color.GREEN);
		checkParking(r3c1);
		r3c1.setBounds(120, 159, 100, 23);
		parkingpanel.add(r3c1);
		
		r3c2 = new JCheckBox("32");
		btnGrp.add(r3c2);
		r3c2.setBorder(lineBorder);
		r3c2.addItemListener(new BoxListener());
		//r3c2.setBackground(Color.GREEN);
		checkParking(r3c2);
		r3c2.setBounds(230, 159, 100, 23);
		parkingpanel.add(r3c2);
		
		r3c3 = new JCheckBox("33");
		btnGrp.add(r3c3);
		r3c3.setBorder(lineBorder);
		r3c3.addItemListener(new BoxListener());
		//r3c3.setBackground(Color.GREEN);
		checkParking(r3c3);
		r3c3.setBounds(340, 159, 100, 23);
		parkingpanel.add(r3c3);
		
		r4c0 = new JCheckBox("40");
		btnGrp.add(r4c0);
		r4c0.setBorder(lineBorder);
		r4c0.addItemListener(new BoxListener());
		//r4c0.setBackground(Color.GREEN);
		checkParking(r4c0);
		r4c0.setBounds(10, 285, 100, 23);
		parkingpanel.add(r4c0);
		
		r4c1 = new JCheckBox("41");
		btnGrp.add(r4c1);
		r4c1.setBorder(lineBorder);
		r4c1.addItemListener(new BoxListener());
		//r4c1.setBackground(Color.GREEN);
		checkParking(r4c1);
		r4c1.setBounds(120, 286, 100, 23);
		parkingpanel.add(r4c1);
		
		r4c2 = new JCheckBox("42");
		btnGrp.add(r4c2);
		r4c2.setBorder(lineBorder);
		r4c2.addItemListener(new BoxListener());
		//r4c2.setBackground(Color.GREEN);
		checkParking(r4c2);
		r4c2.setBounds(230, 286, 100, 23);
		parkingpanel.add(r4c2);
		
		r4c3 = new JCheckBox("43");
		btnGrp.add(r4c3);
		r4c3.setBorder(lineBorder);
		r4c3.addItemListener(new BoxListener());
		//r4c3.setBackground(Color.GREEN);
		checkParking(r4c3);
		r4c3.setBounds(340, 286, 100, 23);
		parkingpanel.add(r4c3);
		
		r5c0 = new JCheckBox("50");
		btnGrp.add(r5c0);
		r5c0.setBorder(lineBorder);
		r5c0.addItemListener(new BoxListener());
		//r5c0.setBackground(Color.GREEN);
		checkParking(r5c0);
		r5c0.setBounds(10, 335, 100, 23);
		parkingpanel.add(r5c0);
		
		r5c1 = new JCheckBox("51");
		btnGrp.add(r5c1);
		r5c1.setBorder(lineBorder);
		r5c1.addItemListener(new BoxListener());
		//r5c1.setBackground(Color.GREEN);
		checkParking(r5c1);
		r5c1.setBounds(120, 336, 100, 23);
		parkingpanel.add(r5c1);
		
		r5c2 = new JCheckBox("52");
		btnGrp.add(r5c2);
		r5c2.setBorder(lineBorder);
		r5c2.addItemListener(new BoxListener());
		//r5c2.setBackground(Color.GREEN);
		checkParking(r5c2);
		r5c2.setBounds(230, 336, 100, 23);
		parkingpanel.add(r5c2);
		
		r5c3 = new JCheckBox("53");
		btnGrp.add(r5c3);
		r5c3.setBorder(lineBorder);
		r5c3.addItemListener(new BoxListener());
		//r5c3.setBackground(Color.GREEN);
		checkParking(r5c3);
		r5c3.setBounds(340, 337, 100, 23);
		parkingpanel.add(r5c3);
		
		r6c0 = new JCheckBox("60");
		btnGrp.add(r6c0);
		r6c0.setBorder(lineBorder);
		r6c0.addItemListener(new BoxListener());
		//r6c0.setBackground(Color.GREEN);
		checkParking(r6c0);
		r6c0.setBounds(10, 381, 100, 23);
		parkingpanel.add(r6c0);
		
		r6c1 = new JCheckBox("61");
		btnGrp.add(r6c1);
		r6c1.setBorder(lineBorder);
		r6c1.addItemListener(new BoxListener());
		//r6c1.setBackground(Color.GREEN);
		checkParking(r6c1);
		r6c1.setBounds(120, 382, 100, 23);
		parkingpanel.add(r6c1);
		
		r6c2 = new JCheckBox("62");
		btnGrp.add(r6c2);
		r6c2.setBorder(lineBorder);
		r6c2.addItemListener(new BoxListener());
		//r6c2.setBackground(Color.GREEN);
		checkParking(r6c2);
		r6c2.setBounds(230, 382, 100, 23);
		parkingpanel.add(r6c2);
		
		r6c3 = new JCheckBox("63");
		btnGrp.add(r6c3);
		r6c3.setBorder(lineBorder);
		r6c3.addItemListener(new BoxListener());
		//r6c3.setBackground(Color.GREEN);
		checkParking(r6c3);
		r6c3.setBounds(340, 382, 100, 23);
		parkingpanel.add(r6c3);
	
	}
	
	private void setButtons() {
		confirmButton = new JButton("CONFIRM PARKING");
		confirmButton.setIcon(confirm);
		confirmButton.setFont(new Font("Sitka Text", Font.BOLD, 17));
		confirmButton.setBounds(10, 434, 430, 37);
		confirmButton.addActionListener(new ConfirmListener());
		parkingpanel.add(confirmButton);
		//confirmButton.setEnabled(false);
		confirmButton.setBorder(BorderFactory.createRaisedBevelBorder());
		
		nextButton = new JButton();
		nextButton.setIcon(next);
		nextButton.setFont(new Font("Sitka Text", Font.BOLD, 17));
		nextButton.setBounds(10, 308, 401, 37);
		nextButton.addActionListener(new nextListener());	
		nextButton.setEnabled(false);
		detailspanel.add(nextButton);
		//nextButton.setEnabled(false);
		
		backButton = new JButton();
		backButton.setIcon(back);
		backButton.setFont(new Font("Sitka Text", Font.BOLD, 17));
		backButton.setBounds(10, 380, 401, 37);
		backButton.addActionListener(new backListener());
		detailspanel.add(backButton);
		
		
	}
	
	private class BoxListener implements ItemListener{
		
		public void itemStateChanged(ItemEvent e) {
			selected = (JCheckBox) e.getItem();
			System.out.println(selected);
			if(e.getStateChange()==ItemEvent.SELECTED) {
				selected.setBackground(Color.red);
			}else if(e.getStateChange()==ItemEvent.DESELECTED) {
				selected.setBackground(Color.green);
			}
		}
		
	}
	
	private class ConfirmListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.out.println("Successful booking at spot: " + selected.getText());
			vehicleBrand.setEnabled(true);
			vehicleModel.setEnabled(true);
			vehicleColor.setEnabled(true);
			vehiclePlat.setEnabled(true);
			selected.setSelected(true);
			selected.setBackground(Color.RED);
			confirmButton.setEnabled(false);
			backButton.setEnabled(false);
			nextButton.setEnabled(true);
			updateParking(selected.getText());		
			print();
			r0c0.setEnabled(false);
			r0c1.setEnabled(false);
			r0c2.setEnabled(false);
			r0c3.setEnabled(false);
			r1c0.setEnabled(false);
			r1c1.setEnabled(false);
			r1c2.setEnabled(false);
			r1c3.setEnabled(false);
			r2c0.setEnabled(false);
			r2c1.setEnabled(false);
			r2c2.setEnabled(false);
			r2c3.setEnabled(false);
			r3c0.setEnabled(false);
			r3c1.setEnabled(false);
			r3c2.setEnabled(false);
			r3c3.setEnabled(false);
			r4c0.setEnabled(false);
			r4c1.setEnabled(false);
			r4c2.setEnabled(false);
			r4c3.setEnabled(false);
			r5c0.setEnabled(false);
			r5c1.setEnabled(false);
			r5c2.setEnabled(false);
			r5c3.setEnabled(false);
			r6c0.setEnabled(false);
			r6c1.setEnabled(false);
			r6c2.setEnabled(false);
			r6c3.setEnabled(false);
			
			
		}
		
	}
	
	private class nextListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			model = vehicleModel.getText();
			brand = vehicleBrand.getText();
			color = vehicleColor.getText();
			plat = vehiclePlat.getText();
			if(model.length()==0 || brand.length()==0 || color.length()==0 || plat.length()==0) {
				JOptionPane.showMessageDialog(nextButton, "PLEASE FILL UP ALL FIELDS", "ERROR", JOptionPane.ERROR_MESSAGE);
			}else {
				System.out.println("next pressed");
				uniqueID = getUniqueID();
				System.out.println("UNIQUE ID IS: "+uniqueID);
				writeVehicleDetails();
				payment obj = new payment(uniqueID);
				frame.setVisible(false);
			}
			
		}
		
	}
	
	private class backListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Menu obj = new Menu();
			frame.setVisible(false);
		}
	}
	
	private void writeVehicleDetails() {
		try {
		      FileWriter carWriter = new FileWriter("texts\\carDetails.txt", true);
		      carWriter.write("MODEL: "+model+"\nBRAND: "+brand+"\nCOLOR: "+color+"\nPLAT NO: "+plat+"\n\n\n\n");
		      carWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}

