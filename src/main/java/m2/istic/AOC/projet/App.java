package m2.istic.AOC.projet;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Afficheur afficheur = new Afficheur();
        Generateur generateur = new GenerateurImpl(0);
        Canal canal  = new Canal(generateur, afficheur);

        generateur.attach(canal);
        canal.attach(afficheur);

        generateur.generateValue();
    }
}
