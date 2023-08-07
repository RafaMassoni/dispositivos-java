package br.com.rafael.aplicativos.navegadorInternet;

import java.util.Objects;
import java.util.UUID;

class Aba{
        private final UUID idAba = UUID.randomUUID();
        private String url;

        public void setUrl(String url) {
            this.url = url;
        }

        public void printarConteudoAba() {
            System.out.println();
            if (url == null || url.isBlank())
                System.out.println("Exibindo aba padrão");
            else
                System.out.println("Exibindo conteúdo da página " + url);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Aba aba = (Aba) o;

            return Objects.equals(idAba, aba.idAba);
        }
    }