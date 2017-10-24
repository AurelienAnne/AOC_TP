package m2.istic.AOC.projet;

public interface Subject {

	public void attach(Observer<?> o);
	public void detach(Observer<?> o);
}
