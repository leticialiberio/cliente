package com.example.cliente.requisicao;

import lombok.Data;

@Data
public class RequisicaoCliente extends RequisicaoClientePatch{
    private String cpf;
}
