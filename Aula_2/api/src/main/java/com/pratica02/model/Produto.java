package com.pratica02.model;

public class Produto extends ProdutoInput {
    private static int contador = 0;
    private int id;
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public Produto(ProdutoInput produtoInput){
        this.id = ++contador;
        this.setNome(produtoInput.getNome());
        this.setDescricao(produtoInput.getDescricao());
    }
}
