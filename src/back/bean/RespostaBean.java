
package back.bean;


public class RespostaBean {

 private int respostaId;
 private String descricao;
 private int perguntaId;
 
 
    public RespostaBean(int respostaId, String descricao, int perguntaId){
        this.respostaId = respostaId;
        this.descricao = descricao;
        this.perguntaId = perguntaId;
    }

    public int getRespostaId() {
        return respostaId;
    }

    public void setRespostaId(int respostaId) {
        this.respostaId = respostaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(int perguntaId) {
        this.perguntaId = perguntaId;
    }
 
 

    
}
