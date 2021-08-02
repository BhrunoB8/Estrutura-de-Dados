/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AeG3;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Usuario
 */
public class trilhos {
    
public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int numSave, n ,vagao, nm;
        String vagoes, numV;
        nm = 0;
            do{
                numV = in.nextLine();
                numSave = Integer.parseInt(numV);
                if(numV.equals("0")){
                    //System.out.println("Aqui 2");
                    break;
                }
                
                
                if(nm == 0){
                    nm++;
                }else{
                    System.out.println();
                }
    
            do{
                vagoes = in.nextLine();
                
                String v[] = new String[numSave];
                Stack<Integer> pilhaV = new Stack<>();
                
                if(vagoes.equals("0")){
                    //System.out.println("Aqui 1");
                    break;
                }
                
                v = vagoes.split(" ");
                
                n =0;
                vagao = Integer.parseInt(v[n]);
                
                for (int i = 1; i <= numSave; i++) {
                    pilhaV.push(i);
                
                
                while(!pilhaV.empty() && pilhaV.lastElement() == vagao){
                   n++;
                   if(n < numSave){
                       vagao =Integer.parseInt(v[n]);
                   }
                    pilhaV.pop();
                }
                
                }
                
                if(pilhaV.empty()){
                    System.out.println("Yes");
                    //System.out.println(pilhaV);
                }else if(!pilhaV.empty()){
                    System.out.println("No");
                    //System.out.println(pilhaV);
                }
                
            } while (!vagoes.equals("0"));
        }while(!numV.equals("0"));
        System.out.println();
    }
}
