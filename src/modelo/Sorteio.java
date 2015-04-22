package modelo;

import java.util.ArrayList;
import java.util.List;

public class Sorteio extends Escalonador {

	private int a, n;

	public Sorteio(int quantum, List<Processo> proces, List<Integer> s) {
		super(quantum, proces,s);
		this.s = s;
	}

	@Override
	public void processar() {
		if (!s.isEmpty()) {
			n = s.get(0);
			int proc = processoCorrent();
			System.out.println(proc);
			int tempo = process.get(proc).getTempoDuracao();
			if (tempo > quantum) {
				process.get(proc).setTempoDuracao(tempo - quantum);
				process.get(proc).setTempoExecutado(
						process.get(proc).getTempoExecutado() + quantum);
				addSequencia(quantum, process.get(proc));
				time += quantum;
			} else {
				addSequencia(tempo, process.get(proc));
				process.remove(proc);
			}
		}
	}

	@Override
	public void ordenar() {
		a = 0;

		for (int i = 0; i < process.size(); i++) {
			int tam = process.get(i).getPrioridade();
			process.get(i).setBilhetes(new ArrayList<Integer>());
			for (int j = 0; j < tam; j++) {
				process.get(i).getBilhetes().add(a);
				a++;
			}
		}
		int num = s.get(0);
		for (int i = 1; i < s.size(); i++) {
			s.set(i - 1, s.get(i));
		}
		s.remove(s.size() - 1);
		s.add(num);
	}

	@Override
	public int processoCorrent() {
		for (int i = 0; i < process.size(); i++) {
			int tam = process.get(i).getBilhetes().size();
			for (int j = 0; j < tam; j++) {
				if ((n % a) == process.get(i).getBilhetes().get(j)) {
					return i;
				}
			}
		}
		return 0;
	}

}