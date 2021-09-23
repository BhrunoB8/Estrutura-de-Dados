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
}