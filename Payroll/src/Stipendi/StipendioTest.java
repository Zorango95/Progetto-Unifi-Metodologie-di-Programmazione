package Stipendi;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Contratti.*;
import Impiegati.*;

public class StipendioTest {

	TipoContratto contratto1, contratto2, temp;
	Impiegati imp;
	Stipendio stipendio;
	
	@Before
	public void setUp(){
		contratto1=new Orario(10);
		SalarioFisso temp1=new SalarioFisso(1200);
		TipoContratto temp2=new Commissione(temp1);
		MultiContratto m1=new MultiContratto();
		m1.InsertContratto(temp1);
		m1.InsertContratto(temp2);
		contratto2=m1;
		MultiContratto m2=new MultiContratto();
		m2.InsertContratto(temp1);
		m2.InsertContratto(temp2);
		temp=m2;
		imp=new Ingegneri("Matteo", "Ghera", "GGGGGGGGGGGGGGGGGGG", new Date(12, 9, 1994) );
		imp.setMyContract(contratto1);
		stipendio=new Stipendio(new DataContabile(2, 11, 2014), imp);
	}

	@Test
	public void testContrattoSemplice() {
		
		Double asserito=contratto1.getSalario(10);
		int[] ore={10};
		try{
			stipendio.setValore(ore);
			Double r=stipendio.getValore();
			assertEquals(asserito, r);
		} catch(Exception e){
			fail(e.getMessage());
		}		
	}
	
	@Test
	public void testMultiContratto(){
		imp.setMyContract(contratto2);
		stipendio=new Stipendio(new DataContabile(2, 11, 2014), imp);
		Double asserito=temp.getSalario(0);
		asserito=temp.getSalario(2);
		int[] ore={0, 2};
		try{
			stipendio.setValore(ore);
			Double r=stipendio.getValore();
			assertEquals(asserito, r);
		} catch(Exception e){
			fail(e.getMessage());
		}		
	}
	@Test(expected=Exception.class)
	public void testContrattoException()throws Exception {
		imp.setMyContract(contratto2);
		stipendio=new Stipendio(new DataContabile(2, 11, 2014), imp);
		Double asserito=temp.getSalario(0);
		asserito=temp.getSalario(2);
		int[] ore={0};
		stipendio.setValore(ore);
		Double r=stipendio.getValore();
	}

}
