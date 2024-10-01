package org.example.strategy;

import org.example.domain.Operation;
import org.example.domain.OperationContext;
import org.example.domain.TaxaOperacao;

import java.util.ArrayList;
import java.util.List;

public class OperacaoCompraStrategy implements OperacaoStrategy {

    @Override
    public OperationContext calcularTaxa(Operation operation, OperationContext context) {
        double novaMedia = calcarMedia(operation, context);
        List<TaxaOperacao> novasTaxas = new ArrayList<>(context.getTaxas());
        novasTaxas.add(new TaxaOperacao(0.00));

        return context.withMedia(novaMedia)
                        .withQuantidade(context.getQuantidade()+ operation.getQuantidade())
                                .withTaxas(novasTaxas);
    }

    private double calcarMedia(Operation operation, OperationContext operationContext){
        return ((operationContext.getQuantidade() * operationContext.getMedia()) + (operation.getQuantidade() * operation.getPreco()))/ (operationContext.getQuantidade() + operation.getQuantidade());
    }
}
