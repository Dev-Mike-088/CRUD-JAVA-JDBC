package org.example;

public class User{
    private int id;
    private String nome;
    private int idade;

    public User(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome(){
        return nome;
    }
    public int getIdade(){
        return idade;
    }

}
