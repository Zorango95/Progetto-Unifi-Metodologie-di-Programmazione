package Contratti;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class SalFissoTest extends TestCase {

	private SalarioFisso salario;
	
	@Before
	public void setUp() {
		
		salario = new SalarioFisso ( 1200 );
		
	}

	@Test
	public void testGetSalario() {
		assertEquals(new Double(1200.0-((1200.0/248.0)*10.0)), (Double)salario.getSalario( 10 ) );
	}
	
	@Test
	public void testEquals(){
		SalarioFisso salario2=new SalarioFisso(1200);
		assertEquals(true, salario2.equals(salario));
	}
	
	@Test
	public void testEqualsDifferent(){
		SalarioFisso salario2=new SalarioFisso(20);
		assertEquals(false, salario2.equals(salario));
	}
	
	@Test
	public void testEqualsDifferentType(){
		OperazioniFoglie salario2=new Orario(10);
		assertEquals(false, salario2.equals(salario));
	}

}
