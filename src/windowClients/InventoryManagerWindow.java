package windowClients;

import java.awt.Color;
import java.awt.Dimension;

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
		frame.setSize(900, 500);
		
		//JPanel for product fields
//		JPanel productPanel = new JPanel();
//		productPanel.setBounds(0, 0, 900, 500);
//		productPanel.setBackground(Color.GRAY);
		
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

		//labels
		JLabel nameLabel = new JLabel("Nome:");
		JLabel valueLabel = new JLabel("valor:");
		JLabel productsDisplay = new JLabel("Produtos:");
		
		//configurating panels
		JPanel namePanel = new JPanel();
		namePanel.setBounds(0, 0, 400, 100);
		namePanel.add(nameLabel);
		textFieldName.setPreferredSize(new Dimension(100, 26));
		namePanel.add(textFieldName);
		
		JPanel valuePanel = new JPanel();
		valuePanel.setBounds(0, 100, 400, 100);
		valuePanel.add(valueLabel);
		textFieldValue.setPreferredSize(new Dimension(100, 26));
		valuePanel.add(textFieldValue);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addButton);
		buttonPanel.setBounds(0, 200, 400, 100);
		
		//adding labels and inputs to the frame
		frame.add(namePanel);
		frame.add(valuePanel);
		frame.add(buttonPanel);
	}
}
