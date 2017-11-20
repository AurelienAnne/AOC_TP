package m2.istic.AOC.projet.observer;

/**
 * A standard observer (Observer pattern).
 * @param <T>
 */
public interface Observer<T> {

	/**
	 * The subject updates the observer.
	 * @param subject
	 */
	public void update(T subject);
}
