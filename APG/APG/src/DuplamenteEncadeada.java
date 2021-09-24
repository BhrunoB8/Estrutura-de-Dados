
// import java.util.Scanner;

public class DuplamenteEncadeada {

    private No head;
    private No tail;
    private int tamanho;
    private int quantidade;
    private No[] nos;

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

    public No inserirhead(Estudante info) {
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
        if (tamanho == 1) {
            return no;
        }
        return null;
    }

    // public void inserirInicio(No no) {
    // if (isVazio()) {
    // head = no;
    // tail = no;
    // } else {
    // no.setProximo(this.head);
    // head.setProximo(no);
    // this.head = no;
    // }
    // quantidade++;
    // }

    // public void inserir(No no, int posicao) {
    // if (isVazio() || posicao <= 1) {
    // inserirInicio(no);
    // // } else if (posicao > quantidade) {
    // // inserirhead(no)
    // } else {
    // No aux = this.head;
    // for (int i = 1; i < posicao; i++) {
    // aux = aux.getProximo();
    // }
    // no.setProximo(aux);
    // no.setAnterior(aux.getAnterior());
    // no.getAnterior().setProximo(no);
    // aux.setAnterior(no);
    // }
    // this.quantidade++;
    // }

    public No[] inserirEstudantes() {

        int q = 10;
        nos = new No[q];
        for (int i = 0; i < q; i++) {
            No n = new No();
            Estudante es = new Estudante();
            n.setEstudante(es);
            nos[i] = n;
            inserirhead(es);
            System.out.println(n.estudante.toString());
            quantidade++;
            // if(i==quantidade-1){
            // System.out.println(nos[i].estudante.toString());
            // return nos;
            // }else{
            // System.out.println("");
            // }
            //
        }
        return nos;
    }

    public Estudante retirarInicio() {
        if (head == null) {
            return null;
        }
        Estudante out = head.estudante;
        head = head.proximo;
        if (head != null) {
            head.anterior = null;
        } else {
            tail = null;
        }
        tamanho--;
        return out;
    }

    public No removerEstudante() {
        int count = 1;
        No aux = nos[count-1];
        if (!isVazio() && count >= 1 && count <= quantidade) {
            count++;
            if (count == 1) {
                head = aux.getProximo();
                if (head != null) {

                    head.setAnterior(null);
                } else if (count == quantidade) {

                    aux = tail;
                    tail = tail.getAnterior();
                    tail.setProximo(null);
                }
            } else {
                for (int i = 1; i < count; i++) {
                    aux = aux.getProximo();
                }
                aux.getAnterior().setProximo(aux.getProximo());
                aux.getProximo().setAnterior(aux.getAnterior());
            }
            if (aux.estudante.getMatricula() < 202060000) {

                aux.setAnterior(null);
                aux.setProximo(null);
                quantidade--;
            }
        } else {

        }
        return aux;
    }

    public No remover(int posicao) {
        No aux = head;
        if (!isVazio() && posicao >= 1 && posicao <= quantidade) {
            if (posicao == 1) {
                head = aux.getProximo();
                if (head != null) {

                    head.setAnterior(null);
                } else if (posicao == quantidade) {

                    aux = tail;
                    tail = tail.getAnterior();
                    tail.setProximo(null);
                }
            } else {
                for (int i = 1; i < posicao; i++) {
                    aux = aux.getProximo();
                }
                aux.getAnterior().setProximo(aux.getProximo());
                aux.getProximo().setAnterior(aux.getAnterior());
            }
            aux.setProximo(null);
            aux.setAnterior(null);
            quantidade--;
        }
        return aux;
    }

    public static void main(String[] args) {
        DuplamenteEncadeada l = new DuplamenteEncadeada();
        // No n = new No();
        double startTime = System.nanoTime();
        l.inserirEstudantes();
        double endTime = System.nanoTime();
        double timeElapsed = endTime - startTime;
        System.out.print("Tempo de criação do vetor: " + timeElapsed / 1000000 + "ms");
        System.out.println("--------------------");
        System.out.println("--------------------");
        System.out.println("--------------------");
        l.removerEstudante();
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