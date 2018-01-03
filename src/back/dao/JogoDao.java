package back.dao;

import back.bean.JogoBean;
import back.conexaoSqlite.ConnectionFactory;
import back.funcoes.ConverteSegundos_Minutos;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class JogoDao extends ConnectionFactory {

    public JogoDao(int cat) {
        listarJogos(cat);
    }
    
    public JogoDao(){
        
    }

    public void insereJogo(JogoBean jogo) {

        String sql = "insert into Jogos(UsuarioId,CategoriaId,DateJogo,"
                + "NumeroPerguntas,NumeroCorretas,Porcentagem, TempoTotal)"
                + " values (?,?,?,?,?,?,?)";

        try {

            iniciaConexao();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, jogo.getUsuarioId());
            stmt.setInt(2, jogo.getCategoriaId());
            stmt.setString(3, jogo.getDataJogo());
            stmt.setInt(4, jogo.getNumeroPerguntas());
            stmt.setInt(5, jogo.getNumeroRespostas());
            stmt.setDouble(6, jogo.getPorcentagem());
            stmt.setInt(7, jogo.getSegundos());

            stmt.execute();

        } catch (SQLException | ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, ex.toString());

        } finally {

            try {

                fechaConexao();

            } catch (Throwable ex) {

                JOptionPane.showMessageDialog(null, ex.toString());

            }

        }
    }

    public ArrayList<Object> dadosTabela = new ArrayList();

    private void listarJogos(int categoriaId) {

        String sql = "select U.Nome as Usuario, J.DateJogo as Data,"
                + " J.Porcentagem as Porcentagem, J.NumeroPerguntas as Numero ,"
                + " J.NumeroCorretas as Corretas , J.TempoTotal as Segundos"
                + " from Jogos as J "
                + " inner join Usuarios as U  on "
                + " U.UsuarioId = J.UsuarioId "
                + " where J.CategoriaId = ?"
                + " order by Porcentagem DESC";

        try {

            iniciaConexao();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoriaId);

            rs = stmt.executeQuery();

            while (rs.next()) {

                String tempo = ConverteSegundos_Minutos.tempoTotal(rs.getInt("Segundos"));
                
                dadosTabela.add(new Object[]{rs.getString("Usuario"), rs.getString("Data"),
                    rs.getDouble("Porcentagem") , rs.getInt("Numero") , rs.getInt("Corretas") , tempo});
            }

        } catch (SQLException | ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, ex.toString());

        } finally {

            try {

                fechaConexao();

            } catch (Throwable ex) {

                JOptionPane.showMessageDialog(null, ex.toString());

            }

        }

    }

}
