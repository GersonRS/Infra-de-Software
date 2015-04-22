package controle;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import view.Janela;

public class TratarTecla extends KeyAdapter {

	private Janela janela;

	public TratarTecla(Janela j) {
		this.janela = j;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			janela.getSistema().getEscalonador().executar();
			janela.getSistema().executar();
		}
		if (e.getKeyCode() == 27) {
			System.exit(0);
		}
	}
}