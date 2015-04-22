package modelo;

import java.util.ArrayList;
import java.util.List;

public class Processo {

	private int id;
	private int tempoDuracao;
	private int tempoExecutado;
	private int tempoChegada;
	private int prioridade;
	private int prioDecrescente;
	private List<Integer> bilhetes;
	private boolean executo;
	private double proporcao;

	public Processo(int id, int tempoDuracao, int tempoChegada, int prioridade) {
		super();
		this.id = id;
		this.tempoDuracao = tempoDuracao;
		this.tempoChegada = tempoChegada;
		this.prioridade = prioridade;
		this.prioDecrescente = prioridade;
		this.tempoExecutado = 0;
		this.bilhetes = new ArrayList<Integer>();
	}

	public int getTempoChegada() {
		return tempoChegada;
	}

	public void addNum(int num) {
		bilhetes.add(num);
	}

	public void setTempoChegada(int tempoChegada) {
		this.tempoChegada = tempoChegada;
	}

	public int getTempoDuracao() {
		return tempoDuracao;
	}

	public void setTempoDuracao(int tempoDuracao) {
		this.tempoDuracao = tempoDuracao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public int getPrioDecrescente() {
		return prioDecrescente;
	}

	public void setPrioDecrescente(int prioDecrescente) {
		if (this.prioDecrescente <= 1)
			this.prioDecrescente = this.prioridade;
		else
			this.prioDecrescente = prioDecrescente;
	}

	public synchronized List<Integer> getBilhetes() {
		return bilhetes;
	}

	public synchronized void setBilhetes(List<Integer> bilhetes) {
		this.bilhetes = bilhetes;
	}

	public String toString() {
		return this.id + "";
	}

	public boolean isExecuto() {
		return executo;
	}

	public void setExecuto(boolean executo) {
		this.executo = executo;
	}

	public double getProporcao() {
		return proporcao;
	}

	public void setProporcao(double proporcao) {
		this.proporcao = proporcao;
	}

	public int getTempoExecutado() {
		return tempoExecutado;
	}

	public void setTempoExecutado(int tempoExecutado) {
		this.tempoExecutado = tempoExecutado;
	}

	public String printBilhetes() {
		String nums = "";
		for (int i = 0; i < bilhetes.size(); i++) {
			nums += bilhetes.get(i);
			nums += (i>=bilhetes.size()-1?"":",");
		}
		return nums;
	}
}