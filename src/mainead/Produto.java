/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainead;

/**
 *
 * @author Wilson Caetano
 */
public class Produto implements Comparable<Produto>{
    
    private String nome;
    private double valor;

    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "\nProduto " + "\nNome: " + nome + "\nValor: " + valor ;
    }

    
    @Override
    public int compareTo(Produto p) {
        return this.nome.toUpperCase().compareToIgnoreCase(p.getNome().toUpperCase());
    }

    
    
}
