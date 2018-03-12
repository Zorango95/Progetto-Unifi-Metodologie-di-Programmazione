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
package Contratti; 

import Stipendi.PeriodoRiferimento;

public interface TipoContratto {
	
	public  double getSalario( int NumOre );
	public void setIntervallo(PeriodoRiferimento i);
	public double calcolo(int[] ore) throws Exception;
	
}
