package windowClients;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.Product;
import publisher.MarketInventory;

public class InventoryManagerWindow {

	private MarketInventory marketInventory;
	
	private JTextField textFieldName = new JTextField();
	private JTextField textFieldValue = new JTextField();
	private JTextField productsList = new JTextField();
	
	public InventoryManagerWindow(MarketInventory marketInventory){
		this.marketInventory = marketInventory;
		this.productsList.setText(marketInventory.getProducts().toString());
	}
	
	public void generateManagerWindow(){
		//setting JFrame for inventory management window client
		JFrame frame = new JFrame("Controle de estoque do mercado");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(900, 700);
		
		//JPanel for product fields
		JPanel productPanel = new JPanel();
		productPanel.setBounds(0, 0, 900, 500);
		productPanel.setBackground(Color.GRAY);
		
		//labels
		JLabel nameLabel = new JLabel("Nome:");
		JLabel valueLabel = new JLabel("valor:");
		JLabel productsDisplay = new JLabel("Produtos:");
		
		//button for adding new products
		JButton addButton = new JButton("Adicionar");
		 addButton.addActionListener(e -> {
			 if(this.textFieldName.getText() != null && this.textFieldValue.getText() != null) {
				 this.marketInventory.getProducts()
				 	.add(new Product(this.textFieldName.getText(), Float.parseFloat(this.textFieldValue.getText())));
				 this.marketInventory.notifySubscribers();
				 this.productsList.setText(marketInventory.getProducts().toString());
			 }
	     });
		
		//adding labels and inputs to the panel
		productPanel.add(nameLabel);
		productPanel.add(textFieldName);
		productPanel.add(valueLabel);
		productPanel.add(textFieldValue);
		productPanel.add(addButton);
		productPanel.add(productsDisplay);
		productPanel.add(productsList);
		
		//adding frame to the JPanel
		frame.add(productPanel);
	}
}
