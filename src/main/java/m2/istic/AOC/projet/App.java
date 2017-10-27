package m2.istic.AOC.projet;

import m2.istic.AOC.projet.observer.Observer;
import m2.istic.AOC.projet.strategy.AlgoDiffusion;
import m2.istic.AOC.projet.strategy.AtomicDiffusion;
import m2.istic.AOC.projet.strategy.SequentialDiffusion;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
        AlgoDiffusion algo = new SequentialDiffusion();
        Generateur generateur = new GenerateurImpl(0, algo);
        for (int i = 0; i < 4; i++) {
            int delay = (int) (100 * Math.pow(3, i));
            Observer<GenerateurAsync> afficheur = new Afficheur();
            Canal canal = new Canal(generateur, afficheur, scheduler, delay);
            generateur.attach(canal);
            canal.attach(afficheur);
        }

        algo.configure(generateur);

        generateur.generateValue();
    }
}
