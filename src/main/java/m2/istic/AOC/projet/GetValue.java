package m2.istic.AOC.projet;

import java.util.concurrent.*;

/**
 * Ask the generator to generate a value.
 * Returns a future contening that value.
 */
public class GetValue implements Callable<Integer>{

    private Generateur generateur;

    public GetValue(Generateur generateur) {
        this.generateur = generateur;
    }

    @Override
    public Integer call() throws Exception {
        return generateur.getValue();
    }
}
