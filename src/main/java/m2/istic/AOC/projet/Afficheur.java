package m2.istic.AOC.projet;

import javafx.scene.control.TextArea;
import m2.istic.AOC.projet.observer.Observer;

import java.util.concurrent.ExecutionException;

public class Afficheur implements Observer<GenerateurAsync> {

	private TextArea display;

    public Afficheur(TextArea display) {
        this.display = display;
    }

    public void update(GenerateurAsync subject) {
		try {
			display.setText(subject.getValue().get().toString());
		    System.out.println(subject.getValue().get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
