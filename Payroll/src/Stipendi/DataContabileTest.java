package Stipendi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DataContabileTest {
	
	DataContabile data;
	DataContabile test;

	@Test
	public void testAggiungiGiorni30(){
		data=new DataContabile(12, 8, 94);
		test=new DataContabile(13, 9, 94);
		assertEquals(test, data.aggiungiGiorni(31));
	}
	
	@Test
	public void testAggiungiGiorni31(){
		data=new DataContabile(12, 7, 94);
		test=new DataContabile(12, 8, 94);
		assertEquals(test, data.aggiungiGiorni(31));
	}
	
	@Test
	public void testAggiungiGiorni28(){
		data=new DataContabile(12, 1, 94);
		test=new DataContabile(15, 2, 94);
		assertEquals(test, data.aggiungiGiorni(31));
	}
	
	@Test
	public void testAggiungiGiorniDic(){
		data=new DataContabile(12, 11, 94);
		test=new DataContabile(12, 0, 95);
		assertEquals(test, data.aggiungiGiorni(31));
	}

}
