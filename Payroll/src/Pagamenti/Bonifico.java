package Pagamenti;

import java.util.Date;

public class Bonifico implements Pagamenti {
	private Date data;
	private String ABI;
	private String CAB;
	private double value;

	public Bonifico(Date d,String ABI, String CAB) {
		super();
		data=d;
		this.ABI = ABI;
		this.CAB = CAB;
	}

	public void paySalary(double value) {
		// TODO Auto-generated method stub
		this.value=value;
	}

}
