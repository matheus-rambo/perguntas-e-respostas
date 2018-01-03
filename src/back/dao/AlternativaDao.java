package back.dao;

import back.bean.AlternativaBean;
import back.conexaoSqlite.ConnectionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlternativaDao extends ConnectionFactory {

    public String[] listaAlternativas(int perguntaId) {

        String descricao[] = new String[5];

        try {

            String sql = "select A.AlternativaId , A.Descricao from Alternativas as A "
                    + "inner join Alternativa_Pergunta as AP on"
                    + " A.AlternativaId = AP.AlternativaId "
                    + "where AP.PerguntaId = ?";

            iniciaConexao();

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, perguntaId);

            rs = stmt.executeQuery();

            int contador = 0;

            while (rs.next()) {

                descricao[contador] = rs.getString("Descricao");
                ++contador;
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

        return descricao;

    }

    public void insereNovaAlternativa(AlternativaBean bean) {

        String sql = "insert into Alternativas(Descricao) values(?) , (?) , (?) , (?) , (?)";

        try {

            iniciaConexao();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, bean.getDescricao()[0]);
            stmt.setString(2, bean.getDescricao()[1]);
            stmt.setString(3, bean.getDescricao()[2]);
            stmt.setString(4, bean.getDescricao()[3]);
            stmt.setString(5, bean.getDescricao()[4]);
            stmt.execute();

        } catch (SQLException | ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, ex.toString());

        } finally {

            try {

            } catch (Throwable ex) {

                JOptionPane.showMessageDialog(null, ex.toString());

            }
        }

    }

    public void insereNovaAlternativa_Pergunta(int alternativaId, int perguntaId) {

        String sql = "insert into Alternativa_Pergunta(AlternativaId, PerguntaId) values(?,?)";

        try {

            iniciaConexao();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, alternativaId);
            stmt.setInt(2, perguntaId);
            stmt.execute();

        } catch (SQLException | ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, ex.toString());

        } finally {

            try {

            } catch (Throwable ex) {

                JOptionPane.showMessageDialog(null, ex.toString());

            }
        }

    }

    public int[] retorna_5_ultimasAlternativas() {

        String sql = "SELECT AlternativaId FROM Alternativas ORDER BY AlternativaID DESC LIMIT 5 ";
        int id[] = new int[5];

        try {

            iniciaConexao();

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            int conta = 0;
            while (rs.next()) {

                id[conta] = rs.getInt("AlternativaId");
                ++conta;
            }

        } catch (SQLException | ClassNotFoundException ex) {

            JOptionPane.showMessageDialog(null, ex.toString());

        } finally {

            try {

            } catch (Throwable ex) {

                JOptionPane.showMessageDialog(null, ex.toString());

            }
        }

        return id;

    }
    
    public List<AlternativaBean> retornaAlternativasPergunta(int perguntaId){
        
        String sql = "SELECT Al.Descricao AS Descricao, Al.AlternativaId as Codigo"
                + " FROM Alternativas AS Al"
                + " INNER JOIN Alternativa_Pergunta AS Ap ON "
                + " Al.AlternativaId = Ap.AlternativaId WHERE "
                + "Ap.PerguntaId = ?";
        
        List<AlternativaBean> alternativas = new ArrayList();
        
        try{
            
            iniciaConexao();
            
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,perguntaId);
            
            rs = stmt.executeQuery();
            
            
            while(rs.next()){
                
                alternativas.add(new AlternativaBean(rs.getInt("Codigo"), rs.getString("Descricao")));
                
            }
        
        }catch(SQLException | ClassNotFoundException ex){
            
            JOptionPane.showMessageDialog(null,ex.toString());
            
        }finally{
         
            try{
                
                fechaConexao();
                
            }catch(Throwable ex){
                
                ex.printStackTrace();
            }
            
        }
     
        return alternativas;
    }

    public void alteraDescricaoAlternativa(int alternativaId, String descricao){
        
        String sql = "UPDATE Alternativas SET Descricao = ? WHERE AlternativaId = ? ";
        
        try{
            
            iniciaConexao();
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,descricao);
            stmt.setInt(2,alternativaId);
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
    
    public void deletaAlternativas(int alternativaId){
        
        String sql = "DELETE FROM Alternativas WHERE AlternativaId = ? ";
        
        try{
            
            iniciaConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,alternativaId);
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
