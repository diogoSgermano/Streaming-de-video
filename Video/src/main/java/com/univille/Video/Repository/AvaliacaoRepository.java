package com.univille.Video.Repository;

import com.univille.Video.Entidade.Avaliacao;
import com.univille.Video.Entidade.Video;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao,Long> {
    // Agrupa por vídeo e ordena por média de nota
    @Query("SELECT a.video FROM Avaliacao a GROUP BY a.video ORDER BY AVG(a.nota) DESC")
    List<Video> findTop10ByOrderByMediaNotaDesc(); // não é derivação automática, precisa de @Query


}
