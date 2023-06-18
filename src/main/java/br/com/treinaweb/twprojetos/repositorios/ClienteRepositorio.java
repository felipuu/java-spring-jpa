package br.com.treinaweb.twprojetos.repositorios;

import br.com.treinaweb.twprojetos.entidades.Cliente;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    @EntityGraph(attributePaths = "endereco")
    List<Cliente> findAll();
}
