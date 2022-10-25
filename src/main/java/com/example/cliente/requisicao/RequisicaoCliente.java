package com.example.cliente.requisicao;

import lombok.Data;

@Data
public class RequisicaoCliente {
    private String cpf;
    private String nome;
    private Integer numero;
    private String logradouro;
    private Integer cidade;

}
