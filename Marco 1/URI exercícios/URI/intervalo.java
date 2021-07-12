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
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class intervalo {
 
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner(System.in);
        float valor;
        
        valor = entrada.nextFloat();
        
        if(valor >= 0 && valor <= 25){
            System.out.println("Intervalo [0,25]");
        }else if(valor > 25 && valor <=50){
            System.out.println("Intervalo (25,50]");
        }else if(valor > 50 && valor <= 75){
            System.out.println("Intervalo (50,75]");
        }else if(valor > 75 && valor <=100){
            System.out.println("Intervalo (75,100]");
        }else{
            System.out.println("Fora de intervalo");
        }
 
    }
 
}
