
package back.bean;

public class UsuarioBean {
    
    public UsuarioBean(String nome){
        this.nome = nome;
    }
    
    
    private int usuarioId;
    private String nome;

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
