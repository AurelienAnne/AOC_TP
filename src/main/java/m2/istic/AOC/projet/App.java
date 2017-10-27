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

        Observer<GenerateurAsync> afficheur = new Afficheur();
        AlgoDiffusion algo = new SequentialDiffusion();
        Generateur generateur = new GenerateurImpl(0, algo);
        algo.configure(generateur);

        Observer<GenerateurAsync> afficheur1 = new Afficheur();
        Observer<GenerateurAsync> afficheur2 = new Afficheur();
        Observer<GenerateurAsync> afficheur3 = new Afficheur();
        Observer<GenerateurAsync> afficheur4 = new Afficheur();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
        Canal canal1  = new Canal(generateur, afficheur1, scheduler, 0);
        Canal canal2  = new Canal(generateur, afficheur2, scheduler, 500);
        Canal canal3  = new Canal(generateur, afficheur3, scheduler, 1000);
        Canal canal4  = new Canal(generateur, afficheur4, scheduler, 2000);

        generateur.attach(canal1);
        generateur.attach(canal2);
        generateur.attach(canal3);
        generateur.attach(canal4);

        canal1.attach(afficheur1);
        canal2.attach(afficheur2);
        canal3.attach(afficheur3);
        canal4.attach(afficheur4);

        generateur.generateValue();
    }
}
