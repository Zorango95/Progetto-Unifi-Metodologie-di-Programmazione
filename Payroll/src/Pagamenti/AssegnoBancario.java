package Pagamenti;

import java.util.Date;

public class AssegnoBancario implements Pagamenti {
	private Date data;
	private String banca;
	private double importo;
	
	public AssegnoBancario(Date data, String banca) {
		super();
		this.data = data;
		this.banca = banca;
	}

	public void paySalary(double value) {
		// TODO Auto-generated method stub
		importo=value;
	}

}
