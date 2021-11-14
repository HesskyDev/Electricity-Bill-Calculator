import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main{
	
	private static JFrame frame;
	
	private static JPanel panel;
	
	private static JLabel title;
	
	private static JLabel unitsL;
	
	private static JButton button;
	
	private static JLabel price;
	
	private static JTextField units;
	
	public static void main(String[] args) {
		
		frame = new JFrame("Electricity Bill Calculator");
		panel = new JPanel();
		
		title = new JLabel("Electricity Bill Calculator");
		unitsL = new JLabel("Number Of Units: ");
		units = new JTextField();
		button = new JButton("Calculate");
		price = new JLabel("Price is: ");
		
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("Verdana", Font.BOLD, 20));
		
		unitsL.setFont(new Font("Verdana", Font.BOLD, 14));
		
		units.setBounds(50,100,200,30);
		units.setHorizontalAlignment(JTextField.HORIZONTAL);
		units.setPreferredSize(new Dimension(150,30));
		
		price.setFont(new Font("Verdana", Font.BOLD, 14));
		price.setHorizontalAlignment(JLabel.CENTER);
		
		button.setPreferredSize(new Dimension(90,30));
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new FlowLayout());
	 
		// Adding Components
		
		panel.add(title);
		panel.add(unitsL);
		panel.add(units);
		panel.add(button);
		panel.add(price);
		
		frame.setVisible(true);
		frame.setSize(300, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(1920/2 - 150, 1080/2 - 150);
		
		frame.add(panel, BorderLayout.CENTER);
		//frame.pack();
		
		//Listeners
		
		ActionListener actionListener = new ActionListener(){
			
		      public void actionPerformed(ActionEvent actionEvent) {
		            JButton pressed = (JButton) actionEvent.getSource();

		            if (pressed.getText() == button.getText()) {
		            	
		            	// Checking if theres something entered
		            	
		            	
		            	if (units.getText() != null) {
		            		
		            		// If it's a number
		            		
		            		try {
		            			
		            			int amount = Integer.parseInt(units.getText());
		            			float charge;
		            			
		            			if (amount < 500) {
		            				
		            				charge = 1;
		            			}else if (500 <= amount && amount < 600) {
		            				
		            				charge = 1.8F;
		            			}else if (600 <= amount && amount < 800) {
		            				
		            				charge = 2.8F;
		            			}else {
		            				
		            				charge = 3;
		            			}
		            			
		            			float money = amount * charge;
		            			
		            			price.setText("Price is: " + money + "$");
		            			
		            		}catch(NumberFormatException e) {
		            			
		            			units.setText("NOT A NUMBER!");
		            			
		            		};
		            		
		            	// There's nothing entered
		            		
		            	} else {
		            		
		            	}
		            	
		            	
		            }
		     }
		};
		
		button.addActionListener(actionListener);
		
	};
}
