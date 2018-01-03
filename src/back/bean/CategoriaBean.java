
package back.bean;


public class CategoriaBean {
    
    private int categoriaId;
    private String descricao;

    public CategoriaBean(int categoriaId, String descricao){
        this.categoriaId = categoriaId;
        this.descricao = descricao;
    }
    
    
    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    


}
