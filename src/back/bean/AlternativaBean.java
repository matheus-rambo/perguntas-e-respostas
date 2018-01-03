package back.bean;

/**
 * Como os dados voltarão de uma tabela de ligação, não será necessário utilizarmos
 * o id da alernativa
 * @author matheus
 */

public class AlternativaBean {

    
    private String descricao [] ;
    private int alternativaId;
    private String descricaoA;
    
    
    public AlternativaBean( String descricao[]){
        this.descricao = descricao;
        
    }
    
    public AlternativaBean(int alternativaId, String descricao[]){
        this.alternativaId = alternativaId;
        this.descricao = descricao;
    }
    
    public AlternativaBean(int id , String des){
        alternativaId = id;
        descricaoA = des;
    }
    

    public String[] getDescricao() {
        return descricao;
    }

    public void setDescricao(String[] descricao) {
        this.setDescricao(descricao);
    }

    public int getAlternativaId() {
        return alternativaId;
    }

    public void setAlternativaId(int alternativaId) {
        this.alternativaId = alternativaId;
    }

    

    public String getDescricaoA() {
        return descricaoA;
    }

    public void setDescricaoA(String descricaoA) {
        this.descricaoA = descricaoA;
    }

  

    
    
}
