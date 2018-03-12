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
package Impiegati;

import java.util.Date;

import Contratti.TipoContratto;

public abstract class Impiegati{
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String CF;
	private TipoContratto contratti;
	
	public Impiegati(String nome, String cognome, Date dataNascita, String cf,
			TipoContratto contratti) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		CF=cf;
		this.contratti = contratti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getCF() {
		return CF;
	}

	public void setCF(String cF) {
		CF = cF;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNasscita) {
		this.dataNascita = dataNasscita;
	}

	public TipoContratto getMyContract() {
		return contratti;
	}

	public void setMyContract(TipoContratto contratti) {
		this.contratti = contratti;
	}
	
	public boolean equals(Object obj){ 
		if(obj instanceof Ingegneri){
			Ingegneri i=(Ingegneri) obj;
			return getNome().equals(i.getNome()) &&
					getCognome().equals(i.getCognome()) &&
					getCF().equals(i.getCF()) &&
					getMyContract().equals(i.getMyContract());
		}
		return false;
	}
	
	
}
