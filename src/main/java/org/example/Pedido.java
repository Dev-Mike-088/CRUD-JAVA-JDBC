package org.example;

public class Pedido {
    private int userId;
    private int produtoId;
    private int quantidade;


    public Pedido(int userId, int produtoId, int quantidade){
        this.userId = userId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public int getUserId(){
        return userId;
    }
    public int getProdutoId(){
        return produtoId;
    }
    public int getQuantidade(){
        return quantidade;
    }
}
