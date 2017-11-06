package m2.istic.AOC.projet;

import m2.istic.AOC.projet.observer.Observer;
import m2.istic.AOC.projet.observer.ObserverAsync;
import m2.istic.AOC.projet.strategy.AlgoDiffusion;

import java.util.*;

public class GenerateurImpl implements Generateur {

	Integer v;
	Set<ObserverAsync<Generateur>> observers = new HashSet<ObserverAsync<Generateur>>();
	AlgoDiffusion algo;
	int compteur = 0;

	public GenerateurImpl(Integer v, AlgoDiffusion algo) {
		super();
		this.v = v;
		this.algo = algo;
	}

	public Integer getV() {
		return v;
	}

	public void setV(Integer v) {
		this.v = v;
		notifyObservers();
	}

	public void setAlgo(AlgoDiffusion algo) {
		this.algo = algo;
	}


	public void attach(ObserverAsync<Generateur> o) {
		observers.add(o);
	}

	public void detach(ObserverAsync<Generateur> o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		algo.execute();
	}

	public Integer getValue() {
		return getV();
	}

	@Override
	public void generateValue() {
		setV( (compteur++));
	}

	@Override
	public Set<ObserverAsync<Generateur>> getObservers() {
		return observers;
	}
}
