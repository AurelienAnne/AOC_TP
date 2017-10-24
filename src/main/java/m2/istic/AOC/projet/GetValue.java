package m2.istic.AOC.projet;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class GetValue implements Callable<Future<Integer>>{

    private GenerateurAsync generateur;

    public GetValue(GenerateurAsync generateur) {
        this.generateur = generateur;
    }

    @Override
    public Future<Integer> call() throws Exception {
        return generateur.getValue();
    }
}
