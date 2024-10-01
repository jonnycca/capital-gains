package org.example.file;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.Operation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OperacaoFileReader {
    private final String filePath;

    public OperacaoFileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<List<Operation>> lerArquivoOperacoes() {
        ObjectMapper objectMapper = new ObjectMapper();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))){

            String conteudo = reader.lines().collect(Collectors.joining("\n"));

            String[] partes = conteudo.split("\n");

            List<List<Operation>> todasOperacoes = new ArrayList<>();
            for (String parte : partes) {
                List<Operation> operacoes = objectMapper.readValue(parte, new TypeReference<List<Operation>>() {});
                todasOperacoes.add(operacoes);
            }
            return todasOperacoes;
        } catch (Exception ex) {
            throw new RuntimeException(MessageFormat.format("Erro ao ler o arquivo: {0}\n Motivo: {1}", filePath, ex.getMessage()), ex);//todo: definir exception especifica?
        }
    }
}
