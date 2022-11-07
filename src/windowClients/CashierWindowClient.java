package windowClients;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import subscribers.Cashier;

@SuppressWarnings("serial")
public class CashierWindowClient extends JFrame {

	private JTextField textFieldProducts = new JTextField(); //mostra a lista de produtos do caixa
	
	public void generateCashierWindow(Cashier cashier){
		
		//setting JFrame for cashier window client
		JFrame frame = new JFrame("Caixa");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(900, 700);
		
		//JPanel for products
		JPanel productPanel = new JPanel();
		productPanel.setBounds(0, 0, 900, 500);
		productPanel.setBackground(Color.LIGHT_GRAY);
		
		//add product array to JPanel
		productPanel.add(textFieldProducts);
		
		//adding frame to the JPanel
		frame.add(productPanel);
	}
	
	public JTextField getTextFieldProducts() {
		return this.textFieldProducts;
	}
}
