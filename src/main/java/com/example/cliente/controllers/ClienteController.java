package com.example.cliente.controllers;

import com.example.cliente.requisicao.RequisicaoCliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@Slf4j
public class ClienteController {
    @PostMapping(path = "/cliente", produces = "application/json")
    public RequisicaoCliente criarCliente(@RequestBody RequisicaoCliente requisicaoCliente) {
        log.info("Info {}", requisicaoCliente);
        return requisicaoCliente;
    }
}
