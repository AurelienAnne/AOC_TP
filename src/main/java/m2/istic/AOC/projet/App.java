package m2.istic.AOC.projet;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Afficheur afficheur = new Afficheur();
        Generateur generateur = new GenerateurImpl(0);
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
        Canal canal  = new Canal(generateur, afficheur, scheduler);

        generateur.attach(canal);
        canal.attach(afficheur);

        generateur.generateValue();
    }
}
