package Contratti;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class OrarioTest extends TestCase {
	
	private Orario salario;
	@Before
	public void setUp(){
		salario = new Orario( 10 );
		
	}

	@Test
	public void testGetFisso() {
		
		assertEquals(new Double (30), (Double)salario.getSalario(3));

	}
	
	@Test
	public void testEquals(){
		OperazioniFoglie salario2=new Orario(10);
		assertEquals(true, salario2.equals(salario));
	}
	
	@Test
	public void testEqualsDifferent(){
		OperazioniFoglie salario2=new Orario(20);
		assertEquals(false, salario2.equals(salario));
	}
	
	@Test
	public void testEqualsDifferentType(){
		SalarioFisso salario2=new SalarioFisso(1200);
		assertEquals(false, salario2.equals(salario));
	}
}
