package front;

import back.bean.JogoBean;
import back.bean.PerguntaBean;
import back.dao.AlternativaDao;
import back.dao.JogoDao;
import back.dao.PerguntaDao;
import back.dao.RespostaDao;
import back.dao.UsuarioDao;
import back.funcoes.Contagem;
import back.funcoes.ManipulaData;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class TelaPerguntas extends javax.swing.JFrame {

    /**
     * Classes necessárias
     */
    Random rand = new Random();
    PerguntaDao dao = new PerguntaDao();
    List<PerguntaBean> pergunta = dao.listaPerguntasCategoria(categoriaId);
    ButtonGroup grupo = new ButtonGroup();
    
    Contagem contagem = new Contagem(); 
    
    

    // seta o numero total de perguntas
    private final int NUMERO_TOTAL_PERGUNTAS = 15;

    static int categoriaId = 0;
    private int respostasCorretas = 0;
    private int valor, perguntaId;

    // a cada pergunta respondida
    // sofre um decremento
    // quando chegar a 0, termina a aplicação!
    private int contador = NUMERO_TOTAL_PERGUNTAS;

    public TelaPerguntas() {
        initComponents();
        setSize(600, 450);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        setaPergunta();
        grupoDeBotoes();


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioAlternativa2 = new javax.swing.JRadioButton();
        radioAltenativa = new javax.swing.JRadioButton();
        radioAlternativa5 = new javax.swing.JRadioButton();
        radioAlternativa4 = new javax.swing.JRadioButton();
        radioAlternativa3 = new javax.swing.JRadioButton();
        labelPergunta = new javax.swing.JLabel();
        botaoProximo = new javax.swing.JButton();
        labelTempo = contagem.getLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        radioAlternativa2.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        radioAlternativa2.setText("jRadioButton1");
        radioAlternativa2.setActionCommand("");
        getContentPane().add(radioAlternativa2);
        radioAlternativa2.setBounds(10, 160, 460, 40);

        radioAltenativa.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        radioAltenativa.setText("jRadioButton1");
        radioAltenativa.setActionCommand("");
        getContentPane().add(radioAltenativa);
        radioAltenativa.setBounds(10, 100, 450, 50);

        radioAlternativa5.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        radioAlternativa5.setText("jRadioButton1");
        radioAlternativa5.setActionCommand("");
        getContentPane().add(radioAlternativa5);
        radioAlternativa5.setBounds(10, 330, 450, 40);

        radioAlternativa4.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        radioAlternativa4.setText("jRadioButton1");
        radioAlternativa4.setActionCommand("");
        getContentPane().add(radioAlternativa4);
        radioAlternativa4.setBounds(10, 270, 450, 40);

        radioAlternativa3.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        radioAlternativa3.setText("jRadioButton1");
        radioAlternativa3.setActionCommand("");
        getContentPane().add(radioAlternativa3);
        radioAlternativa3.setBounds(10, 210, 460, 40);

        labelPergunta.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        labelPergunta.setText("pergunta");
        getContentPane().add(labelPergunta);
        labelPergunta.setBounds(30, 10, 470, 80);

        botaoProximo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        botaoProximo.setText("Próxima");
        botaoProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoProximoActionPerformed(evt);
            }
        });
        getContentPane().add(botaoProximo);
        botaoProximo.setBounds(470, 370, 110, 50);

        labelTempo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        labelTempo.setText(null);
        getContentPane().add(labelTempo);
        labelTempo.setBounds(320, 400, 100, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Limpa o botao selecionado!
     */
    private void limpaSelecao() {
        grupo.clearSelection();
    }

    private void botaoProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoProximoActionPerformed

        /**
         * Verifica se o usuario selecionou algum botao!
         */
        if (usuarioSelecionouBotao() == true) {

            // decrementa para 
            --contador;

            /**
             * Verifica se a resposta está correta
             */
            respostaCorreta(perguntaId);

            /**
             * Caso ainda tenha perguntas!
             */
            if (pergunta.isEmpty() == false & contador > 0) {

                limpaSelecao();
                setaPergunta();
                

            } else {

                JOptionPane.showMessageDialog(null, "Fim!");

                cadastraJogo();

                dispose();
                TelaInicial tela = new TelaInicial();
                tela.setVisible(true);

            }

        } else {

            JOptionPane.showMessageDialog(null, "Selecione!");
        }
    }//GEN-LAST:event_botaoProximoActionPerformed

    /**
     * utiliza as tags HTML para quebrar a linha caso chegue no fim!
     *
     * @param texto
     * @return as tags com o texto
     */
    private String tagHtmlQuebraLinha(String texto) {
        return "<html><br>" + texto;
    }

    /**
     * Seta as alternativas utilizando O ID da perguta!
     */
    private void setaAlternativas(int perguntaId) {
        AlternativaDao dao = new AlternativaDao();
        String alternativas[] = dao.listaAlternativas(perguntaId);

        radioAltenativa.setText(tagHtmlQuebraLinha(alternativas[0]));
        radioAlternativa2.setText(tagHtmlQuebraLinha(alternativas[1]));
        radioAlternativa3.setText(tagHtmlQuebraLinha(alternativas[2]));
        radioAlternativa4.setText(tagHtmlQuebraLinha(alternativas[3]));
        radioAlternativa5.setText(tagHtmlQuebraLinha(alternativas[4]));

    }

    /**
     * Se a resposta que o usurio selecionou está correta! Se sim, acrescenta
     * mais um a variavel respostasCorretas
     *
     * @param perguntaId
     */
    private void respostaCorreta(int perguntaId) {
        RespostaDao dao = new RespostaDao();

        String respostaUsuario = retornaTextoBotaoSelecionado();
        String correta = dao.retornaResposta(perguntaId);

        if (correta.equals(respostaUsuario)) {
            respostasCorretas++;
        }
    }

    /**
     * Verifica se o usuario selecionou algum botao
     *
     * @return
     */
    private boolean usuarioSelecionouBotao() {
        JRadioButton[] botoes = {radioAltenativa, radioAlternativa2, radioAlternativa3, radioAlternativa4, radioAlternativa5};

        for (int i = 0; i < botoes.length; i++) {
            if (botoes[i].isSelected() == true) {
                return true;
            }
        }

        return false;

    }

    private double calculaPorcentagem(int quantidadePerguntas, int quantidadeAcertos) {
        return (quantidadeAcertos * 100) / quantidadePerguntas;
    }

    /**
     * Cadastra o Jogo!
     */
    private void cadastraJogo() {

        LocalDate dataHoje = LocalDate.now();
        UsuarioDao dao = new UsuarioDao();

        // dados para gravar!
        String dataString = ManipulaData.inverteDataLocalDate(dataHoje);
        int usuarioId = dao.retornaUltimoUsuarioCadastado();
        double porcentagem = calculaPorcentagem(NUMERO_TOTAL_PERGUNTAS, respostasCorretas);
        int segundos = Integer.parseInt(labelTempo.getText());
        
        JogoBean jogo = new JogoBean(0, usuarioId, categoriaId, dataString, 
                NUMERO_TOTAL_PERGUNTAS, respostasCorretas, porcentagem, segundos);
        JogoDao daoJogo = new JogoDao();

        daoJogo.insereJogo(jogo);

    }

    /**
     * Cria um grupo de botões, sendo assim, apenas um pode ser selecionado!
     */
    private void grupoDeBotoes() {

        grupo.add(radioAltenativa);
        grupo.add(radioAlternativa2);
        grupo.add(radioAlternativa3);
        grupo.add(radioAlternativa4);
        grupo.add(radioAlternativa5);

    }

    /**
     * Pega a alternativa e retorna para comparar com a resposta correta!
     */
    private String retornaTextoBotaoSelecionado() {

        if (radioAltenativa.isSelected() == true) {

            return radioAltenativa.getText().replace("<html><br>", "");

        } else if (radioAlternativa2.isSelected() == true) {

            return radioAlternativa2.getText().replace("<html><br>", "");

        } else if (radioAlternativa3.isSelected() == true) {

            return radioAlternativa3.getText().replace("<html><br>", "");

        } else if (radioAlternativa4.isSelected() == true) {

            return radioAlternativa4.getText().replace("<html><br>", "");

        } else {

            return radioAlternativa5.getText().replace("<html><br>", "");
        }

    }

    /**
     * Seta a pergunta!
     */
    private void setaPergunta() {

        /**
         * Gera um valor aleatório, para não sabermos a ordem da pergunta!
         */
        valor = rand.nextInt(pergunta.size());

        /**
         * Seta a pergunta no JLabel! As tags html servem para quebrar a linha
         * quando chegar no fim da linha!
         */
        labelPergunta.setText("<html> <br>" + pergunta.get(valor).getPergunta());

        /**
         * Seta as alternativas, de acordo com o ID da pergunta!
         */
        perguntaId = pergunta.get(valor).getPerguntaId();

        /**
         * Utiliza o métor para setar as alternativas
         */
        setaAlternativas(perguntaId);

        /**
         * deleta a pergunta do Array para que a mesma não venha a se repetir
         */
        pergunta.remove(valor);

    }

    public static void main(String args[]) throws InterruptedException {
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
            java.util.logging.Logger.getLogger(TelaPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

          new TelaPerguntas();
                 
                
                
                
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoProximo;
    private javax.swing.JLabel labelPergunta;
    private javax.swing.JLabel labelTempo;
    private javax.swing.JRadioButton radioAltenativa;
    private javax.swing.JRadioButton radioAlternativa2;
    private javax.swing.JRadioButton radioAlternativa3;
    private javax.swing.JRadioButton radioAlternativa4;
    private javax.swing.JRadioButton radioAlternativa5;
    // End of variables declaration//GEN-END:variables

  
    
}
