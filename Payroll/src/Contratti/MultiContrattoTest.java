package Contratti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MultiContrattoTest {
	
	MultiContratto m=new MultiContratto();
	SalarioFisso s;
	Commissione c;

	
	@Before
	public void setUp() {
		s = new SalarioFisso ( 1200 );
		c = new Commissione (s );
		m.InsertContratto(s);
		m.InsertContratto(c);
	}
	
	@Test
	public void testEquals() {
		SalarioFisso s1=new SalarioFisso(1200);
		Commissione c1=new Commissione(s1);
		MultiContratto m1=new MultiContratto();
		m1.InsertContratto(s1);
		m1.InsertContratto(c1);
		assertEquals(true, m.equals(m1));
		
	}
	
	@Test
	public void testEqualsDifferent() {
		SalarioFisso s1=new SalarioFisso(1300);
		Commissione c1=new Commissione(s1);
		MultiContratto m1=new MultiContratto();
		m1.InsertContratto(s1);
		m1.InsertContratto(c1);
		assertEquals(false, m.equals(m1));
		
	}
	
	@Test
	public void testEqualsDifferentType(){
		SalarioFisso salario2=new SalarioFisso(1200);
		assertEquals(false, salario2.equals(m));
	}
	
	@Test
	public void testModifyContratto(){
		SalarioFisso s1=new SalarioFisso(1300);
		MultiContratto m1=new MultiContratto();
		m1.InsertContratto(s1);
		m1.InsertContratto(c);
		m.modifyContratto(s1, 0);
		assertEquals(true, m.equals(m1));
	}
	
	@After
	public void setUp1() {
		s = new SalarioFisso ( 1200 );
		c = new Commissione (s );
		m.InsertContratto(s);
		m.InsertContratto(c);
	}
	
	@Test
	public void testGetSalario(){
		double r = scorriLista();
		assertEquals(new Double(1248), (Double)r);
		
	}
	
	@Test
	public void testGetSalarioTwo(){
		double r=scorriLista();
		r=scorriLista();
		assertEquals(new Double(1248), (Double)r);
		
	}

	private double scorriLista() {
		double r=m.getSalario(0);
		r=m.getSalario(2);
		return r;
	}
	
	@Test
	public void testGetSalarioModify(){
		double r=scorriLista();
		SalarioFisso s=new SalarioFisso(1300);
		m.modifyContratto(s, 0);
		r = scorriLista();
		assertEquals(new Double(1348), (Double)r);
		
	}
	@Test
	public void testGetSalarioAdd(){
		double r=scorriLista();
		SalarioFisso s=new SalarioFisso(1300);
		m.InsertContratto(s);
		r = scorriLista();
		r=m.getSalario(0);
		assertEquals(new Double(2548), (Double)r);
	}
}
