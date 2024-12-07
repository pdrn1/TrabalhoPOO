public class Usuario {
    private String nome;
    private String cpf;
    private String email;

    // construtor
    public Usuario(String nome, String cpf, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    // gets
    public String getNome(){
        return nome;
    }
    public String getCpf(){
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
