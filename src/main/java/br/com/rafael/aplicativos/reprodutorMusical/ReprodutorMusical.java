package br.com.rafael.aplicativos.reprodutorMusical;

import br.com.rafael.aplicativos.Aplicativo;
import br.com.rafael.enums.GeneroMusical;
import br.com.rafael.enums.StatusPlayer;

import java.util.*;

public final class ReprodutorMusical implements Aplicativo {
    private Musica musicaNoPlayer;
    private StatusPlayer statusPlayer;
    private final List<Musica> listaMusicasDisponiveis;

    public ReprodutorMusical() {
        this.listaMusicasDisponiveis = new ArrayList<>();

        listaMusicasDisponiveis.add(new Musica(GeneroMusical.SAMBA, "Aquarela do Brasil", "Ary Barroso", 191));
        listaMusicasDisponiveis.add(new Musica(GeneroMusical.SAMBA, "Mas Que Nada", "Jorge Ben Jor", 160));

        listaMusicasDisponiveis.add(new Musica(GeneroMusical.FORRO, "Asa Branca", "Luiz Gonzaga", 182));
        listaMusicasDisponiveis.add(new Musica(GeneroMusical.FORRO, "Xote das Meninas", "Luiz Gonzaga", 167));

        listaMusicasDisponiveis.add(new Musica(GeneroMusical.BOSSA_NOVA, "Garota de Ipanema", "Tom Jobim e Vinícius de Moraes", 169));
        listaMusicasDisponiveis.add(new Musica(GeneroMusical.BOSSA_NOVA, "Chega de Saudade", "João Gilberto", 180));

        listaMusicasDisponiveis.add(new Musica(GeneroMusical.SERTANEJO, "Evidências", "Chitãozinho & Xororó", 267));
        listaMusicasDisponiveis.add(new Musica(GeneroMusical.SERTANEJO, "Dormi na Praça", "Bruno & Marrone", 186));

        listaMusicasDisponiveis.add(new Musica(GeneroMusical.FUNK, "Bum Bum Tam Tam", "MC Fioti", 154));
        listaMusicasDisponiveis.add(new Musica(GeneroMusical.FUNK, "Vai Malandra", "Anitta", 178));


        this.musicaNoPlayer = listaMusicasDisponiveis.get(0);

        this.statusPlayer = StatusPlayer.PAUSE;
    }

    @Override
    public void iniciar() {
        System.out.println("Iniciando Navegador de Internet");


        System.out.println("Navegador de Internet iniciado");
        exibirMusicaNoPlayer();

        Scanner scanner = new Scanner(System.in);

        boolean aplicativoAberto = true;
        while (aplicativoAberto) {


            System.out.println();
            System.out.println("---- Ações disponíveis ----");
            System.out.println("1.Play na música");
            System.out.println("2.Pause na música");
            System.out.println("3.Nova música");
            System.out.println("4.Voltar ao Início");
            System.out.println();


            int opcaoSelecionada = getOpcaoSelecionada(scanner);


            switch (opcaoSelecionada) {
                case 1 -> {
                    statusPlayer = StatusPlayer.PLAY;
                    exibirMusicaNoPlayer();
                }
                case 2 -> {
                    statusPlayer = StatusPlayer.PAUSE;
                    exibirMusicaNoPlayer();
                }
                case 3 -> {
                    statusPlayer = StatusPlayer.PLAY;
                    proximaMusicaPlayer();
                    exibirMusicaNoPlayer();
                }
                case 4 -> {
                    System.out.println("Fechando aplicativo");
                    aplicativoAberto = false;
                }
                default -> System.out.println("Opção inválida, favor selecionar 1,2,3 ou 4");

            }

        }
    }

    private void proximaMusicaPlayer() {
        Random random = new Random();
        int numeroMusica = random.nextInt(listaMusicasDisponiveis.size());
        musicaNoPlayer = listaMusicasDisponiveis.get(numeroMusica);
    }

    private void exibirMusicaNoPlayer() {
        System.out.println();
        System.out.println("Status player: " + statusPlayer);
        System.out.println("Música no player");
        System.out.println(musicaNoPlayer.getBannerMusica());
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
