package Impiegati;

import java.util.Date;

import Contratti.*;

public class Ingegneri extends Impiegati {
	
	public Ingegneri(String nome, String cognome, String cf, Date dataNascita) {
		super(nome, cognome, dataNascita, cf, new SalarioFisso(1200));
		// TODO Auto-generated constructor stub
	}
}
