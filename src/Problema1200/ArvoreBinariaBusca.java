package Problema1200;

public class ArvoreBinariaBusca {
    private No raiz;

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }

    public void inserir(char valor) {
        raiz = inserirNo(raiz, valor);
    }

    private No inserirNo(No raiz, char valor) {
        if (raiz == null) {
            return new No(valor);
        }

        if (valor < raiz.valor) {
            raiz.esquerda = inserirNo(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = inserirNo(raiz.direita, valor);
        }

        return raiz;
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdemPercurso(raiz);
        System.out.println();
    }

    private void imprimirEmOrdemPercurso(No no) {
        if (no != null) {
            imprimirEmOrdemPercurso(no.esquerda);
            System.out.print(no.valor + " ");
            imprimirEmOrdemPercurso(no.direita);
        }
    }

    public void imprimirPreOrdem() {
        imprimirPreOrdemPercurso(raiz);
        System.out.println();
    }

    private void imprimirPreOrdemPercurso(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            imprimirPreOrdemPercurso(no.esquerda);
            imprimirPreOrdemPercurso(no.direita);
        }
    }

    public void imprimirPosOrdem() {
        imprimirPosOrdemPercurso(raiz);
        System.out.println();
    }

    private void imprimirPosOrdemPercurso(No no) {
        if (no != null) {
            imprimirPosOrdemPercurso(no.esquerda);
            imprimirPosOrdemPercurso(no.direita);
            System.out.print(no.valor + " ");
        }
    }

    public boolean buscar(char valor) {
        return buscarNo(raiz, valor);
    }

    private boolean buscarNo(No no, char valor) {
        if (no == null) {
            return false;
        }

        if (valor == no.valor) {
            return true;
        } else if (valor < no.valor) {
            return buscarNo(no.esquerda, valor);
        } else {
            return buscarNo(no.direita, valor);
        }
    }
}