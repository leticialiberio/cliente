package com.example.cliente.servico;

import com.example.cliente.conversores.ConverterClienteParaRespostaCliente;
import com.example.cliente.entidade.Cliente;
import com.example.cliente.persistencia.ClienteRepositorio;
import com.example.cliente.requisicao.RequisicaoClientePatch;
import com.example.cliente.resposta.RespostaCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AlterarClienteServico {
    private final ClienteRepositorio clienteRepositorio;
    private final PesquisaClienteServico pesquisaClienteServico;

    public RespostaCliente executar(RequisicaoClientePatch clientePatch, String identificador) {

        Cliente cliente = pesquisaClienteServico.executar(identificador);
        if (Objects.nonNull(cliente.getNome())) {
            cliente.setNome(clientePatch.getNome());
        }
        clienteRepositorio.save(cliente);

        return ConverterClienteParaRespostaCliente.converte(cliente);
    }
}
