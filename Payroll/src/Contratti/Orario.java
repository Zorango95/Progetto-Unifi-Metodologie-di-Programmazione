package Contratti;


import Stipendi.PeriodoRiferimento;

public class Orario extends OperazioniFoglie{
	
	private double salario;
	
	public Orario(int salario) {
		super();
		this.salario = salario;
	}
	
	

	public double salario() {
		return salario;
	}

	public double getSalario(int NumOre) {
		
		return salario*NumOre;
	
	}
	
	public boolean equals(Object o){
		if(o instanceof Orario){
			 Orario or=(Orario)o;
			 return salario==or.salario();
		}
		return false;
	}



	public void setIntervallo(PeriodoRiferimento i) {
		// TODO Auto-generated method stub
		i.setFineOrario(this);
	}
}
