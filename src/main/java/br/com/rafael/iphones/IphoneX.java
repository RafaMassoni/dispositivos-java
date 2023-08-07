package br.com.rafael.iphones;

import br.com.rafael.enums.ModeloIphone;

public final class IphoneX extends Iphone {
    @Override
    public ModeloIphone getModeloIphone() {
        return ModeloIphone.IPHONE_X;
    }

    @Override
    public void instalar() throws InterruptedException {
        Thread.sleep(3000);
    }



}
