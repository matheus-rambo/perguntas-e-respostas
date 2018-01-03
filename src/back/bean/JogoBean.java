
package back.bean;

public class JogoBean {

    private int jogoId;
    private int usuarioId;
    private int categoriaId;
    private String dataJogo;
    private int numeroPerguntas;
    private int numeroRespostas;
    private double porcentagem;
    private int segundos;

    private String nomeUsuario;
    
    public JogoBean(int jogoId, int usuarioId, int categoriaId, String dataJogo, int numeroPerguntas, int numeroRespostas,
            double porcentagem, int segundos){
        this.usuarioId = usuarioId;
        this.categoriaId = categoriaId;
        this.dataJogo = dataJogo;
        this.numeroPerguntas = numeroPerguntas;
        this.numeroRespostas = numeroRespostas;
        this.porcentagem = porcentagem;
        this.segundos = segundos;
    }
    
    public JogoBean(String nome, String data, double porc){
        nomeUsuario = nome;
        dataJogo = data;
        porcentagem = porc;
    }
    
    
    
    public int getJogoId() {
        return jogoId;
    }

    public void setJogoId(int jogoId) {
        this.jogoId = jogoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getDataJogo() {
        return dataJogo;
    }

    public void setDataJogo(String dataJogo) {
        this.dataJogo = dataJogo;
    }

    public int getNumeroPerguntas() {
        return numeroPerguntas;
    }

    public void setNumeroPerguntas(int numeroPerguntas) {
        this.numeroPerguntas = numeroPerguntas;
    }

    public int getNumeroRespostas() {
        return numeroRespostas;
    }

    public void setNumeroRespostas(int numeroRespostas) {
        this.numeroRespostas = numeroRespostas;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
    
}
