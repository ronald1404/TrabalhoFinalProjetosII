package Problema1675;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class No {
    String rotulo;
    int prioridade;
    No esquerda;
    No direita;

    // Na treap os nos terão rotulo e prioridade
    public No(String rotulo, int prioridade) {
        this.rotulo = rotulo;
        this.prioridade = prioridade;
        this.esquerda = null;
        this.direita = null;
    }
    public static No inserir(No raiz, No novoNo) {
        // Se nulo, inserir no
        if (raiz == null) {
            return novoNo;
        }

        // Comparar lexicograficamente as strigs e substituí-las
        // Ex: if a < b, inserir na subarvore esquerda
        if (novoNo.rotulo.compareTo(raiz.rotulo) < 0) {
            raiz.esquerda = inserir(raiz.esquerda, novoNo);
            // Comparar as prioridades da subarvore esquerda com o no
            // Ex: if 9 > 8, rotacionar para a direita
            if (raiz.esquerda.prioridade > raiz.prioridade) {
                raiz = rotacionarDireita(raiz);
            }
        } else {
            // Comparar lexicograficamente as strigs e substituí-las
            // Ex: if c > b, inserir na subarvore direita
            raiz.direita = inserir(raiz.direita, novoNo);
            // Comparar as prioridades da subarvore direita com o no
            // Ex: if 10 > 8, rotacionar para a direita
            if (raiz.direita.prioridade > raiz.prioridade) {
                raiz = rotacionarEsquerda(raiz);
            }
        }

        return raiz;
    }
    public static No rotacionarDireita(No no) {
        No filhoEsquerda = no.esquerda;
        no.esquerda = filhoEsquerda.direita;
        filhoEsquerda.direita = no;
        return filhoEsquerda;
    }

    public static No rotacionarEsquerda(No no) {
        No filhoDireita = no.direita;
        no.direita = filhoDireita.esquerda;
        filhoDireita.esquerda = no;
        return filhoDireita;
    }

    public static No construirTreap(List<String> rotulos, List<Integer> prioridades) {

        // Criar lista para nos
        List<No> nos = new ArrayList<>();

        for (int i = 0; i < rotulos.size(); i++) {
            // Adicionar a lista de nos os valores dos rotulos e prioridades
            // Ex nos.add(new No("a",7))
            nos.add(new No(rotulos.get(i), prioridades.get(i)));
        }

        // embaralhar lista
        Collections.shuffle(nos);

        No raiz = null;
        for (No no : nos) {
            raiz = inserir(raiz, no);
        }

        return raiz;
    }
}