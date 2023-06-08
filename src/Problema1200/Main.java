package Problema1200;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();

        while (scanner.hasNext()) {
            String comando = scanner.next();

            if (comando.equals("I")) {
                char valor = scanner.next().charAt(0);
                arvore.inserir(valor);

            } else if (comando.equals("INFIXA")) {
                arvore.imprimirEmOrdem();
            } else if (comando.equals("PREFIXA")) {
                arvore.imprimirPreOrdem();
            } else if (comando.equals("POSFIXA")) {
                arvore.imprimirPosOrdem();
            } else if (comando.equals("P")) {
                char valor = scanner.next().charAt(0);
                boolean encontrado = arvore.buscar(valor);
                System.out.println(encontrado ? "existe" : "nao existe");
            }
        }

        scanner.close();
    }
}
