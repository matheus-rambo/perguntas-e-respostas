package back.dao;

import back.bean.CategoriaBean;
import back.conexaoSqlite.ConnectionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaDao {

    public List<CategoriaBean> listarCategorias() {

        List<CategoriaBean> listar = new ArrayList();

        ConnectionFactory conexao = new ConnectionFactory();

        try {

            conexao.iniciaConexao();

            // inner join!
            String sql = "select * from Categorias";

            conexao.stmt = conexao.conn.prepareStatement(sql);

            conexao.rs = conexao.stmt.executeQuery();

            while (conexao.rs.next()) {

                listar.add(new CategoriaBean(conexao.rs.getInt("CategoriaId"), conexao.rs.getString("Descricao")));
            }

        } catch (SQLException | ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, ex.toString());

        } finally {

            try {
                conexao.fechaConexao();

            } catch (Throwable ex) {

                JOptionPane.showMessageDialog(null, "Erro Fatal!\n" + ex.toString());
            }
        }

        return listar;
    }

    public int retornaIdCategoria(String descricao) {

        String sql = "select CategoriaId from Categorias where Descricao = ?";
        ConnectionFactory con = null;

        try {

            con = new ConnectionFactory();

            con.iniciaConexao();

            con.stmt = con.conn.prepareStatement(sql);

            con.stmt.setString(1, descricao);

            con.rs = con.stmt.executeQuery();

            while (con.rs.next()) {

                return con.rs.getInt("CategoriaId");

            }

        } catch (SQLException | ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, ex.toString());

        } finally {

            try {
                
                con.fechaConexao();

            } catch (Throwable ae) {

                JOptionPane.showMessageDialog(null, ae.toString());

            }
        }
        return 0;
    }

    public void cadastraCategoria(String nomeCategoria){
        
        String sql = "INSERT INTO Categorias(Descricao) VALUES(?)";
        
        ConnectionFactory con = null;
        
        try{
            
            con = new ConnectionFactory();
            con.iniciaConexao();
            
            con.stmt = con.conn.prepareStatement(sql);
            con.stmt.setString(1,nomeCategoria);
            con.stmt.execute();
        
        }catch(SQLException | ClassNotFoundException ex){
            
            JOptionPane.showMessageDialog(null,ex.toString());
            
        }finally{
            
            try{
                
                con.fechaConexao();
                
            }catch(Throwable ex){
                
                ex.printStackTrace();
            }
            
        }
        
        
    }

}
