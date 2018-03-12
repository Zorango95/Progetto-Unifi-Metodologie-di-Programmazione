package Contratti;

import java.util.Iterator;




import Stipendi.PeriodoRiferimento;



public class MultiContratto extends CambioMultiContratto {
	private Iterator<TipoContratto> i;
	private double salario = 0;

	public double getSalario(int NumOre) {
		// TODO Auto-generated method stub
		if(isModify()){
			i=getIterator();
			salario=0;
		}
		if(i.hasNext()){
			salario=salario+ i.next().getSalario(NumOre);
		}
		return salario;	
	}

	public void setIntervallo(PeriodoRiferimento i) {
		// TODO Auto-generated method stub
		i.setFineMulti(this);
	}
	
	public double calcolo(int[] ore) throws Exception{
		if(ore.length!=super.size()){
			throw new Exception("Formato errato");
		}
		double totale=0;
		for(int i=0; i<ore.length; i++){
			int numOre=ore[i];
			totale=getSalario(numOre);
		}
		return totale;
	}

}
