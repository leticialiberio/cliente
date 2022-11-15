package com.example.cliente.servico;

import com.example.cliente.cliente.ConsultaCEPCliente;
import com.example.cliente.conversores.ConverterClienteParaRespostaCliente;
import com.example.cliente.entidade.Cliente;
import com.example.cliente.entidade.Endereco;
import com.example.cliente.excecao.SemConteudoExcecao;
import com.example.cliente.persistencia.ClienteRepositorio;
import com.example.cliente.persistencia.EnderecoRepositorio;
import com.example.cliente.resposta.EnderecoResposta;
import com.example.cliente.resposta.RespostaCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultarClienteServico {
    @Autowired
    private PesquisaClienteServico pesquisaClienteServico;
    @Autowired
    private EnderecoRepositorio enderecoRepositorio;
    @Autowired
    private ConsultaCEPCliente consultaCEPCliente;

    public RespostaCliente executar(String identificador) {
        Cliente cliente = pesquisaClienteServico.executar(identificador);
//        Endereco endereco = enderecoRepositorio.findByCliente(cliente);
//        cliente.setEnderecoList(List.of(endereco));
       EnderecoResposta enderecoResposta= consultaCEPCliente
               .getCep(cliente.getEnderecoList().iterator().next().getCep());
       final RespostaCliente respostaCliente = ConverterClienteParaRespostaCliente.converte(cliente);
       return respostaCliente;
    }
}
