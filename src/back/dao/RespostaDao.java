package back.dao;

import back.bean.RespostaBean;
import back.conexaoSqlite.ConnectionFactory;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class RespostaDao extends ConnectionFactory {

    public String retornaResposta(int perguntaId) {

        String sql = "select Descricao from Respostas where PerguntaId = ?";

        try {

            iniciaConexao();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, perguntaId);

            rs = stmt.executeQuery();

            while (rs.next()) {

                return rs.getString("Descricao");

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

        return null;

    }

    
  
     public void insereNovaResposta(RespostaBean bean) {

        String sql = "insert into Respostas(PerguntaId, Descricao) "
                + "values(?,?)";

        try {

            iniciaConexao();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, bean.getPerguntaId());
            stmt.setString(2, bean.getDescricao());

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
     
     
     public void alteraRespostaPergunta(int perguntaId, String novaResposta) {
         
         String sql = "UPDATE Respostas SET Descricao = ? WHERE PerguntaId = ?";
         
         try{
            
             iniciaConexao();
             
             stmt = conn.prepareStatement(sql);
             stmt.setString(1,novaResposta);
             stmt.setInt(2,perguntaId);
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
     
     public void deletaResposta(int perguntaId){
         
         String sql = "DELETE FROM Respostas WHERE PerguntaId = ?";
         
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
