package com.example.cliente.servico;

import com.example.cliente.entidade.Cliente;
import com.example.cliente.excecao.SemConteudoExcecao;
import com.example.cliente.persistencia.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PesquisaClienteServico {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public Cliente executar(String identificador){
        return clienteRepositorio
                .findIdentificador(identificador).orElseThrow(SemConteudoExcecao::new);
    }
}
