/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front;

import back.bean.AlternativaBean;
import back.dao.AlternativaDao;
import back.dao.CategoriaDao;
import back.dao.PerguntaDao;
import back.dao.RespostaDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author matheus
 */
public class TelaAlterarPergunta extends javax.swing.JFrame {

    CategoriaDao daoCategoria = null;
    PerguntaDao daoPergunta = null;
    AlternativaDao daoAlternativa = null;
    RespostaDao daoResposta = null;

    /*
    Podem ser usados em varios métodos
    para que não seja necessário instânciar
    as classes novamente
     */
    private int categoriaId = 0;
    private int perguntaId = 0;

    private List<AlternativaBean> alternativas = new ArrayList();

    public TelaAlterarPergunta() {
        initComponents();
        setSize(600, 450);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        preencheComboCategoria();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoPergunta = new javax.swing.JTextField();
        labelNumeroPerguntas = new javax.swing.JLabel();
        campoResposta = new javax.swing.JTextField();
        campoAlternativa1 = new javax.swing.JTextField();
        campoAlternativa2 = new javax.swing.JTextField();
        campoAlternativa3 = new javax.swing.JTextField();
        campoAlternativa4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoAlternativa5 = new javax.swing.JTextField();
        comboCategoria = new javax.swing.JComboBox<>();
        comboPerguntaId = new javax.swing.JComboBox<>();
        botaoVoltar = new javax.swing.JButton();
        botaoConfirmar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        botaoExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Altera Forma Pergunta");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel1.setText("Resposta");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(240, 250, 100, 20);
        getContentPane().add(campoPergunta);
        campoPergunta.setBounds(20, 40, 550, 24);

        labelNumeroPerguntas.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        labelNumeroPerguntas.setText("contador");
        getContentPane().add(labelNumeroPerguntas);
        labelNumeroPerguntas.setBounds(200, 380, 90, 20);
        getContentPane().add(campoResposta);
        campoResposta.setBounds(20, 280, 550, 24);

        campoAlternativa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoAlternativa1ActionPerformed(evt);
            }
        });
        getContentPane().add(campoAlternativa1);
        campoAlternativa1.setBounds(20, 100, 550, 24);
        getContentPane().add(campoAlternativa2);
        campoAlternativa2.setBounds(20, 130, 550, 24);
        getContentPane().add(campoAlternativa3);
        campoAlternativa3.setBounds(20, 160, 550, 24);
        getContentPane().add(campoAlternativa4);
        campoAlternativa4.setBounds(20, 190, 550, 24);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setText("Alternativas");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(240, 70, 100, 20);
        getContentPane().add(campoAlternativa5);
        campoAlternativa5.setBounds(20, 220, 550, 24);

        comboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(comboCategoria);
        comboCategoria.setBounds(110, 320, 210, 24);

        comboPerguntaId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPerguntaIdActionPerformed(evt);
            }
        });
        getContentPane().add(comboPerguntaId);
        comboPerguntaId.setBounds(110, 350, 210, 24);

        botaoVoltar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoVoltar);
        botaoVoltar.setBounds(330, 310, 90, 40);

        botaoConfirmar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        botaoConfirmar.setText("Alterar");
        botaoConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoConfirmar);
        botaoConfirmar.setBounds(440, 360, 130, 40);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setText("Pergunta:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(240, 10, 80, 20);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel5.setText("Categoria:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 320, 80, 20);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel6.setText("PerguntaId:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 350, 80, 20);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel7.setText("Número de Perguntas:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 380, 160, 20);

        botaoExcluir.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(botaoExcluir);
        botaoExcluir.setBounds(330, 360, 90, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void preencheComboCategoria() {

        daoCategoria = new CategoriaDao();

        for (int i = 0; i < daoCategoria.listarCategorias().size(); i++) {

            comboCategoria.addItem(String.valueOf(daoCategoria.listarCategorias().get(i).getDescricao()));

        }

    }

    private void preencheComboPergunta() {

        daoPergunta = new PerguntaDao();
        daoCategoria = new CategoriaDao();

        String categoriaSelecionada = comboCategoria.getSelectedItem().toString();

        categoriaId = daoCategoria.retornaIdCategoria(categoriaSelecionada);

        for (int i = 0; i < daoPergunta.listaPerguntasCategoria(categoriaId).size(); i++) {

            comboPerguntaId.addItem(String.valueOf(daoPergunta.listaPerguntasCategoria(categoriaId).get(i).getPerguntaId()));

        }

    }


    private void campoAlternativa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoAlternativa1ActionPerformed
    }//GEN-LAST:event_campoAlternativa1ActionPerformed

    private void limpaComboBox(JComboBox combo) {
        combo.removeAllItems();

    }

    private void limpaCampos() {
        campoAlternativa1.setText("");
        campoAlternativa2.setText("");
        campoAlternativa3.setText("");
        campoAlternativa4.setText("");
        campoAlternativa5.setText("");
        campoPergunta.setText("");
        campoResposta.setText("");

    }

    private void comboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCategoriaActionPerformed
        limpaCampos();
        limpaComboBox(comboPerguntaId);
        preencheComboPergunta();
        setaNumeroPerguntasCategoria();
        //setaPergunta();

    }//GEN-LAST:event_comboCategoriaActionPerformed

    private void comboPerguntaIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPerguntaIdActionPerformed

        /**
         * Cada vez que o usuário alterar o código da pergunta, irá alterar o
         * campo pergunta!
         */
        try {
            limpaCampos();

            perguntaId = Integer.parseInt(comboPerguntaId.getSelectedItem().toString());

            setaPergunta();
            setaAlternativas();
            setaResposta();

        } catch (NullPointerException ex) {

        }

    }//GEN-LAST:event_comboPerguntaIdActionPerformed

    private void botaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarActionPerformed

        daoCategoria = new CategoriaDao();

        alteraDescricaoAlternativas();
        alteraDescricaoPergunta();
        alteraRespostaPergunta();

        JOptionPane.showMessageDialog(null, "Informações alteradas!");

        try {

            limpaComboBox(comboPerguntaId);
            preencheComboPergunta();
            setaNumeroPerguntasCategoria();

            setaPergunta();
            setaAlternativas();
            setaResposta();

        } catch (NullPointerException ex) {

        }

    }//GEN-LAST:event_botaoConfirmarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        /**
         * Irá deletar a todas as informações da pergunta
         */

        int excluir = JOptionPane.showConfirmDialog(null, "Total certeza?");

        if (excluir == 0) {

            deletaResposta();
            deletaAlternativas();
            deletaPergunta();
            JOptionPane.showMessageDialog(null, "Exclusão realizada!");

            dispose();
            new TelaAlterarPergunta();
        }

    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        dispose();
        new TelaInicial();

    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void setaResposta() {

        try {

            daoResposta = new RespostaDao();

            String resposta = daoResposta.retornaResposta(perguntaId);

            campoResposta.setText(resposta);

        } catch (NullPointerException ex) {

        }

    }

    private void setaPergunta() {

        try {
            daoPergunta = new PerguntaDao();

            String pergunta = daoPergunta.listaPergunta(perguntaId);

            campoPergunta.setText(pergunta);

        } catch (NullPointerException ex) {
            // Gambi monstra!!!
            //ex.printStackTrace();
        }
    }

    private void setaNumeroPerguntasCategoria() {
        /**
         * Seta o número de perguntas de uma categoria!
         */

        daoPergunta = new PerguntaDao();

        String numero = String.valueOf(daoPergunta.contaPerguntasCategoria(categoriaId));

        labelNumeroPerguntas.setText(numero);

    }

    private void setaAlternativas() {

        daoAlternativa = new AlternativaDao();

        alternativas = daoAlternativa.retornaAlternativasPergunta(perguntaId);

        campoAlternativa1.setText(alternativas.get(0).getDescricaoA());
        campoAlternativa2.setText(alternativas.get(1).getDescricaoA());
        campoAlternativa3.setText(alternativas.get(2).getDescricaoA());
        campoAlternativa4.setText(alternativas.get(3).getDescricaoA());
        campoAlternativa5.setText(alternativas.get(4).getDescricaoA());

    }

    private void alteraDescricaoPergunta() {

        daoPergunta = new PerguntaDao();

        String descricaoNova = campoPergunta.getText();

        daoPergunta.alteraDescricaoPergunta(perguntaId, descricaoNova);
    }

    private void alteraDescricaoAlternativas() {

        daoAlternativa = new AlternativaDao();

        daoAlternativa.alteraDescricaoAlternativa(alternativas.get(0).getAlternativaId(), campoAlternativa1.getText());
        daoAlternativa.alteraDescricaoAlternativa(alternativas.get(1).getAlternativaId(), campoAlternativa2.getText());
        daoAlternativa.alteraDescricaoAlternativa(alternativas.get(2).getAlternativaId(), campoAlternativa3.getText());
        daoAlternativa.alteraDescricaoAlternativa(alternativas.get(3).getAlternativaId(), campoAlternativa4.getText());
        daoAlternativa.alteraDescricaoAlternativa(alternativas.get(4).getAlternativaId(), campoAlternativa5.getText());

    }

    private void alteraRespostaPergunta() {

        daoResposta = new RespostaDao();

        String descricacaoNova = campoResposta.getText();

        daoResposta.alteraRespostaPergunta(perguntaId, descricacaoNova);

    }

    private void deletaPergunta() {

        daoPergunta = new PerguntaDao();

        daoPergunta.deletaPergunta(perguntaId);

    }

    private void deletaAlternativas() {

        daoAlternativa = new AlternativaDao();

        for (int i = 0; i < alternativas.size(); i++) {

            daoAlternativa.deletaAlternativas(alternativas.get(i).getAlternativaId());

        }

    }

    private void deletaResposta() {

        daoResposta = new RespostaDao();

        daoResposta.deletaResposta(perguntaId);

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
            java.util.logging.Logger.getLogger(TelaAlterarPergunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAlterarPergunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAlterarPergunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAlterarPergunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAlterarPergunta().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JTextField campoAlternativa1;
    private javax.swing.JTextField campoAlternativa2;
    private javax.swing.JTextField campoAlternativa3;
    private javax.swing.JTextField campoAlternativa4;
    private javax.swing.JTextField campoAlternativa5;
    private javax.swing.JTextField campoPergunta;
    private javax.swing.JTextField campoResposta;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JComboBox<String> comboPerguntaId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelNumeroPerguntas;
    // End of variables declaration//GEN-END:variables
}
