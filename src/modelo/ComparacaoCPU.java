package modelo;

import java.util.Comparator;

public class ComparacaoCPU implements Comparator<Processo> {

	@Override  
	public int compare(Processo o1, Processo o2) {  
		Integer a = o1.getTempoDuracao();
		return a.compareTo(o2.getTempoDuracao());  
	};  
}
