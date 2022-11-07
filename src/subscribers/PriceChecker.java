package subscribers;

import java.util.List;

import domain.Product;
import publisher.IPublisher;

public class PriceChecker implements ISubscriber {

	private IPublisher publisher;
	private List<Product> checkerProducts;
	
	public PriceChecker(IPublisher publisher){
		this.publisher = publisher;
		this.publisher.add(this);
	}
	
	@Override
	public void update(List<Product> products) {
		this.setCheckerProducts(products);
	}

	public List<Product> getCheckerProducts() {
		return checkerProducts;
	}

	public void setCheckerProducts(List<Product> checkerProducts) {
		this.checkerProducts = checkerProducts;
	}
}
