package Contratti;


import Stipendi.PeriodoRiferimento;


public class SalarioFisso extends OperazioniFoglie{
	
	private double salario;
	private double numeroOre;
	
	
	public SalarioFisso(double salario, double numeroOre) {
		super();
		this.salario = salario;
		this.numeroOre = numeroOre;
	}

	public SalarioFisso ( int salario ){
		
		this.salario = salario;
		numeroOre=248;
	}
	
	public void setSalario( int salario ){
		this.salario = salario;
	}
	
	public double getSalario( int NumAssenze){
		double salarioUnitario = salario/numeroOre;
		double importoAssenze=salarioUnitario*NumAssenze;
		return salario-importoAssenze;
	
	}
	
	public double salario(){
		
		return salario;
		
	}
	
	public boolean equals(Object o){
		if(o instanceof SalarioFisso ){
			 SalarioFisso s=(SalarioFisso)o;
			 return salario==s.salario() && s.getNumeroOre()==numeroOre; //cambiato
		}
		return false;
	}

	public double getNumeroOre() {
		return numeroOre;
	}

	public void setNumeroOre(double numeroOre) {
		this.numeroOre = numeroOre;
	}

	public void setIntervallo(PeriodoRiferimento i) {
		// TODO Auto-generated method stub
		i.setFineFisso(this);
	}
}
