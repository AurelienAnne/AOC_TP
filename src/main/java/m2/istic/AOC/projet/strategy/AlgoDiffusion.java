package m2.istic.AOC.projet.strategy;

import m2.istic.AOC.projet.Generateur;

public interface AlgoDiffusion {
    void configure(Generateur generateur);
    void execute();
}
