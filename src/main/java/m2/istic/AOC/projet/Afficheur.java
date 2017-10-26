package m2.istic.AOC.projet;

import m2.istic.AOC.projet.observer.Observer;

import java.util.concurrent.ExecutionException;

public class Afficheur implements Observer<GenerateurAsync> {

	public void update(GenerateurAsync subject) {
		try {
			System.out.println(subject.getValue().get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
