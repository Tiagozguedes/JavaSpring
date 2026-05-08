package br.com.fiap.apirest.dto;
import org.springframework.hateoas.Link;
import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoResponse(UUID id, String nome, BigDecimal preco, Link link) {
    //O Response não precisa de validações. Ele serve para controlar o que você quer expor para quem consome a API. Por exemplo, você não quer retornar a senha do usuário,
    // então simplesmente não coloca esse campo no Response DTO
}
