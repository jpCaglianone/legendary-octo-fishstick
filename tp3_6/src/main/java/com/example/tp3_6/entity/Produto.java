package com.example.tp3_6.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("PRODUTOS")
public class Produto {
    @Id
    private Long id;
    private String nome;
    private Double preco;
    private String marca;
    private int quantidade;


}

