package br.com.treinaweb.twprojetos.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Endereco extends Entidade {
    @Column(nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    private Uf uf;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String logradouro;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = true)
    private String complemento;

    public Endereco() {
    }

    public Uf getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }

    public Endereco setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public Endereco setUf(Uf uf) {
        this.uf = uf;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public Endereco setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Endereco setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Endereco setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public Endereco setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public Endereco setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    @Override
    public String toString() {
       StringBuilder enderecoCompleto = new StringBuilder();
       enderecoCompleto
               .append(logradouro)
               .append(", n° ")
               .append(numero)
               .append(", ")
               .append(complemento)
               .append(" - ")
               .append(bairro)
               .append(". ")
               .append(uf.getDescricao())
               .append(" - ")
               .append(cidade)
               .append(". CEP: ")
               .append(cep);
       return enderecoCompleto.toString();
    }
}
