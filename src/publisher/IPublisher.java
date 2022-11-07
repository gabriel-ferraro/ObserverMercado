package publisher;

import subscribers.ISubscriber;
/*
 * Assinatura para observables
*/
public interface IPublisher {

	public void add(ISubscriber subscriber); // subscribe or attach method
	public void remove(ISubscriber subscriber); // unsubscribe or detach method
	public void notifySubscribers(); // notify all subscribers
}
