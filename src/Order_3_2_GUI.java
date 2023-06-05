import java.awt.EventQueue;
import java.awt.Font;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Order_3_2_GUI extends JFrame {

	private JPanel contentPane;

	private JLabel find;
	private JTextField QUANTITY;
	public static int productID;
	public static int customerID;
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order_3_2_GUI frame = new Order_3_2_GUI(productID, customerID);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void updatePro(int productID)
	{
		Order_3_2_GUI.productID = productID;
		
	}
	
	public void updateCus(int customerID)
	{
		Order_3_2_GUI.customerID = customerID;
	}
	


	/**
	 * Create the frame.
	 */
	public Order_3_2_GUI(int productID, int customerID) {
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
		String location = "OOP_IMAGES/" + productID + ".png";
		lbImage.setIcon(new ImageIcon(location));
		contentPane.add(lbImage);
		validate();
		
		JLabel lblProduct_Name = new JLabel(product.getProduct_Name());
		lblProduct_Name.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblProduct_Name.setBounds(334, 131, 493, 79);
		contentPane.add(lblProduct_Name);
		
		double price = product.getPrice();
		DecimalFormat df = new DecimalFormat("0.00");
		JLabel lblPrice = new JLabel("PRICE:  RM " + df.format(price));
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPrice.setBounds(35, 326, 327, 62);
		contentPane.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("QUANTITY :");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblQuantity.setBounds(224, 438, 159, 62);
		contentPane.add(lblQuantity);
		
		QUANTITY = new JTextField();
		QUANTITY.setFont(new Font("Tahoma", Font.BOLD, 25));
		QUANTITY.setBounds(384, 443, 153, 57);
		contentPane.add(QUANTITY);
		QUANTITY.setColumns(10);
		
		JButton btnNEXT = new JButton("NEXT");
		btnNEXT.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNEXT.setBounds(624, 560, 176, 79);
		
		contentPane.add(btnNEXT);
		btnNEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            	boolean test = btnNEXTActionPerformed(evt);
        		if(test == true) //insert quantity as integer
        		{
        			
        			
        			
        			ordersManager OrderManager = new ordersManager();
        			int orderID = OrderManager.getLatestID();
        			Order order = OrderManager.get(orderID);
        			int paymentID = order.getPayment_ID();
        			
        			listManager ListManager = new listManager();
        			OrderList orderlist = new OrderList();
        			orderlist.setProduct_ID(productID); 
        			orderlist.setOrder_ID(orderID);
        			
        			
        		
        			productManager ProductManager = new productManager();
        			Product product = ProductManager.get(productID);
        			int quantity = Integer.parseInt(QUANTITY.getText());
        			double price = product.getPrice();
        			orderlist.setQuantity(quantity);
        			double subtotal = quantity*price;
        			orderlist.setSubtotal(subtotal);
        			
        			ListManager.insert(orderlist);
        			
        			TablePurchase_GUI purchase = new TablePurchase_GUI(productID, quantity, customerID, paymentID, orderID);
        			purchase.updateProductID(productID);
        			purchase.updateQuantity(quantity);
        			purchase.updateCustomer(customerID);
        			purchase.updatePayment(paymentID);
        			purchase.updateOrder(orderID);
        			purchase.setVisible(true);
        			dispose();
        			
        			
        		}
        		
                
            }
        });
		
		
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
	

	
	private boolean btnNEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
	
		String check = QUANTITY.getText();
		
		int Value = 0;
		try {
		    Value = Integer.parseInt(check);
		    return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Error !!! Please Make Sure That You Are Entering Integer Only !!!");
			return false;
		}
		
        
    }
	
	private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Product_1_GUI product = new Product_1_GUI(customerID);
        product.setVisible(true);
		dispose();
        
    }
	

}
