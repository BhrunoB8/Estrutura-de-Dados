/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uri;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class array {
 
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        int N[] = new int[10];
        
        int num;
        num = entrada.nextInt();
        
        if(num <= 50){
            
        
        for(int i = 0; i < 10; i++){
           if(i == 0){
            N[i] = num;
            System.out.println("N[" + i + "] = " + N[i]);
           }else{
             num = num * 2;
             N[i] = num;
             System.out.println("N[" + i + "] = " + N[i]);
           }
            
        }
        }
    }
}