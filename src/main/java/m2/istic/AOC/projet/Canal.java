package m2.istic.AOC.projet;

import java.util.HashSet;
import java.util.Set;

public class Canal implements Generateur, ObservateurGenerateur {

	Generateur generateur;
	Afficheur afficheur;
	Set<Observer<Generateur>> observers = new HashSet<Observer<Generateur>>();
	
	public Canal() {
		super();
	}

	public Canal(Generateur generateur, Afficheur afficheur) {
		super();
		this.generateur = generateur;
		this.afficheur = afficheur;
	}

	public Generateur getGenerateur() {
		return generateur;
	}

	public void setGenerateur(Generateur generateur) {
		this.generateur = generateur;
	}

	public Afficheur getAfficheur() {
		return afficheur;
	}

	public void setAfficheur(Afficheur afficheur) {
		this.afficheur = afficheur;
	}

	public void update(Generateur subject) {
		afficheur.update(subject);
	}

	public Integer getValue() {
		return generateur.getValue();
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
	
	@Override
	public void generateValue() {
		generateur.generateValue();
	}
}
