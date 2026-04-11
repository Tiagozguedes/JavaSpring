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
    @Column(name = "id")
    private UUID id;
    private Enum status;
    private LocalDate data;
    // List<Produto produto>;
    private double Valor;
}
