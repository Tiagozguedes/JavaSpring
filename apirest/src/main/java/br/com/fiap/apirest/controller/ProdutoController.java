package br.com.fiap.apirest.controller;

import br.com.fiap.apirest.model.Produto;
import br.com.fiap.apirest.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired //Injeção de dependência
    private ProdutoService produtoService;

    // POST, GET, PUT, DELETE

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) {
        //@RequestBody é uma anotação do Spring que indica que o corpo da requisição deve ser convertido em um objeto do tipo Produto.
        //ResponseEntity é uma classe do Spring que retorna a resposta da API.
        Produto produtoSalvo = produtoService.create(produto);
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> readProduto(@PathVariable UUID id) {
        //@PathVariable é uma anotação do Spring que indica que o valor do parâmetro id deve ser extraído da URL da requisição.
        Produto produto  = produtoService.read(id);
        if (produto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> readProduto() {
        List<Produto> produtos = produtoService.readAll();
        if (produtos == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @PutMapping
    public  ResponseEntity<Produto> updateProduto(@RequestBody Produto produto) {
        Produto produtoExistente = produtoService.read(produto.getId());
        if (produtoExistente == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Produto produtoAtualizado = produtoService.update(produto);
        return new ResponseEntity<>(produtoAtualizado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable UUID id) {
        produtoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
