import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
public class userLogIn {
	private JFrame frame;
	private JPanel panel;
	private JLabel emailLabel, passwordLabel, logo;
	private JTextField email, password;
	private JPasswordField passwordField;
	private JButton login, CreateNewAccount;
	private ImageIcon parkingLogo = new ImageIcon("Images\\Logo.png");
	private ImageIcon key = new ImageIcon("Images\\key.png");
	private ImageIcon create = new ImageIcon("Images\\new.png");
	private ImageIcon frameLogo = new ImageIcon("Images\\parkingSign.png");
	private String enterMail, enterPass;
	
	public userLogIn() {
		setFrame();
		setLabels();
		setTextFields();
		setButtons();
		frame.setVisible(true);
	}
	
	private void setFrame() {
		frame = new JFrame();
		frame.setSize(750, 400);
		frame.setTitle("LOG IN");
		frame.setIconImage(frameLogo.getImage());
		frame.setResizable(false);
		//frame.setVisible(true);
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
		email.setBounds(227, 151, 293, 32);
		panel.add(email);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(227, 194, 293, 32);
		panel.add(passwordField);
	}
	
	private void setLabels() {
		emailLabel = new JLabel("E-MAIL:");
		emailLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		emailLabel.setBounds(125, 151, 92, 32);
		panel.add(emailLabel);
		
		passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordLabel.setBounds(125, 194, 92, 32);
		panel.add(passwordLabel);
		
		
		logo = new JLabel();
		logo.setIcon(parkingLogo);
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setBounds(206, -33, 328, 186);
		panel.add(logo);
		
		//setButtons();
	}
	
	private void setButtons() {
		login = new JButton("LOG IN");
		login.setIcon(key);
		login.addActionListener(new LogInListener());
		login.setForeground(new Color(255, 255, 255));
		login.setBackground(new Color(47, 79, 79));
		login.setFont(new Font("Tahoma", Font.BOLD, 15));
		login.setBounds(227, 256, 293, 37);
		panel.add(login);
		
		CreateNewAccount = new JButton("CREATE NEW ACCOUNT");
		CreateNewAccount.setIcon(create);
		CreateNewAccount.addActionListener(new NewAccountListener());
		CreateNewAccount.setForeground(new Color(255, 255, 255));
		CreateNewAccount.setBackground(new Color(47, 79, 79));
		CreateNewAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
		CreateNewAccount.setBounds(227, 303, 293, 37);
		panel.add(CreateNewAccount);
	}
	
	private class LogInListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			enterMail = email.getText();
			enterPass = passwordField.getText();
			System.out.println("MAIL: "+enterMail);
			System.out.println("PASS IS: "+enterPass);
			System.out.println();
			boolean match = false;
			try {
				Scanner scan = new Scanner(new File("texts\\LogInDetails.txt"));
				while(scan.hasNext()) {
					String email = scan.next();
					String pass = scan.next();
					System.out.println(email);
					System.out.println(pass);
					
					if((email.equals(enterMail) && (pass.equals(enterPass)))){
						System.out.println("Match!");
						match = true;
					}
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
			if(match==true) {
				System.out.println("Successful login");
				Menu obj = new Menu();
				frame.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null, "INVALID LOG IN DETAILS", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			

		}
		
	}
	
	private class NewAccountListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			createAccount obj =  new createAccount();
			frame.setVisible(false);
			
		}
		
	}
}
