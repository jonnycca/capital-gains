package org.example;


import org.example.config.AppConfig;
import org.example.domain.Operation;
import org.example.file.OperacaoFileReader;
import org.json.JSONException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.*;
import java.util.List;

class MainIntegrationTest {

    @ParameterizedTest
    @MethodSource("cenariosTest")
    void testeCalculoOperacoes(String cenario) throws JSONException {
        AppConfig config = new AppConfig();
        OperacaoFileReader operacaoFileReader = new OperacaoFileReader(cenario+"/request.txt");

        List<List<Operation>> operacoes = operacaoFileReader.lerArquivoOperacoes();

        ProcessadorOperacoes processOperation = config.createProcessOperation();
        String result = processOperation.processarOperacao(operacoes);


        String expected = lerArquivoExperado("src/test/resources/"+cenario+"/result.json");

        JSONAssert.assertEquals(expected, result, true);

    }

    static List<Arguments> cenariosTest(){
        return List.of(
                Arguments.of("case1"),
                Arguments.of("case2"),
                Arguments.of("case3"),
                Arguments.of("case4"),
                Arguments.of("case5"),
                Arguments.of("case6"),
                Arguments.of("case7"),
                Arguments.of("case8")
        );
    }


    private String lerArquivoExperado(String path){
        File expectedFile = new File(path);
        StringBuilder expectedContent = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(expectedFile))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                expectedContent.append(linha);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return expectedContent.toString();
    }
}