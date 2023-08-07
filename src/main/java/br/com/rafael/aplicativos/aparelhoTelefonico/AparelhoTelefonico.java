package br.com.rafael.aplicativos.aparelhoTelefonico;

import br.com.rafael.aplicativos.Aplicativo;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class AparelhoTelefonico implements Aplicativo {


    @Override
    public void iniciar() {
        System.out.println("Iniciando Aparelho Telefonico");


        System.out.println("Aparelho Telefonico iniciado");

        Scanner scanner = new Scanner(System.in);

        boolean aplicativoAberto = true;
        while (aplicativoAberto) {


            System.out.println();
            System.out.println("---- Ações disponíveis ----");
            System.out.println("1.Ligar");
            System.out.println("2.Voltar ao Início");
            System.out.println();


            int opcaoSelecionada = getOpcaoSelecionada(scanner);


            switch (opcaoSelecionada) {
                case 1 -> {
                    System.out.println("Digite a número para discagem:");
                    String numeroTelefone = scanner.nextLine();

                    System.out.println("Ligando para " + numeroTelefone);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("O número chamado está ocupado ou indisponível");
                }
                case 2 -> {
                    System.out.println("Fechando aplicativo");
                    aplicativoAberto = false;
                }
                default -> System.out.println("Opção inválida, favor selecionar 1 ou 2");

            }

        }
    }

    private int getOpcaoSelecionada(Scanner scanner) {
        try {
            int opcaoSelecionada = scanner.nextInt();
            scanner.nextLine();
            return opcaoSelecionada;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return 0;
        }
    }


}
