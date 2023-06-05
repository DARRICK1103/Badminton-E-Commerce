import java.awt.EventQueue;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Product_Admin_GUI extends JFrame {

	private JPanel contentPane;

	private JLabel find;
	public static int adminID;
	public static int productID;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order_3_GUI frame = new Order_3_GUI(adminID, productID);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void updateAdmin(int adminID)
	{
		Product_Admin_GUI.adminID = adminID;
		
	}
	public void updatePro(int productID)
	{
		Product_Admin_GUI.productID = productID;
		
	}
	

	/**
	 * Create the frame.
	 */
	public Product_Admin_GUI(int adminID, int productID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		productManager ProductManager = new productManager();
		Product product = ProductManager.get(productID);
		
		
		JLabel lbImage = new JLabel("");
		lbImage.setBounds(35, 55, 252, 252);
		String location = "C:\\Users\\User\\Desktop\\OOP_IMAGES\\" + productID + ".png";
		lbImage.setIcon(new ImageIcon(location));
		contentPane.add(lbImage);
		validate();
		
		JLabel lblProduct_Name = new JLabel(product.getProduct_Name());
		lblProduct_Name.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblProduct_Name.setBounds(334, 131, 493, 79);
		contentPane.add(lblProduct_Name);
		
		JLabel lblPrice = new JLabel("PRICE:  RM " + product.getPrice());
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPrice.setBounds(35, 326, 222, 62);
		contentPane.add(lblPrice);
		
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnGoBack.setBounds(35, 560, 176, 79);
		contentPane.add(btnGoBack);
		
		find = new JLabel("");
		find.setBounds(296, 627, 241, 67);
		contentPane.add(find);
		
		
		
		btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });
	}
	

	

	
	private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Admin_GUI admin = new Admin_GUI(adminID);
        admin.setVisible(true);
		dispose();
        
    }
	

}
