public class DuplamenteEncadeada {

    private No inicio;
    private No fim;
    private int quantidade;

    //Inicia a lista
    public DuplamenteEncadeada() {
        this.quantidade = 0;
        inicio = fim = null;
    }

    //Verifica se está vazia
    public boolean isVazia() {
        return this.inicio == null;
    }


    //**INSERÇÕES */
    //Insere no Inicio da Lista
    public void inserirInicio(No no) {
        if (isVazia()) {
            inicio = no;
            fim = no;
        } else {
            no.setProximo(this.inicio);
            inicio.setProximo(no);
            this.inicio = no;
        }
        quantidade++;
    }

    //Insere no fim da lista
    public void inserirFim(No no) {
        if (isVazia()) {
            inserirInicio(no);
        } else {
            no.setAnterior(this.fim);
            fim.setProximo(no);
            this.fim = no;
            quantidade++;
        }
    }

    //Insere no inicio da lista
    public void inserir(No no, int posicao) {
        if (isVazia() || posicao <= 1) {
            inserirInicio(no);
        } else if (posicao > quantidade) {
            inserirFim(no);
        } else {
            No aux = this.inicio;
            for (int i = 1; i < posicao; i++) {
                aux = aux.getProximo();
            }
            no.setProximo(aux);
            no.setAnterior(aux.getAnterior());
            no.getAnterior().setProximo(no);
            aux.setAnterior(no);
        }
        quantidade++;
    }

    // //Insere dado na lista em local escolhido
    // public void inserirOrdenado(No no) {
    //     if (isVazia()) {
    //         inicio = no;
    //     } else {
    //         No aux = inicio;
    //         No anterior = inicio;

    //         if (no.getEstudante() < inicio.getEstudante()) {
    //             no.setProximo(inicio);
    //             inicio = no;
    //         } else {
    //             while (no.getEstudante() > aux.getEstudante() || aux.getProximo() != null) {
    //                 anterior = aux;
    //                 aux = aux.getProximo();
    //             }
    //             anterior.setProximo(no);
    //             no.setProximo(aux);
    //         }
    //     }
    // }


    //**IMPRESSÕES */
    //Imprime a lista completa
    public void imprimir() {
        if (isVazia()) {
            System.out.println("A DuplamenteEncadeada está vazia!");
        } else {
            No aux = this.inicio;
            while (aux != null) {
                System.out.println(aux.getEstudante());
                aux = aux.getProximo();
            }
        }
    }

    // //Imprime o maior da lista
    // public double maior() {
    //     double maior = 0;
    //     int contador = 0;
    //     if (!isVazia()) {
    //         No aux = this.inicio;
    //         while (aux != null) {
    //             if (aux.getEstudante() > maior) {
    //                 maior = aux.getEstudante();
    //             }
    //             aux = aux.getProximo();
    //         }
    //         return maior;
    //     } else {
    //         System.out.println("Não foi possível mostrar o maior, pois a DuplamenteEncadeada está vazia!");
    //         return 0.0;
    //     }
    // }

    // //Imprime o menor da lista
    // public double menor() {
    //     double menor = 0;
    //     int contador = 0;
    //     if (!isVazia()) {
    //         No aux = this.inicio;
    //         while (aux != null) {
    //             if (contador == 0) {
    //                 menor = aux.getEstudante();
    //                 contador++;
    //             } else if (aux.getEstudante() < menor) {
    //                 menor = aux.getEstudante();
    //             }
    //             aux = aux.getProximo();
    //         }
    //         return menor;
    //     } else {
    //         System.out.println("Não foi possível mostrar o menor, pois a DuplamenteEncadeada está vazia!");
    //         return 0.0;
    //     }
    // }


    //**REMOÇÕES */
    //Remove um item da lista
    public No remover(int posicao) {
        No aux = inicio;
        if (!isVazia() && posicao >= 1 && posicao <= quantidade) {
            if (posicao == 1) {
                inicio = aux.getProximo();

                if (inicio != null) {
                    inicio.setAnterior(null);
                } else if (posicao == quantidade) {
                    aux = fim;
                    fim = fim.getAnterior();
                    fim.setProximo(null);

                }
            } else {
                for (int i = 1; i < posicao; i++) {
                    aux = aux.getProximo();
                }
                aux.getAnterior().setProximo(aux.getProximo());
                aux.getProximo().setAnterior(aux.getAnterior());
            }
            aux.setProximo(null);
            aux.setAnterior(null);
            quantidade--;
        }
        return aux;
    }

    //Remove o primeiro da lista
    public No removerPrimeiro() {
        return this.remover(1);
    }

    //Remove o ultimo da lista
    public No removerUltimo() {
        return this.remover(quantidade);
    }

    //Limpa a lista
    public DuplamenteEncadeada zerar() {
        this.inicio = null;
        this.fim = null;
        this.quantidade = 0;
        return this;
    }

    // //Deleta os dados repetidos
    // public DuplamenteEncadeada eliminarRepetidos() {
    //     DuplamenteEncadeada nova = new DuplamenteEncadeada();
    //     No aux = this.inicio;
    //     if (!isVazia()) {
    //         while (aux != null) {
    //             if (!nova.contem(aux.getEstudante())) {
    //                 nova.inserirFim(new No(aux.getEstudante()));
    //             }
    //             aux = aux.getProximo();
    //         }
    //         return nova;
    //     } else {
    //         System.out.println("A DuplamenteEncadeada está vazia, chefe!");
    //         return null;
    //     }
    // }

   
    // //**CALCULOS */
    // //Calcula a media da lista
    // public double media() {
    //     double media = 0;
    //     int acumulador = 0;
    //     double contador = 0;
    //     if (!isVazia()) {
    //         No aux = this.inicio;
    //         while (aux != null) {
    //             acumulador += aux.getEstudante();
    //             aux = aux.getProximo();
    //             contador++;
    //         }
    //         media = acumulador / contador;
    //         return media;
    //     } else {
    //         System.out.println("Não foi possível calcular, pois a DuplamenteEncadeada está vazia!");
    //         return 0.0;
    //     }
    // }

    // //Conta os pares da lista
    // public int pares() {
    //     int contador = 0;
    //     if (!isVazia()) {
    //         No aux = this.inicio;
    //         while (aux != null) {
    //             if (aux.getEstudante() % 2 == 0) {
    //                 contador++;
    //             }
    //             aux = aux.getProximo();
    //         }
    //         return contador;
    //     } else {
    //         System.out.println("Não foi possível ver quantos pares tem, pois a DuplamenteEncadeada está vazia!");
    //         return 0;
    //     }
    // }

    // //Muda valor
    // public DuplamenteEncadeada trocarValor(DuplamenteEncadeada DuplamenteEncadeada, int antigo, int novo) {
    //     DuplamenteEncadeada nova = new DuplamenteEncadeada();
    //     No aux = DuplamenteEncadeada.inicio;
    //     if (!DuplamenteEncadeada.isVazia()) {
    //         while (aux != null) {
    //             if (aux.getEstudante() == antigo) {
    //                 nova.inserirFim(new No(novo));
    //             } else {
    //                 nova.inserirFim(new No(aux.getEstudante()));
    //             }
    //             aux = aux.getProximo();
    //         }
    //         return nova;
    //     } else {
    //         System.out.println("A DuplamenteEncadeada passada está vazia!");
    //         return null;
    //     }
    // }

    // //Confere valor
    // public boolean contem(int valor) {
    //     No aux = this.inicio;
    //     if (!isVazia()) {
    //         while (aux != null) {
    //             if (aux.getEstudante() == valor) {
    //                 return true;
    //             } else {
    //                 aux = aux.getProximo();
    //             }
    //         }
    //         return false;
    //     } else {
    //         System.out.println("A DuplamenteEncadeada está vazia!");
    //         return false;
    //     }
    // }


    // //Calcula a união da lista
    // public DuplamenteEncadeada uniao(DuplamenteEncadeada parametro) {
    //     if (!this.isVazia() && !parametro.isVazia()) {
    //         DuplamenteEncadeada todos = this.clonarNaDuplamenteEncadeada(parametro);
    //         todos = todos.eliminarRepetidos();
    //         return todos;
    //     } else {
    //         System.out.println("Aconteceu algum erro!");
    //         return null;
    //     }
    // }

    // //Calcula a intersecção da lista
    // public DuplamenteEncadeada interseccao(DuplamenteEncadeada parametro) {
    //     if (!isVazia() && !parametro.isVazia()) {
    //         DuplamenteEncadeada nova = new DuplamenteEncadeada();
    //         No aux = this.inicio;
    //         while (aux != null) {
    //             if (parametro.contem(aux.getEstudante())) {
    //                 nova.inserirFim(new No(aux.getEstudante()));
    //             }
    //             aux = aux.getProximo();
    //         }
    //         return nova;
    //     } else {
    //         System.out.println("Aconteceu algum erro na intersecção!");
    //         return null;
    //     }
    // }

    // //Calcula a diferença da lista
    // public DuplamenteEncadeada diferenca(DuplamenteEncadeada parametro) {
    //     if (!isVazia() && !parametro.isVazia()) {
    //         DuplamenteEncadeada nova = new DuplamenteEncadeada();
    //         No aux = this.inicio;
    //         while (aux != null) {
    //             if (!parametro.contem(aux.getEstudante())) {
    //                 nova.inserirFim(new No(aux.getEstudante()));
    //             }
    //             aux = aux.getProximo();
    //         }
    //         return nova;
    //     } else {
    //         System.out.println("Houve erro em encotrar a diferença!");
    //         return null;
    //     }
    // }


    // //**ORDENAÇÕES */
    // //Ordena a lista
    // public DuplamenteEncadeada ordenar() {
    //     DuplamenteEncadeada ordenada = new DuplamenteEncadeada();
    //     if (!isVazia()) {
    //         No aux = inicio;
    //         while (aux != null) {
    //             ordenada.inserirOrdenado(new No(aux.getEstudante()));
    //             aux = aux.getProximo();
    //         }
    //         return ordenada;
    //     } else {
    //         return null;
    //     }
    // }

    //Divide a lista
    public DuplamenteEncadeada dividir(int posicao) {
        DuplamenteEncadeada nova = new DuplamenteEncadeada();

        if (isVazia()) {
            return null;
        }

        for (int i = posicao; i < this.quantidade; i++) {
            nova.inserirFim(new No(this.pegarPosicao(i).getEstudante()));
        }

        return nova;
    }

    //Retorna a posição da lista
    public No pegarPosicao(int pos) {
        if (isVazia()) {
            return null;
        }
        if (pos == 0) {
            return this.inicio;
        }
        No aux = this.inicio;

        for (int i = 0; i < pos; i++) {
            aux = aux.getProximo();
        }
        return aux;
    }

    //Duplica a lista
    public DuplamenteEncadeada clonarNaDuplamenteEncadeada(DuplamenteEncadeada parametro) {
        No aux = this.inicio;
        if (!isVazia()) {
            while (aux != null) {
                parametro.inserirFim(new No(aux.getEstudante()));
                aux = aux.getProximo();
            }
            return parametro;
        } else {
            System.out.println("A DuplamenteEncadeada está vazia!");
            return null;
        }
    }

    public static void main(String[] args) {
        DuplamenteEncadeada de = new DuplamenteEncadeada();
    }
}
