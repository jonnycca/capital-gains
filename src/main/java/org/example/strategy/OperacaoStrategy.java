package org.example.strategy;

import org.example.domain.Operation;
import org.example.domain.OperationContext;

public interface OperacaoStrategy {

    OperationContext calcularTaxa(Operation operation, OperationContext context);
}
