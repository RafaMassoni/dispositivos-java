package br.com.rafael.iphones;

import br.com.rafael.aplicativos.aparelhoTelefonico.AparelhoTelefonico;
import br.com.rafael.aplicativos.Aplicativo;
import br.com.rafael.aplicativos.navegadorInternet.NavegadorInternet;
import br.com.rafael.aplicativos.reprodutorMusical.ReprodutorMusical;
import br.com.rafael.enums.ModeloIphone;
import br.com.rafael.enums.TipoAplicativo;
import br.com.rafael.factory.AplicativoFactory;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public  abstract class Iphone {
    private final Map<TipoAplicativo, Aplicativo> mapAplicativosAbertos = new HashMap<>();

    public abstract ModeloIphone getModeloIphone();

    public abstract void instalar() throws InterruptedException;


    public void ligarIphone(){

        System.out.println("Ligando iphone");
        Scanner scanner = new Scanner(System.in);


        boolean iphoneLigado = true;
        while (iphoneLigado)
        {


            System.out.println();
            System.out.println("---- Ações disponíveis ----");
            System.out.println("1.Navegador de Internet");
            System.out.println("2.Reprodutor Musical");
            System.out.println("3.Aparelho Telefônico");
            System.out.println("4.Desligar Iphone");
            System.out.println();


            int opcaoSelecionada = getOpcaoSelecionada(scanner);

            TipoAplicativo tipoAplicativo;
            switch (opcaoSelecionada) {
                case 1 -> tipoAplicativo = TipoAplicativo.NAVEGADOR_INTERNET;
                case 2 -> tipoAplicativo = TipoAplicativo.REPRODUTOR_MUSICAL;
                case 3 -> tipoAplicativo = TipoAplicativo.APARELHO_TELEFONICO;
                case 4 -> {
                    iphoneLigado = false;
                    continue;
                }
                default -> {
                    System.out.println("Opção inválida, favor selecionar 1,2,3 ou 4");
                    continue;
                }
            }


            Aplicativo aplicativo = gerarAplicativo(tipoAplicativo);
            System.out.println();
            aplicativo.iniciar();
        }


        System.out.println("Iphone desligado");

    }

    private Aplicativo gerarAplicativo(TipoAplicativo tipoAplicativo) {
        Aplicativo aplicativo = mapAplicativosAbertos.getOrDefault(tipoAplicativo, AplicativoFactory.factory.criarIphone(tipoAplicativo));
        mapAplicativosAbertos.put(tipoAplicativo,aplicativo);

        return aplicativo;
    }

    private int getOpcaoSelecionada(Scanner scanner) {
        try {
            return scanner.nextInt();
        }
        catch (InputMismatchException e)
        {
            scanner.nextLine();
            return 0;
        }
    }

}
