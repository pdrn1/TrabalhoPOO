import java.util.ArrayList;
import java.util.List;

public class Cidade {
    private String nome;
    private List<Problema> problemas;

    //construtor
    public Cidade(String nome){
        this.nome = nome;
        this.problemas = new ArrayList<>();
    }
    public Problema getProblema(int i){
        return problemas.get(i);
    }

    public void adicionarProblema(Problema problema){
        problemas.add(problema);
    }

    public void listaProblemas(){
        for (Problema problema : problemas){
            String status;
            if (problema.foiResolvido()){
                status = "Resolvido";

            }
            else{
                status = "Pendente";
            }
            System.out.println("Problema: "+problema.getDescricao() + "\n" + "Status: " +status);
        }
    }
}
