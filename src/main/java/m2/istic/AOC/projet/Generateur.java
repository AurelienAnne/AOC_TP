package m2.istic.AOC.projet;

public interface Generateur extends Subject<Generateur> {

	public Integer getValue();
	public void generateValue();
}
