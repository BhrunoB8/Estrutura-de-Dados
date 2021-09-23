/**
 * ArvoreBinaria
 */
public class ArvoreBinaria {

    private Estudante valor;
    private ArvoreBinaria esquerda;
    private ArvoreBinaria direita; 

    ArvoreBinaria(Estudante valor, ArvoreBinaria esquerda, ArvoreBinaria direita){
        this.valor = valor;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public void imprimirPreOrdem(ArvoreBinaria a){
        System.out.println(a.valor);

        if(a.esquerda!=null){
            imprimirPreOrdem(a.esquerda);
        } 
        if(a.direita!=null){
            imprimirPreOrdem(a.direita);
        }
    }
    public static void main(String[] args) {
        //ArvoreBinaria av = new ArvoreBinaria();
    }    
}