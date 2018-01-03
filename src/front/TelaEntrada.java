/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package front;

import back.bean.UsuarioBean;
import back.dao.CategoriaDao;
import back.dao.UsuarioDao;
import back.funcoes.ValidaNome;
import javax.swing.JOptionPane;

/**
 *
 * @author matheus
 */
public class TelaEntrada extends javax.swing.JFrame {

    /**
     * Creates new form TelaEntrada
     */
    public TelaEntrada() {
        initComponents();
        setSize(600, 450);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        // prenche os dados do Combo
        preencheCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboMaterias = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botaoVoltar = new javax.swing.JButton();
        botaoJogar = new javax.swing.JButton();
        Imagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        comboMaterias.setFont(new java.awt.Font("Ubuntu", 1, 22)); // NOI18N
        getContentPane().add(comboMaterias);
        comboMaterias.setBounds(150, 240, 320, 31);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Assunto:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 240, 120, 28);

        campoNome.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        getContentPane().add(campoNome);
        campoNome.setBounds(140, 110, 350, 40);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Insira seu nome:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(200, 50, 210, 28);

        botaoVoltar.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoVoltar);
        botaoVoltar.setBounds(300, 350, 110, 50);

        botaoJogar.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        botaoJogar.setText("Jogar");
        botaoJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoJogarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoJogar);
        botaoJogar.setBounds(470, 350, 110, 50);

        Imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/front/ImagemEntrada.jpg"))); // NOI18N
        Imagem.setText("jLabel1");
        getContentPane().add(Imagem);
        Imagem.setBounds(0, 0, 660, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cadastra o usuario
     */
    private void cadastraUsuario() {
        UsuarioBean bean = new UsuarioBean(campoNome.getText());
        UsuarioDao dao = new UsuarioDao();

        dao.insereUsuario(bean);
    }

    /**
     *
     * @return a CategoriaId da categoria selecionada pelo usuario
     */
    private int retornaCategoriaId() {
        CategoriaDao dao = new CategoriaDao();
        return dao.retornaIdCategoria((String) comboMaterias.getSelectedItem());

    }


    private void botaoJogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoJogarActionPerformed

        /**
         * nomeValido é um membro estático dentro da classe ValidaNome
         */
          if (ValidaNome.nomeValido(campoNome.getText()) == true) {
              
            cadastraUsuario();
        
          int codigoCategoria = retornaCategoriaId();

        dispose();

        
        
        // membro estático!
        TelaPerguntas.categoriaId = codigoCategoria;

        /**
         * como o construtor já seta a pergunta com a categoriaId devemos
         * declara-lá antes do construtor por isso, a mesma é estática!
         */
        
        TelaPerguntas tela = new TelaPerguntas();

        tela.setVisible(true);

        } else {

            JOptionPane.showMessageDialog(null, "Nome inválido!");
            campoNome.setText("");

        }

    }//GEN-LAST:event_botaoJogarActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        dispose();
        TelaInicial tela = new TelaInicial();
        tela.setVisible(true);
        
    }//GEN-LAST:event_botaoVoltarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEntrada().setVisible(true);
            }
        });
    }

    /**
     * Preenche o combo box com a descricao das categorias!
     */
    private void preencheCombo() {

        CategoriaDao dao = new CategoriaDao();

        for (int i = 0; i < dao.listarCategorias().size(); i++) {
            comboMaterias.addItem(String.valueOf(dao.listarCategorias().get(i).getDescricao()));
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Imagem;
    private javax.swing.JButton botaoJogar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JTextField campoNome;
    private javax.swing.JComboBox<String> comboMaterias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}