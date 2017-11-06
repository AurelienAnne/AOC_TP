package m2.istic.AOC.projet;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import m2.istic.AOC.projet.numberingStrategy.IncrementStrategy;
import m2.istic.AOC.projet.numberingStrategy.NumberingStrategy;
import m2.istic.AOC.projet.numberingStrategy.TimestampStrategy;
import m2.istic.AOC.projet.observer.Observer;
import m2.istic.AOC.projet.algoStrategy.AlgoDiffusion;
import m2.istic.AOC.projet.algoStrategy.AtomicDiffusion;
import m2.istic.AOC.projet.algoStrategy.SequentialDiffusion;

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
    @FXML private TextArea display1;
    @FXML private TextArea display2;
    @FXML private TextArea display3;
    @FXML private TextArea display4;

    static private TextArea[] displays;

    static Generateur generateur;
    private Boolean generate;
    static ScheduledExecutorService scheduler;
    static AlgoDiffusion algo;
    static NumberingStrategy numbering;

    public static void main( String[] args ) throws InterruptedException {
        scheduler = Executors.newScheduledThreadPool(10);
        algo = new AtomicDiffusion();
        generateur = new GenerateurImpl(0, algo);
        numbering = new IncrementStrategy();
        numbering.configure(generateur);
        generateur.setNumbering(numbering);
        displays = new TextArea[4];

        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GUI.fxml"));

        Scene scene = new Scene(root, 650, 450);

        primaryStage.setTitle("AOC");
        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });

        primaryStage.show();
    }

    @FXML
    private void startGenerate(ActionEvent event) {
        generate = true;
        (new Thread(){
            public void run(){
                while (generate) {
                    generateur.generateValue();
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @FXML
    public void initialize() {

        displays[0] = display1;
        displays[1] = display2;
        displays[2] = display3;
        displays[3] = display4;

        for (int i = 0; i < 4; i++) {
            int delay = (int) (100 * Math.pow(2, i));
            Observer<GenerateurAsync> afficheur = new Afficheur(displays[i]);
            Canal canal = new Canal(generateur, afficheur, scheduler, delay);
            generateur.attach(canal);
            canal.attach(afficheur);
        }
        algo.configure(generateur);
    }

    @FXML
    private void stopGenerate(ActionEvent event) {
        generate = false;
    }

    @FXML
    private void setAtomicStrategy(ActionEvent event) {
        algo = new AtomicDiffusion();
        algo.configure(generateur);
    }

    @FXML
    private void setSequentielleStrategy(ActionEvent event) {
        algo = new SequentialDiffusion();
        algo.configure(generateur);
    }

    @FXML
    private void setIncrementStrategy(ActionEvent event) {
        numbering = new IncrementStrategy();
        numbering.configure(generateur);
        generateur.setNumbering(numbering);
    }

    @FXML
    private void setTimestampStrategy(ActionEvent event) {
        numbering = new TimestampStrategy();
        numbering.configure(generateur);
        generateur.setNumbering(numbering);
    }
}
