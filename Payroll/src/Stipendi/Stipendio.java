/*
 * ***************************************************************************************
 * ***************************METODOLOGIE DI PROGRAMMAZIONE*******************************
 * Esercizio di progetto Payroll
 * 5645310 Aliberto Manuel manuel.aliberto@stud.unifi.it
 * 5765968 D'Autilia Mattia mattia.dautilia@stud.unifi.it
 * 5616343 Ghera Matteo matteo.ghera@stud.unifi.it
 * ***************************************************************************************
 * ***************************************************************************************
 * 
 */
package Stipendi;

import Contratti.TipoContratto;
import Impiegati.Impiegati;
import Pagamenti.Pagamenti;

public class Stipendio {
	private PeriodoRiferimento periodoRif;
	private Impiegati imp;
	private double valore;
	private Pagamenti pagamento;
	
	public Stipendio(DataContabile dataI, Impiegati imp){
		this.imp=imp;
		
		periodoRif=new Intervallo(dataI);
		TipoContratto myImpiegatoContract=this.imp.getMyContract();
		myImpiegatoContract.setIntervallo(periodoRif);
		
		pagamento=null;
		valore=0;
	}

	public PeriodoRiferimento getPeriodoRif() {
		return periodoRif;
	}
	

	public Impiegati getImp() {
		return imp;
	}

	public Pagamenti getPagamento() {
		return pagamento;
	}

	public double getValore() {
		return valore;
	}

	public void setValore(int[] ore) throws Exception {
		TipoContratto myImpiegatoContract=imp.getMyContract();
		valore=myImpiegatoContract.calcolo(ore);
	}

	public void setPagamento(Pagamenti pagamento) {
		this.pagamento = pagamento;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Stipendio){
			Stipendio s=(Stipendio) obj;
			return periodoRif.equals(s.getPeriodoRif()) && imp.equals(s.getImp());
		}
		return false;
	}
}
