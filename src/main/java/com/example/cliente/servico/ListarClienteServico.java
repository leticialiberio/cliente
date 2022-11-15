package com.example.cliente.servico;

import com.example.cliente.conversores.ConverterClienteParaRespostaCliente;
import com.example.cliente.entidade.Cliente;
import com.example.cliente.persistencia.ClienteRepositorio;
import com.example.cliente.resposta.RespostaCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class ListarClienteServico {
    private final ClienteRepositorio clienteRepositorio;

    public List<RespostaCliente> executar() {

       /* List<RespostaCliente> respostaClienteList = new ArrayList<>();
        for (Cliente cliente : clienteRepositorio.findAll()) {
            respostaClienteList.add(ConverterClienteParaRespostaCliente.converte(cliente));
        }

        return respostaClienteList; */

        return clienteRepositorio.findAll().stream()
                .map(ConverterClienteParaRespostaCliente::converte).collect(Collectors.toList());
    }
}
