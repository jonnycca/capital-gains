package org.example.service;

import org.example.domain.Operation;
import org.example.domain.OperationContext;
import org.example.domain.TaxaOperacao;
import org.example.factory.OperationFactory;
import org.example.strategy.OperacaoStrategy;

import java.util.List;

public class CalculadoraTaxaService {

    private OperationContext operationContext;
    private final OperationFactory operationFactory;

    public CalculadoraTaxaService(OperationContext operationContext, OperationFactory operationFactory) {
        this.operationContext = operationContext;
        this.operationFactory = operationFactory;
    }
    public List<TaxaOperacao> calculaOperacoesList(List<Operation> operations) {
        for (Operation operation : operations) {
            OperacaoStrategy strategy = operationFactory.criarOperacao(operation.getTipoOperacao());
            this.operationContext = strategy.calcularTaxa(operation, operationContext);
        }
        return this.operationContext.getTaxas();
    }
}
