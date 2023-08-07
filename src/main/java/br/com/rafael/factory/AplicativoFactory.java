package br.com.rafael.factory;

import br.com.rafael.aplicativos.Aplicativo;
import br.com.rafael.aplicativos.aparelhoTelefonico.AparelhoTelefonico;
import br.com.rafael.aplicativos.navegadorInternet.NavegadorInternet;
import br.com.rafael.aplicativos.reprodutorMusical.ReprodutorMusical;
import br.com.rafael.enums.ModeloIphone;
import br.com.rafael.enums.TipoAplicativo;
import br.com.rafael.iphones.Iphone;
import br.com.rafael.iphones.Iphone7;
import br.com.rafael.iphones.Iphone8;
import br.com.rafael.iphones.IphoneX;

public class AplicativoFactory {


    public static final AplicativoFactory factory = new AplicativoFactory();

    private AplicativoFactory() {
    }


    public Aplicativo criarIphone(TipoAplicativo tipoAplicativo) {
        switch (tipoAplicativo) {
            case APARELHO_TELEFONICO -> {
                return new AparelhoTelefonico();
            }
            case NAVEGADOR_INTERNET -> {
                return new NavegadorInternet();
            }
            case REPRODUTOR_MUSICAL -> {
                return new ReprodutorMusical();
            }
            default -> throw new RuntimeException("Aplicativo ainda não foi implementado");
        }
    }


}
