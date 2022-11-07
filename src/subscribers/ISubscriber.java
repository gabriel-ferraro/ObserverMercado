package subscribers;

import java.util.List;

import domain.Product;

/*
 * Assinatura para observers
*/
public interface ISubscriber {

	public void update(List<Product> products);
}
