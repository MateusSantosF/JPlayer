
package Utils.Observer.interfaces;


public interface IPublisher {
    
    void addObserver(IObserver observer);
    
    void removeObserver(IObserver observer);
    
    void notifyObservers();
}
