package com.example.cliente.servico;

import com.example.cliente.entidade.Cliente;
import com.example.cliente.entidade.Endereco;
import com.example.cliente.persistencia.ClienteRepositorio;
import com.example.cliente.persistencia.EnderecoRepositorio;
import com.example.cliente.requisicao.EnderecoRequisicao;
import com.example.cliente.requisicao.RequisicaoCliente;
import com.example.cliente.resposta.RespostaCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IncluirClienteServico {

    private final ClienteRepositorio clienteRepositorio;
    private final EnderecoRepositorio enderecoRepositorio;

    public RespostaCliente executar(RequisicaoCliente requisicaoCliente) {
        RespostaCliente respostaCliente = new RespostaCliente();

        respostaCliente.setIdentificador(UUID.randomUUID().toString());

        Cliente cliente = new Cliente();
        cliente.setNome(requisicaoCliente.getNome());
        cliente.setCpf(requisicaoCliente.getCpf());
        cliente.setIdentificador(respostaCliente.getIdentificador());
        clienteRepositorio.save(cliente);

        Endereco endereco = new Endereco();
        endereco.setCliente(cliente);
        endereco.setCep(requisicaoCliente.getEnderecoRequisicao().getCep());
        endereco.setNumero(requisicaoCliente.getEnderecoRequisicao().getNumero().longValue());
        endereco.setLogradouro(requisicaoCliente.getEnderecoRequisicao().getLogradouro());
        enderecoRepositorio.save(endereco);

        respostaCliente.setCpf(requisicaoCliente.getCpf());
        respostaCliente.setNome(requisicaoCliente.getNome());

        EnderecoRequisicao enderecoRequisicao = new EnderecoRequisicao();
        enderecoRequisicao.setNumero(requisicaoCliente.getEnderecoRequisicao().getNumero());
        enderecoRequisicao.setLogradouro(requisicaoCliente.getEnderecoRequisicao().getLogradouro());
        enderecoRequisicao.setCep(requisicaoCliente.getEnderecoRequisicao().getCep());

        return respostaCliente;
    }
}