package m2.istic.AOC.projet;

public interface Subject<T> {

	public void attach(Observer<T> o);
	public void detach(Observer<T> o);
	public void notifyObservers();
}
