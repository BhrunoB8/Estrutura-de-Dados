
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


class QuickSort {

    private static Scanner entrada;

    public static void main(String args[]) {
        int op;
        entrada = new Scanner(System.in);
        do {
            System.out.println("Digite a opção desejada: ");
            System.out.println("1. Vetor gerado automaticamente.");
            System.out.println("2. Vetor gerado manualmente.");
            System.out.println("3. Vetor com 90% das posições preenchidas com o mesmo valor.");
            System.out.println("Digite 0 para sair.");
            op = entrada.nextInt();
            entrada.nextLine();

            switch (op) {
                case 0:
                    System.out.println("Saindo do programa... ");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Entre com o tamanho do vetor: ");
                    int tamanho = entrada.nextInt();
                    // entrada.nextLine();
                    
                    int vetor[] = new int[tamanho];
                   
                   randomizaVetor(vetor);

                    System.out.println("Vetor não ordenado: ");
                    printaVetor(vetor);

                    double startTime = System.nanoTime();
                    sort(vetor, 0, vetor.length - 1);
                    double endTime = System.nanoTime();
                    double timeElapsed = endTime - startTime;

                    System.out.println("Vetor ordenado: ");
                    printaVetor(vetor);
                    
                    System.out.println("Execution time in miliseconds: " + timeElapsed / 1000000);
                    break;
                case 2:
                    System.out.println("Digite o tamanho do vetor: ");
                    tamanho = entrada.nextInt();
                    entrada.nextLine();
                    int arrayManual[] = new int[tamanho];
                    
                    for (int i = 0; i < arrayManual.length; i++) {
                        System.out.println("Digite o valor desejado para a posição " + i + ": ");
                        arrayManual[i] = entrada.nextInt();
                        entrada.nextLine();
                    }
                    System.out.println("Vetor antigo:");
                    printaVetor(arrayManual);
                    
                    double tempoInicial = System.currentTimeMillis();
                    sort(arrayManual, 0, arrayManual.length - 1);
                    double tempoFinal = System.currentTimeMillis() - tempoInicial;

                    System.out.println("Vetor ordenado:");
                    printaVetor(arrayManual);
                    System.out.println("O tempo de execução é de: " + tempoFinal + "ms");

                    break;
                case 3:
                    System.out.println("Digite o tamanho do vetor: ");
                    tamanho = entrada.nextInt();
                    int array90[] = new int[tamanho];
                    if (tamanho > 1) {

                        Random numRand = new Random();
                        int numeroRand = numRand.nextInt(tamanho);  

                        int perCent = (int) Math.ceil(tamanho * 0.1);
                        int[] vetor3 = new int[perCent];

                        for (int i = 0; i < vetor3.length; i++) {
                            boolean novoNumero = false;

                            int numero = -1;

                            while (!novoNumero) {
                                numero = numRand.nextInt(array90.length);
                                if (numero != numeroRand) {
                                    novoNumero = verificarExistencia(numero, vetor3);
                                }
                            }
                            vetor3[i] = numero;
                        }
                        for (int i = 0; i < vetor3.length; i++) {
                            array90[numRand.nextInt(array90.length)] = vetor3[i];
                        }

                        int[] vetor5 = new int[1];

                        for (int i = 0; i < array90.length; i++) {
                            if (array90[i] == vetor5[0]) {
                                array90[i] = numeroRand;
                            }
                        }
                        System.out.println("Vetor Inicial: ");
                        printaVetor(array90);


                        startTime = System.nanoTime();
                        sort(array90, 0, array90.length - 1);
                        endTime = System.nanoTime();
                        timeElapsed = endTime - startTime;

                        System.out.println("\nVetor Final Ordenado:");

                        printaVetor(array90);

                        System.out.println("==============================================");
                        System.out.println("Execution time in nanoseconds: " + timeElapsed);
                        System.out.println("Execution time in miliseconds: " + timeElapsed / 1000000);
                        System.out.println("==============================================");
                        

                    } else {
                        System.out.println("O tamanho do vetor deve ser maior que 1.");
                    }
                    break;

            }
        } while (op != 0);

    }
    public static int[] randomizaVetor(int[] vetor1) {
        Random random = new Random();

        for (int i = 0; i < vetor1.length; i++) {
            boolean novoNumero = false;
            int numero = -1;
            while (!novoNumero) {
                numero = random.nextInt(vetor1.length + 1); 
                novoNumero = verificarExistencia(numero, vetor1);
            }
            vetor1[i] = numero;
        }
        return vetor1;
    }

    static void sort(int vetor[], int inicio, int fim) {
        if (inicio < fim) {
            int indice = partition(vetor, inicio, fim);
            sort(vetor, inicio, indice - 1);
            sort(vetor, indice + 1, fim);
        }
    }

    static int partition(int vetor[], int inicio, int fim) {
        int pivo = vetor[fim];
        int indice = inicio;
        for (int i = inicio; i < fim; i++) {
            if (vetor[i] <= pivo) {
                troca(vetor, i, indice);
                indice++;
            }
        }
        troca(vetor, indice, fim);
        return indice;
    }

    static void troca(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void printaVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println("\n");
    }

    public static boolean verificarExistencia(int numero, int[] vetor1) {
        for (int i = 0; i < vetor1.length; i++) {
            if (numero == vetor1[i]) {
                return false;
            }
        }
        return true;
    }
}
