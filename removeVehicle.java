import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class removeVehicle extends parkingStatus{
	private JFrame frame;
	private JPanel panel;
	private JTextField IDField;
	private JLabel IDText;
	private JButton remove;
	private Border bevelborder = BorderFactory.createBevelBorder(0, Color.black, Color.gray);
	private Font tahoma = new Font("Tahoma", Font.BOLD, 15);
	private JButton backButton;
	private ImageIcon back = new ImageIcon("Images\\backIcon.png");
	private ImageIcon removeIcon = new ImageIcon("Images\\removeIcon.png");
	private ImageIcon frameLogo = new ImageIcon("Images\\parkingSign.png");
	
	public removeVehicle() {
		setFrame();
		setLabel();
		setTextField();
		setButton();
		frame.setVisible(true);
	}
	
	private void setFrame() {
		frame = new JFrame();
		frame.setSize(500, 250);
		frame.setIconImage(frameLogo.getImage());
		frame.setTitle("REMOVE VEHICLE MENU");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPanel();	
	}
	
	private void setPanel() {
		panel = new JPanel();
		panel.setBounds(0,0,500, 250);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
	}
	
	private void setLabel() {
		IDText = new JLabel("ENTER UNIQUE ID");
		IDText.setFont(tahoma);
		IDText.setBorder(bevelborder);
		IDText.setHorizontalAlignment(SwingConstants.CENTER);
		IDText.setBounds(21, 23, 193, 28);
		panel.add(IDText);
		
	}
	
	private void setTextField() {	
		IDField = new JTextField();
		IDField.setBounds(139, 61, 320, 28);
		panel.add(IDField);
		IDField.setColumns(10);
	}
	
	private void setButton() {	
		remove = new JButton("REMOVE");
		remove.setIcon(removeIcon);
		remove.setBounds(21, 61, 108, 28);
		remove.addActionListener(new RemoveListener());
		panel.add(remove);
		
		backButton = new JButton();
		backButton.setIcon(back);
		backButton.setBounds(21, 171, 108, 28);
		backButton.addActionListener(new backListener());
		panel.add(backButton);
	}
	
	private class RemoveListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String text = IDField.getText();
			if(text.length()==0) {
				JOptionPane.showMessageDialog(IDField, "Please Enter the Unique ID of your booking","ERROR!", JOptionPane.ERROR_MESSAGE);
			}else {
				initializeParking();
				checkforUniqueID(text);
			}
			
		}
		
	}
	
	private class backListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Menu obj = new Menu();
		}
		
	}
}
