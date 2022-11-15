package com.example.cliente.entidade;

import lombok.Data;

import javax.persistence.*;

@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long numero;

    private String logradouro;

    @ManyToOne
    @JoinColumn(name = "cpf_cliente")
    private Cliente cliente;

    private String cep;
}
