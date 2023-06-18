package br.com.treinaweb.twprojetos.repositorios;

import br.com.treinaweb.twprojetos.entidades.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepositorio extends JpaRepository<Cargo, Long> {
}
