package br.com.fiap.apirest.Enum;

public enum Categoria {
    ELETRONICOS("Eletrônicos"),
    LIVROS("Livros"),
    OUTROS("Outros");

    private String descricao;

    Categoria(String descricao) {
        this.descricao=descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
