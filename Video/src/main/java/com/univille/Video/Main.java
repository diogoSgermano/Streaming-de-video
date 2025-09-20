package com.univille.Video;

import com.univille.Video.Repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		// Sobe o contexto do Spring Boot
		ApplicationContext context = SpringApplication.run(Main.class, args);

		// Recupera os repositórios que você precisa
		UsuarioRepository usuarioRepository = context.getBean(UsuarioRepository.class);
		VideoRepository videoRepository = context.getBean(VideoRepository.class);
		AvaliacaoRepository avaliacaoRepository = context.getBean(AvaliacaoRepository.class);
		CategoriaRepository categoriaRepository = context.getBean(CategoriaRepository.class);
		VisualizacaoRepository visualizacaoRepository = context.getBean(VisualizacaoRepository.class);
		PerfilRepository perfilRepository = context.getBean(PerfilRepository.class);

		// Agora o menu roda normalmente
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
			System.out.println("0- fechar programa");

			op = Integer.parseInt(sc.nextLine());

			// aqui dentro você pode usar os repositórios normalmente
			if (op == 1) {
				System.out.println("Digite o título:");
				String titulo = sc.nextLine();
				videoRepository.findByTituloContainingIgnoreCaseOrderByTituloAsc(titulo)
						.forEach(System.out::println);
			}

		} while (op != 0);
	}
}
