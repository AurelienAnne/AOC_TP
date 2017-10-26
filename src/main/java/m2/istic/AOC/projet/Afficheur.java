package m2.istic.AOC.projet;

public class Afficheur implements ObservaterGenerateur {

	public void update(Generateur subject) {
		System.out.println(subject.getValue());
	}

}
