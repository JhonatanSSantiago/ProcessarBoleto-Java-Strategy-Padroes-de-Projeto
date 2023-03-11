package com.jhssantiago;

public class Main {
    public static void main(String[] args) {
        var processador = new ProcessarBoletos(LeituraRetornoBancoBrasil::lerArquivo); //passando função por parametro
        processador.processar("banco-brasil-1.csv");

        var p1 = new ProcessarBoletos(LeituraRetornoBradesco::lerArquivo);
        p1.processar("bradesco-1.csv");
    }

}