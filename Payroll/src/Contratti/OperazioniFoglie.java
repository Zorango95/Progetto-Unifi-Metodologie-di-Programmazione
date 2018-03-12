package Contratti;

public abstract class OperazioniFoglie implements TipoContratto {

	public OperazioniFoglie() {
		super();
	}

	public double calcolo(int[] ore) throws Exception {
		// TODO Auto-generated method stub
		if(ore.length==1){
			return getSalario(ore[0]);
		}
		throw new Exception("Formato errato");
	}
}