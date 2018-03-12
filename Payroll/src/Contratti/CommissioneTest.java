package Contratti;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class CommissioneTest extends TestCase {
	
	Commissione commissione;
	SalarioFisso salario;
	
	@Before
	public void setUp() {
		salario = new SalarioFisso ( 1200 );
		commissione = new Commissione ( salario );
		
	}

	@Test
	public void testGetSalario() {
		
		assertEquals ( new Double (15*1200*0.02), (Double) commissione.getSalario(15));
		
	}

	@Test
	public void testMaxVendite() {
		
		assertEquals ( new Double (1200*0.02*25), (Double) commissione.getSalario(50));
		
	}
	
	@Test
	public void testEquals(){
		SalarioFisso temporany=new SalarioFisso(1200);
		Commissione salario2=new Commissione(temporany);
		assertEquals(true, salario2.equals(commissione));
	}
	
	@Test
	public void testEqualsDifferent(){
		SalarioFisso temporany=new SalarioFisso(1300);
		Commissione salario2=new Commissione(temporany);
		assertEquals(false, salario2.equals(commissione));
	}
	
	
	@Test
	public void testEqualsDifferentType(){
		OperazioniFoglie salario2=new Orario(10);
		assertEquals(false, salario2.equals(commissione));
	}
	
	@Test
	public void testDifferentCommition(){
		Commissione commissione1=new Commissione(0.05, 50, salario);
		assertEquals(false, commissione1.equals(commissione));
	}
}
