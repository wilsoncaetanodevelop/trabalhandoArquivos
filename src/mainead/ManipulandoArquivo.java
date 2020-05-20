/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainead;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static mainead.Main.sc;

/**
 *
 * @author Wilson Caetano
 */
public class ManipulandoArquivo {

    public void lerArquivo(List<Produto> lista) {

        String caminho = "C:\\teste\\Main.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String line = br.readLine();
            while (line != null) {
                String[] dados = line.split(",");
                lista.add(new Produto(dados[0], Double.parseDouble(dados[1])));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    //Gravar os arquivos alterados e em ordem alfabetica
    public void gravarAquivo(List<Produto> list) {

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            PrintWriter gravarArq = new PrintWriter(outputStream);

            gravarArq.println(list.toString());
            gravarArq.flush();

            FileOutputStream file = new FileOutputStream("C:\\teste\\in.txt");
            file.write(outputStream.toByteArray());
            file.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

    //adiciona no arquivo texto
    public void addProduto(String path) {

        try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true))) {

            String linha = "";
            System.out.println("Digite um produto no formato(nome,Preço)");
            linha = sc.nextLine();
            buffWrite.append(linha);
            buffWrite.close();

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    //Encontrar Produto no arquivo Texto
    public void encontrar() {

        File file = new File("C:\\teste\\Main.txt");

        String encontrado = " ";

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();
            System.out.println("Digite o nome e preco do produto");
            String dados = sc.next();

            while (linha != null) {
                if (linha.trim().equals(dados.trim())) {
                    encontrado = linha;
                    System.out.println("Encontrado " + encontrado);
                } else {
                    System.out.println("Produto Enixistente");
                }
                linha = br.readLine();
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    //excluir direto no arquivo texto
    public void excluir() {

        File file = new File("C:\\teste\\Main.txt");

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();
            ArrayList<String> novo = new ArrayList<>();
            System.out.println("Digite o nome e preco do produto");
            String dados = sc.next();

            while (linha != null) {
                if (!linha.trim().equals(dados.trim())) {
                    novo.add(linha);
                }
                linha = br.readLine();
            }

            br.close();
            fr.close();
            FileWriter fw2 = new FileWriter(file, true);
            fw2.close();

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < novo.size(); i++) {
                bw.write(novo.get(i));
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    // imprime o arquivo texto 
    public void imprime(List<Produto> list) {

        Collections.sort(list);
        for (Produto c : list) {
            System.out.println(c);
        }
    }

}
