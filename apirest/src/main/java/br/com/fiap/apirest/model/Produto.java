package br.com.fiap.apirest.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUTOS") //Persistir nomes no banco de dados
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @NotNull
    @Column(name = "name")
    private String nome;
    @Column(name = "preco")
    private BigDecimal preco;
    @Column(name = "expiracao")
    private LocalDate expiracao;

    public Produto(String nome, BigDecimal preco, LocalDate expiracao) {
        this.nome = nome;
        this.preco = preco;
        this.expiracao = expiracao;
    }

    public Produto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDate getExpiracao() {
        return expiracao;
    }

    public void setExpiracao(LocalDate expiracao) {
        this.expiracao = expiracao;
    }


}
