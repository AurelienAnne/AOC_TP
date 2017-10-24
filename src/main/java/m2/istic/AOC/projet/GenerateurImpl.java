package m2.istic.AOC.projet;

import java.util.*;

public class GenerateurImpl implements Generateur {

	Integer v;
	Set<Observer<Generateur>> observers = new HashSet<Observer<Generateur>>();
	
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

	public void attach(Observer<Generateur> o) {
		observers.add(o);
	}

	public void detach(Observer<Generateur> o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		observers.forEach(o -> o.update(this));
	}

	public Integer getValue() {
		return getV();
	}

}
