package com.univille.Video;

import com.univille.Video.Entidade.*;
import com.univille.Video.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class VideoApplication {
    public static void main(String[] args) {
        SpringApplication.run(VideoApplication.class, args);
    }

    // como foram realizadas as inserções (exemplo, pois apagamos as inserções reais)

    // Avaliacao
    //// Buscar um perfil e um vídeo existentes
    //        Perfil perfil = perfilRepo.findById(1L).orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
    //        Video video = videoRepo.findById(1L).orElseThrow(() -> new RuntimeException("Vídeo não encontrado"));
    //
    //        // Criar uma nova avaliação
    //        Avaliacao avaliacao = new Avaliacao();
    //        avaliacao.setPerfil(perfil);
    //        avaliacao.setVideo(video);
    //        avaliacao.setNota(5);
    //        avaliacao.setComentario("Vídeo excelente!");
    //
    //        avaliacaoRepo.save(avaliacao);

    @Bean
    CommandLineRunner run(
            UsuarioRepository usuarioRepo,
            PerfilRepository perfilRepo,
            CategoriaRepository categoriaRepo,
            VideoRepository videoRepo,
            AvaliacaoRepository avaliacaoRepo,
            VisualizacaoRepository visualizacaoRepo
    ) {
        return args -> {

            Scanner sc = new Scanner(System.in);
            System.out.println("===== Sistema de Streaming de Videos =====");
            System.out.println();

            int op;
            do {
                System.out.println("----- O que você deseja fazer? :");
                System.out.println("1- Buscar um vídeo pelo Título");
                System.out.println("2- Ver todos os vídeos e suas categorias");
                System.out.println("3- Os top 10 vídeos mais bem avaliados ");
                System.out.println("4- Os top 10 vídeos mais assistidos");
                System.out.println("5- O usuário que mais assistiu vídeos");
                System.out.println("0- Fechar programa");

                op = Integer.parseInt(sc.nextLine());

                switch (op) {
                    case 1 -> {

                        System.out.println("Digite o título:");
                        String titulo = sc.nextLine();
                        videoRepo.findByTituloContainingIgnoreCaseOrderByTituloAsc(titulo)
                                .forEach(System.out::println);
                    }
                    case 2 -> {
                        videoRepo.findAll().forEach(video -> {
                            System.out.println(video.getTitulo() + " | Categoria: " + video.getCategoria().getNome());
                        });
                    }
                    case 3 -> {
                        avaliacaoRepo.findTop10ByOrderByMediaNotaDesc().forEach(System.out::println);
                    }
                    case 4 -> {
                        visualizacaoRepo.findTop10MaisAssistidos().forEach(System.out::println);
                    }
                    case 5 -> {
                        System.out.println("Usuário que mais assistiu vídeos:");
                        List<Object[]> resultados = visualizacaoRepo.findUsuariosComQuantidadeDeVideos();

                        resultados.forEach(linha -> {
                            String nome = (String) linha[0];
                            Long quantidade = (Long) linha[1];
                            System.out.println();
                            System.out.println(nome + " assistiu " + quantidade + " vídeos");
                        });
                    }


                    case 0 -> {
                        System.out.println("Saindo do sistema...");
                        sc.close();
                    }


                    default -> System.out.println("Opção inválida!");
                }

            } while (op != 0);
        };
    }
}
