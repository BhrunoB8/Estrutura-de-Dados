//Classe No para a Lista DuplamenteEncadeada
public class No {

    public int elemento;
    public No anterior;
    public No proximo;
    public Estudante estudante;

    public No(int elemento) {
        this.elemento = elemento;
        anterior = proximo = null;
    }

    public No() {

    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public int getElemento(){
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    // public void removerEstudantes() {
    //     Estudante es = head.estudante;
    //     No aux = head;
    //     int count = 0;
    //     if (!isVazio()) {
    //         for (aux = head; aux == tail; aux = aux.proximo) {
    //             count++;
    //             if (es.getMatricula() < 202060000) {
    //                 System.out.println("ok1");
    //                 remover(count);
    //             } else {
    //                 System.out.println("ok2");
    //                 System.out.println(es.toString());
    //             }
    //         }
    //     } else {
    //         System.out.println("ok3");
    //     }
    // }
}