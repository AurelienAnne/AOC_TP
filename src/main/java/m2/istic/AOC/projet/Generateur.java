package m2.istic.AOC.projet;

import m2.istic.AOC.projet.observer.Subject;
import m2.istic.AOC.projet.observer.SubjectAsync;
import m2.istic.AOC.projet.strategy.AlgoDiffusion;

public interface Generateur extends SubjectAsync<Generateur> {

	public Integer getValue();
	public void generateValue();
	public void setAlgo(AlgoDiffusion algo);
}
