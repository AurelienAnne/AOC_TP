package m2.istic.AOC.projet;

import java.util.concurrent.Future;

public interface GenerateurAsync extends SubjectAsync<GenerateurAsync> {

    public Future<Integer> getValue();
    public void generateValue();

}
