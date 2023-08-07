package br.com.rafael.iphones;

import br.com.rafael.enums.ModeloIphone;

public final class Iphone7 extends Iphone {
    @Override
    public ModeloIphone getModeloIphone() {
        return ModeloIphone.IPHONE_7;
    }

    @Override
    public void instalar() throws InterruptedException {
        Thread.sleep(1000);
    }


}
