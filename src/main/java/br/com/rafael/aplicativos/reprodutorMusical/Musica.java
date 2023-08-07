package br.com.rafael.aplicativos.reprodutorMusical;

import br.com.rafael.enums.GeneroMusical;

import java.util.Objects;
import java.util.UUID;

class Musica{
        private final UUID idMusica = UUID.randomUUID();
        private final String nome;
        private final String artista;
        private final int duracao;
        private final GeneroMusical generoMusical;

        public Musica(GeneroMusical generoMusical, String nome, String artista, int duracao) {
            this.nome = nome;
            this.artista = artista;
            this.duracao = duracao;
            this.generoMusical = generoMusical;
        }

        public String getBannerMusica() {
            return "Nome: " + nome +
                   "\nDuração: " + duracao + " segundos" +
                   "\nArtista: " + artista +
                   "\nGênero Musical: " + generoMusical.name();
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Musica musica = ( Musica) o;

            return Objects.equals(idMusica, musica.idMusica);
        }
    }