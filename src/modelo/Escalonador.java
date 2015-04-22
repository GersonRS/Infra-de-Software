package modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Escalonador {

	protected List<Processo> process;
	protected List<Processo> sequence;
	protected List<Integer> s;
	protected int quantum;
	protected int time = 0;
	protected Comparator<Processo> comparador;

	public Escalonador(int quantum, List<Processo> p, List<Integer> s) {
		this.process = p;
		this.s = s;
		this.quantum = quantum;
		sequence = new ArrayList<Processo>();
	}

	public void executar() {
		if (!process.isEmpty()) {
			processar();
		}else{
			time++;
			sequence.add(new Processo(0, 0, 0, 0));
		}
		if (sequence.size() > 16) {
			sequence = new ArrayList<Processo>();
		}
	}
	
	public void addSequencia(int n, Processo p){
		for (int i = 0; i < n; i++) {
			sequence.add(p);
		}
	}

	public abstract void processar();

	public abstract int processoCorrent();

	public abstract void ordenar();
	
	public int getQuantum() {
		return quantum;
	}

	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}

	public synchronized int getTime() {
		return time;
	}

	public synchronized List<Processo> getProcess() {
		return process;
	}

	public synchronized void setProcess(List<Processo> process) {
		this.process = process;
	}

	public synchronized List<Processo> getSequence() {
		return sequence;
	}

	public List<Integer> getS() {
		return s;
	}
	
}