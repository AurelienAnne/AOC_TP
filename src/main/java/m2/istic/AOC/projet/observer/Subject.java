package m2.istic.AOC.projet.observer;

import java.util.Set;

/**
 * A standard Subject (Observer pattern).
 * @param <T>
 */
public interface Subject<T> {

	/**
	 * Add an observer to this subject.
	 * @param o
	 */
	public void attach(Observer<T> o);

	/**
	 * Removes an observer to this subject.
	 * @param o
	 */
	public void detach(Observer<T> o);

	/**
	 * The subject notify all observer that an event occured.
	 */
	public void notifyObservers();

	/**
	 * Get the list of all observers.
	 * @return
	 */
	public Set<Observer<T>> getObservers();
}
