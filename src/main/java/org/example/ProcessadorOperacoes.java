package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.config.AppConfig;
import org.example.domain.Operation;
import org.example.domain.TaxaOperacao;
import org.example.service.CalculadoraTaxaService;

import java.util.List;

public class ProcessadorOperacoes {

    private CalculadoraTaxaService taxaService;
    private final ObjectMapper objectMapper;

    public ProcessadorOperacoes(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    public String processarOperacao(List<List<Operation>> operations) {
        String taxsJson = "";
        for (List<Operation> conjuntoOperacoes : operations) {
            taxaService = new AppConfig().createCalculateTaxService();
            List<TaxaOperacao> operationTaxes = taxaService.calculaOperacoesList(conjuntoOperacoes);

            try{
                String json = objectMapper.writeValueAsString(operationTaxes);
                System.out.println(json);
                taxsJson = json;
            }catch (JsonProcessingException ex){
                throw new RuntimeException("Falha ao converter taxas para json: "+ ex.getMessage());
            }
        }
        return taxsJson;
    }
}
