package modelo;

import java.util.Comparator;

public class ComparacaoPrior implements Comparator<Processo> {

	@Override  
	public int compare(Processo o1, Processo o2) {  
		Integer a = o2.getPrioDecrescente();
		return a.compareTo(o1.getPrioDecrescente());  
	};  

}
