package org.example.factory;

import org.example.strategy.OperacaoStrategy;

public interface OperationFactory {

    OperacaoStrategy criarOperacao(String operationType);
}
