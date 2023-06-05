import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class Product_1_GUI extends JFrame {

	private JPanel contentPane;
	public int sleepSense;
	JButton GO;
	JSlider slider;
	public static int CustomerID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product_1_GUI frame = new Product_1_GUI(CustomerID);
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
	

	public void update(int customerID)
	{
		Product_1_GUI.CustomerID = customerID;
	}
	
	
	public Product_1_GUI(int customerID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 804);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel lblNewLabel = new JLabel("WELCOME TO OUR STORE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2_1 = new JLabel("1.  RACQUET");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblNewLabel_2 = new JLabel("2.  SHOES");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblNewLabel_2_2 = new JLabel("3.  SHUTTLECOCKS");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblNewLabel_2_2_1 = new JLabel("4.  OTHERS");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		GO = new JButton("GO");
		GO.setFont(new Font("Tahoma", Font.BOLD, 30));
		 GO.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                GOActionPerformed(evt);
	            }
	        });
		
		
		JButton EXIT = new JButton("EXIT");
		EXIT.setFont(new Font("Tahoma", Font.BOLD, 30));
		EXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EXITActionPerformed(evt);
            }
        });
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		
		slider = new JSlider(1,4,1);
	
		slider.setPaintTicks(true);
		slider.setForeground(new Color(233, 150, 122));
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.setMaximum(4);
		slider.setMinimum(1);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(97, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
							.addGap(252))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(131)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2_2_1, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2_2)
										.addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel_2_1))
									.addGap(97)
									.addComponent(slider, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
									.addGap(9))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(97)
									.addComponent(EXIT, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
									.addComponent(GO, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)))
							.addGap(73))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 620, GroupLayout.PREFERRED_SIZE)
							.addGap(119))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(107)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))
					.addGap(63)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2_1)
							.addGap(34)
							.addComponent(lblNewLabel_2)
							.addGap(34)
							.addComponent(lblNewLabel_2_2)
							.addGap(30)
							.addComponent(lblNewLabel_2_2_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addComponent(slider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(GO, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(EXIT, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
					.addGap(166))
		);
		
		JLabel lblNewLabel_1 = new JLabel("PRODUCT LIST");
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		contentPane.setLayout(gl_contentPane);
		}
	

	private void GOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here
	
		
		if (!slider.getValueIsAdjusting()) 
	          sleepSense = (int)slider.getValue();	
		
		ShowProduct table = new ShowProduct(sleepSense, CustomerID);
		table.updateCus(CustomerID);
		table.updateSe(sleepSense);
	
		table.setVisible(true);
		dispose();
		
        
    }
	
	private void EXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
		LoginGUI login = new LoginGUI();
		login.setVisible(true);
        dispose();
    }
}
