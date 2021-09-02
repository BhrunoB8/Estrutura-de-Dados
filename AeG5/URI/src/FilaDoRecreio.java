import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;



public class FilaDoRecreio {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numTest;
		int vetor1[];
		int vetor2[];
		
		numTest = in.nextInt();
		
		for(int i =0; i< numTest; i++){
		    int numA = in.nextInt();
		    vetor1 = new int[numA];
		    vetor2 = new int[numA];
		    for(int o=0; o<numA; o++){
		        int nota = in.nextInt();
		        vetor1[o] = nota;
		        vetor2[o] = nota;
		    }
		    
            
            bubbleSort(vetor1);
            // for(int x = 0; x<vetor1.length; x++){
            //     System.out.println(vetor1[x]);   
            // }
		    System.out.println(MudaAluno(vetor1,vetor2));
		}
	}
	public static void bubbleSort(int vetor1[]){
        for (int i = 1; i < vetor1.length; i++) {
            for (int j = 0; j < i; j++) {
                if (vetor1[i] > vetor1[j]) {
                    int temp = vetor1[i];
                    vetor1[i] = vetor1[j];
                    vetor1[j] = temp;
                }
            }
        }
    }

	public static int MudaAluno(int[] vetor1, int[] vetor2){
	    int n = 0;
	    for(int i = 0; i<vetor1.length; i++){
	        if(vetor1[i] == vetor2[i]){
	            n++;
	        }
	    }
	    return n;
	}
}
