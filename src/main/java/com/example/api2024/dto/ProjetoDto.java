package com.example.api2024.dto;

import com.example.api2024.entity.Adm;

import java.time.LocalDate;

public class ProjetoDto {
    private String referenciaProjeto;
    private String empresa;
    private String objeto;
    private String descricao;
    private String coordenador;
    private Double valor;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private String situacao;
    private Long adm;

    // Getters e Setters
    public String getReferenciaProjeto() {
        return referenciaProjeto;
    }

    public void setReferenciaProjeto(String referenciaProjeto) {
        this.referenciaProjeto = referenciaProjeto;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Long getAdm() {
        return adm;
    }

    public void setAdm(Long adm) {
        this.adm = adm;
    }
}
