package modelo;

import java.util.Collections;
import java.util.List;

public class JobMaisCurto extends Escalonador {

	public JobMaisCurto(int quantum, List<Processo> p, List<Integer> s) {
		super(quantum, p, s);
	}

	@Override
	public void processar() {

		int tempo = process.get(0).getTempoDuracao();
		if (tempo > quantum) {
			process.get(0).setTempoDuracao(tempo - quantum);
			process.get(0).setTempoExecutado(
					process.get(0).getTempoExecutado() + quantum);
			addSequencia(quantum, process.get(0));
			time += quantum;
		} else {
			addSequencia(tempo, process.get(0));
			process.remove(0);
		}

	}

	@Override
	public void ordenar() {
		Collections.sort(process, new ComparacaoCPU());
	}

	@Override
	public int processoCorrent() {
		return 0;
	}

}
