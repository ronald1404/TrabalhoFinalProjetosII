package Problema1675;

class No {
    String rotulo;
    int prioridade;
    No esquerda;
    No direita;

    public No(String rotulo, int prioridade) {
        this.rotulo = rotulo;
        this.prioridade = prioridade;
        this.esquerda = null;
        this.direita = null;
    }
}