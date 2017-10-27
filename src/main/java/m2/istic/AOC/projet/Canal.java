package m2.istic.AOC.projet;

import m2.istic.AOC.projet.observer.Observer;
import m2.istic.AOC.projet.observer.ObserverAsync;
import m2.istic.AOC.projet.observer.Subject;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Canal implements GenerateurAsync, ObserverAsync<Generateur>, Subject<GenerateurAsync> {

	Generateur generateur;
	Observer<GenerateurAsync> afficheur;
	ScheduledExecutorService scheduler;
	Set<Observer<GenerateurAsync>> observers = new HashSet<>();

	public Canal(Generateur generateur, Observer<GenerateurAsync> afficheur, ScheduledExecutorService scheduler) {
		super();
		this.generateur = generateur;
		this.afficheur = afficheur;
		this.scheduler = scheduler;
	}

	public Generateur getGenerateur() { return generateur; }
	public void setGenerateur(Generateur generateur) { this.generateur = generateur; }
	public Observer<GenerateurAsync> getAfficheur() { return afficheur; }
	public void setAfficheur(Observer<GenerateurAsync> afficheur) { this.afficheur = afficheur; }

	public Future<Void> update(Generateur subject) {
		System.out.println("Update asynchrone");
		return scheduler.schedule(new Update(afficheur, this), 1000, TimeUnit.MILLISECONDS);
	}

	public void attach(Observer<GenerateurAsync> o) { observers.add(o); }
	public void detach(Observer<GenerateurAsync> o) { observers.remove(o); }
	public void notifyObservers() { observers.forEach(o -> o.update(this)); }

	public Future<Integer> getValue() {
		System.out.println("GetValue asynchrone");
		return scheduler.schedule(new GetValue(generateur), 1000, TimeUnit.MILLISECONDS);
	}

	@Override
	public void generateValue() {
		generateur.generateValue();
	}

	@Override
	public Set<Observer<GenerateurAsync>> getObservers() {
		return observers;
	}
}
