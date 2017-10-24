package m2.istic.AOC.projet;

public class GenerateurImpl implements Generateur{

	Integer v;
	
	public GenerateurImpl() {
		super();
	}

	public GenerateurImpl(Integer v) {
		super();
		this.v = v;
	}

	public Integer getV() {
		return v;
	}

	public void setV(Integer v) {
		this.v = v;
	}

	public void attach(Observer<?> o) {
		// TODO Auto-generated method stub
		
	}

	public void detach(Observer<?> o) {
		// TODO Auto-generated method stub
		
	}

	public Integer getValue() {
		return getV();
	}

}
