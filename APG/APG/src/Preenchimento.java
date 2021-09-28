import java.util.HashMap;
import java.util.Map;

public class Preenchimento {

    private Estudante estudante;
    private Map<Integer,String> map_estudante;
    private final int total_alunos = 1000;


    public DuplamenteEncadeada<Map<Integer, String>> getLDE(){
        DuplamenteEncadeada<Map<Integer, String>> listaDuplamenteEncadeada = new DuplamenteEncadeada<>();


        for (int i = 0; i < total_alunos; i++) {
            estudante     = new Estudante();
            map_estudante = new HashMap<>();

            map_estudante.put(estudante.getMatricula(), estudante.getCurso());
            listaDuplamenteEncadeada.adicionarFim(map_estudante);
        }
        System.out.println("----------------------------------------------");
        System.out.println("Cadastros realizados com sucesso! ");
        System.out.println("TOTAL DE CADASTROS: ");

        return listaDuplamenteEncadeada;
    }


}