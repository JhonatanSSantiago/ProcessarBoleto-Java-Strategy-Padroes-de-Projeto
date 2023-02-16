package com.jhssantiago;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class LeituraRetornoBancoBrasil  implements LeituraRetorno {
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
        System.out.println("lendo arquivo BB: "+ nomeArquivo);

        var listaBoletos = new LinkedList<Boleto>();

        try {
            var linhas = Files.readAllLines(Paths.get(nomeArquivo));
            for (var linha : linhas) {
                var vetor = linha.split(";");
                var boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setDataVencimento(LocalDate.parse(vetor[2], FORMATO_DATA));
                var dataHoraPag = LocalDate.parse(vetor[3], FORMATO_DATA).atTime(0, 0);
                boleto.setDataPagamento(dataHoraPag);
                boleto.setCpfCliente(vetor[4]);
                boleto.setValor(Double.parseDouble(vetor[5]));
                boleto.setMulta(Double.parseDouble(vetor[6]));
                boleto.setJuros(Double.parseDouble(vetor[7]));
                listaBoletos.add(boleto);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return listaBoletos;
    }
}
