package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ProcessadorOperacoes;
import org.example.domain.OperationContext;
import org.example.factory.OperationFactory;
import org.example.factory.OperationFactoryImpl;
import org.example.service.CalculadoraTaxaService;

import java.util.ArrayList;

public class AppConfig {

    public OperationContext createOperationContext() {
        return new OperationContext(1.00, 0, 0.00, new ArrayList<>());
    }

    public OperationFactory createOperationFactory() {
        return new OperationFactoryImpl();
    }

    public CalculadoraTaxaService createCalculateTaxService() {
        return new CalculadoraTaxaService(createOperationContext(), createOperationFactory());
    }

    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
    public ProcessadorOperacoes createProcessOperation() {
        return new ProcessadorOperacoes(objectMapper());
    }
}
