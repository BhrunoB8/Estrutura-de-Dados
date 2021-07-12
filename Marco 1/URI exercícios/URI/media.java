/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uri;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class media {
 
    public static void main(String[] args) throws IOException {
        Locale.setDefault(new Locale("en", "US"));
        Scanner entrada = new Scanner(System.in);
        
        float N1,N2,N3,N4, Media;
        N1 = entrada.nextFloat();
        N2 = entrada.nextFloat();
        N3 = entrada.nextFloat();
        N4 = entrada.nextFloat();
        
        Media = ((2*N1) + (3*N2) + (4*N3) + N4)/10;
        
        String mediaF = String.format("%.1f", Media);
        System.out.println("Media: " + mediaF);
        
        if(Media >= 7.0f){
            System.out.println("Aluno aprovado.");
        }else if (Media < 5.0f){
            System.out.println("Aluno reprovado.");
        }else if(Media >= 5.0f && Media <=6.9f){
            System.out.println("Aluno em exame.");
            float NExm;
            NExm = entrada.nextFloat();
            System.out.println("Nota do exame: " + String.format("%.1f", NExm));
            float MediaFinal = (NExm + Media)/2;
            String mediaFi = String.format("%.1f", MediaFinal);
            if(MediaFinal >= 5.0f){
                System.out.println("Aluno aprovado.");
            }else if(MediaFinal < 5.0f){
                System.out.println("Aluno reprovado.");
            }
            System.out.println("Media final: " + mediaFi);
        }
 
    }
 
}