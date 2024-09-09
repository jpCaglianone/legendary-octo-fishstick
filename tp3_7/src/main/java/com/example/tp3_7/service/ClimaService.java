package com.example.tp3_7.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ClimaService {

    private final WebClient webClient;

    public ClimaService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openweathermap.org/data/2.5").build();
    }

    public Mono<String> obterClimaPorCidade(String cidade) {
        String apiKey = "1079330ce48267a148f8fcf97c225384"; // Substitua pela sua chave da API

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/weather")
                        .queryParam("q", cidade)
                        .queryParam("appid", apiKey)
                        .queryParam("units", "metric") // Para retornar a temperatura em Celsius
                        .build())
                .retrieve()
                .bodyToMono(String.class); // Converte a resposta para String ou um DTO
    }
}
