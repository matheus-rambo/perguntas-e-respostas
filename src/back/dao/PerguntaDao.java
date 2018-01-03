package back.dao;

import back.bean.PerguntaBean;
import back.conexaoSqlite.ConnectionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PerguntaDao extends ConnectionFactory {

    /**
     * Irá listar as perguntas de acordo com a categoria!
     *
     * @return uma lista com as descricoes e suas Id's
     * @param categoriaId id utilizado para criar o select!
     */
    public List<PerguntaBean> listaPerguntasCategoria(int categoriaId) {

        List<PerguntaBean> listar = new ArrayList();

        try {

            String sql = "select * from Perguntas where CategoriaId = ?";

            iniciaConexao();

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, categoriaId);

            rs = stmt.executeQuery();

            while (rs.next()) {

                listar.add(new PerguntaBean(rs.getInt("PerguntaId"), rs.getInt("CategoriaId"), rs.getString("Descricao")));

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

        return listar;
    }

    public void insereNovaPergunta(PerguntaBean bean) {

        String sql = "insert into Perguntas(CategoriaId, Descricao) "
                + "values(?,?)";

        try {

            iniciaConexao();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, bean.getCategoriaId());
            stmt.setString(2, bean.getPergunta());

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

    public int retornaUltimaPerguntaCadastrada() {

        String sql = "select MAX(PerguntaId) as Maximo From Perguntas";
        int id = 0;
        try {

            iniciaConexao();

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {

                return rs.getInt("Maximo");

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

        return id;
    }

    public String listaPergunta(int perguntaId) {

        String pergunta = null;
        String sql = "select Descricao from Perguntas where PerguntaId = ?";

        try {

            iniciaConexao();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, perguntaId);

            rs = stmt.executeQuery();

            while (rs.next()) {

                pergunta = rs.getString("Descricao");

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

        return pergunta;
    }

    public int retornaPerguntaId(String descricao) {

        String sql = "select PerguntaId from Perguntas where Descricao = ?";
        int id = 0;
        try {

            iniciaConexao();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, descricao);

            rs = stmt.executeQuery();

            while (rs.next()) {

                return rs.getInt("PerguntaId");

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

        return id;
    }

    public int contaPerguntasCategoria(int categoriaId) {

        int contador = 0;

        String sql = "select COUNT(PerguntaId) as Conta FROM Perguntas WHERE CategoriaId = ?";

        try {

            iniciaConexao();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoriaId);

            rs = stmt.executeQuery();

            while (rs.next()) {

                contador = rs.getInt("Conta");

            }

        } catch (SQLException | ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, ex.toString());

        } finally {

            try {

            } catch (Throwable ex) {

                ex.printStackTrace();

            }

        }

        return contador;

    }

    public void alteraDescricaoPergunta(int perguntaId, String novaDescricao) {

        String sql = "UPDATE Perguntas SET Descricao = ? WHERE PerguntaId = ?";

        try {

            iniciaConexao();

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, novaDescricao);
            stmt.setInt(2, perguntaId);

            stmt.execute();
            
        } catch (SQLException | ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, ex.toString());

        } finally {

            try {
                
                fechaConexao();
                
            } catch (Throwable ex) {

                ex.printStackTrace();

            }
        }

    }
    
    public void deletaPergunta(int perguntaId){
        
        String sql = "DELETE FROM Perguntas WHERE PerguntaId = ?";
        
        try{
            
            iniciaConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,perguntaId);
            stmt.execute();
            
        }catch(SQLException | ClassNotFoundException ex){
            
            JOptionPane.showMessageDialog(null,ex.toString());
            
        }finally{
            
            try{
                
                fechaConexao();
                
            }catch(Throwable ex){
                
                ex.printStackTrace();
            }
        }
        
    }
    

}
