package m2.istic.AOC.projet;

import m2.istic.AOC.projet.observer.Observer;
import m2.istic.AOC.projet.observer.ObserverAsync;

import java.util.*;

public class GenerateurImpl implements Generateur {

	Integer v;
	Set<ObserverAsync<Generateur>> observers = new HashSet<ObserverAsync<Generateur>>();
	
	public GenerateurImpl() {
		super();
	}

	public GenerateurImpl(Integer v) {
		super();
		this.v = v;
	}

	public Integer getV() {
		return v;
	}

	public void setV(Integer v) {
		this.v = v;
		notifyObservers();
	}

	public void attach(ObserverAsync<Generateur> o) {
		observers.add(o);
	}

	public void detach(ObserverAsync<Generateur> o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		observers.forEach(o -> o.update(this));
	}

	public Integer getValue() {
		return getV();
	}

	@Override
	public void generateValue() {
		setV((int) (System.currentTimeMillis() / 1000L)); // 2038 problem :p
	}
}
