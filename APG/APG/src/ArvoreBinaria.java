/**
 * ArvoreBinaria
 */
public class ArvoreBinaria {

    private int valor;
    private ArvoreBinaria esquerda;
    private ArvoreBinaria direita; 

    ArvoreBinaria(int valor, ArvoreBinaria esquerda, ArvoreBinaria direita){
        this.valor = valor;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public void imprimirPreOrdem(ArvoreBinaria a){
        System.out.println(a.valor);
        //imprimirPreOrdem(a, esquerda);
    }
}