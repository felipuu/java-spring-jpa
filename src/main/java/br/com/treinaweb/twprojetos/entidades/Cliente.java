package br.com.treinaweb.twprojetos.entidades;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Cliente extends Pessoa {
    @OneToMany(mappedBy = "cliente")
    private List<Projeto> projetos;

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public Cliente setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
        return this;
    }
}
