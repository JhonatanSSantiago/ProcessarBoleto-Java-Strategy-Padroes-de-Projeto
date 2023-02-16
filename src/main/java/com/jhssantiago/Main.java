package com.jhssantiago;

public class Main {
    public static void main(String[] args) {
        var processador = new ProcessarBoletos(new LeituraRetornoBancoBrasil());
        // processador.setLeituraRetorno(new LeituraRetornoBancoBrasil());
        processador.processar("banco-brasil-1.csv");
    }
}