import java.util.Scanner;

public class DuplamenteEncadeada {

    private No head = null;
    private No tail = null;
    private int tamanho;

    public boolean isVazio() {
        if (head == null && tail == null)
            return true;
        else
            return false;
    }

    public void adicionarhead(No novo) {

        if (isVazio()) {
            head = novo;
            tail = novo;
        } else {
            novo.proximo = head;
            head = novo;
            novo.proximo.anterior = head;
        }
    }

    public void adicionarFinal(No novo) {

        if (isVazio()) {
            head = novo;
            tail = novo;
        } else {
            novo.anterior = tail;
            tail = novo;
            novo.anterior.proximo = tail;
        }
    }

    public void imprimir() {
        No aux = head;

        while (aux != null) {
            System.out.println("No: " + aux.getEstudante().toString());
            if (aux.anterior != null)
                System.out.println("Anterior: " + aux.anterior.getEstudante().toString());
            if (aux.proximo != null)
                System.out.println("Posterior: " + aux.proximo.getEstudante().toString());
            System.out.println("------------------------------------");
            aux = aux.proximo;
        }

    }

    public void inserirheadThiago(Estudante info) {
        No no = new No();
        no.estudante = info;
        no.anterior = null;
        no.proximo = head;

        // **INSERÇÕES */
        // Insere no head da Lista
        if (head != null) {
            head.anterior = no;

        }
        head = no;
        if (tamanho == 0) {
            tail = head;
        }
        tamanho++;

    }

    public void inserirEstudantes() {
        for (int i = 0; i < 100000; i++) {
            Estudante es = new Estudante();
            inserirheadThiago(es);
            System.out.println(es.toString());
        }
    }

    public Estudante retirarInicio() {
        if (head == null) {
            return null;
        }
        Estudante out = head.estudante;
        head = head.proximo;
        if (head != null) {
            head.anterior = null;
        }else{
            tail = null;
        }
        tamanho--;
        return out;
    }

    public static void main(String[] args) {
        DuplamenteEncadeada l = new DuplamenteEncadeada();
        // No n = new No();
        l.inserirEstudantes();
        // for(int i=0; i<10; i++){
        // Estudante e = new Estudante();
        // n.setEstudante(e);
        // l.adicionarhead(n);
        // }
        // l.imprimir();
        // Estudante[] array = new Estudante[100000];

        // Scanner in = new Scanner(System.in);

        // int op;
        // double startTime = System.nanoTime();
        // v.inserirEstudante(array);
        // double endTime = System.nanoTime();
        // double timeElapsed = endTime - startTime;
        // System.out.print("Tempo de criação do vetor: " + timeElapsed / 1000000 + "ms
        // \n");
        // do {
        // System.out.println("1. Apresentar todos estudantes em ordem crescente de
        // matrícula");
        // System.out.println("2. Estudantes realizando o curso de ES");
        // System.out.println("3. Remover estudantes com matricula igual ou inferior a
        // 202060000");
        // System.out.println("4. Sair");
        // op = in.nextInt();

        // switch (op) {
        // case 1:
        // startTime = System.nanoTime();
        // mergeSort(array.length, array);
        // endTime = System.nanoTime();
        // timeElapsed = endTime - startTime;

        // imprimir();
        // System.out.println("==============================================");
        // System.out.println("Execution time in nanoseconds: " + timeElapsed);
        // System.out.println("Execution time in miliseconds: " + timeElapsed /
        // 1000000);
        // System.out.println("==============================================");
        // break;

        // case 2:
        // startTime = System.nanoTime();

        // System.out.println("Número de alunos que cursam ES: " +
        // v.verificaCurso(array));
        // endTime = System.nanoTime();
        // timeElapsed = endTime - startTime;
        // System.out.println("==============================================");
        // System.out.println("Execution time in nanoseconds: " + timeElapsed);
        // System.out.println("Execution time in miliseconds: " + timeElapsed /
        // 1000000);
        // System.out.println("==============================================");
        // break;

        // case 3:
        // startTime = System.nanoTime();
        // v.removeEstudantes(array);
        // endTime = System.nanoTime();
        // printaVetor(array);
        // timeElapsed = endTime - startTime;
        // System.out.println("==============================================");
        // System.out.println("Execution time in nanoseconds: " + timeElapsed);
        // System.out.println("Execution time in miliseconds: " + timeElapsed /
        // 1000000);
        // System.out.println("==============================================");
        // break;// dianho no break
        // case 4:
        // System.out.println("SAINDO...");
        // in.close();
        // }

        // System.out.println(timeElapsed);
        // } while (op != 4);

    }

}