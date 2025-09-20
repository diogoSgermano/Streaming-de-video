package com.univille.Video.Repository;

import com.univille.Video.Entidade.Usuario;
import com.univille.Video.Entidade.Video;
import com.univille.Video.Entidade.Visualizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VisualizacaoRepository extends JpaRepository<Visualizacao,Long> {
    @Query(value = "SELECT v.id_video, v.titulo, v.descricao, v.duracao, v.categoria_id " +
            "FROM visualizacao vis " +
            "JOIN video v ON vis.id_video = v.id_video " +
            "GROUP BY v.id_video, v.titulo, v.descricao, v.duracao, v.categoria_id " +
            "ORDER BY COUNT(vis.id_visualizacao) DESC " +
            "LIMIT 10", nativeQuery = true)
    List<Video> findTop10MaisAssistidos();

    @Query("SELECT v.perfil.usuario FROM Visualizacao v GROUP BY v.perfil.usuario ORDER BY COUNT(v.idVisualizacao) DESC")
    List<Usuario> findUsuariosMaisAtivos();



}
