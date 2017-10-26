package m2.istic.AOC.projet.observer;

public interface SubjectAsync<T> {
    public void attach(ObserverAsync<T> o);
    public void detach(ObserverAsync<T> o);
    public void notifyObservers();
}
