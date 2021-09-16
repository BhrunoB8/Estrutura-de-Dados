import java.util.Random;
import java.util.Scanner;

public class Vetor {
    private Estudante estudante;

    public static void printaVetor(Estudante[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != null) {
                System.out.print(vetor[i] + " \n");
            }
        }
        System.out.println("\n");
    }

    public Estudante[] inserirEstudante(Estudante array[]) {
        for (int i = 0; i < array.length; i++) {
            estudante = new Estudante();
            array[i] = estudante;
        }

        return array;
    }

    public Estudante[] removeEstudantes(Estudante array[]) {
        int indexATT = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].getMatricula() < 202060000) {
                array[i] = null;
            }
        }

        return array;
    }

    private static void mergeSort(int tamanho, Estudante[] vetor) {

        int elementos = 1;

        int inicio, meio, fim;

        while (elementos < tamanho) {
            inicio = 0;

            while (inicio + elementos < tamanho) {

                meio = inicio + elementos;

                fim = inicio + 2 * elementos;

                if (fim > tamanho)
                    fim = tamanho;

                intercala(vetor, inicio, meio, fim);

                inicio = fim;
            }

            elementos = elementos * 2;
        }
    }

    private static void intercala(Estudante[] vetor, int inicio, int meio, int fim) {

        Estudante novoVetor[] = new Estudante[fim - inicio];

        int i = inicio;

        int m = meio;

        int pos = 0;

        while (i < meio && m < fim) {

            if (vetor[i].getMatricula() <= vetor[m].getMatricula()) {
                novoVetor[pos] = vetor[i];
                pos = pos + 1;
                i = i + 1;

            } else {
                novoVetor[pos] = vetor[m];
                pos = pos + 1;
                m = m + 1;
            }
        }

        while (i < meio) {
            novoVetor[pos] = vetor[i];
            pos = pos + 1;
            i = i + 1;
        }

        while (m < fim) {
            novoVetor[pos] = vetor[m];
            pos = pos + 1;
            m = m + 1;
        }

        for (pos = 0, i = inicio; i < fim; i++, pos++) {
            vetor[i] = novoVetor[pos];
        }
    }

    public int verificaCurso(Estudante array[]) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {

                if (array[i].isCursoES()) {
                    count++;
                }

            }
        }
        return count;
    }

    public static void main(String[] args) {
        Vetor v = new Vetor();
        Estudante[] array = new Estudante[100000];
        //v.inserirEstudante(array);

    // V de Gustavo
    // V de Vitória
       // v.mergeSort(array.length, array);
       // printaVetor(array);
          
          
       // System.out.println("Número de alunos que cursam ES: " + v.verificaCurso(array));

        Scanner in = new Scanner(System.in);

        int op;
        do{
            System.out.println("1. Inserir 100000 estudantes");
            System.out.println("2. Apresentar todos estudantes em ordem crescente de matrícula");
            System.out.println("3. Estudantes realizando o curso de ES");
            System.out.println("4. Remover estudantes com matricula igual ou inferior a 202060000");
            System.out.println("5. Sair");
            op = in.nextInt();

            switch(op){
                case 1: 
                v.inserirEstudante(array);
                printaVetor(array);
                break;

                case 2:
                v.inserirEstudante(array);
                v.mergeSort(array.length, array);
                printaVetor(array);
                break;

                case 3:
                v.inserirEstudante(array);
                System.out.println("Número de alunos que cursam ES: " + v.verificaCurso(array));
                break;

                case 4:
                if(array == null){}
                v.inserirEstudante(array);
                v.removeEstudantes(array);
                printaVetor(array);

            }
        }while(op != 0);

    }
}
