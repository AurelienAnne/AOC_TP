package m2.istic.AOC.projet;

import m2.istic.AOC.projet.observer.ObserverAsync;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class Canal implements GenerateurAsync, ObservaterGenerateur {

	Generateur generateur;
	Afficheur afficheur;
	ScheduledExecutorService scheduler;
	Set<ObserverAsync<GenerateurAsync>> observers = new HashSet<>();
	
	public Canal() {
		super();
	}

	public Canal(Generateur generateur, Afficheur afficheur, ScheduledExecutorService scheduler) {
		super();
		this.generateur = generateur;
		this.afficheur = afficheur;
		this.scheduler = scheduler;
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

	public Future<Integer> getValue() {
		new GetValue(generateur);
		return null; // TODO
	}

	public void attach(ObserverAsync<GenerateurAsync> o) {
		observers.add(o);
	}

	public void detach(ObserverAsync<GenerateurAsync> o) {
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
