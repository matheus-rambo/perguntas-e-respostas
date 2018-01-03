
package back.funcoes;


public class ThreadGravarArquivo implements Runnable{
    
    Thread thr = null;
    String nomeCategoria , conteudo;
    
    public ThreadGravarArquivo(String nomeCategoria, String conteudo){
        
        thr = new Thread(this,"Thread");
        
        this.nomeCategoria = nomeCategoria;
        this.conteudo = conteudo;
        
        thr.start();
        
    }
    
    public void run(){
        
        SalvaArquivo.salvaArquivo(nomeCategoria, conteudo);
        
        
    }
    
}
