package org.example.model;

public class Restaurante {
    private String nome;
    private String categoria;
    private boolean ativo;

    public Restaurante(String nome, String categoria, boolean ativo) {
        this.nome = nome;
        this.categoria = categoria;
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
