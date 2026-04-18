package main.java.br.com.fiap.apirest.model;

public enum Categoria {
    BEBIDAS,
    ESSENCIA,
    NARGUILE,
    VAPE,
    ACESSORIO,
    CIGARRO;

    private String descricao;

    Categoria(String descricao) {
        this.descricao=descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
