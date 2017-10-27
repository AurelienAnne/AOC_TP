package m2.istic.AOC.projet.observer;

import java.util.Set;

public interface SubjectAsync<T> {
    public void attach(ObserverAsync<T> o);
    public void detach(ObserverAsync<T> o);
    public void notifyObservers();
    public Set<ObserverAsync<T>> getObservers();
}
