package Stipendi;

import Contratti.*;

public class Intervallo implements PeriodoRiferimento {
	private DataContabile inizio;
	private DataContabile fine;

	public Intervallo(DataContabile inizio) {
			super();
			this.inizio = inizio;
	}

	
	/* (non-Javadoc)
	 * @see Stipendi.PeriodoRiferimento#setFine(Contratti.SalarioFisso)
	 */
	public void setFineFisso(SalarioFisso contract){
		this.fine=inizio.aggiungiGiorni(31);
	}
	
	/* (non-Javadoc)
	 * @see Stipendi.PeriodoRiferimento#setFine(Contratti.Orario)
	 */
	public void setFineOrario(Orario contract){
		this.fine=inizio.aggiungiGiorni(7);
	}
	
	/* (non-Javadoc)
	 * @see Stipendi.PeriodoRiferimento#setFine(Contratti.Commissione)
	 */
	public void setFineCommissione(Commissione  contract){
		this.fine=inizio.aggiungiGiorni(31);
	}
	
	/* (non-Javadoc)
	 * @see Stipendi.PeriodoRiferimento#setFine(Contratti.MultiContratto)
	 */
	public void setFineMulti(MultiContratto contract){
		this.fine=inizio.aggiungiGiorni(31);
	}

	/* (non-Javadoc)
	 * @see Stipendi.PeriodoRiferimento#getInizio()
	 */
	public DataContabile getInizio() {
		return inizio;
	}


	/* (non-Javadoc)
	 * @see Stipendi.PeriodoRiferimento#getFine()
	 */
	public DataContabile getFine() {
		return fine;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Intervallo){
			Intervallo rif=(Intervallo) obj;
			return getInizio().equals(rif.getInizio()) && getFine().equals(rif.getFine());
		}
		return false;
	}
}
