package br.com.treinaweb.twprojetos.repositorios;

import br.com.treinaweb.twprojetos.entidades.Projeto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetoRepositorio extends JpaRepository<Projeto, Long> {
    @EntityGraph(attributePaths = {"cliente", "lider"})
    @Override
    List<Projeto> findAll();
}
