/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AeG3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class fila {
    
    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        
        int qFila,saiu,sF = 0;
        String pessoas;
        String qmSaiu;
        //Quantas pessoas estão na fila
        qFila = in.nextInt();
        in.nextLine();
        
        String people[] = new String[qFila];
        ArrayList<Integer> fila = new ArrayList<>();
        ArrayList<Integer> saiuFila = new ArrayList<>();
        
        //Qual o número das pessoas
        pessoas = in.nextLine();
        people = pessoas.split(" ");
        for(int i = 0; i<qFila; i++){
            fila.add(Integer.parseInt(people[i]));
        }
        
        //Quantas sairam
        saiu = in.nextInt();
        in.nextLine();
        String saiuP[] = new String[saiu];
        
        //Quais os números que sairam
        qmSaiu = in.nextLine();
        saiuP = qmSaiu.split(" ");
        for(int i = 0; i<saiu; i++){
            saiuFila.add(Integer.parseInt(saiuP[i]));
        }
        
        for(Integer s : saiuFila){
            fila.remove(s);
        }
        
        for(int c = 0; c<fila.size(); c++){
            System.out.print(fila.get(c));
            int i = c;
            i++;
            if(i == fila.size()){
                System.out.println();
            }else{
                System.out.print(" ");
            }
        }
    }
}
