package org.example.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxaOperacao {
    private BigDecimal taxa;

    public TaxaOperacao(double taxa) {
        this.taxa = BigDecimal.valueOf(taxa).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = BigDecimal.valueOf(taxa).setScale(2, RoundingMode.HALF_UP);
    }
}
