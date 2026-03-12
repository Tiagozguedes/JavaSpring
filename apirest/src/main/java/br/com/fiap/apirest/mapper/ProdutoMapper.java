package br.com.fiap.apirest.mapper;

import br.com.fiap.apirest.dto.ProdutoResponse;
import br.com.fiap.apirest.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {
    public ProdutoResponse produtoToResponse(Produto produto) {
        return new ProdutoResponse(produto.getId(), produto.getNome(), produto.getPreco());
    }
}
