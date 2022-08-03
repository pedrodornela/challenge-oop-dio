package br.com.dio.desfio.dominio;

import java.util.*;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();// Ordena por cadastro. Apenas adiciona elementos únicos
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        //Pega os set de conteudos incritos e adiona dentro dele todos os conteudos do Bootcamp
        // Adiciona bootcamp.getConteudos() em conteudosInscritos
        this.conteudosInscritos.addAll(bootcamp.getConteudos());

        bootcamp.getDevsIncritos().add(this);//adiocna o dev() ao bootcamp
    }


    public void progredir(){    //Passar a "lista" inscritos para concluidos

        //pega o primeiro conteúdo da "lista" de conteudos
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();

        if(conteudo.isPresent()){ //se o conteudo existe em this.conteudosInscritos

            this.conteudosConcluidos.add(conteudo.get()); // adiciona aos CONTEUDO a conteudosConcluidos
            this.conteudosInscritos.remove(conteudo.get());//remove dos conteudos incritos
        }
        else{
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp(){
        return this.conteudosConcluidos //pega o XP de cada conteúdo em conteudosConcluidos e somas todos/total
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
