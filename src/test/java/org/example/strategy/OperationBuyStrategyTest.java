package org.example.strategy;

import org.example.domain.Operation;
import org.example.domain.OperationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

class OperationBuyStrategyTest {

    private OperacaoCompraStrategy operationBuyStrategy;

    @BeforeEach
    public void setUp() {
        operationBuyStrategy = new OperacaoCompraStrategy();
    }

    @Test
    void testCalcularTaxa() {
        Operation operation = createOperacao();
        OperationContext operationContext = createOperationContext();

        OperationContext result = operationBuyStrategy.calcularTaxa(operation, operationContext);

        Assertions.assertEquals(result.getMedia(), operation.getPreco());
        Assertions.assertEquals(result.getQuantidade(), operation.getQuantidade());
        Assertions.assertEquals(result.getTaxas().get(0).getTaxa(), new BigDecimal("0.00"));
    }

    private Operation createOperacao(){
        return new Operation("buy", 10.0, 15);
    }

    public OperationContext createOperationContext() {
        return new OperationContext(1.00, 0, 0.00, new ArrayList<>());
    }

}