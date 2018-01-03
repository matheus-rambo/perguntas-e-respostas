package back.funcoes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Contagem extends JFrame {

    int tempo = 0;

    JLabel show = null;

    Timer time = null;
    
    public Contagem() {

        show = new JLabel();
      
        
        // a classe time, implementa Runnable
        // 1000, é o delay, ativar é o 
        // ActionListener
         time = new Timer(1000, ativar);
        time.start();

    }

    void incrementa() {


            show.setText(String.valueOf(tempo));

            ++tempo;

        
    }

    public JLabel getLabel(){
        return show;
    }
    

    
    
    public int getTempo(){
        return tempo;
    }

    
    ActionListener ativar = (new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            /** incrementa, sendo assim, é possível saber 
            * quantos segundos o usuário levou para 
            * completar!
            */
            
            incrementa();
            

        }
    });

    
}
