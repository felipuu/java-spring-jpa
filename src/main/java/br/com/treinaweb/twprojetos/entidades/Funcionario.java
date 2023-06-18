package br.com.treinaweb.twprojetos.entidades;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Funcionario extends Pessoa{

    @Column(name = "data_admissao",nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataAdmissao;
    @Column(name = "data_demissao", nullable = true)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataDemissao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargo_id_fk", nullable = false)
    private Cargo cargo;

    @ManyToMany(mappedBy = "equipe")
    private List<Projeto> projetos;

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public Funcionario setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
        return this;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Funcionario setCargo(Cargo cargo) {
        this.cargo = cargo;
        return this;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public Funcionario setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
        return this;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public Funcionario setDataDemissao(LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
        return this;
    }
}
