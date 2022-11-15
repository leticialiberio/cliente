package com.example.cliente.persistencia;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cliente.entidade.Cliente;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, String>{
    @Query("Select c FROM Cliente c inner join c.enderecoList Where c.identificador = :identificador")
    Optional<Cliente> findIdentificador(@Param("identificador") String identificador);

    Optional<Cliente> findByIdentificador(String identificador);

    @Modifying
    Long deleteByIdentificador(String identificador);
}
