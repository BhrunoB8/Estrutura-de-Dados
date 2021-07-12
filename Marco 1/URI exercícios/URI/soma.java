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
public class soma {
 
    public static void main(String[] args) throws IOException {
 
        int A;
        int B;
        int X;
        
        Scanner entrada = new Scanner(System.in);
        A = entrada.nextInt();
        B = entrada.nextInt();
        X = A + B;
        
        System.out.println("X = " + X);
        
    }
 
}