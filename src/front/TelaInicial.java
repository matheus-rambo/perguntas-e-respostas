package front;

import back.dao.CategoriaDao;
import back.funcoes.RelogioDigital;
import back.funcoes.ThreadCaminhoBanco;
import back.funcoes.ValidaNome;
import java.io.File;
import javax.swing.JOptionPane;

public class TelaInicial extends javax.swing.JFrame {

    /* Utilizada para setar a data */
    RelogioDigital instanciaRelogio = new RelogioDigital();
    
    /*Irá utilizar apenas uma vez a Thread para encontrar o caminho
    da base de dados */
    private static boolean encontrou = false;
    

    public TelaInicial() {
                
        // verifica se a base já foi localizada!
        if(encontrou == false){
            
        // inicia a Thread que encontra o caminho da base
        inicializaCaminhoBanco();
        
        }
        
        initComponents();
        setSize(600, 450);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    private void inicializaCaminhoBanco(){
        
         new ThreadCaminhoBanco("BASE");
        encontrou = true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoEntrar = new javax.swing.JButton();
        botaoRanking = new javax.swing.JButton();
        jlabelHorario = instanciaRelogio.retornaRelogio();
        imagem = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuAdicionarPergunta = new javax.swing.JMenuItem();
        menuAdicionarCategoria = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuAlterarPergunta = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuContato = new javax.swing.JMenuItem();
        menuSobreJogo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        botaoEntrar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        botaoEntrar.setText("Entrar");
        botaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoEntrar);
        botaoEntrar.setBounds(480, 310, 90, 50);

        botaoRanking.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        botaoRanking.setText("Ranking");
        botaoRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRankingActionPerformed(evt);
            }
        });
        getContentPane().add(botaoRanking);
        botaoRanking.setBounds(330, 310, 120, 50);

        jlabelHorario.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jlabelHorario.setForeground(java.awt.Color.red);
        jlabelHorario.setText(null);
        getContentPane().add(jlabelHorario);
        jlabelHorario.setBounds(20, 70, 160, 70);

        imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/front/ImagemTelaInicial.jpg"))); // NOI18N
        getContentPane().add(imagem);
        imagem.setBounds(0, 0, 620, 460);

        jMenu1.setText("Adicionar");

        menuAdicionarPergunta.setText("Pergunta");
        menuAdicionarPergunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAdicionarPerguntaActionPerformed(evt);
            }
        });
        jMenu1.add(menuAdicionarPergunta);

        menuAdicionarCategoria.setText("Categoria");
        menuAdicionarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAdicionarCategoriaActionPerformed(evt);
            }
        });
        jMenu1.add(menuAdicionarCategoria);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        menuAlterarPergunta.setText("Pergunta");
        menuAlterarPergunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAlterarPerguntaActionPerformed(evt);
            }
        });
        jMenu2.add(menuAlterarPergunta);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Sobre");

        menuContato.setText("Contato");
        menuContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuContatoActionPerformed(evt);
            }
        });
        jMenu3.add(menuContato);

        menuSobreJogo.setText("Sobre o Jogo");
        menuSobreJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSobreJogoActionPerformed(evt);
            }
        });
        jMenu3.add(menuSobreJogo);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarActionPerformed
        dispose();
        new TelaEntrada().setVisible(true);

    }//GEN-LAST:event_botaoEntrarActionPerformed

    private void botaoRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRankingActionPerformed
        dispose();
        new TelaRanking().setVisible(true);
    }//GEN-LAST:event_botaoRankingActionPerformed

    private void menuAdicionarPerguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAdicionarPerguntaActionPerformed

        try {

            String senha = JOptionPane.showInputDialog("Senha:");

            if (senha.equals("root") == true) {

                dispose();
                new TelaAdicionarConteudo();

            }

        } catch (NullPointerException ex) {

        }

    }//GEN-LAST:event_menuAdicionarPerguntaActionPerformed

    private void menuAlterarPerguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAlterarPerguntaActionPerformed

        try {

            String senha = JOptionPane.showInputDialog("Senha:");

            if (senha.equals("root") == true) {

                dispose();
                new TelaAlterarPergunta();

            }

        } catch (NullPointerException ex) {

        }
    }//GEN-LAST:event_menuAlterarPerguntaActionPerformed

    private void menuSobreJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSobreJogoActionPerformed
        JOptionPane.showMessageDialog(null, "Jogo de perguntas com multiplas escolhas\n"
                + "com diversos assuntos!\nDivirta-se!!!");


    }//GEN-LAST:event_menuSobreJogoActionPerformed

    private void menuContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuContatoActionPerformed

        JOptionPane.showMessageDialog(null, "Software criado por Matheus Rambo\n"
                + "e-mail: matheusrambo24@gmail.com\n"
                + "Copyright: RamboIndustries 2017");

    }//GEN-LAST:event_menuContatoActionPerformed

    private void menuAdicionarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAdicionarCategoriaActionPerformed

        try {
            
            String senha = JOptionPane.showInputDialog(null, "Senha:");

            if (senha.equals("root") == true) {

                String nomeCategoria = JOptionPane.showInputDialog("Insira o nome da nova categoria!");

                if (!nomeCategoria.equals("") | nomeCategoria != null) {

                    if (ValidaNome.nomeValido(nomeCategoria) == true) {

                        CategoriaDao daoCategoria = new CategoriaDao();
                        daoCategoria.cadastraCategoria(nomeCategoria);
                        JOptionPane.showMessageDialog(null, "Categoria cadastrada!");

                    } else {

                        JOptionPane.showMessageDialog(null, "Nome inválido para categoria!");

                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Insira algo!!!");

                }

            }

        } catch (NullPointerException ex) {

        }

    }//GEN-LAST:event_menuAdicionarCategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEntrar;
    private javax.swing.JButton botaoRanking;
    private javax.swing.JLabel imagem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel jlabelHorario;
    private javax.swing.JMenuItem menuAdicionarCategoria;
    private javax.swing.JMenuItem menuAdicionarPergunta;
    private javax.swing.JMenuItem menuAlterarPergunta;
    private javax.swing.JMenuItem menuContato;
    private javax.swing.JMenuItem menuSobreJogo;
    // End of variables declaration//GEN-END:variables
}
