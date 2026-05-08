package br.com.fiap.apirest.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Entity
public class Cliente {
    @Id
    private UUID cpf;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")

    private Endereco endereco;

    @OneToMany(mappedBy = "cliente")
    // mappedBy define quem é o dono relação um cliente tem muitos pedidos
    private List<Pedido> pedidos;
    // List/Set isso é necessário por conta da relação de OneToMany

    public UUID getCpf() {
        return cpf;
    }

    public void setCpf(UUID cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



}
