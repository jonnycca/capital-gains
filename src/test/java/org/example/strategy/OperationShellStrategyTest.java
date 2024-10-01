package org.example.strategy;

import org.example.domain.Operation;
import org.example.domain.OperationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OperationShellStrategyTest {

    private OperacaoVendaStrategy operationShellStrategy;

    @BeforeEach
    public void setUp() {
        operationShellStrategy = new OperacaoVendaStrategy();
    }

    @Test
    public void testCalcularTaxaPrejuizo() {
        Operation operation = createOperacaoPrejuizo();
        OperationContext operationContext = createOperationContext();

        OperationContext result = operationShellStrategy.calcularTaxa(operation, operationContext);

        Assertions.assertEquals(result.getMedia(), 10.00);
        Assertions.assertEquals(result.getQuantidade(), 5);
        Assertions.assertEquals(result.getPrejuizo(), 0);
        Assertions.assertEquals(result.getTaxas().get(0).getTaxa(),new BigDecimal("0.00"));
    }

    @Test
    public void testCalcularTaxaSemPrejuizo() {
        Operation operation = createOperacaoLucro();
        OperationContext operationContext = createOperationContext().withMedia(5.00).withQuantidade(10000);

        OperationContext result = operationShellStrategy.calcularTaxa(operation, operationContext);

        assertEquals(5000, result.getQuantidade());
        assertEquals(5.00, result.getMedia());
        assertEquals(0.0, result.getPrejuizo());
        assertEquals(1, result.getTaxas().size());
        assertEquals(result.getTaxas().get(0).getTaxa(),new BigDecimal("15000.00"));
    }

    public OperationContext createOperationContext() {
        return new OperationContext(10.00, 20, 0.00, new ArrayList<>());
    }
    private Operation createOperacaoPrejuizo(){
        return new Operation("shell", 10.0, 15);
    }
    private Operation createOperacaoLucro(){
        return new Operation("shell", 20.0, 5000);
    }
}