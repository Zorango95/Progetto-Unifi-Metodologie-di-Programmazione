package Stipendi;

import java.util.Iterator;
import java.util.LinkedList;

import Impiegati.Impiegati;

public class Scheduling {
	private Impiegati imp;
	private LinkedList<Stipendio> scheduler;
	private int nElement;

	public Scheduling(Impiegati imp) {
		scheduler = new LinkedList<Stipendio>();
		this.imp = imp;
		nElement = 0;
	}

	public void addFirst(DataContabile d) {
		scheduler.add(new Stipendio(d, imp));
		nElement++;
	}

	public void add() throws Exception {
		if (nElement > 0) {
			Stipendio s = take(nElement - 1);
			scheduler.add(new Stipendio(s.getPeriodoRif().getFine(), imp));
			nElement++;
		} else
			throw new Exception("Inserisci data");
	}

	protected Iterator<Stipendio> getIterator() {
		return scheduler.iterator();
	}

	public Stipendio take(int i) throws Exception {
		Iterator<Stipendio> it = getIterator();
		int count = 0;
		Stipendio st = null;
		while (count <= i && it.hasNext()) {
			st = it.next();
			count++;
		}
		if (count <= i) {
			throw new Exception("Indice errato");
		}
		return st;
	}

	public void modify(Stipendio s, int posizione) throws Exception {
		if (posizione >= nElement)
			throw new Exception("Indice errato");
		if (s.getImp().equals(imp)) {
			scheduler.remove(posizione);
			scheduler.add(posizione, s);

		} else
			throw new Exception("Impiegato errato");
	}
}
