public class FuncionarioGov extends Usuario{
    private String nome;
    private int cpf;
    private String email;
    private String cargo;

    //construtor
    public FuncionarioGov(String nome, int cpf, String email, String cargo){
        super(nome, cpf, email);
        this.cargo = cargo;
    }

    //gets
    public String getCargo(){
        return cargo;
    }

    public void resolverProblema(Problema p){
        p.setResolvido();
        System.out.println("Problema resolvido por "+this.nome);
    }




}
