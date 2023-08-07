package br.com.rafael.iphones;

import br.com.rafael.enums.ModeloIphone;

public final class Iphone8 extends Iphone {
    @Override
    public ModeloIphone getModeloIphone() {
        return ModeloIphone.IPHONE_8;
    }

    @Override
    public void instalar() throws InterruptedException {
        Thread.sleep(2000);
    }


}
