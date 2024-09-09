package com.example.tp3_6.service;

import com.example.tp3_6.entity.Produto;
import com.example.tp3_6.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Mono<Produto> criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }
    public Mono<Produto> atualizarProduto(Long id, Produto produtoAtualizado) {
        return produtoRepository.findById(id)
                .flatMap(produto -> {
                    produto.setNome(produtoAtualizado.getNome());
                    produto.setPreco(produtoAtualizado.getPreco());
                    return produtoRepository.save(produto);
                });
    }

    public Mono<Void> excluirProduto(Long id) {
        return produtoRepository.deleteById(id);
    }
    public Flux<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }


}
