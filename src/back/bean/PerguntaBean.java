package back.bean;

public class PerguntaBean {

    private int perguntaId;
    private int categoriaId;
    private String pergunta;
    
    public PerguntaBean() {

    }

    public PerguntaBean(int perguntaId, int categoriaId, String pergunta) {
        this.perguntaId = perguntaId;
        this.categoriaId = categoriaId;
        this.pergunta = pergunta;

    }

    public int getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(int perguntaId) {
        this.perguntaId = perguntaId;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
    
    public int getCategoriaId(){
        return categoriaId;
    }
    
    public void setCategoriaId(int categoriaId){
        this.categoriaId = categoriaId;
    }
}
