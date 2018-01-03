
package back.funcoes;


public class ThreadCaminhoBanco implements Runnable{

    public Thread thread = null;
    
    
    
    public ThreadCaminhoBanco(String nome){
        
        thread = new Thread(this,nome);
        
        // inicia o método RUN()
        thread.start();
        
    }
    
    /**
     * Esta thread foi criada para evitar a demora da requisição do 
     * comando locate, sendo assim, quando o usuario inicia o programa,
     * a thread já encontra o caminho da base
     */

    
    public void run(){

        String sisOp = System.getProperty("os.name");
        
        if(sisOp.startsWith("Win") | sisOp.startsWith("win")){
            
            // realiza o comando dir /s /d Logica.db
            // e lista aonde o arquivo se encontra!
            EncontraBase.caminhoBaseWindows();
            
        }else{
            
        // realiza o comando locate database/Logica.db
        // que encontra a base de dados
             EncontraBase.caminhoBaseLinux();
        }
    }
    
}
