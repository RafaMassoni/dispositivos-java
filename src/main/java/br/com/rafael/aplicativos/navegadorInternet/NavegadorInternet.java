package br.com.rafael.aplicativos.navegadorInternet;

import br.com.rafael.aplicativos.Aplicativo;

import java.util.*;

public final class NavegadorInternet implements Aplicativo {

    private static Aba abaSelecionada;
    private static List<Aba> listaAbas;

    public NavegadorInternet() {
        listaAbas = new ArrayList<>();

        abaSelecionada = new Aba();
        listaAbas.add(abaSelecionada);
    }

    @Override
    public void iniciar() {
        System.out.println("Iniciando Navegador de Internet");


        System.out.println("Navegador de Internet iniciado");
        abaSelecionada.printarConteudoAba();

        Scanner scanner = new Scanner(System.in);

        boolean aplicativoAberto = true;
        while (aplicativoAberto) {


            System.out.println();
            System.out.println("---- Ações disponíveis ----");
            System.out.println("1.Exibir Página");
            System.out.println("2.Adicionar Nova Aba");
            System.out.println("3.Atualizar Página");
            System.out.println("4.Voltar ao Início");
            System.out.println();
            System.out.println("Abas abertas:" + listaAbas.size());
            System.out.println();


            int opcaoSelecionada = getOpcaoSelecionada(scanner);


            switch (opcaoSelecionada) {
                case 1 -> {
                    System.out.println("Digite a url de destino:");
                    String url = scanner.nextLine();
                    if (!url.contains("http://") && !url.contains("https://"))
                        url = "https://" + url;

                    abaSelecionada.setUrl(url);
                    abaSelecionada.printarConteudoAba();
                }
                case 2 -> {
                    abaSelecionada = new Aba();
                    abaSelecionada.printarConteudoAba();
                    listaAbas.add(abaSelecionada);
                }
                case 3 -> {
                    System.out.println("Atualizando página");
                    abaSelecionada.printarConteudoAba();
                }
                case 4 -> {
                    System.out.println("Fechando aplicativo");
                    aplicativoAberto = false;
                }
                default -> System.out.println("Opção inválida, favor selecionar 1,2,3 ou 4");

            }

        }
    }



    private static int getOpcaoSelecionada(Scanner scanner) {
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
