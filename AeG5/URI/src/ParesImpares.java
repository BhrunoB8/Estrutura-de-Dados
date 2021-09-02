import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ParesImpares{
    public static void main(String args[]){

        ArrayList<Integer> tdsNum = new ArrayList<>();
        ArrayList<Integer> impares = new ArrayList<>();
        ArrayList<Integer> pares = new ArrayList<>();
        
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        for(int i = 0; i < num; i++){
            tdsNum.add(in.nextInt());
        }

        for(Integer l : tdsNum){//adiciona em listas diferentes caso for par ou impar
            if(l%2 == 0){
                pares.add(l);
            }else{
                impares.add(l);
            }
        }
        Collections.sort(pares);//bota em ordem crescente   

        Collections.sort(impares);//bota em ordem crescente

        Collections.reverse(impares);//inverte a ordem 
        
         for(Integer a: pares){//printa os pares
             System.out.println(a);
         }
         for(Integer b: impares){//printa os impares
             System.out.println(b);
        }
        
    }
}