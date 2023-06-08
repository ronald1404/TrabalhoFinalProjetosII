package Problema1195;
public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void insert(int valor) {
        raiz = inserirNo(raiz, valor);
    }

    private No inserirNo(No raiz, int valor) {
        if (raiz == null) {
            return new No(valor);
        }

        if (valor < raiz.valor) {
            raiz.esquerda = inserirNo(raiz.esquerda, valor);
        } else {
            raiz.direita = inserirNo(raiz.direita, valor);
        }

        return raiz;
    }

    public void printPreordem() {
        printPreordemTransversal(raiz);
        System.out.println();
    }

    private void printPreordemTransversal(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            printPreordemTransversal(no.esquerda);
            printPreordemTransversal(no.direita);
        }
    }

    public void printEmOrdem() {
        printEmOrdemTransversal(raiz);
        System.out.println();
    }

    private void printEmOrdemTransversal(No no) {
        if (no != null) {
            printEmOrdemTransversal(no.esquerda);
            System.out.print(no.valor + " ");
            printEmOrdemTransversal(no.direita);
        }
    }

    public void printPosOrdem() {
        printPostOrdemTrasversal(raiz);
        System.out.println();
    }

    private void printPostOrdemTrasversal(No node) {
        if (node != null) {
            printPostOrdemTrasversal(node.esquerda);
            printPostOrdemTrasversal(node.direita);
            System.out.print(node.valor + " ");
        }
    }
}