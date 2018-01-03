package back.funcoes;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalTime;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class RelogioDigital  {

//    String relogio = null;
    private int minutos, horas, segundos;
    DecimalFormat formato; //*

    JLabel show = new JLabel();
     
    public RelogioDigital() {
       
        Timer time = new Timer(1000, ativar);
        time.start();
        
    }

    /**
     * Pega os dados necessários para fazermos o relógio digital!
     */
    private void pegaOsDados() {


        horas = LocalTime.now().getHour();
        minutos = LocalTime.now().getMinute();
        segundos = LocalTime.now().getSecond();
        
        show.setText(formatar(horas) + ":" + formatar(minutos) + ":" + formatar(segundos));

    }

    private String formatar(int num) {
        formato = new DecimalFormat("00");
        return formato.format(num);
    }

    ActionListener ativar = (new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pegaOsDados();
        }
    });
    
    public JLabel retornaRelogio(){
        return show;
    }
    
    
}


       

        
        
    
    
    
    

