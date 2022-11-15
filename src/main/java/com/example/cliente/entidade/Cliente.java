package com.example.cliente.entidade;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {
    @Id
    private String cpf;
    @Column(name = "nome_cliente")

    private String nome;

    private String identificador;
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecoList;
}
