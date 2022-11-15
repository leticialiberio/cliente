package com.example.cliente.cliente;

import com.example.cliente.resposta.EnderecoResposta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class ConsultaCEPCliente {
    public EnderecoResposta getCep(String cep) {
        WebClient webClient = WebClient.create();
       return
                webClient.get().uri("https://viacep.com.br/ws/{cep}/json", cep).retrieve()
                        .bodyToMono(EnderecoResposta.class).block();
    }
}
