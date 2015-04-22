package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.Inic;
import view.Janela;

public class TratarBotoes implements ActionListener {

	private Inic i;

	public TratarBotoes(Inic i) {
		this.i = i;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (i.getTxtQuantum().getText().length() > 0) {
			int n = Integer.parseInt(i.getTxtQuantum().getText());
			if (e.getSource() == i.getBtnRoundRobin()) {
				i.j = new Janela(i.getProcess(), 0, i.getS(), n);
				i.j.addKeyListener(new TratarTecla(i.j));
				new Thread(i.j).start();
				i.dispose();
			}
			if (e.getSource() == i.getBtnPrioridade()) {
				i.j = new Janela(i.getProcess(), 1, i.getS(), n);
				i.j.addKeyListener(new TratarTecla(i.j));
				new Thread(i.j).start();
				i.dispose();
			}
			if (e.getSource() == i.getBtnMultiplasFilas()) {
				i.j = new Janela(i.getProcess(), 2, i.getS(), n);
				i.j.addKeyListener(new TratarTecla(i.j));
				new Thread(i.j).start();
				i.dispose();
			}
			if (e.getSource() == i.getBtnJobMaisCurto()) {
				i.j = new Janela(i.getProcess(), 3, i.getS(), n);
				i.j.addKeyListener(new TratarTecla(i.j));
				new Thread(i.j).start();
				i.dispose();
			}
			if (e.getSource() == i.getBtnSorteio()) {
				if (!i.getS().isEmpty()) {
					i.j = new Janela(i.getProcess(), 4, i.getS(), n);
					i.j.addKeyListener(new TratarTecla(i.j));
					new Thread(i.j).start();
					i.dispose();
				}else
					JOptionPane.showMessageDialog(null, "Insira pelo menos um numero pra sorteio");
			}
			if (e.getSource() == i.getBtnGarantido()) {
				i.j = new Janela(i.getProcess(), 5, i.getS(), n);
				i.j.addKeyListener(new TratarTecla(i.j));
				new Thread(i.j).start();
				i.dispose();
			}
		} else
			JOptionPane.showMessageDialog(null, "preencha o campo Quantum");
	}
}
