package Problema1200;

class No {
    char valor;
    No esquerda, direita;

    public No(char valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}