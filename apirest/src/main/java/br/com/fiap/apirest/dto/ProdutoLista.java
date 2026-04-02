package br.com.fiap.apirest.dto;

import org.springframework.hateoas.Link;

public record ProdutoLista(String nome, Link link) {
}