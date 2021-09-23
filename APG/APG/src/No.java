//Classe No para a Lista DuplamenteEncadeada
public class No {

   
    private No anterior;
    private No proximo;
    private Estudante estudante;

    public No(Estudante estudante) {
        this.estudante = estudante;
        anterior = proximo = null;
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
}