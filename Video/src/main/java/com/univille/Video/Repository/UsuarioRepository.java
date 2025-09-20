package com.univille.Video.Repository;

import com.univille.Video.Entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value = "SELECT u.* FROM visualizacao v JOIN perfil p ON v.id_perfil = p.id JOIN usuario u ON p.usuario_id = u.id GROUP BY u.id ORDER BY COUNT(v.id_visualizacao) DESC LIMIT 1", nativeQuery = true)
    Usuario findUsuarioMaisAtivo();

}
