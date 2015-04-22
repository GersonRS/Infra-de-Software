package modelo;

import java.util.Comparator;

public class ComparacaoID implements Comparator<Processo> {

	@Override  
	public int compare(Processo o1, Processo o2) {  
		Integer a = o1.getId();
		return a.compareTo(o2.getId());  
	};  

}
