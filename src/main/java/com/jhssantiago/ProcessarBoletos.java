package com.jhssantiago;

public class ProcessarBoletos {
    private LeituraRetorno leituraRetorno;

    public ProcessarBoletos(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public void processar(String nomeArquivo){
        var listaBoletos = leituraRetorno.lerArquivo(nomeArquivo);
        for (Boleto boleto : listaBoletos){
            System.out.println(boleto);
        }
    };

    public void setLeituraRetorno(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
}
