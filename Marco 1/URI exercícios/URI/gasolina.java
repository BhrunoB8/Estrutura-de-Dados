/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uri;

import java.io.IOException;
import java.util.Scanner;
 
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class gasolina {
 
    public static void main(String[] args) throws IOException {
 
        Scanner entrada = new Scanner(System.in);
        
        int horas;
        int velMedia;
        horas = entrada.nextInt();
        velMedia = entrada.nextInt();
        
        float distancia = horas * velMedia;
        
        float litro = distancia / 12;
        
        System.out.printf("%.3f", litro);
        
    }
 
}