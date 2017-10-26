package m2.istic.AOC.projet;

import java.util.concurrent.*;

public class GetValue implements Callable<Future<Integer>>{

    private Generateur generateur;

    public GetValue(Generateur generateur) {
        this.generateur = generateur;
    }

    @Override
    public Future<Integer> call() throws Exception {
        // return generateur.getValue();
        return null; // TODO
    }
}
