package m2.istic.AOC.projet;

public class Canal implements Generateur, ObservateurGenerateur {

	Generateur generateur;
	Afficheur afficheur;
	
	public Canal() {
		super();
	}

	public Canal(Generateur generateur, Afficheur afficheur) {
		super();
		this.generateur = generateur;
		this.afficheur = afficheur;
	}

	public Generateur getGenerateur() {
		return generateur;
	}

	public void setGenerateur(Generateur generateur) {
		this.generateur = generateur;
	}

	public Afficheur getAfficheur() {
		return afficheur;
	}

	public void setAfficheur(Afficheur afficheur) {
		this.afficheur = afficheur;
	}

	public void update(Generateur subject) {
		afficheur.update(subject);
	}

	public Integer getValue() {
		return generateur.getValue();
	}

	/* Unused methods */ 
	
	@Override
	public void notifyObservers() {}
	
	public void attach(Observer<Generateur> o) {}

	public void detach(Observer<Generateur> o) {}
	
	@Override
	public void generateValue() {}
}
