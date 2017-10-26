package m2.istic.AOC.projet.observer;

import java.util.concurrent.Future;

public interface ObserverAsync<T> {
    public Future<Void> update(T subject);
}
