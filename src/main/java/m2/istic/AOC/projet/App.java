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
 * The main application.
 * Bootstrap everything :
 *  - Created the different parts.
 *  - Handle JavaFX execution.
 *  - Start main loop to generate values.
 */
public class App extends Application {

    /**
     * The first display.
     */
    @FXML private TextArea display1;

    /**
     * The second display.
     */
    @FXML private TextArea display2;

    /**
     * The third display.
     */
    @FXML private TextArea display3;

    /**
     * The fourth display.
     */
    @FXML private TextArea display4;

    /**
     * All for displays.
     */
    static private TextArea[] displays;

    /**
     * The generateur.
     */
    static Generateur generateur;

    /**
     * The loop to generate values is running.
     */
    private Boolean generate;

    /**
     * The scheduler.
     */
    static ScheduledExecutorService scheduler;

    /**
     * The algorithm to update the canal.
     */
    static AlgoDiffusion algo;

    /**
     * The algorithm to generate values.
     */
    static NumberingStrategy numbering;

    /**
     *
     * @param args
     * @throws InterruptedException
     */
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

    /**
     * Set and start JavaFX window.
     * @param primaryStage
     * @throws Exception
     */
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

    /**
     * Start main loop in a new thread.
     * @param event
     */
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

    /**
     * Creates the for JavaFX displays and link them to the canals and generator.
     */
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

    /**
     * Handle button click to stop the main loop.
     * @param event
     */
    @FXML
    private void stopGenerate(ActionEvent event) {
        generate = false;
    }

    /**
     * Handle the button to change strategy.
     * @param event
     */
    @FXML
    private void setAtomicStrategy(ActionEvent event) {
        algo = new AtomicDiffusion();
        algo.configure(generateur);
    }

    /**
     * Handle the button to change strategy.
     * @param event
     */
    @FXML
    private void setSequentielleStrategy(ActionEvent event) {
        algo = new SequentialDiffusion();
        algo.configure(generateur);
    }

    /**
     * Handle the button to change strategy.
     * @param event
     */
    @FXML
    private void setIncrementStrategy(ActionEvent event) {
        numbering = new IncrementStrategy();
        numbering.configure(generateur);
        generateur.setNumbering(numbering);
    }

    /**
     * Handle the button to change strategy.
     * @param event
     */
    @FXML
    private void setTimestampStrategy(ActionEvent event) {
        numbering = new TimestampStrategy();
        numbering.configure(generateur);
        generateur.setNumbering(numbering);
    }
}
