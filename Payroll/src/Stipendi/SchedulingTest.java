package Stipendi;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import Impiegati.Impiegati;
import Impiegati.Ingegneri;

public class SchedulingTest {
	Impiegati i;
	Scheduling s;

	@Before
	public void setUp() throws Exception {
		i=new Ingegneri("Matteo", "Ghera", "GGGGGGGGGGGGGGGGGGG", new Date(12, 9, 1994) );
		s=new Scheduling(i);
	}

	@Test(expected=Exception.class)
	public void testAddException() throws Exception {
		s.add();
	}
	
	@Test
	public void testAdd(){
		ArrayList<Stipendio> temp=new ArrayList<Stipendio>();
		temp.add(new Stipendio(new DataContabile(11, 10, 2015), i));
		temp.add(new Stipendio(new DataContabile(10, 11, 2015), i));
		s.addFirst(new DataContabile(11, 10, 2015));
		try{
			s.add();
			Iterator<Stipendio>it=s.getIterator();
			Iterator<Stipendio>it1=s.getIterator();
			assertEquals(true, confrontaStipendi(it, it1));
		} catch (Exception e){
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testTake(){
		creaListaPaghe();
		try{
			Stipendio prelevato=s.take(1);
			Stipendio ris=new Stipendio(new DataContabile(16, 1, 2015), i);
			assertEquals(true, prelevato.equals(ris));
		} catch(Exception e){
			fail(e.getMessage());
		}
	}
	
	@Test(expected=Exception.class)
	public void testTeakeError() throws Exception{
		s.take(1);		
	}
	
	@Test
	public void testModify(){
		creaListaPaghe();
		Stipendio st=new Stipendio(new DataContabile(20, 0, 2015), i);
		ArrayList<Stipendio> temp=new ArrayList<Stipendio>();
		temp.add(new Stipendio(new DataContabile(16,1, 2015), i));
		temp.add(st);
		temp.add(new Stipendio(new DataContabile(16,1, 2015), i));
		try{
			s.modify(st,1);
			assertEquals(true, confrontaStipendi(temp.iterator(), s.getIterator()));
		} catch (Exception e){
			fail(e.getMessage());
		}
	}
	
	@Test(expected=Exception.class)
	public void testModifyErrorIndex() throws Exception{
		s.modify(new Stipendio(new DataContabile(20, 0, 2015), i),1);		
	}
	
	@Test(expected=Exception.class)
	public void testModifyErrorImp() throws Exception{
		s.modify(new Stipendio(new DataContabile(20, 0, 2015), new Ingegneri("Aliberto", "Manuel","AAAAAAAAAAAA", new Date(1, 1, 95))),1);		
	}
	
	private void creaListaPaghe(){
		s.addFirst(new DataContabile(16, 0, 2015));
		try{
			s.add();
			s.add();
		} catch (Exception e){
			e.getMessage();
		}
	}
	
	private boolean confrontaStipendi(Iterator<Stipendio>i1, Iterator<Stipendio>i2){
		boolean equals=false;
		while(!equals && i1.hasNext()&& i2.hasNext()){
			equals=i1.next().equals(i2.next());
		}
		if(equals&&(i1.hasNext() || i2.hasNext())){
			return equals;
		}
		return false;
	}

}
