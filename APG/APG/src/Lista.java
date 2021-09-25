import java.util.Scanner;


public class Lista {

    private NoEncadeado primeiro = null;
    private NoEncadeado ultimo = null;
    private int quantidade = 0;
    private int count;

    public void inserirNoInicio(Estudante elemento) {
        NoEncadeado novoNo = new NoEncadeado();
        novoNo.setElemento(elemento);
        novoNo.setProximo(primeiro);

        primeiro = novoNo;

        if (quantidade == 0) {
            ultimo = primeiro;
        }
        quantidade++;
    }

    public void novosEstudantes(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            Estudante elemento = new Estudante();
            inserirNoInicio(elemento);
        }
    }

    public void inserirNoFinal(Estudante elemento) {
        if (quantidade == 0) {
            inserirNoInicio(elemento);
        } else {
            NoEncadeado novoNo = new NoEncadeado();
            novoNo.setElemento(elemento);
            novoNo.setProximo(null);
            ultimo.setProximo(novoNo);
            ultimo = novoNo;
            quantidade++;
        }
    }

    public void inserirNaPosicao(int posicao, Estudante elemento) {
        if (quantidade == 0) {
            inserirNoInicio(elemento);
        } else if (posicao == quantidade) {
            inserirNoFinal(elemento);// tem que retornar o elemento pra funcionar
        } else {
            NoEncadeado noNaPosicao = buscarNoNaPosicao(posicao);
            noNaPosicao.setElemento(elemento);
        }
    }

    public void removerNoInicio() {
        if (quantidade == 0) {
            return;
        }

        primeiro = primeiro.getProximo();
        quantidade--;

        if (quantidade == 0) {
            ultimo = null;
        }
    }

    public int acharPosicao() { //encontra a posicao do No e o remove
        int contador=0;
        for (int i=0; i < quantidade ; i++) {
            NoEncadeado atual = buscarMatricula();
            for (int j = 1; j < quantidade; j++) {
                if (atual.equals(buscarNoNaPosicao(j))) {
                    removerNaPosicao(j);
                    contador++;
                    System.out.println("Numero de removidos: "+ contador);                         
                }
            }
        }
        return 0;
    }

    public void removerNoFinal() {
        if (quantidade == 0) {
            return;
        }

        if (quantidade == 1) {
            removerNoInicio();
            return;
        }

        NoEncadeado noNaPosicaoAnterior = buscarNoNaPosicao(quantidade - 2);
        noNaPosicaoAnterior.setProximo(null);

        ultimo = noNaPosicaoAnterior;
        quantidade--;
    }


    public void removerNaPosicao(int posicao) {
        if (quantidade == 0) {
            removerNoInicio();
        } else if(posicao == quantidade) {
            removerNoFinal();
        } else {
            NoEncadeado noNaPosicaoAnterior = buscarNoNaPosicao(posicao - 1);
            NoEncadeado noNaPosicaoAtual = noNaPosicaoAnterior.getProximo();

            if(noNaPosicaoAtual.getProximo() != null) {
                noNaPosicaoAnterior.setProximo(noNaPosicaoAtual.getProximo());
            } else {
                noNaPosicaoAnterior.setProximo(null);
                ultimo = noNaPosicaoAnterior;
            }

            quantidade--;
        }
    }



    public NoEncadeado buscarMatricula() {
        if (!existeElementoNaPosicao(1)) {
            throw new RuntimeException("Está vazio");
        }
        NoEncadeado atual = primeiro;
        for (int i = 0; i < quantidade; i++) {
            if (atual.getElemento().getMatricula() < 202060000) {
                return atual;       
            }
            atual = atual.getProximo();
        }
        return atual;
    }

    public NoEncadeado buscarCurso() {
        if (!existeElementoNaPosicao(1)) {
            throw new RuntimeException("Está vazio");
        }
        NoEncadeado atual = primeiro;
        for (int i = 0; i < quantidade; i++) {
            if (atual.getElemento().getCurso() == "Engenharia de Software") {
                System.out.println(atual.getElemento().toString()); 
                count++;  
            }
            atual = atual.getProximo();
        }
        return atual;
    }

    public NoEncadeado buscarNoNaPosicao(int posicao) {
        if(!existeElementoNaPosicao(posicao)) {
            throw new RuntimeException("Posição não existente");
        }

        NoEncadeado atual = primeiro;

        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    public Estudante retonarElementoPorPosicao(int posicao) {
        return buscarNoNaPosicao(posicao).getElemento();
    }

    public int retornarQuantidadeDeElementos() {
        return quantidade;
    }

    public int retornarQuantidadeTotal() {
        return count;
    }

    private boolean existeElementoNaPosicao(int posicao) {
        return posicao >= 0 && posicao < quantidade;
    }

    public void imprimir() {
        if (quantidade == 0) {
            System.out.println("[VAZIO]");
            return;
        }

        String elementos = retornarElementos();
        System.out.println(elementos);
    }

    String retornarElementos() {
        StringBuilder elementos = new StringBuilder("");

        NoEncadeado atual = primeiro;

        while (atual.getProximo() != null) {
            elementos.append(atual.getElemento());
            elementos.append(" \n");
            atual = atual.getProximo();
        }

        elementos.append(atual.getElemento());

        elementos.append("");

        return elementos.toString();
    }

    public NoEncadeado getPrimeiro() {
        return primeiro;
    }

    public NoEncadeado getUltimo() {
        return ultimo;
    }

    public static void main(String[] args) {
        Lista l = new Lista();
        double startTime = System.nanoTime();
        l.novosEstudantes(100);
        double endTime = System.nanoTime();
        double timeElapsed = endTime - startTime;
        l.imprimir();
        System.out.println("");
        System.out.println("==============================================");
        System.out.print("Tempo de criação da lista: " + timeElapsed / 1000000 + "ms");
        System.out.println("==============================================");
        Scanner in = new Scanner(System.in);
        int op;
        do {
            System.out.println(""); 
            System.out.println("1. Apresentar todos estudantes");
            System.out.println("2. Estudantes realizando o curso de ES");
            System.out.println("3. Remover estudantes com matricula igual ou inferior a 202060000");
            System.out.println("4. Sair");
            op = in.nextInt();

            switch (op) {
                case 1:
                    startTime = System.nanoTime();
                    l.imprimir();
                    endTime = System.nanoTime();
                    timeElapsed = endTime - startTime;
                    System.out.println("==============================================");
                    System.out.println("Execution time in nanoseconds: " + timeElapsed);
                    System.out.println("Execution time in miliseconds: " + timeElapsed / 1000000);
                    System.out.println("==============================================");
                    break;
                    
                    case 2:
                    startTime = System.nanoTime();
                    l.buscarCurso();
                    System.out.println("Total de alunos que cursam ES: "+ l.count);
                    endTime = System.nanoTime();
                    timeElapsed = endTime - startTime;
                    System.out.println("==============================================");
                    System.out.println("Execution time in nanoseconds: " + timeElapsed);
                    System.out.println("Execution time in miliseconds: " + timeElapsed / 1000000);
                    System.out.println("==============================================");
                    break;

                case 3:
                    startTime = System.nanoTime();
                    l.acharPosicao();
                    endTime = System.nanoTime();
                    l.imprimir();
                    timeElapsed = endTime - startTime;
                    System.out.println("==============================================");
                    System.out.println("Execution time in nanoseconds: " + timeElapsed);
                    System.out.println("Execution time in miliseconds: " + timeElapsed / 1000000);
                    System.out.println("==============================================");
                    break;//dianho no break
                case 4:
                    System.out.println("SAINDO...");
                    in.close();
            }
            

            System.out.println(timeElapsed);
        } while (op != 4);
    }
}