package m2.istic.AOC.projet;

import m2.istic.AOC.projet.numberingStrategy.IncrementContext;
import m2.istic.AOC.projet.numberingStrategy.NumberingStrategy;
import m2.istic.AOC.projet.observer.SubjectAsync;
import m2.istic.AOC.projet.algoStrategy.AlgoDiffusion;


/**
 * Interface for a synchronous generateur.
 * The generateur implements this.
 */
public interface Generateur extends SubjectAsync<Generateur>, IncrementContext {

	/**
	 *
	 * @return
	 */
	public Integer getValue();
	public void generateValue();
	public void setAlgo(AlgoDiffusion algo);
	public void setNumbering(NumberingStrategy numbering);
}
