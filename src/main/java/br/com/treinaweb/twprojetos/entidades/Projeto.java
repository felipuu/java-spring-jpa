package br.com.treinaweb.twprojetos.entidades;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Projeto extends Entidade{

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data_fim", nullable = true)
    private LocalDate dataFim;
    @ManyToOne
    @JoinColumn(name = "cliente_id_fk", nullable = false)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "lider_id_fk", nullable = false)
    private Funcionario lider;
    @Column(nullable = false)
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal orcamento;
    @Column(nullable = false)
    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal gastos;
    @ManyToMany
    @JoinTable(
            name = "projeto_funcionario",
            joinColumns = @JoinColumn(name = "projeto_id_fk"),
            inverseJoinColumns = @JoinColumn(name = "funcionario_id_fk")
    )
    List<Funcionario> equipe;

    public String getNome() {
        return nome;
    }

    public Projeto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Projeto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public Projeto setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
        return this;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public Projeto setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Projeto setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public Funcionario getLider() {
        return lider;
    }

    public Projeto setLider(Funcionario lider) {
        this.lider = lider;
        return this;
    }

    public BigDecimal getOrcamento() {
        return orcamento;
    }

    public Projeto setOrcamento(BigDecimal orcamento) {
        this.orcamento = orcamento;
        return this;
    }

    public BigDecimal getGastos() {
        return gastos;
    }

    public Projeto setGastos(BigDecimal gastos) {
        this.gastos = gastos;
        return this;
    }

    public List<Funcionario> getEquipe() {
        return equipe;
    }

    public Projeto setEquipe(List<Funcionario> equipe) {
        this.equipe = equipe;
        return this;
    }
}
