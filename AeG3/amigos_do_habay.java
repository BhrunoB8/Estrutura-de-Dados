/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AeG3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class amigos_do_habay {
    public static void main(String args[]){
        Scanner entrada = new Scanner(System.in);
        String nome = "";
        String nome1;
        String resposta = "";
        int maiorV = 0;
        String nomeAmigo = "";
        String nomeC = "";
        
        
        
        
        ArrayList<String>nomesY = new ArrayList<>();
        ArrayList<String>nomesN = new ArrayList<>();
        
        
        
        do{
            int cont = 0;
            nome = entrada.nextLine();
        
            if(nome.equalsIgnoreCase("FIM")){
                break;
            }
            
            String info[] = nome.split(" ");
            nome1 = info[0];
            resposta = info[1];

            if(resposta.equalsIgnoreCase("YES")){ 
                for(String nY : nomesY){
                    if(nome1.equalsIgnoreCase(nY)){
                        cont++;
                    }
                }
                
                if(cont == 0){
                   nomesY.add(nome1); 
                }
            }else if(resposta.equalsIgnoreCase("NO")){
                for(String nN : nomesN){
                    if(nome1.equalsIgnoreCase(nN)){
                        cont++;
                    }
                }
                
                if(cont == 0){
                   nomesN.add(nome1); 
                }
                
            }
           
        }while(!nome.equalsIgnoreCase("FIM"));
        
        for(String nm : nomesY){
            if(nm.length() > maiorV){
                maiorV = nm.length();
                nomeAmigo = nm;
            }
            
        }
        //calcular o tamanho de cada no para ver se é o maior e se o amigo é 1 ou 0

        Collections.sort(nomesY);
        for(String nm : nomesY){
            System.out.println(nm);
        }
        Collections.sort(nomesN);
        for(String nm : nomesN){
            System.out.println(nm);
        }
       System.out.print("\n"); 
       System.out.println("Amigo do Habay:\n"+ nomeAmigo);
             
    }
}
