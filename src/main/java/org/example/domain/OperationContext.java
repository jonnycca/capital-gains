package org.example.domain;

import java.util.Collections;
import java.util.List;

public class OperationContext {

    private Double media = 1.00;
    private Integer quantidade = 0;
    private Double prejuizo = 0.00;
    private List<TaxaOperacao> taxas;


    public OperationContext(Double media, Integer quantidade, Double prejuizo, List<TaxaOperacao> taxas) {
        this.media = media;
        this.quantidade = quantidade;
        this.prejuizo = prejuizo;
        this.taxas = Collections.unmodifiableList(taxas);
    }

    public Double getMedia() {
        return media;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPrejuizo() {
        return prejuizo;
    }

    public List<TaxaOperacao> getTaxas() {
        return taxas;
    }

    public OperationContext withMedia(Double media) {
        return new OperationContext(media, this.quantidade, this.prejuizo, this.taxas);
    }

    public OperationContext withQuantidade(Integer quantidade) {
        return new OperationContext(this.media, quantidade, this.prejuizo, this.taxas);
    }


    public OperationContext withPrejuizo(Double prejuizo) {
        return new OperationContext(this.media, this.quantidade, prejuizo, this.taxas);
    }

    public OperationContext withTaxas(List<TaxaOperacao> taxas) {
        return new OperationContext(this.media, this.quantidade, this.prejuizo, taxas);
    }
}
