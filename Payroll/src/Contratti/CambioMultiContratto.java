package Contratti;

import java.util.ArrayList;
import java.util.Iterator;


public abstract class CambioMultiContratto implements TipoContratto {
	private ArrayList<TipoContratto> contratti;
	private boolean modify;

	/*
	 * i metodi getIterator, isModify e size sono protected perchè sono utilizzati solo nelle 
	 * classi di questo pacchetto e solo qui devono essere utilizzati
	 */
	
	public CambioMultiContratto() {
		super();
		contratti=new ArrayList<TipoContratto>();
		modify=true;
	}
	
	protected Iterator<TipoContratto> getIterator() {
		modify=false;
		return contratti.iterator();
	}
	
	public void InsertContratto(TipoContratto nuovoContratto){
		contratti.add(nuovoContratto);
		modify=true;
	}

	protected boolean isModify() {
		return modify;
	}

	public void modifyContratto(TipoContratto nuovoContratto, int i){
		if(i<contratti.size()){
			contratti.remove(i);
			contratti.add(i, nuovoContratto);
			modify=true;
		}
	}
	
	//servira' per la modifyContratto
	public boolean equals(Object o){
		if(o instanceof MultiContratto){
			boolean egual=true;
			MultiContratto m=(MultiContratto)o;
			Iterator<TipoContratto> it1=getIterator();
			Iterator<TipoContratto> it2=m.getIterator();
			while(egual &&it1.hasNext() && it2.hasNext() ){
				TipoContratto e1=it1.next();
				TipoContratto e2=it2.next();
				egual=egual && e1.equals(e2);
			}
			if(egual && !(it1.hasNext() || it2.hasNext())){
				return egual;
			}
		}
		return false;
	}
	
	protected int size(){
		int i=0;
		Iterator<TipoContratto> it=contratti.iterator();
		while(it.hasNext()){
			it.next();
			i++;
		}
		return i;
	}
}
