package br.com.treinaweb.twprojetos.repositorios;

import br.com.treinaweb.twprojetos.entidades.Funcionario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {

    @EntityGraph(attributePaths = {"endereco", "cargo"})
    @Override
    List<Funcionario> findAll();

    @Query("select f from Funcionario f where f.cargo.nome = :cargoNome")
    List<Funcionario> buscarPorCargo(String cargoNome);

    @Query("select f from Funcionario f where f.cargo.nome <> :cargoNome")
    List<Funcionario> buscarPorCargoExceto(String cargoNome);
}
