public class SistemaLogin {
    private String usuario;
    private String senha;
    private String tipo;

    public void registraConta(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
        this.tipo = tipo;
        System.out.println("Conta registrada com sucesso!");
    }

    public boolean verificarLogin(String usuario, String senha) {
        return this.usuario.equals(usuario) && this.senha.equals(senha);
    }

    public String getUsuario() {
        return usuario;
    }

    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "SistemaLogin{" + "usuario='" + usuario + '\'' + '}';
    }
}
