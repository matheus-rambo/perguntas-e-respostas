
package back.funcoes;

import java.time.LocalDate;

public class ManipulaData {
    
    
    private static String corta(String texto, int inicial, int finalI){
        return texto.substring(inicial,finalI);
        
    }
    
    public static String inverteDataLocalDate(LocalDate data){
        String dataString = data.toString();
        return corta(dataString, 8, 10)  + "-" + corta(dataString,5,7) + "-" + corta(dataString, 0, 4);
        
        
    }
    

}
