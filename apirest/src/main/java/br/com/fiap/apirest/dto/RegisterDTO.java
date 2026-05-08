package br.com.fiap.apirest.dto;

import br.com.fiap.apirest.model.UserRole;

public record RegisterDTO(String login, String senha, UserRole role) {
}