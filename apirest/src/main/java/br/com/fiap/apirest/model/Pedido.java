package main.java.br.com.fiap.apirest.model;

import br.com.fiap.apirest.model.Produto;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Status status;
    private LocalDate data;
    private Double valor;
    @ManyToOne
    @JoinColumn(name = "id_cliente")

    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "produto_pedido",
                joinColumns = @joinColumn(name = "id_produto", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "id_pedido", referencedColumnName = "id" ))
    private List<Produto> produtos;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
