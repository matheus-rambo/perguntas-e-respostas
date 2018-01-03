
package back.funcoes;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;



public class ModeloTabela extends AbstractTableModel{

    private ArrayList linhas = null;
    private String [] colunas = null;
    
        public ModeloTabela(ArrayList linhas, String [] colunas){
            this.linhas = linhas;
            this.colunas = colunas;
        }
        
        public ArrayList getLinhas(){
            return linhas;
        }
        public void setLinhas(ArrayList linhas){
            this.linhas = linhas;
        }
        public String [] getColunas(){
            return colunas;
        }
        public void setColunas(String [] colunas){
            this.colunas = colunas;
        }
        
        public int getColumnCount(){
            return colunas.length;
        }
        public int getRowCount(){
            return linhas.size();
        }
        public String getColumnName(int numeroColuna){
            return colunas[numeroColuna];
        }
        public Object getValueAt(int numeroLinha, int numeroColuna){
            Object [] linha = (Object[]) getLinhas().get(numeroLinha);
            return linha[numeroColuna];
        }
}


    

