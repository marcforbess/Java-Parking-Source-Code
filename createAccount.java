import java.awt.Color;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class createAccount {
	private JFrame frame;
	private JPanel panel;
	private JTextField email, name, dob, password;
	private JLabel lblNewLabel;
	private JLabel lblEmail;
	private JLabel lblDobddmmyy;
	private JLabel lblPassword;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton backButton;
	private ImageIcon register = new ImageIcon("Images\\registerIcon.png");
	private ImageIcon back = new ImageIcon("Images\\backIcon.png");
	private ImageIcon frameLogo = new ImageIcon("Images\\parkingSign.png");
	
	public createAccount() {
		setFrame();
		setLabels();
		setTextFields();
		setButton();
		frame.setVisible(true);
	}
	
	private void setFrame() {
		frame = new JFrame();
		frame.setSize(750, 400);
		frame.setTitle("CREATE ACCOUNT");
		frame.setIconImage(frameLogo.getImage());
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPanel();
	}
	
	private void setPanel() {
		panel = new JPanel();
		panel.setBounds(0, 0, 750, 400);
		panel.setLayout(null);
		panel.setBackground(new Color(0, 139, 139));
		frame.getContentPane().add(panel);
	}
	
	private void setTextFields() {
		email = new JTextField();
		email.setBounds(135, 118, 250, 31);
		panel.add(email);
		
		name = new JTextField();
		name.setBounds(135, 77, 250, 31);
		panel.add(name);
		
		dob = new JTextField();
		dob.setBounds(135, 159, 250, 31);
		panel.add(dob);
		
		password = new JPasswordField();
		password.setBounds(135, 200, 250, 31);
		panel.add(password);
		
	}
	
	private void setLabels() {
		lblNewLabel = new JLabel("NAME");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 77, 115, 31);
		panel.add(lblNewLabel);
		
		lblEmail = new JLabel("E-MAIL");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(10, 118, 115, 31);
		panel.add(lblEmail);
		
		lblDobddmmyy = new JLabel("DOB (DD/MM/YY)");
		lblDobddmmyy.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDobddmmyy.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDobddmmyy.setBounds(10, 159, 115, 31);
		panel.add(lblDobddmmyy);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(10, 200, 115, 31);
		panel.add(lblPassword);
		
		lblNewLabel_1 = new JLabel("CREATE ACCOUNT");
		lblNewLabel_1.setFont(new Font("STHupo", Font.PLAIN, 34));
		lblNewLabel_1.setForeground(new Color(240, 255, 255));
		lblNewLabel_1.setBounds(31, 24, 305, 31);
		panel.add(lblNewLabel_1);
		
	}
	
	private void setButton() {
		btnNewButton = new JButton("REGISTER");
		btnNewButton.setIcon(register);
		btnNewButton.addActionListener(new RegisterListener());
		btnNewButton.setForeground(new Color(124, 252, 0));
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(42, 272, 174, 44);
		panel.add(btnNewButton);
		
		backButton = new JButton();
		backButton.setForeground(Color.BLACK);
		backButton.setIcon(back);
		backButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		backButton.setBackground(new Color(47, 79, 79));
		backButton.setBounds(257, 272, 174, 44);
		backButton.addActionListener(new backListener());
		panel.add(backButton);
	}
	
	private class RegisterListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String usermail = email.getText();
			String userpass = password.getText();
			String userDOB = dob.getText();
			String username = name.getText();
			
			if(usermail.length()==0 || userpass.length()==0 || userDOB.length()==0 || username.length()==0) {
				JOptionPane.showMessageDialog(null, "PLEASE FILL UP ALL FIELDS", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {

				try {
			      FileWriter accWriter = new FileWriter("texts\\LogInDetails.txt", true);
				  accWriter.write(usermail+" "+userpass+"\n");
				  accWriter.close();
				  System.out.println("Successfully wrote to the file.");
				  JOptionPane.showMessageDialog(null, "ACCOUNT CREATED SUCCESSFULLY");
				  frame.setVisible(false);
				  userLogIn obj = new userLogIn();
				} catch (IOException e1) {
				     System.out.println("An error occurred.");
				     e1.printStackTrace();
				   }
		}
		}
		
	}
	
	private class backListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			userLogIn obj = new userLogIn();
			frame.setVisible(false);
		}
		
	}
	
}
