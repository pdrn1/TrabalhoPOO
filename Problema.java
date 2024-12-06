public class Problema {
    private String descricao;
    private Usuario nome;
    private boolean resolvido;

    //construtor
    public Problema(String descricao, Usuario nome){
        this.descricao = descricao;
        this.nome= nome;
        this.resolvido = false;
    }

    //gets
    public String getDescricao(){
        return this.descricao;
    }
    public Usuario getRegistradoPor(){
        return this.nome;
    }
    public boolean foiResolvido(){
        return this.resolvido;
    }

    public void setResolvido(){
        this.resolvido = true;
    }
}
