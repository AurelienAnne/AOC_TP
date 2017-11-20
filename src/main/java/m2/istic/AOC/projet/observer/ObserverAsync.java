package m2.istic.AOC.projet.observer;

import java.util.concurrent.Future;


/**
 * An asynchronous observer (Observer pattern).
 * @param <T>
 */
public interface ObserverAsync<T> {

    /**
     * The subject updates the observer.
     * @param subject
     * @return A future representing the end of the update.
     */
    public Future<Void> update(T subject);
}
