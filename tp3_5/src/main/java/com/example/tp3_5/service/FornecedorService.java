package com.example.tp3_5.service;

import com.example.tp3_5.entity.Fornecedor;
import com.example.tp3_5.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    @Autowired
    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public Fornecedor criarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Fornecedor buscarFornecedor(Long id) {
        return fornecedorRepository.findById(id).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    public Iterable<Fornecedor> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor atualizarFornecedor(Long id, Fornecedor fornecedorAtualizado) {
        Fornecedor fornecedorExistente = buscarFornecedor(id);
        fornecedorExistente.setNome(fornecedorAtualizado.getNome());
        fornecedorExistente.setEmail(fornecedorAtualizado.getEmail());
        fornecedorExistente.setTelefone(fornecedorAtualizado.getTelefone());
        return fornecedorRepository.save(fornecedorExistente);
    }

    public void excluirFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
