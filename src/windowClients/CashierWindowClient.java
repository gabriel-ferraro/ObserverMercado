package windowClients;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.Product;
import subscribers.Cashier;

@SuppressWarnings("serial")
public class CashierWindowClient extends JFrame {

	//private JTextField textFieldProducts = new JTextField(); //mostra a lista de produtos do caixa
	private JList productsList = new JList<>();
	
	public void generateCashierWindow(Cashier cashier) {
		
		//setting JFrame for cashier window client
		JFrame frame = new JFrame("Caixa");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(500, 500);
		
		//JPanel for products
		JPanel productPanel = new JPanel();
		productPanel.setBounds(0, 0, 500, 500);
		productPanel.setBackground(Color.LIGHT_GRAY);
		
		//add product array to JPanel
		productPanel.add(productsList);
		
		//adding frame to the JPanel
		frame.add(productPanel);
	}
	
	public List<Product> getProductsList() {
		return this.productsList;
	}

	public void setProductList(JList<Product> products) {
		this.productsList = products;
	}
}
