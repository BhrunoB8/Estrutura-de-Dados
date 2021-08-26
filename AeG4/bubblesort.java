

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * bubblesort
 */
public class bubblesort {

    public static boolean bubbleSorting(int[] vetor) {

        boolean head = true;

        do {
            head = false;
            for (int i = 0; i < vetor.length; i++) {
                int j = i;
                j++;
                if (j >= vetor.length) {
                } else {
                    if (vetor[i] > vetor[j]) {
                        swap(vetor, i, j);
                        head = true;
                    }
                }
            }
        } while (head == true);

        return true;
    }

    static int swap(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
        return j;
    }

    public static void printaVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println("\n"); 
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

    public static boolean verificarExistencia(int numero, int[] vetor1) {
        for (int i = 0; i < vetor1.length; i++) {
            if (numero == vetor1[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choose;
        do {
            System.out.println("[1] Vetor gerado manual");
            System.out.println("[2] Vetor gerado automatico");
            System.out.println("[3] Vetor 90% valores iguais");
            choose = in.nextInt();
            in.nextLine();
            switch (choose) {
                case 1:
                    System.out.println("Escolha o tamanho do seu vetor");
                    int size = in.nextInt();
                    in.nextLine();
                    System.out.println("\n");
                    System.out.println("O tamanho do seu vetor é de: " + size);
                    int[] vetor = new int[size];

                    for (int i = 0; i < vetor.length; i++) {
                        System.out.println("Digite o valor para a posição " + i);
                        vetor[i] = in.nextInt();
                    }
                    System.out.println("\n");
                    System.out.println("Vetor Inicial: ");
                    printaVetor(vetor);

                    if (vetor.length > 1) {

                        System.out.println("\n");
                        double startTime = System.nanoTime();

                        bubbleSorting(vetor);

                        double endTime = System.nanoTime();
                        double timeElapsed = endTime - startTime;
                        System.out.println("\nVetor Final Ordenado:");
                        printaVetor(vetor);
                        System.out.println("==============================================");
                        System.out.println("Execution time in nanoseconds: " + timeElapsed);
                        System.out.println("Execution time in miliseconds: " + timeElapsed / 1000000);
                        System.out.println("==============================================");
                    }
                    break;
                case 2:
                    System.out.println("Escolha o tamanho do seu vetor");
                    int size1 = in.nextInt();
                    in.nextLine();
                    System.out.println("O tamanho do seu vetor é de: " + size1 + "\n");
                    int[] vetor1 = new int[size1];
                    randomizaVetor(vetor1); //RANDOMIZA O VETOR COM SIZE INDICADO
                    System.out.println("Vetor Inicial: ");
                    printaVetor(vetor1);

                    if (vetor1.length > 1) {

                        System.out.println("\n");
                        double startTime = System.nanoTime();

                        bubbleSorting(vetor1); //CHAMA NO BUBBLE BB

                        double endTime = System.nanoTime();
                        double timeElapsed = endTime - startTime;
                        System.out.println("\nVetor Final Ordenado:");
                        
                        printaVetor(vetor1);
                        System.out.println("==============================================");
                        System.out.println("Execution time in nanoseconds: " + timeElapsed);
                        System.out.println("Execution time in miliseconds: " + timeElapsed / 1000000);
                        System.out.println("==============================================");
                    }

                    break;

                case 3:
                    System.out.println("Escolha o tamanho do seu vetor");
                    int size2 = in.nextInt();
                    in.nextLine();
                    if (size2 > 1) {

                        System.out.println("O tamanho do seu vetor é de: " + size2 + "\n");
                        int[] vetor2 = new int[size2];

                        Random numRand = new Random();
                        int numeroRand = numRand.nextInt(size2);

                        int perCent = (int) Math.ceil(size2 * 0.1); //AQUI ARREDONDA O VALOR DE 10% PRA CIMA.
                        int[] vetor3 = new int[perCent]; //CRIA UM VETOR BASE COM O 10% ALEATÓRIUO

                        for (int i = 0; i < vetor3.length; i++) {
                            boolean novoNumero = false;

                            int numero = -1;
                            while (!novoNumero) {
                                numero = numRand.nextInt(vetor2.length); //AQUI PREENCHE O VETOR BASE COM VALORES ALEATÓRIOS
                                                                        // DIFERENTES UM DOS OUTROS E TAMBÉM DIFERENTE DO RANDOMICO BREVEMENTE ESCOLHIDO

                                if (numero != numeroRand) {
                                    novoNumero = verificarExistencia(numero, vetor3);
                                } else {
                                }
                            }
                            vetor3[i] = numero;
                        }

                        for (int i = 0; i < vetor3.length; i++) {
                            vetor2[numRand.nextInt(vetor2.length)] = vetor3[i];
                        }

                        int[] vetor5 = new int[1];

                        for (int i = 0; i < vetor2.length; i++) {
                            if (vetor2[i] == vetor5[0]) {
                                vetor2[i] = numeroRand;
                            }
                        }

                        System.out.println("Vetor Inicial: ");
                        printaVetor(vetor2);

                        double startTime = System.nanoTime();

                        bubbleSorting(vetor2); //CHAMA NO BUBBLE BB

                        double endTime = System.nanoTime();
                        double timeElapsed = endTime - startTime;
                        System.out.println("\nVetor Final Ordenado:");
                        
                        printaVetor(vetor2);
                        System.out.println("==============================================");
                        System.out.println("Execution time in nanoseconds: " + timeElapsed);
                        System.out.println("Execution time in miliseconds: " + timeElapsed / 1000000);
                        System.out.println("==============================================");
                    } else {
                        System.out.println("Digite um vetor maior que 1...");
                    }
                    break;

                default:
            }
        } while (choose != 0);

    }
}