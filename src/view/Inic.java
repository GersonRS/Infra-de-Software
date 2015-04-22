package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modelo.Processo;
import controle.TratarBotoes;
import controle.TratarEntrada;

public class Inic extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtProcesso;
	private JTextField txtDuracao;
	private JTextField txtChegada;
	private JTextField txtPrioridade;
	private JTextField txtQuantum;
	private JTextField txtNumSorteio;
	private JTable table_1;
	private JTable table;
	private DefaultTableModel modelo, model;
	private List<Processo> process;
	private List<Integer> s;
	private TratarEntrada entrada;
	private int a = 1, x = 1;
	public Janela j;
	private JButton btnRoundRobin;
	private JButton btnPrioridade;
	private JButton btnJobMaisCurto;
	private JButton btnSorteio;
	private JButton btnGarantido;
	private JButton btnMultiplasFilas;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inic frame = new Inic();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inic() {
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 480);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		process = new ArrayList<Processo>();
		s = new ArrayList<Integer>();
		entrada = new TratarEntrada();
		TratarBotoes b = new TratarBotoes(this);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(3, 5, 5, 5));

		JLabel lblProcesso = new JLabel("Processo");
		lblProcesso.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblProcesso);

		JLabel lblDuracao = new JLabel("Dura\u00E7\u00E3o");
		lblDuracao.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblDuracao);

		JLabel lblChegada = new JLabel("Chegada");
		lblChegada.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblChegada);

		JLabel lblPrioridade = new JLabel("Prioridade");
		lblPrioridade.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPrioridade);

		JLabel label = new JLabel("");
		panel.add(label);

		txtProcesso = new JTextField();
		txtProcesso.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(txtProcesso);
		txtProcesso.setColumns(10);
		txtProcesso.setEnabled(false);
		txtProcesso.setText(a + "");
		txtProcesso.addKeyListener(entrada);

		txtDuracao = new JTextField();
		txtDuracao.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(txtDuracao);
		txtDuracao.setColumns(10);
		txtDuracao.addKeyListener(entrada);

		txtChegada = new JTextField();
		txtChegada.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(txtChegada);
		txtChegada.setColumns(10);
		txtChegada.addKeyListener(entrada);

		txtPrioridade = new JTextField();
		txtPrioridade.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(txtPrioridade);
		txtPrioridade.setColumns(10);
		txtPrioridade.addKeyListener(entrada);
		JButton btnAdd = new JButton("Add");
		panel.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtDuracao.getText().length() > 0
						&& txtChegada.getText().length() > 0
						&& txtPrioridade.getText().length() > 0) {
					int processo = Integer.parseInt(txtProcesso.getText());
					int duracao = Integer.parseInt(txtDuracao.getText());
					int tempo = Integer.parseInt(txtChegada.getText());
					int prioridade = Integer.parseInt(txtPrioridade.getText());

					if (duracao > 0 && prioridade > 0 && prioridade < 5) {
						modelo.addRow(new Object[] { processo, duracao, tempo,
								prioridade });

						process.add(new Processo(processo, duracao, tempo,
								prioridade));

						a++;
						txtProcesso.setText(a + "");
						txtDuracao.requestFocus();
						txtDuracao.setText("");
						txtChegada.setText("");
						txtPrioridade.setText("");
					
					}
				}
			}

		});

		JLabel lblQuantum = new JLabel("Quantum");
		lblQuantum.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblQuantum);

		txtQuantum = new JTextField();
		txtQuantum.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuantum.setText("2");
		panel.add(txtQuantum);
		txtQuantum.setColumns(10);
		txtQuantum.addKeyListener(entrada);

		JLabel lblNumSorteado = new JLabel("N\u00FAm Sorteado");
		lblNumSorteado.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNumSorteado);

		txtNumSorteio = new JTextField();
		txtNumSorteio.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(txtNumSorteio);
		txtNumSorteio.setColumns(10);
		txtNumSorteio.addKeyListener(entrada);

		JButton btnAdd_1 = new JButton("Add");
		panel.add(btnAdd_1);
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtNumSorteio.getText().length() > 0) {
					int num = Integer.parseInt(txtNumSorteio.getText());

					if (num > 0) {
						model.addRow(new Object[] { x, num });
						s.add(num);
						x++;
						txtNumSorteio.setText("");
						txtNumSorteio.requestFocus();
					}
				}
			}

		});

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(2, 3, 0, 0));

		btnRoundRobin = new JButton("Round Robin");
		panel_1.add(btnRoundRobin);
		btnRoundRobin.addActionListener(b);

		btnPrioridade = new JButton("Prioridade");
		panel_1.add(btnPrioridade);
		btnPrioridade.addActionListener(b);

		btnMultiplasFilas = new JButton("Multiplas Filas");
		panel_1.add(btnMultiplasFilas);
		btnMultiplasFilas.addActionListener(b);

		btnJobMaisCurto = new JButton("Job Mais Curto");
		panel_1.add(btnJobMaisCurto);
		btnJobMaisCurto.addActionListener(b);

		btnSorteio = new JButton("Sorteio");
		panel_1.add(btnSorteio);
		btnSorteio.addActionListener(b);

		btnGarantido = new JButton("Garantido");
		panel_1.add(btnGarantido);
		btnGarantido.addActionListener(b);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new BorderLayout(0, 0));

		JLabel lblListaDeProcessos_1 = new JLabel("Lista de Processos");
		lblListaDeProcessos_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblListaDeProcessos_1, BorderLayout.NORTH);

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, BorderLayout.CENTER);

		modelo = new DefaultTableModel();
		model = new DefaultTableModel();

		String[] nome = { "Processo", "Duração", "Tempo de Chegada",
				"Prioridade", "Ordem", "Número" };

		modelo.addColumn("Processo");
		modelo.addColumn(nome[1]);
		modelo.addColumn(nome[2]);
		modelo.addColumn(nome[3]);
		model.addColumn(nome[4]);
		model.addColumn(nome[5]);

		table = new JTable();
		table.setModel(modelo);
	    table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {  
	        @Override
	        public void valueChanged(ListSelectionEvent evt) {
	           if (evt.getValueIsAdjusting())
	              return;
//	           int selected = table.getSelectedRow();
//	           System.out.println(selected);
	        }  
	     });
		scrollPane_1.setViewportView(table);

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));

		JLabel lblListaDeProcessos = new JLabel("Sorteio");
		lblListaDeProcessos.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblListaDeProcessos, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		panel_4.add(scrollPane, BorderLayout.CENTER);

		table_1 = new JTable();
		table_1.setModel(model);
		scrollPane.setViewportView(table_1);

		JLabel lblNewLabel = new JLabel(
				"Executar Lista de Processos com Escalonador:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel, BorderLayout.SOUTH);
	}

	public JButton getBtnRoundRobin() {
		return btnRoundRobin;
	}

	public JButton getBtnPrioridade() {
		return btnPrioridade;
	}

	public JButton getBtnJobMaisCurto() {
		return btnJobMaisCurto;
	}

	public JButton getBtnSorteio() {
		return btnSorteio;
	}

	public JButton getBtnGarantido() {
		return btnGarantido;
	}

	public JButton getBtnMultiplasFilas() {
		return btnMultiplasFilas;
	}

	public List<Processo> getProcess() {
		return process;
	}

	public List<Integer> getS() {
		return s;
	}

	public JTextField getTxtQuantum() {
		return txtQuantum;
	}
}
