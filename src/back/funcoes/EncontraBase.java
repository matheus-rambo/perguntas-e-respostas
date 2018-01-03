/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back.funcoes;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class EncontraBase {

    /**
     * Está classe não pode ser instanciada, sendo asssim, a mesma tem métodos
     * estáticos para localizar a base de dados
     */
    private EncontraBase() {
    }

    public static String caminhoParaLinux = null;
    public static String caminhoParaWindows = null;

    /**
     * Utiliza o comando locate para localizar a base de dados!
     */
    public static void caminhoBaseLinux() {

        Runtime run = null;
        Process pro = null;
        Scanner in = null;

        try {

            run = Runtime.getRuntime();
            pro = run.exec(new String[]{"/bin/sh", "-c", "locate /database/Logica.db"});
            in = new Scanner(pro.getInputStream());
            caminhoParaLinux = in.next();

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao executar comando Linux!\n" + ex.toString());

        } finally {

            try {

                in.close();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "Erro fatal!\n" + ex.toString());

            }
        }

    }

    /**
     * Fazer o mesmo para windows
     */
    public static void caminhoBaseWindows() {

        Runtime run = null;
        Process pro = null;
        Scanner in = null;
        try {

            run = Runtime.getRuntime();
            String comando[] = {"cmd", "/c", "dir /s /b Logica.db"};

            pro = run.exec(comando);
            in = new Scanner(pro.getInputStream());
            
            caminhoParaWindows = in.next();
            
            
        } catch (IOException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao executar comando Windows!\n" + ex.toString());

        } finally {

            try {

                in.close();
                

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "Erro fatal!\n" + ex.toString());

            }
        }

    }


      
      

}
