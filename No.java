public class No<T> {
    T dado;
    No<T> proximo;
    No<T> anterior;

   No(T d) {
       dado = d;
       proximo = null;
       anterior = null;
   }

   public T getDado() {
       return dado;
   }

   public void setDado(T dado) {
       this.dado = dado;
   }

   public No<T> getProximo() {
       return proximo;
   }

   public void setProximo(No<T> proximo) {
       this.proximo = proximo;
   }

   public No<T> getAnterior() {
       return anterior;
   }

   public void setAnterior(No<T> anterior) {
       this.anterior = anterior;
   }
}
