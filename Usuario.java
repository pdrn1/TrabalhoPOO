public class Usuario {
    private String nome;
    private int cpf;
    private String email;

    // construtor
    public Usuario(String nome, int cpf, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    // gets
    public String getNome(){
        return nome;
    }
    public int getCpf(){
        return cpf;
    }
    public String getEmail() {
        return email;
    }

    public void cadastraProblema(Cidade cidade, String descricao){
        Problema problema = new Problema(descricao, this);
        cidade.adicionarProblema(problema);
        System.out.println("Problema registrado por "+this.nome);
    }


}
