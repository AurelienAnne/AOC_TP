package m2.istic.AOC.projet;

public interface SubjectAsync<T> {
    public void attach(Observer<T> o);
    public void detach(Observer<T> o);
    public void notifyObservers();
}
