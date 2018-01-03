package back.funcoes;

public class FormataLinha {

    /**
     *      */
    public static String formata(String texto){
        
        int tamanho = 15 - texto.length();
        StringBuilder textoVolta = new StringBuilder(texto);
        
        for(;tamanho > 0; tamanho--){
            textoVolta.append(" ");
        }
        
        return textoVolta.toString();
    
    }
    
  
    
}
