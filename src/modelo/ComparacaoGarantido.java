package modelo;

import java.util.Comparator;

public class ComparacaoGarantido implements Comparator<Processo>{

	@Override  
	public int compare(Processo o1, Processo o2) {  
		Double a = o1.getProporcao();
		return a.compareTo(o2.getProporcao());  
	};
	
}
