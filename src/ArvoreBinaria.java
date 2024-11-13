public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    // Classe interna para representar um nó da árvore
    private static class No {
        int valor;
        No esquerda, direita;

        No(int valor) {
            this.valor = valor;
            esquerda = direita = null;
        }
    }

    // Método para inserir um valor na árvore
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No raiz, int valor) {
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        }
        if (valor < raiz.valor) {
            raiz.esquerda = inserirRec(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = inserirRec(raiz.direita, valor);
        }
        return raiz;
    }

    // Método para remover um valor da árvore
    public void remover(int valor) {
        raiz = removerRec(raiz, valor);
    }

    private No removerRec(No raiz, int valor) {
        if (raiz == null) return null;

        if (valor < raiz.valor) {
            raiz.esquerda = removerRec(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = removerRec(raiz.direita, valor);
        } else {
            if (raiz.esquerda == null) return raiz.direita;
            if (raiz.direita == null) return raiz.esquerda;

            No sucessor = buscarMenor(raiz.direita);
            raiz.valor = sucessor.valor;
            raiz.direita = removerRec(raiz.direita, sucessor.valor);
        }
        return raiz;
    }

    private No buscarMenor(No raiz) {
        while (raiz != null && raiz.esquerda != null) {
            raiz = raiz.esquerda;
        }
        return raiz;
    }

    // Método para buscar um valor na árvore
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(No no, int valor) {
        if (no == null) return false;
        if (valor == no.valor) return true;
        return valor < no.valor ? buscarRecursivo(no.esquerda, valor) : buscarRecursivo(no.direita, valor);
    }

    // Método para imprimir a árvore em ordem crescente
    public void imprimirEmOrdem() {
        System.out.print("Em ordem: \n");
        imprimirEmOrdemRecursivo(raiz);
        System.out.println();
    }

    private void imprimirEmOrdemRecursivo(No no) {
        if (no != null) {
            imprimirEmOrdemRecursivo(no.esquerda);
            System.out.print(no.valor + " ");
            imprimirEmOrdemRecursivo(no.direita);
        }
    }

    // Método para imprimir a árvore em pré-ordem
    public void imprimirPreOrdem() {
        System.out.print("Pré-ordem: \n");
        imprimirPreOrdemRecursivo(raiz);
        System.out.println();
    }

    private void imprimirPreOrdemRecursivo(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            imprimirPreOrdemRecursivo(no.esquerda);
            imprimirPreOrdemRecursivo(no.direita);
        }
    }

    // Método para imprimir a árvore em pós-ordem
    public void imprimirPosOrdem() {
        System.out.print("Pós-ordem: \n");
        imprimirPosOrdemRecursivo(raiz);
        System.out.println();
    }

    private void imprimirPosOrdemRecursivo(No no) {
        if (no != null) {
            imprimirPosOrdemRecursivo(no.esquerda);
            imprimirPosOrdemRecursivo(no.direita);
            System.out.print(no.valor + " ");
        }
    }

    // Método para calcular a altura da árvore
    public int altura() {
        System.out.println("Altura da arvore \n" + calcularAltura(raiz));
        return calcularAltura(raiz);
    }

    private int calcularAltura(No no) {
        if (no == null) return -1;
        return 1 + Math.max(calcularAltura(no.esquerda), calcularAltura(no.direita));
    }

    // Método para contar o número total de nós
    public int contarNos() {
        System.out.println("Numero de Nos \n" + contarNosRec(raiz));
        return contarNosRec(raiz);
    }

    private int contarNosRec(No no) {
        if (no == null) return 0;
        return 1 + contarNosRec(no.esquerda) + contarNosRec(no.direita);
    }

    // Método para contar o número de folhas
    public int contarFolhas() {
        System.out.println("Numero de folhas \n" + contarFolhasRec(raiz));
        return contarFolhasRec(raiz);
    }

    private int contarFolhasRec(No no) {
        if (no == null) return 0;
        if (no.esquerda == null && no.direita == null) return 1;
        return contarFolhasRec(no.esquerda) + contarFolhasRec(no.direita);
    }

    // Método para calcular a profundidade de um nó específico
    public int profundidadeNo(int valor) {
        System.out.println("Profundidade \n" + calcularProfundidade(raiz, valor, 0));
        return calcularProfundidade(raiz, valor, 0);
    }

    private int calcularProfundidade(No no, int valor, int profundidade) {
        if (no == null) return -1;
        if (valor == no.valor) return profundidade;

        int nivel = valor < no.valor
                ? calcularProfundidade(no.esquerda, valor, profundidade + 1)
                : calcularProfundidade(no.direita, valor, profundidade + 1);

        return nivel;
    }
}

