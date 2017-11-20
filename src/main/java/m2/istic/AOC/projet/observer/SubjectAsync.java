package m2.istic.AOC.projet.observer;

import java.util.Set;

/**
 * A asynchronous subject (Observer pattern).
 * @param <T>
 */
public interface SubjectAsync<T> {

    /**
     * Add an observer to this subject.
     * @param o
     */
    public void attach(ObserverAsync<T> o);

    /**
     * Removes an observer to this subject.
     * @param o
     */
    public void detach(ObserverAsync<T> o);

    /**
     * The subject notify all observer that an event occured.
     */
    public void notifyObservers();

    /**
     * Get the list of all observers.
     * @return
     */
    public Set<ObserverAsync<T>> getObservers();
}
