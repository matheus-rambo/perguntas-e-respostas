/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front;

import back.bean.JogoBean;
import back.dao.CategoriaDao;
import back.dao.JogoDao;
import back.funcoes.FormataLinha;
import back.funcoes.ModeloTabela;
import back.funcoes.ThreadGravarArquivo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author matheus
 */
public class TelaRanking extends javax.swing.JFrame {

            CategoriaDao daoCategoria ;

    
  int categoriaId;
    
    
    public TelaRanking() {
        initComponents();
        setSize(600, 450);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        
        preencheComboBox();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaJogos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        comboCategorias = new javax.swing.JComboBox<>();
        botaoSalvar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaJogos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        tabelaJogos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaJogos);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("Categoria:");

        comboCategorias.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        comboCategorias.setToolTipText("");
        comboCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoriasActionPerformed(evt);
            }
        });

        botaoSalvar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoVoltar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoriasActionPerformed

        daoCategoria = new CategoriaDao();
        
        categoriaId = daoCategoria.retornaIdCategoria(comboCategorias.getSelectedItem().toString());
        
        preencheTabela();

        
    }//GEN-LAST:event_comboCategoriasActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        dispose();
        TelaInicial tela = new TelaInicial();
        tela.setVisible(true);

    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        
        gravarArquivo();

    }//GEN-LAST:event_botaoSalvarActionPerformed

   

    private void preencheTabela(){
        
        
        ArrayList <Object> dados = new ArrayList();
        JogoDao jogoDao = new JogoDao(categoriaId);
        
        String coluna [] = new String[]{"Nome","Data","Porcentagem","Perguntas", "Corretas", "Tempo"};

        dados = jogoDao.dadosTabela;
       
        ModeloTabela mo = new ModeloTabela(dados, coluna);
        
        tabelaJogos.setModel(mo);
        
        tabelaJogos.getColumnModel().getColumn(0).setPreferredWidth(70);
        tabelaJogos.getColumnModel().getColumn(1).setPreferredWidth(50);
        tabelaJogos.getColumnModel().getColumn(2).setPreferredWidth(58);
        tabelaJogos.getColumnModel().getColumn(3).setPreferredWidth(40);
        tabelaJogos.getColumnModel().getColumn(4).setPreferredWidth(40);
        tabelaJogos.getColumnModel().getColumn(5).setPreferredWidth(40);
    
        
        
        
    }
    

    private void preencheComboBox(){
        
        daoCategoria = new CategoriaDao();
        
        for(int i = 0; i < daoCategoria.listarCategorias().size(); i++){
            comboCategorias.addItem(daoCategoria.listarCategorias().get(i).getDescricao());
        }
    }


    private int pegaNumeroColunas(){
        return tabelaJogos.getColumnCount();

    }
    
    private int pegaNumeroLinhas(){
        return tabelaJogos.getRowCount();
    }
    
    /**
     * Chama a class ThreadGravarArquvio 
     * que irá gravar o arquivo instantaneamenta!
     */
    
    private void gravarArquivo(){
        
        // se existe registros na tabela, então irá salvar.
        if(pegaNumeroLinhas() != 0){
        
        
        StringBuilder texto = new StringBuilder("Nome        |     Data      |  Porcentagem |  Perguntas  |  Corretas   |   Tempo");
        
        for(int i = 0; i < pegaNumeroLinhas(); i++){ 
            
            texto.append("\n"); // quebra a linnha
            
            for(int z = 0; z < pegaNumeroColunas(); z++){
                
                texto.append(FormataLinha.formata(tabelaJogos.getValueAt(i, z).toString())); // pega o valor da tabela
               // texto.append(tabelaJogos.getValueAt(i, z)); // pega o valor da tabela
                //texto.append("                 "); // deixa um espaço!
                
            }
        }
        
        String categoria = comboCategorias.getSelectedItem().toString(); // pega a categoria
        String conteudo = texto.toString(); // converte StringBuilder para String
        
        
        // chama a Thread e grava o arquivo!
        ThreadGravarArquivo th = new ThreadGravarArquivo(categoria, conteudo); 
        
        }else{
            
            JOptionPane.showMessageDialog(null,"O ranking está vazio!!!");
            
        }
        
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRanking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JComboBox<String> comboCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaJogos;
    // End of variables declaration//GEN-END:variables
}
