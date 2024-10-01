package org.example.strategy;

import org.example.domain.Operation;
import org.example.domain.OperationContext;
import org.example.domain.TaxaOperacao;

import java.util.ArrayList;
import java.util.List;

public class OperacaoVendaStrategy implements OperacaoStrategy {

    @Override
    public OperationContext calcularTaxa(Operation operation, OperationContext context) {
        List<TaxaOperacao> novasTaxas = new ArrayList<>(context.getTaxas());
        double novoPrejuizo = context.getPrejuizo();
        int novaQuantidade = context.getQuantidade() - operation.getQuantidade();

        if(operation.getPreco() <= context.getMedia()){// isso é prejuizo
            novoPrejuizo = context.getPrejuizo() + ((operation.getQuantidade() * operation.getPreco())-(context.getMedia() * operation.getQuantidade()));
            novasTaxas.add(new TaxaOperacao(0.00));

            return context.withTaxas(novasTaxas).withPrejuizo(novoPrejuizo).withQuantidade(novaQuantidade);
        }

        if(calculaOperacao(operation) <= 20000){
            novasTaxas.add(new TaxaOperacao(0.00));
            return context.withQuantidade(novaQuantidade).withTaxas(novasTaxas);
        }

        if(operation.getPreco() > context.getMedia()){ //verificando se teve lucro
            if(context.getPrejuizo() < 0){
                double lucro = (calculaOperacao(operation) - (context.getMedia() * operation.getQuantidade())) ; // deduzir prejuizo
                if(lucro + context.getPrejuizo() > 0){ // exemplo 1000  + (-1100) = -100
                    novasTaxas.add(new TaxaOperacao((lucro + context.getPrejuizo()) * 0.2));
                }else {
                    novasTaxas.add(new TaxaOperacao(0.00));
                }
                novoPrejuizo = lucro + context.getPrejuizo();
            }else {// taxa sem prejuizo anterior
                novasTaxas.add(new TaxaOperacao((calculaOperacao(operation) - (context.getMedia() * operation.getQuantidade())) * 0.2));
            }
        }
        return context.withTaxas(novasTaxas)
                .withPrejuizo(novoPrejuizo)
                .withQuantidade(novaQuantidade);
    }

    private Double calculaOperacao(Operation operation){
        return  operation.getQuantidade() * operation.getPreco();
    }
}
