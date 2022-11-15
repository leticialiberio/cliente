package com.example.cliente.resposta;

import com.example.cliente.requisicao.RequisicaoCliente;
import lombok.Data;

@Data
public class RespostaCliente extends RequisicaoCliente {
    private String identificador;

}
