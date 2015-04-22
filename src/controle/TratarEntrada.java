package controle;

import java.awt.event.KeyAdapter;

public class TratarEntrada extends KeyAdapter {
	public void keyTyped(java.awt.event.KeyEvent e) {
		String caracteres = "0987654321";
		if (!caracteres.contains(e.getKeyChar() + "")) {
			e.consume();
		}
	};
}
