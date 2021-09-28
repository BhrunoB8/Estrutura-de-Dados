import java.util.Map;

public class Validar {

    //LISTA ENCADEADA
    public static DuplamenteEncadeada<Map<Integer, String>> remover(DuplamenteEncadeada<Map<Integer, String>> lista, Integer matricula){
        int count = 0;
        for (int i = 0; i < lista.size(); i++) {
            Map<Integer, String> entry = lista.get(i).getDado();

            for (Integer key : entry.keySet()) {
                if (key <= matricula){
                    lista.remove(lista.get(i));
                    count++;
                }              
            }       
        }
        System.out.println("----------------------------------------------");
        System.out.println("Total de cadastros removidos: "+ count);
        System.out.println("----------------------------------------------");
        return lista;
    }

    public static int pesquisar(DuplamenteEncadeada<Map<Integer, String>> lista, String curso){
        int qtd=0;
        int count = 0;
        boolean compativel;

        for (int i = 0; i < lista.size(); i++) {
            Map<Integer, String> entry = lista.get(i).getDado();


            for (Integer key : entry.keySet()) {
                String value = entry.get(key);
                if (value.equals(curso)) {
                    compativel = false;
                    System.out.println(lista.get(i).getDado());
                    count++;
                    for (int j = i + 1; j < lista.size(); j++) {
                        Map<Integer, String> a = lista.get(j).getDado();
                        if (entry.entrySet().equals(a.entrySet())) {
                            compativel = true;
                        }

                    }

                    if (!compativel)
                        qtd++;

                }
                
            }
            
        }
        System.out.println("----------------------------------------------");
        System.out.println("Total de alunos que cursam ES: "+count);
        System.out.println("----------------------------------------------");

        return qtd;
    }
}
    

