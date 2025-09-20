package com.univille.Video.Repository;

import com.univille.Video.Entidade.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>  {
}