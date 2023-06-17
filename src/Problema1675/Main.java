package Problema1675;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n;

        // Parar o programa quando for digitado 0
        while ((n = in.nextInt()) != 0) {

            // Criar lista de inserção dos rótulos e prioridades
            List<String> rotulos = new ArrayList<>();
            List<Integer> prioridades = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                // Ler linha ex: "a/7"
                String par = in.next();
                // divide em uma uma lista ex: "a/7" --> ["a","7"]
                String[] partes = par.split("/");

                // Adiciona os elementos as listas correspondentes
                rotulos.add(partes[0]);
                prioridades.add(Integer.parseInt(partes[1]));

            }
            // Criar no raiz e construir a treap
            No raiz = construirTreap(rotulos, prioridades);
            imprimirTreap(raiz);
            System.out.println();
        }

        in.close();
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
        // Collections.shuffle(nos);

        No raiz = null;
        for (No no : nos) {
            raiz = inserir(raiz, no);
        }

        return raiz;
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

    public static void imprimirTreap(No raiz) {
        // Se arvore for nula, sai da função
        if (raiz == null) {
            return;
        }

        System.out.print("(");
        imprimirTreap(raiz.esquerda);
        System.out.print(raiz.rotulo + "/" + raiz.prioridade);
        imprimirTreap(raiz.direita);
        System.out.print(")");
    }
}