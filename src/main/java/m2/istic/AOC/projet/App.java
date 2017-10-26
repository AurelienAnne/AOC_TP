package m2.istic.AOC.projet;

import m2.istic.AOC.projet.observer.Observer;
import m2.istic.AOC.projet.observer.ObserverAsync;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Observer<GenerateurAsync> afficheur = new Afficheur();
        Generateur generateur = new GenerateurImpl(0);
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
        Canal canal  = new Canal(generateur, afficheur, scheduler);

        generateur.attach( (ObserverAsync) canal);
        canal.attach(afficheur);

        generateur.generateValue();
    }
}
