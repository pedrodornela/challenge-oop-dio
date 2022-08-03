package br.com.dio.desfio.dominio;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){

        Conteudo conteudo = new Curso();

        Curso curso = new Curso();
        curso.setTitulo("POO Java");
        curso.setDescricao("Java Orientado a Objeto");
        curso.setCargaHoraria(6);

        Curso curso1 = new Curso();
        curso1.setTitulo("Introdução ao Spring");
        curso1.setDescricao("Spring Java");
        curso1.setCargaHoraria(4);

        Curso curso2 = new Curso();
        curso2.setTitulo("Introdução a Redes");
        curso2.setDescricao("Principais protocolos de Comunicação da Internet");
        curso2.setCargaHoraria(5);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("1ª mentoria");
        mentoria.setDescricao("Mentoria java");
        mentoria.setData(LocalDate.now());

        /*System.out.println(curso);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Java...");
        bootcamp.getConteudos().add(curso);
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devPedro = new Dev();
        devPedro.setNome("Pedro");
        devPedro.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos - Pedro: " + devPedro.getConteudosInscritos());
        devPedro.progredir();
        devPedro.progredir();
        devPedro.progredir();
        devPedro.progredir();
        System.out.println("Conteúdos Inscritos que faltam - Pedro: " + devPedro.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos - Pedro: " + devPedro.getConteudosConcluidos());
        System.out.println("XP: " + devPedro.calcularTotalXp());

        System.out.println("");

        Dev devBruno = new Dev();
        devBruno.setNome("Bruno");
        devBruno.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos - Bruno: " + devBruno.getConteudosInscritos());
        devBruno.progredir();
        System.out.println("Conteúdos Inscritos que faltam - Bruno: " + devBruno.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos - Bruno: " + devBruno.getConteudosConcluidos());
        System.out.println("XP: " + devBruno.calcularTotalXp());

    }
}
