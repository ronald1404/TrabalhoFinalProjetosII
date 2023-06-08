package Problema1195;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Informe o número de casos:");
        int casos = in.nextInt();

        for (int numCasos = 1; numCasos <= casos; numCasos++) {

            System.out.println("Digite o número de chaves:");

            int n = in.nextInt();
            int[] numbers = new int[n];

            
            for (int i = 0; i < n; i++) {
                numbers[i] = in.nextInt();
            }

            ArvoreBinaria tree = new ArvoreBinaria();
            for (int num : numbers) {
                tree.insert(num);
            }

            System.out.println("Case " + numCasos + ":");
            // System.out.print("Pre.: ");
            tree.printPreordem();
            System.out.print("In..: ");
            tree.printEmOrdem();
            System.out.print("Post: ");
            tree.printPosOrdem();
            System.out.println("\n");
        }

        in.close();
    }
}
