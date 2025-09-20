package com.univille.Video.Repository;

import com.univille.Video.Entidade.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video,Long> {
    // Buscar vídeos pelo título com ordenação
    List<Video> findByTituloContainingIgnoreCaseOrderByTituloAsc(String titulo);

    // Buscar vídeos por categoria ordenados pelo título
    List<Video> findByCategoriaIdOrderByTituloAsc(int categoriaId);

    @Query(value = "SELECT v.* FROM visualizacao vis JOIN video v ON vis.id_video = v.id_video GROUP BY v.id_video ORDER BY COUNT(vis.id_visualizacao) DESC LIMIT 10", nativeQuery = true)
    List<Video> findTop10MaisAssistidos();

}
