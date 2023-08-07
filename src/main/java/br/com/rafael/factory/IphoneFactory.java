package br.com.rafael.factory;

import br.com.rafael.enums.ModeloIphone;
import br.com.rafael.iphones.Iphone;
import br.com.rafael.iphones.Iphone7;
import br.com.rafael.iphones.Iphone8;
import br.com.rafael.iphones.IphoneX;

public class IphoneFactory {


    public static final IphoneFactory factory = new IphoneFactory();

    private IphoneFactory() {
    }


    public Iphone criarIphone(ModeloIphone modeloIphone) {
        switch (modeloIphone) {

            case IPHONE_7 -> {
                return new Iphone7();
            }
            case IPHONE_8 -> {
                return new Iphone8();
            }
            case IPHONE_X -> {
                return new IphoneX();
            }

            default -> throw new RuntimeException("Modelo ainda não foi implementado");
        }
    }


}
