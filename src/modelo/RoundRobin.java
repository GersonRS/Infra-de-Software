package modelo;

import java.util.List;

public class RoundRobin extends Escalonador {

	public RoundRobin(int quantum, List<Processo> p, List<Integer> s) {
		super(quantum, p, s);
	}

	@Override
	public void processar() {

		int tempo = process.get(0).getTempoDuracao();
		if (tempo > quantum) {
			process.get(0).setTempoDuracao(tempo - quantum);
			process.get(0).setTempoExecutado(
					process.get(0).getTempoExecutado() + quantum);
			time += quantum;
			moverFila();
		} else {
			addSequencia(tempo, process.get(0));
			time++;
			process.remove(0);
		}

	}

	public void moverFila() {
		Processo p = process.get(0);
		for (int i = 1; i < process.size(); i++) {
			process.set(i - 1, process.get(i));
		}
		addSequencia(quantum, p);
		process.remove(process.size() - 1);
		process.add(p);
	}

	@Override
	public void ordenar() {
	}

	@Override
	public int processoCorrent() {
		return 0;
	}
}