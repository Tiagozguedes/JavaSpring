package br.com.fiap.apirest.model;

public enum Categoria {
    BEBIDAS("Bebidas"),
    ESSENCIA("Essencia"),
    NARGUILE("Narguile"),
    VAPE("Vape"),
    ACESSORIO("Acessorio"),
    CIGARRO("Cigarro");

    //Como passamos um construtor com argumentos, obrigatóriamente precisamos passar valores
    private String descricao;

    Categoria(String descricao) {
        this.descricao=descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
