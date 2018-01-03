package back.conexaoSqlite;

import back.funcoes.EncontraBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection conn = null;
    public PreparedStatement stmt = null;
    public ResultSet rs = null;
    
    public void iniciaConexao() throws SQLException, ClassNotFoundException {

        Class.forName("org.sqlite.JDBC");

        String sisOp = System.getProperty("os.name");
        String url = null;
        String jdbc = "jdbc:sqlite:";
        
        if (sisOp.startsWith("win") | sisOp.startsWith("Win")) {

            url = EncontraBase.caminhoParaWindows;

        } else {
        
            // quando chegar aqui, a Thread já localizou o caminho!
            url = EncontraBase.caminhoParaLinux;
            

        }

        conn = DriverManager.getConnection(jdbc + url);

    }

    public void fechaConexao() throws SQLException {

        if (rs != null) {

            rs.close();

        }

        if (stmt != null) {

            stmt.close();

        }

        if (conn != null) {

            conn.close();

        }

    }

}

