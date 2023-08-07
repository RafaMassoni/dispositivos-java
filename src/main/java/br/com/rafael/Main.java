package br.com.rafael;

import br.com.rafael.enums.ModeloIphone;
import br.com.rafael.factory.IphoneFactory;
import br.com.rafael.iphones.Iphone;

public class Main {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Modelo de iphone incorreto, favor enviar como parâmetro uma das opções (IPHONE_7, IPHONE_8 ou IPHONE_X)");
            System.out.println("Ex: java Main.java IPHONE_X");
            return;
        }


        String modeloSelecionado = args[0].toUpperCase();


        Iphone iphone = getIphone(modeloSelecionado);
        iniciarIphone(iphone);


        System.out.println("Aplicação finalizada");
    }

    private static void iniciarIphone(Iphone iphone) {
        System.out.println("Instalando iphone " + iphone.getModeloIphone());

        try {
            iphone.instalar();
            System.out.println("Iphone instalado com sucesso");
            iphone.ligarIphone();
        } catch (InterruptedException e) {
            throw new RuntimeException("Falha ao instalar iphone");
        }


    }

    private static Iphone getIphone(String modeloSelecionado) {
        Iphone iphone;
        try {
            ModeloIphone modeloIphone = ModeloIphone.valueOf(modeloSelecionado);
            iphone = IphoneFactory.factory.criarIphone(modeloIphone);
            return iphone;
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Modelo iphone inválido, tente (IPHONE_7, IPHONE_8 ou IPHONE_X)");
            System.out.println("Ex: java Main.java IPHONE_X");
            throw new  RuntimeException("Modelo iphone inválido");
        }

    }


}