package subscribers;

import java.util.List;

import domain.Product;
import publisher.IPublisher;
import windowClients.CashierWindowClient;

public class Cashier implements ISubscriber {

	private IPublisher publisher; //os subscribers conhecem o publisher
	private List<Product> cashierProducts;
	public CashierWindowClient cashierWindow;
	
	public Cashier(IPublisher publisher, CashierWindowClient cashierWindow){
		this.publisher = publisher;
		this.publisher.add(this);
		this.cashierWindow = cashierWindow;
	}
	
	@Override
	public void update(List<Product> products) {
		this.setCashierProducts(products);
		this.cashierWindow.getTextFieldProducts().setText(products.toString());
	}

	public List<Product> getCashierProducts() {
		return cashierProducts;
	}

	public void setCashierProducts(List<Product> cashierProducts) {
		this.cashierProducts = cashierProducts;
	}
}
