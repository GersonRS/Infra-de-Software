package view;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import modelo.Processo;

public class ProcessoTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    /* Lista de Processo que representam as linhas. */
    private List<Processo> linhas;

    /* Array de Strings com o nome das colunas. */
    private String[] colunas = new String[]{
        "Nome","EndereÁo", "Telefone"};



    /* Cria um ProcessoTableModel vazio. */
    public ProcessoTableModel() {
        linhas = new ArrayList<Processo>();
    }

    /* Cria um ProcessoTableModel carregado com
     * a lista de Processo especificada. */
    public ProcessoTableModel(List<Processo> listaDeProcesso) {
        linhas = new ArrayList<Processo>(listaDeProcesso);
    }


    /* Retorna a quantidade de colunas. */
    @Override
    public int getColumnCount() {
        // Est√° retornando o tamanho do array "colunas".
        return colunas.length;
    }

    /* Retorna a quantidade de linhas. */
    @Override
    public int getRowCount() {
        // Retorna o tamanho da lista de Processo.
        return linhas.size();
    }


    @Override
    public String getColumnName(int columnIndex) {
        // Retorna o conte√∫do do Array que possui o nome das colunas
        return colunas[columnIndex];
    }

    ;

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    ;


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            Processo cliente = linhas.get(rowIndex);

        // Retorna o campo referente a coluna especificada.
        // Aqui È feito um switch para verificar qual È a coluna
        // e retornar o campo adequado. As colunas s„oas mesmas
        // que foram especificadas no array "colunas".
        switch (columnIndex) {

            // Seguindo o exemplo: "Tipo","Data de Cadastro", "Nome", "Idade"};
            case 0:
                return cliente.getId();
            case 1:
                return cliente.getTempoDuracao();
            case 2:
                return cliente.getTempoChegada();
            case 3:
            	return cliente.getPrioridade();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

 @Override
 //modifica na linha e coluna especificada
 public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
      Processo cliente = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado

     switch (columnIndex) { // Seta o valor do campo respectivo
         case 0:
             cliente.setId(Integer.parseInt(aValue.toString()));
         case 1:
             cliente.setTempoDuracao(Integer.parseInt(aValue.toString()));
         case 2:
             cliente.setTempoChegada(Integer.parseInt(aValue.toString()));
         default:
     }
     fireTableCellUpdated(rowIndex, columnIndex);
     }

    //modifica na linha especificada
    public void setValueAt(Processo aValue, int rowIndex) {
        Processo cliente = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado

        cliente.setId(aValue.getId());
        cliente.setTempoDuracao(aValue.getTempoDuracao());
        cliente.setTempoChegada(aValue.getTempoChegada());
        cliente.setPrioridade(aValue.getPrioridade());

        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);

    }
    ;


    ;


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }


    public Processo getProcesso(int indiceLinha) {
        return linhas.get(indiceLinha);
    }



    /* Adiciona um registro. */
    public void addProcesso(Processo m) {
        // Adiciona o registro.
        linhas.add(m);


        int ultimoIndice = getRowCount() - 1;

        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /* Remove a linha especificada. */
    public void removeProcesso(int indiceLinha) {
        linhas.remove(indiceLinha);

        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    /* Adiciona uma lista de Processo ao final dos registros. */
    public void addListaDeProcesso(List<Processo> cliente) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.
        linhas.addAll(cliente);

        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    /* Remove todos os registros. */
    public void limpar() {
        linhas.clear();


        fireTableDataChanged();
    }

    /* Verifica se este table model esta vazio. */
    public boolean isEmpty() {
        return linhas.isEmpty();
    }



}
