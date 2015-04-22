package modelo;

import java.util.Collections;
import java.util.List;

public class MultiplasFilas extends Escalonador {

	

	public MultiplasFilas(int quantum, List<Processo> p, List<Integer> s) {
		super(quantum, p, s);
		comparador = new ComparacaoPrior();
	}

	@Override
	public void processar() {
		int id = processoCorrent();
		int tempo = process.get(id).getTempoDuracao();
		if (tempo > quantum) {
			process.get(id).setTempoDuracao(tempo - quantum);
			process.get(id).setExecuto(true);
			process.get(id).setTempoExecutado(
					process.get(id).getTempoExecutado() + quantum);
			addSequencia(quantum, process.get(id));
			time += quantum;
		} else {
			addSequencia(tempo, process.get(id));
			process.remove(id);
		}
	}

	@Override
	public int processoCorrent() {
		for (int i = 0; i < process.size(); i++) {
			if (!process.get(i).isExecuto())
				return i;
		}
		for (int j = 0; j < process.size(); j++) {
			process.get(j).setExecuto(false);
		}
		return 0;
	}

	@Override
	public void ordenar() {
		Collections.sort(process, comparador);
	}

}