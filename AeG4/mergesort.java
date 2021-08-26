import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class mergesort {
    public static void main(String[] args) {
        // sobe aqui
        Scanner in = new Scanner(System.in);
        int choose;
        do {
            System.out.println("[1] Vetor gerado manual");
            System.out.println("[2] Vetor gerado automatico");
            System.out.println("[3] Vetor 90% valores iguais");
            choose = in.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Escolha o tamanho do seu vetor");
                    int size = in.nextInt();
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

                        mergeSort(vetor.length, vetor);

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
                    System.out.println("O tamanho do seu vetor é de: " + size1 + "\n");
                    int[] vetor1 = new int[size1];
                    randomizaVetor(vetor1);
                    System.out.println("Vetor Inicial: ");
                    printaVetor(vetor1);

                    if (vetor1.length > 1) {

                        System.out.println("\n");
                        printaVetor(vetor1);

                         double startTime = System.nanoTime();
                         mergeSort(vetor1.length, vetor1);
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
                    System.out.println("O tamanho do seu vetor é de: " + size2 + "\n");
                    int[] vetor2 = new int[size2];

                    Random numRand = new Random();
                    int numeroRand = numRand.nextInt(size2 + 1);

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
                    mergeSort(vetor2.length, vetor2);
                    double endTime = System.nanoTime();

                    double timeElapsed = endTime - startTime;
                    System.out.println("\nVetor Final Ordenado:");

                    printaVetor(vetor2);
                    System.out.println("==============================================");
                    System.out.println("Execution time in nanoseconds: " + timeElapsed);
                    System.out.println("Execution time in miliseconds: " + timeElapsed / 1000000);
                    System.out.println("==============================================");

                    break;

                default:
                in.close();
            }
        } while (choose != 0);

    }
    
        public static void printaVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println("\n"); // n²-n 5² - 5 = 20
    }

    public static int[] randomizaVetor(int[] vetor1) {
        Random random = new Random();

        for (int i = 0; i < vetor1.length; i++) {
            boolean novoNumero = false;
            int numero = -1;
            while (!novoNumero) {
                numero = random.nextInt(vetor1.length + 1); // isso gera ate 49, se quiser gerar ate 10 coloque 11
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
    
    private static void mergeSort(int tamanho, int[] vetor) {
      
      int elementos = 1;
    
      int inicio, meio, fim;
      
      while(elementos < tamanho) {
        inicio = 0;
        
        
        while(inicio + elementos < tamanho) {
         
          meio = inicio + elementos;
         
          fim = inicio + 2 * elementos;
          
          
          if(fim > tamanho)
            fim = tamanho;
          
          
          intercala(vetor, inicio, meio, fim);
          
          inicio = fim;
        }
        
        elementos = elementos * 2;
      }
    }
    private static void intercala(int[] vetor, int inicio, int meio, int fim) {
        
        int novoVetor[] = new int[fim - inicio];
        
        int i = inicio;

        int m = meio;
        
        int pos = 0;
        
        
        while(i < meio && m < fim) {
          
          if(vetor[i] <= vetor[m]) {
            novoVetor[pos] = vetor[i];
            pos = pos + 1;
            i = i + 1;
         
          } else {
            novoVetor[pos] = vetor[m];
            pos = pos + 1;
            m = m + 1;
          }
        }
        
        
        while(i < meio) {
          novoVetor[pos] = vetor[i];
          pos = pos + 1;
          i = i + 1;
        }
        
        while(m < fim) {
          novoVetor[pos] = vetor[m];
          pos = pos + 1;
          m = m + 1;
        }
        
        for(pos = 0, i = inicio; i < fim; i++, pos++) {
          vetor[i] = novoVetor[pos];
        }
      }
    }