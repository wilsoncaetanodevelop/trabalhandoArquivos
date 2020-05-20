package mainead;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void menu() {

        System.out.println("*************************************");
        System.out.println("Digite:");
        System.out.println("1_Para Adicionar");
        System.out.println("2_Para Remover");
        System.out.println("3_Para Pesquisar o item");
        System.out.println("4_Para Imprimir");
        System.out.println("5_Encerrar o programa");
        System.out.println("*************************************");
        System.out.print("-> ");
    }

    public static void addProduto(List<Produto> list) {

        sc.nextLine();
        System.out.print("digite o nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite o valor: ");
        double valor = sc.nextDouble();

        list.add(new Produto(nome, valor));
    }

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        List<Produto> list = new ArrayList<>();
        ManipulandoArquivo l = new ManipulandoArquivo();
        l.lerArquivo(list);
        
        int n;
        do {

            menu();
            n = sc.nextInt();

            switch (n) {

                case 1:
                    //direto na lista
                    addProduto(list);
                    //add direto no arquivo
                    l.gravarAquivo(list);

                    break;

                case 2:
                    l.excluir();
                    break;

                case 3:
                    l.encontrar();
                    break;
                case 4:
                    l.imprime(list);

                    break;

                case 5:
                    System.out.println("Final do Programa !!");

            }
        } while (n != 5);
    }
}
