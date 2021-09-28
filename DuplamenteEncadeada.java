import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class DuplamenteEncadeada<T> {

    private No<T> head;
    private No<T> tail;
    private ArrayList <T> Nos = new ArrayList();
    private Integer size = 0;

    public void adicionarInicio(T dado) {
        No<T> novoNo = new No<>(dado);

        novoNo.proximo = head;
        novoNo.anterior = null;

        if (head != null)
            head.anterior = novoNo;

        head = novoNo;
        
        if (tail == null)
            tail = novoNo;
        size++;
    }

    public void adicionarFim(T dado) {
        No<T> novoNo = new No<>(dado);
        No<T> ultimo = head;
        Nos.add(dado);
        System.out.println(dado.toString());
        novoNo.proximo = null;
        if (tail != null)
            tail.proximo = novoNo;
        tail = novoNo;

        if (head == null) {
            head = novoNo;
        } else {

            while (ultimo.proximo != null) {
                ultimo = ultimo.proximo;
            }
            ultimo.proximo = novoNo;
            novoNo.anterior = ultimo;
        }
        size++;
    }

    public void remove(No<T> no) {

        System.out.println("Estudante removido com sucesso!");
        if (head == null || no == null)
            return;

        if (head == no)
            head = no.proximo;
        
        if (no.proximo != null)
            no.proximo.anterior = no.anterior;

        if (no.anterior != null)
            no.anterior.proximo = no.proximo;

        size--;
    }

    public No<T> getPrimeiro() {
        return head;
    }

    public No<T> get(Integer index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Passou do limite!");
        } else {
            No<T> aux = head;
            for (int i = 0; i < index; i++) {
                aux = aux.proximo;
            }
            return aux;
        }
    }

    public Integer size() {
        return this.size;
    }


    public static void pesquisar(DuplamenteEncadeada<Map<Integer, String>> lista, String curso) {
        int qtd = 0;
        boolean duplicada;

        for (int i = 0; i < lista.size(); i++) {
            Map<Integer, String> entry = lista.get(i).getDado();

            for (Integer key : entry.keySet()) {
                String value = entry.get(key);

                if (value.equals(curso)) {
                    duplicada = false;

                    for (int j = i + 1; j < lista.size(); j++) {
                        Map<Integer, String> a = lista.get(j).getDado();
                        if (entry.entrySet().equals(a.entrySet())) {
                            duplicada = true;
                        }

                    }

                    if (!duplicada)
                        qtd++;

                }

            }

        }
    }

    public static void main(String[] args) {
        Preenchimento prencher = new Preenchimento();
        String curso = "Engenharia de Software";
        Integer matricula = 202050000;
 
        DuplamenteEncadeada<Map<Integer, String>> listaDuplamenteEncadeada = new DuplamenteEncadeada<>();

        Scanner in = new Scanner(System.in);

        int op;
        double startTime = System.nanoTime();
        double endTime = System.nanoTime();
        double timeElapsed = endTime - startTime;
        do {
            System.out.println("1. Cadastrar todos estudantes");
            System.out.println("2. Estudantes realizando o curso de ES");
            System.out.println("3. Remover estudantes com matricula igual ou inferior a 202060000");
            System.out.println("4. Sair");
            op = in.nextInt();

            switch (op) {
                case 1:
                    startTime = System.nanoTime();
                    // doSelectionSort(Nos);
                    listaDuplamenteEncadeada = prencher.getLDE();
                    endTime = System.nanoTime();
                    System.out.println(listaDuplamenteEncadeada.size());
                    timeElapsed = endTime - startTime;

                    System.out.println("==============================================");
                    System.out.println("Execution time in nanoseconds: " + timeElapsed);
                    System.out.println("Execution time in miliseconds: " + timeElapsed / 1000000);
                    System.out.println("==============================================");
                    break;

                case 2:
                    startTime = System.nanoTime();
                    Validar.pesquisar(listaDuplamenteEncadeada, curso);
                    endTime = System.nanoTime();
                    timeElapsed = endTime - startTime;
                    System.out.println("==============================================");
                    System.out.println("Execution time in nanoseconds: " + timeElapsed);
                    System.out.println("Execution time in miliseconds: " + timeElapsed / 1000000);
                    System.out.println("==============================================");
                    break;

                case 3:
                    startTime = System.nanoTime();
                    Validar.remover(listaDuplamenteEncadeada, matricula);
                    endTime = System.nanoTime();
                    timeElapsed = endTime - startTime;
                    System.out.println("==============================================");
                    System.out.println("Execution time in nanoseconds: " + timeElapsed);
                    System.out.println("Execution time in miliseconds: " + timeElapsed / 1000000);
                    System.out.println("==============================================");
                    break;// dianho no break
                case 4:
                    System.out.println("SAINDO...");
                    in.close();
            }

            System.out.println("Tempo de execução do sistema: "+timeElapsed);
        } while (op != 4);

    }

}