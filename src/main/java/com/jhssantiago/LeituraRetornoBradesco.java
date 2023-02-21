package com.jhssantiago;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class LeituraRetornoBradesco implements LeituraRetorno {
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
        System.out.println("lendo arquivo Bradesco: "+ nomeArquivo);

        var listaBoletos = new LinkedList<Boleto>();

        /*
            id do boleto com 10 dígitos
            cód banco onde o boleto foi pago (3 dígitos)
            *agência onde o boleto foi pago (6 dígitos)
            *conta do cliente para possível estorno de pagamento (9 dígitos)
            data vencimento (dd/mm/yyyy)
            *data/hora pagamento (dd/mm/yyyy hh:nn:ss)
            *CPF do cliente (com . e -)
            valor do boleto (decimal 10.2)
            multa por atraso (decimal 10.2)
            juros no formato (decimal 10.2)
         */

        try {
            var linhas = Files.readAllLines(Paths.get(nomeArquivo));
            for (var linha : linhas) {
                var vetor = linha.split(";");
                var boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setAgencia(vetor[2]);
                boleto.setContaBancaria(vetor[3]);
                boleto.setDataVencimento(LocalDate.parse(vetor[4], FORMATO_DATA));
                boleto.setDataPagamento(LocalDateTime.parse(vetor[5],FORMATO_DATA_HORA));
                boleto.setCpfCliente(vetor[6]);
                boleto.setValor(Double.parseDouble(vetor[7]));
                boleto.setMulta(Double.parseDouble(vetor[8]));
                boleto.setJuros(Double.parseDouble(vetor[8]));
                listaBoletos.add(boleto);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return listaBoletos;
    }
}
