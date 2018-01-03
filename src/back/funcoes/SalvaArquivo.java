package back.funcoes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class SalvaArquivo {

    /**
     * Irá salvar um arquivo, de acordo com a tabela ranking vai criar uma
     * pasta, com o nome Rankings se a pasta já existe, irá apenas gravar o
     * arquivo dentro dela! o nome será o nome da categoria + a data do dia em
     * que o mesmo foi gerado.
     * O método é synchronized, pois apenas uma Thread poderá executar de vez!
     */
    public static synchronized void salvaArquivo(String nomeCategoria, String conteudo) {

        LocalDate dataHoje = LocalDate.now();
        String dataString = ManipulaData.inverteDataLocalDate(dataHoje);

        String nomeArquivo = nomeCategoria + "_" + dataString;

        File diretorio = new File("Rankings");

        // se o diretório ainda não existe!
        if (diretorio.exists() == false) {

            // cria o diretorio
            diretorio.mkdir();

        }

        String caminhoDiretorio = null;
        String sisOp = System.getProperty("os.name");

            /**
             * Verifica o sistema operacional do usuario!
             */
        
        if (sisOp.startsWith("win") | sisOp.startsWith("Win")) {
            
            caminhoDiretorio = diretorio.getAbsolutePath() + "\\" + nomeArquivo;

        } else {

            caminhoDiretorio = diretorio.getAbsolutePath() + "/" + nomeArquivo;
        }

        File salvarArquivoNovo = new File(caminhoDiretorio);

        gravaArquivo(conteudo, salvarArquivoNovo);

    }
    

    /**
     * É passado o conteudo que será salvo no arquivo como String
     * e um arquivo File que será o caminho do arquivo
     */
    
    private static void gravaArquivo(String conteudoArquivo, File caminhoDoArquivo) {

        FileWriter gravarConteudo = null;

        try {

            gravarConteudo = new FileWriter(caminhoDoArquivo);

            gravarConteudo.write(conteudoArquivo);

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao gravar!!!\n" + ex.toString());

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Erro fatal!!!\n" + ex.toString());

        } finally {

            try {

                gravarConteudo.close();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "Erro ao encerrar a gravação!\n" + ex.toString());
                return;

            }
        }

        JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso!");

    }

  
}
