package com.jhssantiago;

public class Main {
    public static void main(String[] args) {
        var processador = new ProcessarBoletos(new LeituraRetornoBancoBrasil());
        // processador.setLeituraRetorno(new LeituraRetornoBancoBrasil());
        processador.processar("banco-brasil-1.csv");
        processador.setLeituraRetorno(new LeituraRetornoBradesco());
        processador.processar("bradesco-1.csv");
    }
}