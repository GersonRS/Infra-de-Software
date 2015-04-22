package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import modelo.ComparacaoID;
import modelo.Processo;
import modelo.Sistema;

public class Janela extends JFrame implements Runnable {

	private static final long serialVersionUID = 6047845876191904562L;
	private BufferedImage backBuffer, fundo;
	private int FPS = 30;
	private int janelaW = 800;
	private int janelaH = 600;
	private List<Processo> process;
	private List<Processo> sequence;
	private List<Integer> time;
	private Sistema sistema;
	private int inc = 44, x = 86, inicTime = 99, incY = 555;

	public void atualizar() {

		process = new ArrayList<Processo>();

		for (int i = 0; i < sistema.getProcess().size(); i++) {
			process.add(sistema.getProcess().get(i));
		}

		Collections.sort(process, new ComparacaoID());

		sequence = sistema.getSequence();

		time = sistema.getTime();

	}

	@Override
	public void paint(Graphics g) {
		Graphics bbg = backBuffer.getGraphics();

		bbg.drawImage(fundo, 0, 0, null);

		bbg.setColor(Color.BLACK);
		bbg.setFont(new Font("Verdana", Font.BOLD, 20));
		bbg.drawString("" + sistema.getEscalonador().getTime(), 568, 80);
		 bbg.drawString("" + sistema.getEscalonador().getQuantum(), 579, 185);
		for (int i = 0; i < process.size(); i++) {
			if (i < 11) {
				bbg.drawString("P" + process.get(i).getId(), 50, 75 + (i * 39));
				bbg.drawString("" + process.get(i).getTempoDuracao(), 150,
						75 + (i * 39));
				bbg.drawString("" + process.get(i).getTempoChegada(), 240,
						75 + (i * 39));
				bbg.drawString("" + process.get(i).getPrioDecrescente(), 330,
						75 + (i * 39));
				bbg.setFont(new Font("Verdana", Font.BOLD, 12));
				bbg.drawString("" + process.get(i).printBilhetes(), 410,
						75 + (i * 39));
				bbg.setFont(new Font("Verdana", Font.BOLD, 20));
			}
		}
		bbg.setFont(new Font("Verdana", Font.BOLD, 20));
		for (int i = 1; i < sistema.getProcess().size(); i++) {
			if (i < 10)
				bbg.drawString("P" + sistema.getProcess().get(i).getId(), 700,
						166 + (i * 32));
		}

		if (!sistema.getProcess().isEmpty()) {
			int id = sistema.getProcess().get(sistema.getCorrent()).getId();
			bbg.drawString("P" + id, 685, 80);
		}

		for (int i = 0; i < sequence.size(); i++) {
			bbg.drawString(sequence.get(i).getId()==0?"":"P" + sequence.get(i).getId(), x + inc * i, incY);
		}
		bbg.setFont(new Font("Verdana", Font.PLAIN, 12));
		for (int i = 0; i < time.size(); i++) {
			bbg.drawString(time.get(i) + "", 44 * i + inicTime, 580);
		}
		bbg.setFont(new Font("Verdana", Font.BOLD, 20));
		
		if (!sistema.getEscalonador().getS().isEmpty()) {
			int id = sistema.getEscalonador().getS().get(0);
			bbg.drawString("" + id, 573, 275);
		}
		for (int i = 1; i < sistema.getEscalonador().getS().size(); i++) {
			if(i<4)
				bbg.drawString(sistema.getEscalonador().getS().get(i) + "", 573, 352 + (i*32));
		}
		

		g.drawImage(backBuffer, 0, 0, this);
	}

	public Janela(List<Processo> process2, int i, List<Integer> s, int quantum) {
		setTitle("Agendadores");
		setSize(janelaW, janelaH);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setUndecorated(true);
		sistema = new Sistema(process2, i, s, quantum);
	}

	public void inicializar() {
		backBuffer = new BufferedImage(janelaW, janelaH,
				BufferedImage.TYPE_INT_RGB);

		try {
			// fundo = ImageIO.read(getClass().getClassLoader().getResource(
			// "Escalonador.png"));
			fundo = ImageIO.read(getClass().getClassLoader().getResource(
					"Agendador.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setVisible(true);
	}

	public void run() {
		inicializar();
		while (true) {

			atualizar();
			repaint();

			try {
				Thread.sleep(1000 / FPS);
			} catch (Exception e) {
				System.out.println("Thread interrompida! janela");
			}
		}
	}

	public Sistema getSistema() {
		return sistema;
	}

}