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
//Versão antiga
public class jogando_cartas_foras {
    public static void main (String args[]){
        
        Scanner entrada = new Scanner(System.in);
        
        int N;
        Stack pilha = new Stack();
        ArrayList<Integer>discartada = new ArrayList<>();
        List<Integer>montarN = new ArrayList<>();
        int firstE;
       do{ 
        N = entrada.nextInt();
        if(N == 0){
            break;
        }
        entrada.nextLine();

        for(int i = N; i>=1; i--){
            pilha.push(i);
        }
        do{ 
        discartada.add((Integer) pilha.peek());
        pilha.pop();

        firstE = (int) pilha.peek();
        
        for(int y = pilha.size(); y>=1; y--){
            montarN.add((Integer) pilha.peek());
            pilha.pop();
            
        }
        montarN.remove(0);
        pilha.clear();
        for(Integer mn : montarN){
            pilha.add(mn);
        }
        
        montarN.clear();
        for(int t = pilha.size(); t>=1; t--){
            montarN.add((Integer) pilha.peek());
            pilha.pop();
        }
        pilha = new Stack();
        pilha.add(firstE);
        for(Integer mn : montarN){
            pilha.add(mn);
        }
        montarN.clear();
        }while(pilha.size() != 1);
        
        System.out.println("Discarded cards: "+ discartada);

        System.out.println("Remaining card: " + pilha.peek());
        
        pilha.clear();
        
        montarN.clear();
        discartada.clear();
        
       }while(N != 0); 
  
    }
}
