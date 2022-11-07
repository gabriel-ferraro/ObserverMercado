package publisher;

import java.util.ArrayList;
import java.util.List;

import domain.Product;
import subscribers.ISubscriber;

/**
 * EstoqueMercado eh um observable (publisher) concreto.
*/
public class MarketInventory implements IPublisher {

	private List<ISubscriber> subscribers; //o publisher conhece seus subscribers
	private List<Product> products;
	
	public MarketInventory(){
		this.subscribers = new ArrayList<ISubscriber>();
	}
	
	public List<Product> getProducts() {
		return this.products;
	}
	
	public void setProducts(List<Product> products) { //sempre que o estoque muda, os subscribers sao notificados
		this.products = products;
		notifySubscribers();
	}
	
	@Override
	public void add(ISubscriber subscriber) {
		this.subscribers.add(subscriber);
	}

	@Override
	public void remove(ISubscriber subscriber) {
		int i = this.subscribers.indexOf(subscriber);
		if (i >= 0) {
			this.subscribers.remove(i);
		}
	}

	@Override
	public void notifySubscribers() {
		for(ISubscriber subs: subscribers) {
			subs.update(products); //notificando subscribers que os produtos mudaram
		}
	}
}
