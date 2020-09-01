package br.com.projetotqi.projetotqi.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String usuario;
    private String senha;
    private boolean elegivelParaEmprestimo;
    private Integer propostas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isElegivelParaEmprestimo() {
        return elegivelParaEmprestimo;
    }

    public void setElegivelParaEmprestimo(boolean elegivelParaEmprestimo) {
        this.elegivelParaEmprestimo = elegivelParaEmprestimo;
    }

    public Integer getPropostas() {
        return propostas;
    }

    public void setPropostas(Integer propostas) {
        this.propostas = propostas;
    }
}
