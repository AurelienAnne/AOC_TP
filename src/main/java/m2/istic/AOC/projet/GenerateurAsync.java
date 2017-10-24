package m2.istic.AOC.projet;

import java.util.concurrent.Future;

public interface GenerateurAsync extends Subject<GenerateurAsync> {

    public Future<Integer> getValue();
    public void generateValue();

}
