package com.example.cliente.servico;

import com.example.cliente.conversores.ConverterClienteParaRespostaCliente;
import com.example.cliente.entidade.Cliente;
import com.example.cliente.persistencia.ClienteRepositorio;
import com.example.cliente.resposta.RespostaCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class RemoverClienteServico {
    private final ClienteRepositorio clienteRepositorio;
    private final PesquisaClienteServico pesquisaClienteServico;

    @Transactional
    public RespostaCliente executar(String identificador) {
        final Cliente cliente = pesquisaClienteServico.executar(identificador);

        clienteRepositorio.delete(cliente);
        return ConverterClienteParaRespostaCliente.converte(cliente);
    }
}
