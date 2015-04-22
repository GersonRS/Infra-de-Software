package modelo;

import java.util.Collections;
import java.util.List;

public class Prioridade extends Escalonador {

	public Prioridade(int quantum, List<Processo> p, List<Integer> s) {
		super(quantum, p, s);
		comparador = new ComparacaoPrior();
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
			diminuirPrioridade(process.get(0));
		} else {
			time++;
			addSequencia(tempo, process.get(0));
			process.remove(0);
		}

	}

	@Override
	public void ordenar() {

		Collections.sort(process, comparador);

	}

	private void diminuirPrioridade(Processo p) {
		int prior = p.getPrioDecrescente();
		p.setPrioDecrescente(prior - 1);
	}

	@Override
	public int processoCorrent() {
		return 0;
	}

}