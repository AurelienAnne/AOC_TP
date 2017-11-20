package m2.istic.AOC.projet;

import m2.istic.AOC.projet.numberingStrategy.NumberingStrategy;
import m2.istic.AOC.projet.observer.ObserverAsync;
import m2.istic.AOC.projet.algoStrategy.AlgoDiffusion;

import java.util.*;

/**
 * The actual implementation of the generateur.
 * Delegates the creation of values to a strategy.
 * Notify canals when a value is produced.
 */
public class GenerateurImpl implements Generateur {

	/**
	 * The value the generateur produces.
	 * It is stored to be fetched by the generateur's observers.
	 */
	Integer v;

	/**
	 * The observers of the generateur (which are canals.)
	 */
	Set<ObserverAsync<Generateur>> observers = new HashSet<ObserverAsync<Generateur>>();

	/**
	 * The algorithm used to notify observers.
	 */
	AlgoDiffusion algo;

	/**
	 * The algorithm used to generate a new value.
	 */
	NumberingStrategy numbering;

	/**
	 * The number of values generated.
	 * Used to be able to switch numbering strategies and keep track.
	 */
	Integer counter = 0;

	/**
	 *
	 * @param v
	 * @param algo
	 */
	public GenerateurImpl(Integer v, AlgoDiffusion algo) {
		super();
		this.v = v;
		this.algo = algo;
	}

	/**
	 * getV
	 * @return v
	 */
	public Integer getV() {
		return v;
	}

	/**
	 *
	 * @param v
	 */
	public void setV(Integer v) {
		this.v = v;
		notifyObservers();
	}

	/**
	 *
	 * @param algo
	 */
	public void setAlgo(AlgoDiffusion algo) {
		this.algo = algo;
	}

	/**
	 *
	 * @param numbering
	 */
	public void setNumbering(NumberingStrategy numbering) {
		this.numbering = numbering;
	}

	/**
	 *
	 */
	@Override
	public void increment() {
		this.counter++;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public Integer getCounter() {
		return this.counter;
	}

	/**
	 *
	 * @param o
	 */
	public void attach(ObserverAsync<Generateur> o) {
		observers.add(o);
	}

	/**
	 *
	 * @param o
	 */
	public void detach(ObserverAsync<Generateur> o) {
		observers.remove(o);
	}

	/**
	 * Uses the definied strategy to notify the observers.
	 */
	@Override
	public void notifyObservers() {
		algo.execute();
	}

	/**
	 *
	 * @return
	 */
	public Integer getValue() {
		return getV();
	}

	/**
	 * Increment the counter no matter what.
	 * Uses a strategy to actually update the value.
	 */
	@Override
	public void generateValue() {
		increment();
		setV(numbering.execute());
	}

	/**
	 *
	 * @return
	 */
	@Override
	public Set<ObserverAsync<Generateur>> getObservers() {
		return observers;
	}
}
