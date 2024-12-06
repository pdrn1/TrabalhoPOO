public class SistemaLogin {
    private String usuario;
    private String senha;

    public void registraConta(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
        System.out.println("Conta registrada com sucesso!");
    }

    public boolean verificarLogin(String usuario, String senha) {
        return this.usuario.equals(usuario) && this.senha.equals(senha);
    }

    public String getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "SistemaLogin{" + "usuario='" + usuario + '\'' + '}';
    }
}
