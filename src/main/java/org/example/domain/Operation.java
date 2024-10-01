package org.example.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Operation {
    @JsonProperty("operation")
    private String tipoOperacao;
    @JsonProperty("unit-cost")
    private Double preco;
    @JsonProperty("quantity")
    private Integer quantidade;

    public Operation(String tipoOperacao, Double preco, Integer quantidade) {
        this.tipoOperacao = tipoOperacao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Operation() {
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}
