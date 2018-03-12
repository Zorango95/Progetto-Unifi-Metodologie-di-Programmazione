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

import Contratti.Commissione;
import Contratti.MultiContratto;
import Contratti.Orario;
import Contratti.SalarioFisso;

public interface PeriodoRiferimento {

	public abstract void setFineFisso(SalarioFisso contract);

	public abstract void setFineOrario(Orario contract);

	public abstract void setFineCommissione(Commissione contract);

	public abstract void setFineMulti(MultiContratto contract);

	public abstract DataContabile getInizio();

	public abstract DataContabile getFine();

}