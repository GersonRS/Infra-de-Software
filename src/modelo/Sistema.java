package modelo;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

	private Escalonador escalonador;
	private List<Processo> process;
	private List<Processo> p;
	private List<Integer> time;

	public Sistema(List<Processo> p, int n, List<Integer> s, int quantum) {
		this.p = p;
		this.process = new ArrayList<Processo>();
		this.time = new ArrayList<Integer>();
		switch (n) {
		case 0: {
			escalonador = new RoundRobin(quantum, process,s);
			break;
		}
		case 1: {
			escalonador = new Prioridade(quantum, process,s);
			break;
		}
		case 2: {
			escalonador = new MultiplasFilas(quantum, process,s);
			break;
		}
		case 3: {
			escalonador = new JobMaisCurto(quantum, process,s);
			break;
		}
		case 4: {
			escalonador = new Sorteio(quantum, process, s);
			break;
		}
		case 5: {
			escalonador = new Garantido(quantum, process,s);
			break;
		}

		default:
			break;
		}
		executar();
	}

	public void executar() {
		if (!p.isEmpty()) {
			Processo proc = new Processo(9999, 9999, 9999, 9999);
			for (int i = 0; i < p.size(); i++) {
				if (escalonador.getTime() >= p.get(i).getTempoChegada()
						&& escalonador.getTime() - escalonador.getQuantum() <= p
								.get(i).getTempoChegada()) {
					process.add(p.get(i));
					p.set(i, proc);
				}
			}
			for (int i = 0; i < p.size(); i++) {
				if(p.get(i).getId()==9999)
					p.remove(i);
			}
		}
		time = new ArrayList<Integer>();
		int m = (int) (escalonador.getTime() % 18
				);
		int base = (int) (escalonador.getTime() - m);
		int verd = base + m;
		while (base != verd) {
			time.add(base);
			base++;
		}
		escalonador.ordenar();
	}

	public List<Integer> getTime() {
		return time;
	}

	public Escalonador getEscalonador() {
		return escalonador;
	}

	public synchronized List<Processo> getProcess() {
		return process;
	}

	public List<Processo> getSequence() {
		return escalonador.getSequence();
	}

	public int getCorrent() {
		return escalonador.processoCorrent();
	}
}