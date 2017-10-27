package m2.istic.AOC.projet;

import m2.istic.AOC.projet.observer.Observer;
import m2.istic.AOC.projet.strategy.AlgoDiffusion;
import m2.istic.AOC.projet.strategy.AtomicDiffusion;
import m2.istic.AOC.projet.strategy.SequentialDiffusion;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

import static java.lang.Thread.sleep;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static void main( String[] args ) throws InterruptedException {

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

        while (true) {
            generateur.generateValue();
            sleep(1000);
        }
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI.fxml"));

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("AOC");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
