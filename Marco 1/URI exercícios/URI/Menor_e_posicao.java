/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uri;

import java.util.Scanner;

public class Menor_e_posicao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int posicao = 0, menorValor = 0;
        int[] X = new int[N];
        sc.nextLine();

        String[] vetor = sc.nextLine().split(" ");

        for (int i = 0; i < X.length; i++) {
            X[i] = Integer.parseInt(vetor[i]);

            if (i == 0) {
                menorValor = X[i];
                posicao = i;
            } else if (X[i] < menorValor) {
                menorValor = X[i];
                posicao = i;
            }
        }
        System.out.println("Menor valor: " + menorValor);
        System.out.println("Posicao: " + posicao);

    }
}
