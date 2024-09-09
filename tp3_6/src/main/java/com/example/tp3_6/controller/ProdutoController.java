package com.example.tp3_6.controller;

import com.example.tp3_6.entity.Produto;
import com.example.tp3_6.service.ProdutoService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public Mono<Produto> criarProduto(@RequestBody Produto produto) {
        return produtoService.criarProduto(produto);
    }

    @PutMapping("/{id}")
    public Mono<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizarProduto(id, produto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> excluirProduto(@PathVariable Long id) {
        return produtoService.excluirProduto(id);
    }

    @GetMapping
    public Flux<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }
}
