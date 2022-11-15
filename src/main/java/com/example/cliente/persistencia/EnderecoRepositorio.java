package com.example.cliente.persistencia;

import com.example.cliente.entidade.Cliente;
import com.example.cliente.entidade.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepositorio extends JpaRepository<Endereco, Long> {
    Long deleteByCliente(Cliente cliente);
    Endereco findByCliente(Cliente cliente);
}
