package Contratti;


import Stipendi.PeriodoRiferimento;


public class Commissione extends OperazioniFoglie {
	private double commissioni;
	private int maxVendite;
	private SalarioFisso salario;
	
	public Commissione ( SalarioFisso salario ){
		
		this.salario = salario;
		maxVendite=25;
		commissioni=0.02;
	}
	
	public Commissione(double commissioni, int maxVendite, SalarioFisso salario) {
		super();
		this.commissioni = commissioni;
		this.maxVendite = maxVendite;
		this.salario = salario;
	}

	public double getSalario ( int NumeroVendite ){
		
		double ImportoCommissione = commissioni*salario.salario();
		
		if ( NumeroVendite <= maxVendite ){
			
			return ImportoCommissione*NumeroVendite;
					
		}
		
		return ImportoCommissione*maxVendite;
	}
	
	
	public SalarioFisso salario() {
		return salario;
	}

	
	public double getCommissioni() {
		return commissioni;
	}

	public int getMaxVendite() {
		return maxVendite;
	}

	public void setCommissioni(double commissioni) {
		this.commissioni = commissioni;
	}

	public void setMaxVendite(int maxVendite) {
		this.maxVendite = maxVendite;
	}

	public boolean equals(Object o){ 
		if(o instanceof Commissione){
			 Commissione c=(Commissione)o;
			 return salario.equals(c.salario()) && c.getCommissioni()==commissioni && c.getMaxVendite()==maxVendite;
		}
		return false;
	}

	public void setIntervallo(PeriodoRiferimento i) {
		// TODO Auto-generated method stub
		i.setFineCommissione(this);
	}
}
