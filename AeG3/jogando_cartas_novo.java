/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AeG3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Usuario
 */
public class jogando_cartas_novo {

    public static void main(String args[]) {

        Scanner entrada = new Scanner(System.in);
        ArrayList<Integer> ce = new ArrayList<>();
        Stack<Integer> discarded = new Stack<>();
        Stack<Integer> pilha = new Stack<>();
        int firstE;
        int N;

        do {
            N = entrada.nextInt();
            if (N != 0) {
                ce.add(N);
            }
        } while (N != 0);

        for (Integer num : ce) {
            for (int i = num; i > 0; i--) {
                pilha.push(i);
            }

            while (pilha.size() > 1) {
                firstE = pilha.peek();
                discarded.add(firstE);
                pilha.pop();
                firstE = pilha.peek();
                pilha.add(0,firstE);
                pilha.pop();
            }
            System.out.print("Discarded cards: ");
            for(int i = 0; i < discarded.size();i++){
                System.out.print(discarded.get(i));
                int d = i;
                d++;
                if(d == discarded.size()){
                    System.out.println();
                }else{
                    System.out.print(", ");
                }
                
            }
            System.out.print("Remaining card: ");
            for(int i = 0; i < pilha.size();i++){
                System.out.print(pilha.get(i));
                int d = i;
                d++;
                if(d == pilha.size()){
                    System.out.println();
                }else{
                    System.out.print(", ");
                }
                
            }
            pilha.clear();
            discarded.clear();
        }
        entrada.close();
    }
}
