import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<String, SistemaLogin> contas = new HashMap<>();
    private static ArrayList<Problema> listaProblemas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("=== Bem-vindo ao Sistema de Gerenciamento ===");
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Entrar no sistema");
            System.out.println("3 - Encerrar programa");
            System.out.print("Opção: ");
            String opcao = entrada.nextLine();

            switch (opcao) {
                case "1":
                    criarConta(entrada);
                    break;
                case "2":
                    entrar(entrada);
                    break;
                case "3":
                    System.out.println("Obrigado por usar o sistema! Até a próxima.");
                    entrada.close();
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }

    private static void criarConta(Scanner entrada) {
        System.out.print("Você é funcionário do governo? (s/n): ");
        String resposta = entrada.nextLine().trim().toLowerCase();

        if (resposta.equals("s")) {
            cadastrarFuncionario(entrada);
        } else if (resposta.equals("n")) {
            cadastrarUsuario(entrada);
        } else {
            System.out.println("Resposta inválida. Tente novamente.");
        }
    }

    private static void cadastrarFuncionario(Scanner entrada) {
        SistemaLogin login = criarLogin(entrada);

        System.out.println("Informações do funcionário:");
        System.out.print("Nome: ");
        String nome = entrada.nextLine();
        System.out.print("Email: ");
        String email = entrada.nextLine();
        System.out.print("CPF: ");
        String cpf = entrada.nextLine();
        System.out.print("Cargo: ");
        String cargo = entrada.nextLine();
        login.setTipo("Funcionario");

        FuncionarioGov funcionario = new FuncionarioGov(nome, cpf, email, cargo);
        contas.put(login.getUsuario(), login);

        System.out.println("Funcionário registrado com sucesso!");
    }

    private static void cadastrarUsuario(Scanner entrada) {
        SistemaLogin login = criarLogin(entrada);

        System.out.println("Informações do usuário:");
        System.out.print("Nome: ");
        String nome = entrada.nextLine();
        System.out.print("Email: ");
        String email = entrada.nextLine();
        System.out.print("CPF: ");
        String cpf = entrada.nextLine();
        login.setTipo("Usuario");

        Usuario usuario = new Usuario(nome, cpf, email);
        contas.put(login.getUsuario(), login);

        System.out.println("Usuário registrado com sucesso!");
    }

    private static SistemaLogin criarLogin(Scanner entrada) {
        System.out.println("Criando conta...");
        System.out.print("Nome de usuário: ");
        String usuario = entrada.nextLine();
        System.out.print("Senha: ");
        String senha = entrada.nextLine();

        SistemaLogin login = new SistemaLogin();
        login.registraConta(usuario, senha);
        return login;
    }

    private static void entrar(Scanner entrada) {
        System.out.print("Nome de usuário: ");
        String usuario = entrada.nextLine();
        System.out.print("Senha: ");
        String senha = entrada.nextLine();

        SistemaLogin login = contas.get(usuario);

        if (login != null && login.verificarLogin(usuario, senha)) {
            System.out.println("Login realizado com sucesso!");
            if (login.getTipo().compareTo("Funcionario") == 0) {
                menuFuncionario(entrada, usuario);
            } else {
                menuUsuario(entrada, usuario);
            }
        } else {
            System.out.println("Usuário ou senha inválidos. Verifique suas credenciais e tente novamente.");
        }
    }

    private static void menuUsuario(Scanner entrada, String usuario) {
        while (true) {
            System.out.println("\n=== Menu do Usuário ===");
            System.out.println("1 - Registrar um problema");
            System.out.println("2 - Listar problemas cadastrados");
            System.out.println("3 - Sair do sistema");
            System.out.print("Escolha: ");
            String opcao = entrada.nextLine();

            switch (opcao) {
                case "1":
                    registrarProblema(entrada, usuario);
                    break;
                case "2":
                    listarProblemas();
                    break;
                case "3":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void menuFuncionario(Scanner entrada, String usuario) {
        while (true) {
            System.out.println("\n=== Menu do Funcionário ===");
            System.out.println("1 - Registrar um problema");
            System.out.println("2 - Listar problemas cadastrados");
            System.out.println("3 - Resolver um problema");
            System.out.println("4 - Sair do sistema");
            System.out.print("Escolha: ");
            String opcao = entrada.nextLine();

            switch (opcao) {
                case "1":
                    registrarProblema(entrada, usuario);
                    break;
                case "2":
                    listarProblemas();
                    break;
                case "3":
                    resolverProblema(entrada);
                    break;
                case "4":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void registrarProblema(Scanner entrada, String usuario) {
        System.out.print("Descreva o problema: ");
        String descricao = entrada.nextLine();
        Problema problema = new Problema(descricao, new Usuario(usuario, "0", "N/A"));
        listaProblemas.add(problema);
        System.out.println("Problema registrado com sucesso!");
    }

    private static void listarProblemas() {
        if (listaProblemas.isEmpty()) {
            System.out.println("Nenhum problema cadastrado.");
        } else {
            System.out.println("\nLista de problemas:");
            for (int i = 0; i < listaProblemas.size(); i++) {
                Problema problema = listaProblemas.get(i);
                String status = problema.foiResolvido() ? "Resolvido" : "Pendente";
                System.out.printf("%d. %s (Cadastrado por: %s, Status: %s)\n", i + 1,
                        problema.getDescricao(), problema.getRegistradoPor().getNome(), status);
            }
        }
    }

    private static void resolverProblema(Scanner entrada) {
        listarProblemas();
        if (!listaProblemas.isEmpty()) {
            System.out.print("Informe o número do problema que deseja resolver: ");
            int indice = Integer.parseInt(entrada.nextLine()) - 1;
            if (indice >= 0 && indice < listaProblemas.size()) {
                Problema problema = listaProblemas.get(indice);
                problema.setResolvido();
                System.out.println("Problema marcado como resolvido!");
            } else {
                System.out.println("Número inválido.");
            }
        }
    }
}
