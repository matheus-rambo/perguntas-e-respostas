package back.funcoes;

import java.text.DecimalFormat;

/**
 * Converte Segundos para minutos
 * @author matheus
 */

public class ConverteSegundos_Minutos {

    private static int totalMinutos(int segundos) {

        if (segundos > 60) {
            
            return segundos / 60;
        
        }
        return 0;

    }

    private static int totalSegundos(int segundos) {
        
        if(segundos > 60){
        
        return segundos % 60;
        
        } return segundos;
    }
    
    public static String tempoTotal(int segundos){
     
        DecimalFormat df = new DecimalFormat("00");
        
        int m = totalMinutos(segundos);
        int s = totalSegundos(segundos);
     
        return df.format(m) + ":" + df.format(s);
    }
    
    
 
    
}
