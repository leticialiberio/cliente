package com.example.cliente.conversores;

import com.example.cliente.entidade.Cliente;
import com.example.cliente.entidade.Endereco;
import com.example.cliente.requisicao.EnderecoRequisicao;
import com.example.cliente.resposta.RespostaCliente;

import java.util.Objects;

public class ConverterClienteParaRespostaCliente {
    public static RespostaCliente converte(Cliente cliente) {

        RespostaCliente respostaCliente = new RespostaCliente();
        respostaCliente.setIdentificador(cliente.getIdentificador());
        respostaCliente.setNome(cliente.getNome());
        respostaCliente.setCpf(cliente.getCpf());
        if (!cliente.getEnderecoList().isEmpty()){
            Endereco endereco = cliente.getEnderecoList().iterator().next();
            EnderecoRequisicao enderecoRequisicao = new EnderecoRequisicao();
            enderecoRequisicao.setCep(endereco.getCep());
            enderecoRequisicao.setLogradouro(endereco.getLogradouro());
            enderecoRequisicao.setNumero(endereco.getNumero().intValue());
            respostaCliente.setEnderecoRequisicao(enderecoRequisicao);
        }
        return respostaCliente;
    }
}
