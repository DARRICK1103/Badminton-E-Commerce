import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Register_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField IC;
	private JTextField address;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_GUI frame = new Register_GUI();
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
	public Register_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1148, 770);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(32, 178, 170));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(112, 22, 861, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CUSTOMER REGISTRATION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(184, 10, 447, 82);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(112, 142, 861, 502);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("NAME              :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(23, 22, 277, 63);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("IC                    :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(23, 116, 207, 63);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Address          :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_2.setBounds(23, 214, 207, 63);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Username      :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_3.setBounds(23, 310, 207, 63);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Password       :");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_4.setBounds(23, 402, 207, 63);
		panel_1.add(lblNewLabel_1_4);
		
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.BOLD, 25));
		name.setBounds(249, 35, 539, 50);
		panel_1.add(name);
		name.setColumns(10);
		
		IC = new JTextField();
		IC.setFont(new Font("Tahoma", Font.BOLD, 25));
		IC.setColumns(10);
		IC.setBounds(249, 129, 539, 50);
		panel_1.add(IC);
		
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.BOLD, 25));
		address.setColumns(10);
		address.setBounds(249, 227, 539, 50);
		panel_1.add(address);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.BOLD, 25));
		username.setColumns(10);
		username.setBounds(249, 323, 539, 50);
		panel_1.add(username);
		
		password = new JTextField();
		password.setFont(new Font("Tahoma", Font.BOLD, 25));
		password.setColumns(10);
		password.setBounds(249, 415, 539, 50);
		panel_1.add(password);
		
		JButton btnNewButton = new JButton("CONFIRM");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(737, 661, 248, 62);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewButtonActionPerformed(evt);
            }
        });
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnCancel.setBounds(101, 661, 248, 62);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
	}
	
	private boolean checkEmpty()
	{
		String Name = name.getText();
		if(Name == null || Name.trim().equals( "" ))
		{
			return true; // no name
		}
		
		String ic = IC.getText();
		if(ic == null || ic.trim().equals( "" ))
		{
			return true; // no ic
		}
		
		String Address = address.getText();
		if(Address == null || Address.trim().equals( "" ))
		{
			return true; // no address
		}
		
		String Username = username.getText();
		if(Username == null || Username.trim().equals( "" ))
		{
			return true; // no username
		}	
		
		
		String P = password.getText();
		if(P == null || P.trim().equals( "" ))
		{
			return true; // no password
		}	
		return false;
		
	}
	
	private void btnNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
		
		
	
		try {
			Customer customer = new Customer();
	        customer.setCustomer_Name(name.getText());
	        customer.setCustomer_IC(IC.getText()); 
	        customer.setCustomer_Address(address.getText()); 
	        customer.setCustomer_Username(username.getText()); 
	        customer.setCustomer_Password(password.getText()); 
			
			customerManager CustomerManager = new customerManager();
			adminManager AdminManager = new adminManager();
			boolean check = checkEmpty();
			if(check != true)
			{

				if(CustomerManager.checkUsername(customer.getCustomer_Username())!= true && AdminManager.checkAdminUsername(customer.getCustomer_Username())!=true)
				{
					CustomerManager.insert(customer);
					
					LoginGUI login = new LoginGUI();
					login.setVisible(true);
					dispose();
				}
				else 
				{
					JOptionPane.showMessageDialog(this, "Username already exists. Please change another one !");
				}
			}
			else
				JOptionPane.showMessageDialog(this, "Please make sure that you insert all the data");
		
			
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, "Error !");
		}
		
        
    }
	
	private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
		LoginGUI login = new LoginGUI();
		login.setVisible(true);
        
    }

}
