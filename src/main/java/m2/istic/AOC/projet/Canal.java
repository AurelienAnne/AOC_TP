package m2.istic.AOC.projet;

import m2.istic.AOC.projet.observer.Observer;
import m2.istic.AOC.projet.observer.ObserverAsync;
import m2.istic.AOC.projet.observer.Subject;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class Canal implements GenerateurAsync, ObserverAsync<Generateur>, Subject<GenerateurAsync> {

	/**
	 * The number generateur.
	 * Consume requests, produce updates.
	 */
	Generateur generateur;

	/**
	 * Display the values.
	 */
	Observer<GenerateurAsync> afficheur;

	/**
	 * Sdk scheduler.
	 * Schedules updates correctly.
	 */
	ScheduledExecutorService scheduler;

	/**
	 * Internal parameter to modify delay when displaying the values.
	 */
	int delay;

	/**
	 * Observers from eponymous pattern.
	 */
	Set<Observer<GenerateurAsync>> observers = new HashSet<>();

	/**
	 * Basic constructor.
	 * Set every value in the canal.
	 * @param generateur
	 * @param afficheur
	 * @param scheduler
	 * @param delay
	 */
	public Canal(Generateur generateur, Observer<GenerateurAsync> afficheur, ScheduledExecutorService scheduler, int delay) {
		super();
		this.generateur = generateur;
		this.afficheur = afficheur;
		this.scheduler = scheduler;
		this.delay = delay;
	}

	public Generateur getGenerateur() { return generateur; }
	public void setGenerateur(Generateur generateur) { this.generateur = generateur; }
	public Observer<GenerateurAsync> getAfficheur() { return afficheur; }
	public void setAfficheur(Observer<GenerateurAsync> afficheur) { this.afficheur = afficheur; }

	/**
	 * Ask the scheduler to create and handle an update to afficheur.
	 * @param subject
	 * @return
	 */
	public Future<Void> update(Generateur subject) {
		System.out.println("Update asynchrone");
		return scheduler.schedule(new Update(afficheur, this), 10, TimeUnit.MILLISECONDS);
	}

	public void attach(Observer<GenerateurAsync> o) { observers.add(o); }
	public void detach(Observer<GenerateurAsync> o) { observers.remove(o); }
	public void notifyObservers() { observers.forEach(o -> o.update(this)); }

	/**Ask the scheduler to create and handle a request to generateur.
	 * The generateur will, at some point produce a value.
	 *
	 * @return
	 */
	public Future<Integer> getValue() {
		System.out.println("GetValue asynchrone");
		return scheduler.schedule(new GetValue(generateur), delay, TimeUnit.MILLISECONDS);
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
