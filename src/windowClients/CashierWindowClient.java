package windowClients;

import java.awt.Color;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import domain.Product;
import subscribers.Cashier;

@SuppressWarnings("serial")
public class CashierWindowClient extends JFrame {

	private Product[] productList;
	
	private DefaultListModel<String> model = new DefaultListModel<>();
	private JList<String> productListDisplay = new JList<>(model);
	
	public void generateCashierWindow(Cashier cashier) {
		
		//setting JFrame for cashier window client
		JFrame frame = new JFrame("Caixa");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(500, 500);
		
		//add product array to JPanel
		this.productListDisplay.setLayout(null);
		this.productListDisplay.setVisible(true);
		this.productListDisplay.setBounds(0, 0, 500, 500);
		this.productListDisplay.setBackground(Color.lightGray);
		
		//adding frame to the JPanel
		frame.add(productListDisplay);
	}
	
	public Product[] getProductsList() {
		return this.productList;
	}

	public void setProductList(List<Product> products) {
		this.productList = products.toArray(new Product[0]);	
		for(int i=0; i < productList.length; i++) {
			if(!model.contains(productList[i].toString())) {
				this.model.addElement(productList[i].toString());
			}
		}
	}
}
