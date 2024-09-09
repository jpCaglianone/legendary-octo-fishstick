package com.example.tp3_7.controller;

import com.example.tp3_7.service.ClimaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ClimaController {

    private final ClimaService climaService;

    public ClimaController(ClimaService climaService) {
        this.climaService = climaService;
    }

    @GetMapping("/clima/{cidade}")
    public Mono<String> obterClima(@PathVariable String cidade) {
        return climaService.obterClimaPorCidade(cidade);
    }
}
