/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uri;

/**
 *
 * @author Usuario
 */
import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;
 
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class maiorDe3 {
 
    public static void main(String[] args) throws IOException {
       Scanner entrada = new Scanner(System.in);
       int A,B,C,MaiorAB, MaiorABC;
       
       A = entrada.nextInt();
       B = entrada.nextInt();
       C = entrada.nextInt();
       
       MaiorAB = (A + B + Math.abs(A-B))/2;
       MaiorABC = (MaiorAB + C + Math.abs(MaiorAB -C))/2;
       
       System.out.println(MaiorABC + " eh o maior ");
 
    }
}