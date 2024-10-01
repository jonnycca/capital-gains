package org.example;

import org.example.config.AppConfig;
import org.example.domain.Operation;
import org.example.file.OperacaoFileReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        OperacaoFileReader fileReader = new OperacaoFileReader("operations.txt");

        List<List<Operation>> operations = fileReader.lerArquivoOperacoes();

        ProcessadorOperacoes processOperation = config.createProcessOperation();
        processOperation.processarOperacao(operations);
    }
}