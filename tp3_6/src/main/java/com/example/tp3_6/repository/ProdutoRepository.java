package com.example.tp3_6.repository;

import com.example.tp3_6.entity.Produto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProdutoRepository extends ReactiveCrudRepository<Produto, Long> {
}
