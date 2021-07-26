/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AeG3;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class voleibol {
 
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        int N;
        String nome;
        N = entrada.nextInt();
        entrada.nextLine();
        
        float tentativas[] = new float[3];
        float acertos[] = new float[3];
        
        String tentativasA[] = new String[3];
        String acertosA[] = new String[3];
        
        if(1 <= N || N <=100){
            for(int i =0; i < N; i++){
                nome = entrada.nextLine();
                String arz1 = entrada.nextLine();
                tentativasA = arz1.split(" ");
                tentativas[0] += Float.parseFloat(tentativasA[0]);
                tentativas[1] += Float.parseFloat(tentativasA[1]);
                tentativas[2] += Float.parseFloat(tentativasA[2]);
                String arz2 = entrada.nextLine();
                acertosA = arz2.split(" ");
                acertos[0] += Float.parseFloat(acertosA[0]);
                acertos[1] += Float.parseFloat(acertosA[1]);       
                acertos[2] += Float.parseFloat(acertosA[2]);
            }
            
            double resultado1 = ((acertos[0]* 100) / tentativas[0]);
            double resultado2 = ((acertos[1]* 100) / tentativas[1]);
            double resultado3 = ((acertos[2]* 100) / tentativas[2]);
            
            System.out.printf("Pontos de Saque: %.2f %%.\n", resultado1);
            System.out.printf("Pontos de Bloqueio: %.2f %%.\n",resultado2);
            System.out.printf("Pontos de Ataque: %.2f %%.\n",resultado3);
            
            
        }
    }
}
 
    
