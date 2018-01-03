
package back.dao;

import back.bean.UsuarioBean;
import back.conexaoSqlite.ConnectionFactory;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class UsuarioDao extends ConnectionFactory{
    
    
    public void insereUsuario(UsuarioBean usuario){
        
        String sql = "insert into Usuarios(Nome) values(?)";
        
        try{
            
            iniciaConexao();
            
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.execute();
        
        }catch(SQLException | ClassNotFoundException ex){
            
            JOptionPane.showMessageDialog(null,ex.toString());
            
        }finally{
            
            try{
                
                fechaConexao();
                
            }catch(Throwable ex){
                
                JOptionPane.showMessageDialog(null,ex.toString());
                
            }
            
        }
    }
    
    public int retornaUltimoUsuarioCadastado(){
        
        String sql = "select UsuarioId from Usuarios ";
        int id = 0;
            try{
            
            iniciaConexao();
            
            stmt = conn.prepareStatement(sql);
           rs = stmt.executeQuery();
           
           while(rs.next()){
               
               id =  rs.getInt("UsuarioId");
               
           }
        
        }catch(SQLException | ClassNotFoundException ex){
            
            JOptionPane.showMessageDialog(null,ex.toString());
            
        }finally{
            
            try{
                
                fechaConexao();
                
            }catch(Throwable ex){
                
                JOptionPane.showMessageDialog(null,ex.toString());
                
            }
            
        }
        
        return id;
    }
    
  

}
