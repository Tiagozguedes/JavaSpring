package br.com.fiap.apirest.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class Cliente {
    private UUID cpf;
    private String nome;
    private String dataNascimento;
    private String telefone;

}
