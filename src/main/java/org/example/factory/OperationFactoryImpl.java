package org.example.factory;

import org.example.strategy.OperacaoCompraStrategy;
import org.example.strategy.OperacaoVendaStrategy;
import org.example.strategy.OperacaoStrategy;

public class OperationFactoryImpl implements OperationFactory{

    @Override
    public OperacaoStrategy criarOperacao(String operationType) {
        switch (operationType) {
            case "buy":
                return new OperacaoCompraStrategy();
            case "sell":
                return new OperacaoVendaStrategy();
            default:
                throw new IllegalArgumentException("Tipo de operação desconhecido: " + operationType);
        }
    }
}
