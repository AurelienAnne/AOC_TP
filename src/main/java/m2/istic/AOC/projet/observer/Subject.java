package m2.istic.AOC.projet.observer;

import java.util.Set;

public interface Subject<T> {

	public void attach(Observer<T> o);
	public void detach(Observer<T> o);
	public void notifyObservers();
	public Set<Observer<T>> getObservers();
}
