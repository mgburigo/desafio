package com.neoway.desafio.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String cpf;
    private String privado;
    private String incompleto;
    private String dataUltimaCompra;
    private String ticketMedio;
    private String ticketUltimaCompra;
    private String lojaMaisFrequente;
    private String lojaUltimaCompra;
    private Boolean cpfValido;
    private Boolean cnpjValido;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getPrivado() {
        return privado;
    }

    public void setPrivado(String privado) {
        this.privado = privado;
    }

    public String getIncompleto() {
        return incompleto;
    }

    public void setIncompleto(String incompleto) {
        this.incompleto = incompleto;
    }

    public String getDataUltimaCompra() {
        return dataUltimaCompra;
    }

    public void setDataUltimaCompra(String dataUltimaCompra) {
        this.dataUltimaCompra = dataUltimaCompra;
    }

    public String getTicketMedio() {
        return ticketMedio;
    }

    public void setTicketMedio(String ticketMedio) {
        this.ticketMedio = ticketMedio;
    }

    public String getTicketUltimaCompra() {
        return ticketUltimaCompra;
    }

    public void setTicketUltimaCompra(String ticketUltimaCompra) {
        this.ticketUltimaCompra = ticketUltimaCompra;
    }

    public String getLojaMaisFrequente() {
        return lojaMaisFrequente;
    }

    public void setLojaMaisFrequente(String lojaMaisFrequente) {
        this.lojaMaisFrequente = lojaMaisFrequente;
    }

    public String getLojaUltimaCompra() {
        return lojaUltimaCompra;
    }

    public void setLojaUltimaCompra(String lojaUltimaCompra) {
        this.lojaUltimaCompra = lojaUltimaCompra;
    }

    public Boolean getCpfValido() {
        return cpfValido;
    }

    public void setCpfValido(Boolean cpfValido) {
        this.cpfValido = cpfValido;
    }

    public Boolean getCnpjValido() {
        if (cnpjValido == null) {
            cnpjValido = Boolean.FALSE;
        }
        return cnpjValido;
    }

    public void setCnpjValido(Boolean cnpjValido) {
        this.cnpjValido = cnpjValido;
    }
}
