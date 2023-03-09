package com.jhssantiago;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;

public class ProcessarBoletos {
    static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Function<String, List<Boleto>> leituraRetorno;

    public ProcessarBoletos(Function<String, List<Boleto>> leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public void processar(String nomeArquivo){
        var listaBoletos = leituraRetorno.apply(nomeArquivo);
        for (Boleto boleto : listaBoletos){
            System.out.println(boleto);
        }
    };

    public void setLeituraRetorno(Function<String, List<Boleto>> leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
}
