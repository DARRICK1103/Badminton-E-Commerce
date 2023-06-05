import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(143, 188, 143));
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(0, 10, 850, 103);
		panel.add(panel_1);
		
		JLabel lbTittle = new JLabel("BADMINTON E-COMMERCE");
		panel_1.add(lbTittle);
		lbTittle.setFont(new Font("Tahoma", Font.BOLD, 35));
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setBounds(189, 191, 211, 46);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblPassword.setBounds(189, 266, 211, 46);
		panel.add(lblPassword);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 28));
		username.setBounds(390, 191, 320, 46);
		panel.add(username);
		username.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(new Color(205, 133, 63));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnLogin.setBounds(478, 380, 232, 64);
		panel.add(btnLogin);
		/*btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		*/
		 btnLogin.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnLoginActionPerformed(evt);
	            }
	        });
		
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 28));
		passwordField.setBounds(390, 266, 320, 46);
		panel.add(passwordField);
		
		JButton btnRegister = new JButton("REGISTER");
		/*
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		 btnRegister.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnRegisterActionPerformed(evt);
	            }
	        });
		*/
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 29));
		btnRegister.setBackground(SystemColor.activeCaption);
		btnRegister.setBounds(161, 380, 221, 64);
		panel.add(btnRegister);
		 btnRegister.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnRegisterActionPerformed(evt);
	            }
	        });
	}
	
	private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
          String UserName, Password;
          UserName = username.getText();
          
          Password= new String(passwordField.getPassword());
          customerManager CustomerManager = new customerManager();
          adminManager AdminManager = new adminManager();
          int customerID = CustomerManager.getLogin(UserName, Password);
         
          int adminID = AdminManager.getLogin(UserName, Password);
           
          if(customerID!=0 && adminID ==0)
          {
        	 
        	  
        	  Product_1_GUI products = new Product_1_GUI(customerID);
        	  products.update(customerID);
        	  products.setVisible(true);
        	  dispose(); //close window
        	  
        	  
        	 
          }
          else if(adminID!=0 && customerID==0)
          {
        	  Admin_GUI admingui = new Admin_GUI(adminID);
        	  admingui.update(adminID);
        	  admingui.setVisible(true);
        	  dispose();
          }
          else
          {
        	  JOptionPane.showMessageDialog(this, "No user found ! Please try again !");
          }
				
	
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed
	
	private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
		
		Register_GUI register = new Register_GUI();
		register.setVisible(true);
		 dispose(); //close window
    }
	
	
}
