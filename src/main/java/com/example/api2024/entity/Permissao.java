package com.example.api2024.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long adminSolicitanteId;

    @Column
    private String statusSolicitado;

    @Column
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataSolicitacao;

    @Column
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataAprovado;

    @ManyToOne
    @JoinColumn(name = "id_adm")
    private Adm adm;

    @ManyToOne
    @JoinColumn(name = "id_projeto")
    private Projeto projeto;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminSolicitanteId() {
        return adminSolicitanteId;
    }

    public void setAdminSolicitanteId(Long adminSolicitanteId) {
        this.adminSolicitanteId = adminSolicitanteId;
    }

    public String getStatusSolicitado() {
        return statusSolicitado;
    }

    public void setStatusSolicitado(String statusSolicitado) {
        this.statusSolicitado = statusSolicitado;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public LocalDate getDataAprovado() {
        return dataAprovado;
    }

    public void setDataAprovado(LocalDate dataAprovado) {
        this.dataAprovado = dataAprovado;
    }

    public Adm getAdm() {
        return adm;
    }

    public void setAdm(Adm adm) {
        this.adm = adm;
    }

    public Projeto getProjetoId() {
        return projeto;
    }

    public void setProjetoId(Projeto projeto) {
        this.projeto = projeto;
    }
}
