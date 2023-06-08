package Problema1675;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        while ((n = scanner.nextInt()) != 0) {
            List<String> rotulos = new ArrayList<>();
            List<Integer> prioridades = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String par = scanner.next();
                String[] partes = par.split("/");
                rotulos.add(partes[0]);
                prioridades.add(Integer.parseInt(partes[1]));
            }

            No raiz = construirTreap(rotulos, prioridades);
            imprimirTreap(raiz);
            System.out.println();
        }

        scanner.close();
    }

    public static No construirTreap(List<String> rotulos, List<Integer> prioridades) {
        List<No> nos = new ArrayList<>();

        for (int i = 0; i < rotulos.size(); i++) {
            nos.add(new No(rotulos.get(i), prioridades.get(i)));
        }

        Collections.shuffle(nos); // Embaralha os nós aleatoriamente

        No raiz = null;
        for (No no : nos) {
            raiz = inserir(raiz, no);
        }

        return raiz;
    }

    public static No inserir(No raiz, No novoNo) {
        if (raiz == null) {
            return novoNo;
        }

        if (novoNo.rotulo.compareTo(raiz.rotulo) < 0) {
            raiz.esquerda = inserir(raiz.esquerda, novoNo);
            if (raiz.esquerda.prioridade > raiz.prioridade) {
                raiz = rotacionarDireita(raiz);
            }
        } else {
            raiz.direita = inserir(raiz.direita, novoNo);
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